.bytecode 50.0
.class public tests/10
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 5
	.limit locals 5
	bipush 2
	bipush 2
	isub
	ifeq LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	bipush 2
	bipush 2
	isub
	ifne LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ifeq LabelNotTrue1
	bipush 0
	goto LabelNotEnd1
LabelNotTrue1:
	bipush 1
	LabelNotEnd1:
	iand
	ifeq LabelIfDown0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 1
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown0:
	return
.end method
