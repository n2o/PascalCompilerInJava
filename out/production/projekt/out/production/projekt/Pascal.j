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
	.limit stack 9
	.limit locals 5
	bipush 1
	istore 3
	iload 3
	istore 2
LabelWhileUp0:
	iload 2
	bipush 100
	isub
	iflt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelWhileDown0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	iload 3
	istore 1
	iload 2
	iload 3
	iadd
	istore 3
	iload 1
	istore 2
	iload 2
	bipush 34
	isub
	ifgt LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelIfElse1
	goto LabelWhileDown0
LabelIfElse1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 0
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp0
LabelWhileDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 10
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
