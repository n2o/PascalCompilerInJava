.bytecode 50.0
.class public tests/13
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
	istore 1
	ldc 1
	istore 2
	ldc 0
	istore 5
	ldc 0
	istore 3
	ldc 42
	istore 4
	iload 5
	ldc 1
	isub
	ifeq LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelIfDown0
	iload 2
	iload 2
	iadd
	istore 4
	iload 4
	istore 3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	iload 5
	ldc 2
	isub
	iflt LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelIfDown1
	iload 2
	ldc 1
	iadd
	istore 2
	iload 4
	ldc 2
	iadd
	istore 4
LabelIfDown1:
LabelIfDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	iload 5
	ldc 4
	isub
	ifgt LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	ifeq LabelIfElse2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd2
LabelIfElse2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(Z)V
	ldc 0
	istore 5
LabelWhileUp3:
	iload 5
	ldc 4
	isub
	iflt LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	ifeq LabelWhileDown3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	iload 5
	ldc 1
	iadd
	istore 5
	goto LabelWhileUp3
LabelWhileDown3:
LabelBreakDown0:
	return
.end method
