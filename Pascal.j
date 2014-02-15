.bytecode 50.0
.class public Pascal
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 4
	.limit locals 5
	ldc 1
	istore 1
	ldc 1
	istore 2
	ldc 10
	istore 4
while:
	iload 1
	iload 4
	isub
	ifge endLabel
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
	iload 2
	istore 3
	iload 1
	iload 2
	iadd
	istore 2
	iload 3
	istore 1
	goto while
endLabel:
	return
.end method
