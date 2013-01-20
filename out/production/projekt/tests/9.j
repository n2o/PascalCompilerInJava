.bytecode 50.0
.class public tests/9
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
	.limit locals 4
	bipush 1
	istore 2
	bipush 1
	istore 3
LabelWhileUp0:
	bipush 1
	iload 2
	bipush 100
	isub
	iflt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	iand
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
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	return
.end method
