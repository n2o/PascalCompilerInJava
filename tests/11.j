.bytecode 50.0
.class public tests/11
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 24
	.limit locals 5
	ldc 4
	istore 1
	ldc 4
	istore 3
	iload 1
	iload 3
	isub
	ifgt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
	iload 1
	iload 3
	isub
	ifge LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
	iload 1
	iload 3
	isub
	ifeq LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
	iload 1
	iload 3
	isub
	ifle LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	bipush 1
	invokevirtual java/io/PrintStream/println(Z)V
	iload 1
	iload 3
	isub
	iflt LabelTrue4
	bipush 0
	goto LabelCompEnd4
LabelTrue4:
	bipush 1
LabelCompEnd4:
	istore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
	iload 4
	ifeq LabelIfElse0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 3
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd0
LabelIfElse0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd0:
	ldc 2
	ldc 2
	isub
	ifeq LabelTrue5
	bipush 0
	goto LabelCompEnd5
LabelTrue5:
	bipush 1
LabelCompEnd5:
	ldc 2
	ldc 2
	isub
	ifne LabelTrue6
	bipush 0
	goto LabelCompEnd6
LabelTrue6:
	bipush 1
LabelCompEnd6:
	ifeq LabelNotTrue2
	bipush 0
	goto LabelNotEnd2
LabelNotTrue2:
	bipush 1
	LabelNotEnd2:
	iand
	ifeq LabelIfDown1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown1:
	return
.end method
