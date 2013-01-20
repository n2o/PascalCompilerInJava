.bytecode 50.0
.class public tests/12
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
	.limit locals 5
	bipush 0
	istore 1
	bipush 6
	istore 3
	iload 1
	iload 3
	isub
	ifgt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	istore 4
LabelWhileUp0:
	iload 1
	iload 3
	isub
	iflt LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelWhileDown0
	iload 1
	bipush 1
	iload 1
	iadd
	ineg
	isub
	istore 1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 0
	invokevirtual java/io/PrintStream/println(Z)V
	return
.end method
