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
	.limit stack 6
	.limit locals 1
	ldc 1
	ldc 2
	isub
	iflt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelIfElse0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd0
LabelIfElse0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 0
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd0:
	return
.end method
