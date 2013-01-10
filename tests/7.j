.bytecode 50.0
.class public tests/7
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 7
	.limit locals 4
	bipush 1
	bipush 7
	bipush 3
	imul
	iadd
	istore 1
	bipush 7
	bipush 1
	bipush 4
	iadd
	ineg
	isub
	istore 3
	bipush 2
	bipush 1
	ineg
	ineg
	ineg
	ineg
	ineg
	iadd
	istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
