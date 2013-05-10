     li	$a0,84
     li	$v0,11
     syscall
     li	$t0,100
     li	$t1,4
     add	$a0,$t0,$t1
     syscall
     li	$t2,-3
     add	$a0,$t0,$t2
     syscall
     li	$t3,5
     li	$t4,11
     mul	$t5,$t3,$t4
     sll	$a0,$t5,0x1
     syscall
     li	$a0,107
     syscall
     li	$a0,2
     sll	$a0,$a0,0x4
     syscall
     li	$a0,121
     syscall
     sll	$a0,$t5,0x1
     li	$a1,1
     add	$a0,$a0,$a1
     syscall
     li	$a1,6
     add	$a0,$a0,$a1
     syscall
     li	$a0,32
     syscall
     li	$t5,70
     add	$a0,$a0,$t5
     syscall
     li	$t0,9
     add	$a0,$a0,$t0
     syscall
     li	$t0,57
     sll	$a0,$t0,0x1
     syscall
     li	$t5,2
     li	$t6,4
     sllv	$a0,$t5,$t6
     syscall
     li	$a0,115
     syscall
     li	$t4,222
     sra	$a0,$t4,0x1
     syscall
     li	$t4,3
     li	$t3,0
     sub	$t3,$t3,$t4
     add	$a0,$a0,$t3
     syscall
     li	$a0,118
     syscall
     li	$t0,10
     mul	$t0,$t0,$t0
     li	$t1,5
     add	$a0,$t0,$t1
     syscall
     add	$a0,$a0,$t1
     syscall
     li	$t1,-7
     add	$a0,$a0,$t1
     syscall
     li	$a0,33
     syscall
     li	$t1,-1
     add	$a0,$a0,$t1
     syscall
     li	$t1,9
     mul	$t1,$t1,$t1
     li	$t2,3
     add	$a0,$t1,$t2
     syscall
     li	$t0,-32
     add	$a0,$a0,$t0
     sll	$a0,$a0,0x1
     syscall
     li	$t0,-3
     add	$a0,$a0,$t0
     syscall
     li	$a0,32
     syscall
     li	$t4,10
     mul	$t3,$t4,$t4
     add	$a0,$t3,$t0
     syscall
     li	$t5,11
     mul	$a0,$t4,$t5
     syscall
     li	$t5,5
     add	$a0,$a0,$t5
     syscall
     add	$a0,$a0,$t5
     li	$t2,-1
     add	$a0,$a0,$t2
     syscall
     li	$a0,101
     syscall
     li	$t1,13
     add	$a0,$a0,$t1
     syscall
     li	$t0,32
     addu	$a0,$zero,$t0
     syscall
     li	$a0,105
     syscall
     li	$t0,10
     add	$a0,$t0,$a0
     syscall
     li	$t4,2
     sll	$a0,$t4,0x4
     syscall
     mul	$t4,$t0,$t0
     li	$t0,12
     add	$t0,$t4,$t0
     addu	$a0,$zero,$t0
     syscall
     li	$t1,-7
     add	$a0,$a0,$t1
     syscall
     addu	$a0,$zero,$t0
     syscall
     li	$t1,10
     div	$zero,$a0,$t1
     mflo	$t1
     li	$t2,-1
     mul	$t2,$t2,$t1
     add	$a0,$a0,$t2
     syscall
     li	$t7,7
     add	$a0,$t7,$a0
     syscall
     li	$t0,-3
     add	$a0,$a0,$t0
     syscall
     li	$t7,2
     div	$zero,$a0,$t7
     mflo	$t0
     li	$t1,10
     div	$zero,$t0,$t1
     mflo	$t0
     add	$a0,$a0,$t0
     syscall
     li	$a0,101
     syscall
     div	$zero,$a0,$t1
     mflo	$a0
     li	$t0,3
     mul	$a0,$a0,$t0
     add	$a0,$a0,$t0
     syscall