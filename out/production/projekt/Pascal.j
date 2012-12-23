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
	.limit stack 17
	.limit locals 5
	bipush 1
	istore 2
	bipush 1
	istore 3
	iload 3
	istore 2
	bipush 1
	istore 4
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
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	bipush 1
	bipush 2
	isub
	iflt LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	ifeq LabelIfElse2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 0
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElse2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 100
	invokevirtual java/io/PrintStream/println(I)V
LabelWhileUp3:
	iload 4
	bipush 5
	isub
	iflt LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	ifeq LabelWhileDown3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
	iload 4
	bipush 1
	iadd
	istore 4
	goto LabelWhileUp3
LabelWhileDown3:
	goto LabelWhileUp0
LabelWhileDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 10
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
