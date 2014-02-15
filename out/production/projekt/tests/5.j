.bytecode 50.0
.class public tests/5
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 15
	.limit locals 8
	ldc 1
	istore 4
	ldc 7
	iload 4
	ineg
	iadd
	istore 7
	bipush 1
	istore 5
LabelWhileUp0:
	bipush 1
	ifeq LabelWhileDown0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
	iload 7
	istore 3
	ldc 2
	iload 3
	iadd
	istore 7
	iload 4
	ldc 2
	isub
	istore 7
	iload 4
	iload 7
	imul
	istore 7
	iload 4
	ldc 2
	idiv
	istore 7
	iload 4
	iload 7
	iadd
	ldc 4
	idiv
	istore 7
	iload 4
	ldc 2
	irem
	istore 7
	iload 4
	ldc 3
	irem
	istore 7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 2
	invokevirtual java/io/PrintStream/println(I)V
	bipush 1
	ifeq LabelIfElse1
	bipush 1
	istore 5
	goto LabelIfElseEnd1
LabelIfElse1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 3
	invokevirtual java/io/PrintStream/println(I)V
	iload 5
	ifeq LabelNotTrue3
	bipush 0
	goto LabelNotEnd3
LabelNotTrue3:
	bipush 1
	LabelNotEnd3:
	ifeq LabelIfDown2
	iload 5
	ifeq LabelIfElse4
	goto LabelIfElseEnd4
LabelIfElse4:
LabelIfElseEnd4:
LabelIfDown2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 4
	invokevirtual java/io/PrintStream/println(I)V
	bipush 0
	istore 5
LabelWhileUp5:
	bipush 1
	ifeq LabelWhileDown5
	iload 4
	ldc 1
	iadd
	istore 4
	goto LabelBreakDown0
	goto LabelWhileUp5
LabelWhileDown5:
LabelBreakDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 5
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelBreakDown1
	iload 3
	istore 4
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown1:
	return
.end method
