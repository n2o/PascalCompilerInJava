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
	.limit stack 21
	.limit locals 6
	bipush 1
	istore 2
	bipush 1
	istore 3
	bipush 0
	istore 1
	bipush 0
	istore 4
	bipush 42
	istore 5
	iload 1
	bipush 1
	isub
	ifeq LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelIfDown0
	iload 3
	iload 3
	iadd
	istore 5
	iload 5
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	iload 1
	bipush 2
	isub
	iflt LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelIfDown1
	iload 3
	bipush 1
	iadd
	istore 3
	iload 5
	bipush 2
	iadd
	istore 5
LabelIfDown1:
LabelIfDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
	iload 1
	bipush 4
	isub
	ifgt LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	ifeq LabelIfElse2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 5
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd2
LabelIfElse2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(Z)V
	bipush 0
	istore 1
LabelWhileUp3:
	iload 1
	bipush 4
	isub
	iflt LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	ifeq LabelWhileDown3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	iload 1
	bipush 1
	iadd
	istore 1
	goto LabelWhileUp3
LabelWhileDown3:
LabelBreakDown0:
	return
.end method
