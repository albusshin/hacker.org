package com.albusshin.lazymaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LazyMazeRightDown {
	static Stack<Map<Character, Boolean>> maps = new Stack<>();
	static Stack<Character> stack = new Stack<Character>();
	static String directions = "D";
	static char lastDirection = 'D';
	static char nowDirection;
	static boolean firstTime = true;
	static int steps = 1;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		initialize();
		execute();
	}

	public static void initialize() {
		Map<Character, Boolean> m = new HashMap<Character, Boolean>();
		maps.push(m);
		stack.push('D');
		m.clear();
	}

	/**
	 * @param direction
	 * @return 反方向是什么
	 */
	public char getOppositeChar(char direction) {
		if (direction == 'U')
			return 'D';
		else if (direction == 'D')
			return 'U';
		else if (direction == 'R')
			return 'L';
		else
			return 'R';
	}

	/**
	 * @return 是否当前的路已经是死路
	 */
	public static boolean checkIfDead() {
		Map<Character, Boolean> m = maps.peek();
		boolean ret = true;
		if (m.get('D') != null) {
			ret &= m.get('D');
		}
		if (m.get('U') != null) {
			ret &= m.get('U');
		}
		if (m.get('R') != null) {
			ret &= m.get('R');
		}
		if (m.get('L') != null) {
			ret &= m.get('L');
		}

		return ret;
	}

	/**
	 * 尝试四个方向
	 * 
	 * @return 是否当前所有方向都已经尝试过了
	 */
	public static boolean deadEndExecute() {
		boolean ifDead = checkIfDead();
		if (!ifDead) {
			Map<Character, Boolean> m = maps.peek();
			if (m.get('D') != null) {
				if (!m.get('D')) {
					m.remove('D');
					m.put('D', true);
					directions = directions.substring(0,
							directions.length() - 1);
					nowDirection = 'D';
					return false;
				}
			}
			if (m.get('U') != null) {// Try another direction.
				if (!m.get('U')) {
					m.remove('U');
					m.put('U', true);
					directions = directions.substring(0,
							directions.length() - 1);
					nowDirection = 'U';
					return false;
				}
			}
			if (m.get('R') != null) {
				if (!m.get('R')) {
					m.remove('R');
					m.put('R', true);
					directions = directions.substring(0,
							directions.length() - 1);
					nowDirection = 'R'; // UDRL是顺序
					return false;
				}
			}
			if (m.get('L') != null) {
				if (!m.get('L')) {
					m.remove('L');
					m.put('L', true);
					directions = directions.substring(0,
							directions.length() - 1);
					nowDirection = 'L'; // UDRL是顺序
					return false;
				}
			} else {// All directions have gone and dead end occurs
					// must roll back.
				return true;

			}
		}// All directions have gone and dead end occurs
			// must roll back.
		return true;
	}

	/**
	 * 改变lastDirection成为下一个可选的方向
	 * 
	 * @return 是否lastDirection也没有方向可选了
	 */
	public static boolean changeLastDirection() {
		firstTime = true;
		maps.pop();
		directions = directions.substring(0, directions.length() - 1);// 先返回一层
		Map<Character, Boolean> m = maps.peek();
		if (m.get('D') != null) {
			if (!m.get('D')) {
				m.remove('D');
				m.put('D', true);
				directions = directions.substring(0, directions.length() - 1);
				directions += "D";
				lastDirection = 'D';
				return false;
			}
		}
		if (m.get('U') != null) {// Try another direction.
			if (!m.get('U')) {
				m.remove('U');
				m.put('U', true);
				directions = directions.substring(0, directions.length() - 1);
				directions += "U";
				lastDirection = 'U';
				return false;
			}
		}
		if (m.get('R') != null) {
			if (!m.get('R')) {
				m.remove('R');
				m.put('R', true);
				directions = directions.substring(0, directions.length() - 1);
				directions += "R";
				lastDirection = 'R';
				return false;
			}
		}
		if (m.get('L') != null) {
			if (!m.get('L')) {
				m.remove('L');
				m.put('L', true);
				directions = directions.substring(0, directions.length() - 1);
				directions += "L";
				lastDirection = 'L';
				return false;
			}
		} else {// 所有方向都试过了，必须再回滚
			return true;
		}

		return true;
	}

	public static void execute() throws IOException {
		steps++;
		URL maze = new URL(
				"http://www.hacker.org/challenge/misc/maze.php?steps="
						+ directions);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				maze.openStream()));
		if (firstTime) {
			Map<Character, Boolean> m = new HashMap<Character, Boolean>();
			switch (lastDirection) {
			case 'D':
				m.put('D', true);
				m.put('R', false);
				m.put('L', false);
				nowDirection = 'D';
				break;
			case 'U':
				m.put('U', true);
				m.put('R', false);
				m.put('L', false);
				nowDirection = 'U';
				break;
			case 'R':
				m.put('D', false);
				m.put('U', true);
				m.put('R', false);
				nowDirection = 'U';
				break;
			case 'L':
				m.put('D', false);
				m.put('U', true);
				m.put('L', false);
				nowDirection = 'U';
				break;
			}
			maps.push(m);
			firstTime = false;
		}
		directions += nowDirection;// TODO: 不知有没有错误
		System.out.println("execute, directions=" + directions);
		System.out.println("execute, nowDirection=" + nowDirection);
		System.out.println("execute, nowStep=" + directions.length());
		System.out.println("execute, steps=" + steps);
		System.out.println("execute, lastDirection=" + lastDirection);
		String line;
		line = in.readLine();
		line = in.readLine();
		if (line.equals("off the edge of the world")) {
			System.out.println(directions);
			System.out.println("Result:off the edge of the world");
			if (!deadEndExecute()) {
				execute();
			} else {
				// 已经是死路了，需要回溯
				while (!changeLastDirection())
					;
				execute();
			}
		} else if (line.equals("boom")) {
			System.out.println(directions);
			System.out.println("Result:boom");
			if (!deadEndExecute()) {
				execute();
			} else {
				// 已经是死路了，需要回溯
				while (changeLastDirection())
					;
				execute();
			}
		} else if (line.equals("")){
			line = in.readLine();
			
			if (line.equals("keep moving...")) {
				System.out.println(directions);
				System.out.println("Result:keep moving...");
				firstTime = true;
				execute();
			}
			else{
				System.out.println("Success! the Answer is " + directions);
				return;
			}
		} 
		else{
			System.out.println("Success! the Answer is " + directions);
			return;
		}
		in.close();
		// 递归后

	}
}
