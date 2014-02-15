.bytecode 50.0
.class public tests/14
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 6
	.limit locals 4
	ldc 42
	istore 2
	ldc 2
	istore 1
	bipush 1
	istore 3
LabelWhileUp0:
	bipush 1
	ifeq LabelWhileDown0
	iload 2
	iload 1
	irem
	ldc 0
	isub
	ifeq LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelIfElse1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
	bipush 0
	istore 3
	goto LabelBreakDown0
	goto LabelIfElseEnd1
LabelIfElse1:
	iload 1
	ldc 1
	iadd
	istore 1
LabelIfElseEnd1:
	iload 1
	iload 2
	ldc 1
	isub
	isub
	ifeq LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelIfDown2
	bipush 1
	istore 3
	goto LabelBreakDown0
LabelIfDown2:
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	return
.end method
