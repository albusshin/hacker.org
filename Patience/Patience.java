import java.util.Random;

public class Patience {
	public static void main(String[] args) {
		Random paramArrayOfString = new Random(739391L);
		long l, l2;
		do {
			while ((l2 = paramArrayOfString.nextLong()) < 0L);
			l2 = 9085560309849087808L;
			l = l2;
			for (int i = 0; i < 20000; i++) {
				l %= 1000000000;
				l <<= 1;
				l++;
				System.out.println(l);
			}
			l %= 1000000000;
		} while (l != 843997183);
		System.out.println(l2);

		// answer: 9085560309849087808
	}
}