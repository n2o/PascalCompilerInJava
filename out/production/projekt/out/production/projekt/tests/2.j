.bytecode 50.0
.class public tests/2
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
	.limit locals 3
	ldc 5
	istore 1
	ldc 1
	istore 2
LabelWhileUp0:
	iload 1
	ldc 0
	isub
	ifgt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelWhileDown0
	iload 2
	iload 1
	imul
	istore 2
	iload 1
	ldc 1
	isub
	istore 1
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
