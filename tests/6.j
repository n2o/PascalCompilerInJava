.bytecode 50.0
.class public tests/6
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 10
	.limit locals 7
	bipush 10
	istore 4
	iload 4
	bipush 3
	irem
	bipush 3
	imul
	bipush 2
	idiv
	istore 5
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 5
	invokevirtual java/io/PrintStream/println(I)V
	bipush 1
	istore 6
	bipush 1
	istore 1
LabelWhileUp0:
	iload 4
	iload 6
	isub
	ifge LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelWhileDown0
	iload 4
	iload 6
	isub
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
	iload 4
	iload 6
	bipush 1
	iadd
	isub
	ifle LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelIfElse1
	goto LabelBreakDown0
	goto LabelIfElseEnd1
LabelIfElse1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(Z)V
LabelIfElseEnd1:
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	return
.end method
