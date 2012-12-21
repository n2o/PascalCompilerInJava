.bytecode 50.0
.class public Out
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 4
	ldc 1
	ldc 4
	iadd
	istore 1
	ldc 1
	istore 3
	ldc 42
	ldc 4
	idiv
	istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
