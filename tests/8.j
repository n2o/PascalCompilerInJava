.bytecode 50.0
.class public tests/8
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 14
	.limit locals 4
	ldc 1
	istore 1
	iload 1
	istore 3
	iload 3
	iload 1
	iadd
	istore 2
LabelWhileUp0:
	iload 1
	ldc 10
	isub
	iflt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelWhileDown0
	iload 1
	ldc 1
	iadd
	istore 1
LabelWhileUp1:
	iload 3
	ldc 10
	isub
	iflt LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelWhileDown1
	iload 3
	ldc 1
	iadd
	istore 3
LabelWhileUp2:
	iload 2
	ldc 10
	isub
	iflt LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	ifeq LabelWhileDown2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelBreakDown0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 111111
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp2
LabelWhileDown2:
LabelBreakDown0:
	goto LabelBreakDown1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 222222
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp1
LabelWhileDown1:
LabelBreakDown1:
	goto LabelBreakDown2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 333333
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 999999
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
