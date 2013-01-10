.bytecode 50.0
.class public tests/1
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
	.limit locals 1
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
	ldc 334364336
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown0:
	bipush 2
	bipush 2
	isub
	ifeq LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	bipush 2
	bipush 3
	isub
	ifne LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	ifeq LabelNotTrue3
	bipush 0
	goto LabelNotEnd3
LabelNotTrue3:
	bipush 1
	LabelNotEnd3:
	iand
	ifeq LabelIfDown2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 3334443
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 0
	ifeq LabelNotTrue4
	bipush 0
	goto LabelNotEnd4
LabelNotTrue4:
	bipush 1
	LabelNotEnd4:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 1
	ifeq LabelNotTrue5
	bipush 0
	goto LabelNotEnd5
LabelNotTrue5:
	bipush 1
	LabelNotEnd5:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 1
	bipush 0
	iand
	ifeq LabelNotTrue6
	bipush 0
	goto LabelNotEnd6
LabelNotTrue6:
	bipush 1
	LabelNotEnd6:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 1
	bipush 3
	bipush 2
	bipush 1
	iadd
	isub
	isub
	invokevirtual java/io/PrintStream/println(I)V
	return
.end method
