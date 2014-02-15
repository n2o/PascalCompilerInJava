.bytecode 50.0
.class public tests/15
.super java/lang/Object
.method public <init>()V
	.limit stack 1
	.limit locals 1
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method
	.method public static main([Ljava/lang/String;)V
	.limit stack 64
	.limit locals 16
	ldc 5
	istore 8
	ldc 1
	istore 14
LabelWhileUp0:
	iload 8
	ldc 0
	isub
	ifgt LabelTrue0
	bipush 0
	goto LabelCompEnd0
LabelTrue0:
	bipush 1
LabelCompEnd0:
	ifeq LabelWhileDown0
	iload 14
	iload 8
	imul
	istore 14
	iload 8
	ldc 1
	isub
	istore 8
	goto LabelWhileUp0
LabelWhileDown0:
LabelBreakDown0:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 14
	invokevirtual java/io/PrintStream/println(I)V
	ldc 2
	ldc 2
	isub
	ifeq LabelTrue1
	bipush 0
	goto LabelCompEnd1
LabelTrue1:
	bipush 1
LabelCompEnd1:
	ldc 2
	ldc 2
	isub
	ifne LabelTrue2
	bipush 0
	goto LabelCompEnd2
LabelTrue2:
	bipush 1
LabelCompEnd2:
	ifeq LabelNotTrue2
	bipush 0
	goto LabelNotEnd2
LabelNotTrue2:
	bipush 1
	LabelNotEnd2:
	iand
	ifeq LabelIfDown1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 334364336
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown1:
	ldc 2
	ldc 2
	isub
	ifeq LabelTrue3
	bipush 0
	goto LabelCompEnd3
LabelTrue3:
	bipush 1
LabelCompEnd3:
	ldc 2
	ldc 3
	isub
	ifne LabelTrue4
	bipush 0
	goto LabelCompEnd4
LabelTrue4:
	bipush 1
LabelCompEnd4:
	ifeq LabelNotTrue4
	bipush 0
	goto LabelNotEnd4
LabelNotTrue4:
	bipush 1
	LabelNotEnd4:
	iand
	ifeq LabelIfDown3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 3334443
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown3:
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
	ldc 1
	ldc 3
	ldc 2
	ldc 1
	iadd
	isub
	isub
	invokevirtual java/io/PrintStream/println(I)V
	ldc 1
	istore 10
	ldc 1
	istore 12
LabelWhileUp7:
	iload 10
	ldc 1000
	isub
	iflt LabelTrue5
	bipush 0
	goto LabelCompEnd5
LabelTrue5:
	bipush 1
LabelCompEnd5:
	ifeq LabelWhileDown7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 10
	invokevirtual java/io/PrintStream/println(I)V
	iload 12
	istore 5
	iload 10
	iload 12
	iadd
	istore 12
	iload 5
	istore 10
	goto LabelWhileUp7
LabelWhileDown7:
LabelBreakDown1:
	ldc 3
	istore 10
	ldc 10
	istore 10
	iload 10
	ldc 3
	irem
	ldc 3
	imul
	ldc 2
	idiv
	istore 11
	ldc 1
	istore 12
	bipush 1
	istore 1
LabelWhileUp8:
	iload 10
	iload 12
	isub
	ifge LabelTrue6
	bipush 0
	goto LabelCompEnd6
LabelTrue6:
	bipush 1
LabelCompEnd6:
	ifeq LabelWhileDown8
	iload 10
	iload 12
	isub
	istore 10
	iload 10
	iload 12
	ldc 1
	iadd
	isub
	ifle LabelTrue7
	bipush 0
	goto LabelCompEnd7
LabelTrue7:
	bipush 1
LabelCompEnd7:
	ifeq LabelIfElse9
	goto LabelBreakDown2
	goto LabelIfElseEnd9
LabelIfElse9:
	ldc 1
	istore 10
LabelIfElseEnd9:
	goto LabelWhileUp8
LabelWhileDown8:
LabelBreakDown2:
	ldc 1
	ldc 7
	ldc 3
	imul
	iadd
	istore 10
	ldc 7
	ldc 1
	ldc 4
	iadd
	ineg
	isub
	istore 12
	ldc 2
	ldc 1
	ineg
	ineg
	ineg
	ineg
	ineg
	iadd
	istore 11
	ldc 1
	istore 10
	iload 10
	istore 12
	iload 12
	iload 10
	iadd
	istore 11
LabelWhileUp10:
	iload 10
	ldc 10
	isub
	iflt LabelTrue8
	bipush 0
	goto LabelCompEnd8
LabelTrue8:
	bipush 1
LabelCompEnd8:
	ifeq LabelWhileDown10
	iload 10
	ldc 1
	iadd
	istore 10
LabelWhileUp11:
	iload 12
	ldc 10
	isub
	iflt LabelTrue9
	bipush 0
	goto LabelCompEnd9
LabelTrue9:
	bipush 1
LabelCompEnd9:
	ifeq LabelWhileDown11
	iload 12
	ldc 1
	iadd
	istore 12
LabelWhileUp12:
	iload 11
	ldc 10
	isub
	iflt LabelTrue10
	bipush 0
	goto LabelCompEnd10
LabelTrue10:
	bipush 1
LabelCompEnd10:
	ifeq LabelWhileDown12
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 11
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelBreakDown3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 111111
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp12
LabelWhileDown12:
LabelBreakDown3:
	goto LabelBreakDown4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 222222
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp11
LabelWhileDown11:
LabelBreakDown4:
	goto LabelBreakDown5
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 333333
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelWhileUp10
LabelWhileDown10:
LabelBreakDown5:
	ldc 1
	istore 10
	ldc 1
	istore 12
LabelWhileUp13:
	bipush 1
	iload 10
	ldc 100
	isub
	iflt LabelTrue11
	bipush 0
	goto LabelCompEnd11
LabelTrue11:
	bipush 1
LabelCompEnd11:
	iand
	ifeq LabelWhileDown13
	iload 12
	istore 5
	iload 10
	iload 12
	iadd
	istore 12
	iload 5
	istore 10
	goto LabelWhileUp13
LabelWhileDown13:
LabelBreakDown6:
	ldc 4
	istore 10
	ldc 4
	istore 12
	iload 10
	iload 12
	isub
	ifgt LabelTrue12
	bipush 0
	goto LabelCompEnd12
LabelTrue12:
	bipush 1
LabelCompEnd12:
	istore 15
	iload 10
	iload 12
	isub
	ifge LabelTrue13
	bipush 0
	goto LabelCompEnd13
LabelTrue13:
	bipush 1
LabelCompEnd13:
	istore 15
	iload 10
	iload 12
	isub
	ifeq LabelTrue14
	bipush 0
	goto LabelCompEnd14
LabelTrue14:
	bipush 1
LabelCompEnd14:
	istore 15
	iload 10
	iload 12
	isub
	ifle LabelTrue15
	bipush 0
	goto LabelCompEnd15
LabelTrue15:
	bipush 1
LabelCompEnd15:
	istore 15
	iload 10
	iload 12
	isub
	iflt LabelTrue16
	bipush 0
	goto LabelCompEnd16
LabelTrue16:
	bipush 1
LabelCompEnd16:
	istore 15
	iload 15
	ifeq LabelIfElse14
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 3
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd14
LabelIfElse14:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd14:
	ldc 2
	ldc 2
	isub
	ifeq LabelTrue17
	bipush 0
	goto LabelCompEnd17
LabelTrue17:
	bipush 1
LabelCompEnd17:
	ldc 2
	ldc 2
	isub
	ifne LabelTrue18
	bipush 0
	goto LabelCompEnd18
LabelTrue18:
	bipush 1
LabelCompEnd18:
	ifeq LabelNotTrue16
	bipush 0
	goto LabelNotEnd16
LabelNotTrue16:
	bipush 1
	LabelNotEnd16:
	iand
	ifeq LabelIfDown15
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 1
	invokevirtual java/io/PrintStream/println(I)V
LabelIfDown15:
	ldc 0
	istore 10
	ldc 6
	istore 12
	iload 10
	iload 12
	isub
	ifgt LabelTrue19
	bipush 0
	goto LabelCompEnd19
LabelTrue19:
	bipush 1
LabelCompEnd19:
	istore 15
LabelWhileUp17:
	iload 10
	iload 12
	isub
	iflt LabelTrue20
	bipush 0
	goto LabelCompEnd20
LabelTrue20:
	bipush 1
LabelCompEnd20:
	ifeq LabelWhileDown17
	iload 10
	ldc 1
	iload 10
	iadd
	ineg
	isub
	istore 10
	goto LabelWhileUp17
LabelWhileDown17:
LabelBreakDown7:
	bipush 1
	istore 3
	ldc 1
	istore 10
	ldc 0
	istore 13
	ldc 0
	istore 11
	ldc 42
	istore 12
	iload 13
	ldc 1
	isub
	ifeq LabelTrue21
	bipush 0
	goto LabelCompEnd21
LabelTrue21:
	bipush 1
LabelCompEnd21:
	ifeq LabelIfDown18
	iload 10
	iload 10
	iadd
	istore 12
	iload 12
	istore 11
	iload 13
	ldc 2
	isub
	iflt LabelTrue22
	bipush 0
	goto LabelCompEnd22
LabelTrue22:
	bipush 1
LabelCompEnd22:
	ifeq LabelIfDown19
	iload 10
	ldc 1
	iadd
	istore 10
	iload 12
	ldc 2
	iadd
	istore 12
LabelIfDown19:
LabelIfDown18:
	iload 13
	ldc 4
	isub
	ifgt LabelTrue23
	bipush 0
	goto LabelCompEnd23
LabelTrue23:
	bipush 1
LabelCompEnd23:
	ifeq LabelIfElse20
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 10
	invokevirtual java/io/PrintStream/println(I)V
	goto LabelIfElseEnd20
LabelIfElse20:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 11
	invokevirtual java/io/PrintStream/println(I)V
LabelIfElseEnd20:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 3
	invokevirtual java/io/PrintStream/println(Z)V
	ldc 0
	istore 13
LabelWhileUp21:
	iload 13
	ldc 4
	isub
	iflt LabelTrue24
	bipush 0
	goto LabelCompEnd24
LabelTrue24:
	bipush 1
LabelCompEnd24:
	ifeq LabelWhileDown21
	iload 13
	ldc 1
	iadd
	istore 13
	goto LabelWhileUp21
LabelWhileDown21:
LabelBreakDown8:
	ldc 42
	istore 9
	ldc 2
	istore 7
	bipush 1
	istore 6
LabelWhileUp22:
	bipush 1
	ifeq LabelWhileDown22
	iload 9
	iload 7
	irem
	ldc 0
	isub
	ifeq LabelTrue25
	bipush 0
	goto LabelCompEnd25
LabelTrue25:
	bipush 1
LabelCompEnd25:
	ifeq LabelIfElse23
	bipush 0
	istore 6
	goto LabelBreakDown9
	goto LabelIfElseEnd23
LabelIfElse23:
	iload 7
	ldc 1
	iadd
	istore 7
LabelIfElseEnd23:
	iload 7
	iload 9
	ldc 1
	isub
	isub
	ifeq LabelTrue26
	bipush 0
	goto LabelCompEnd26
LabelTrue26:
	bipush 1
LabelCompEnd26:
	ifeq LabelIfDown24
	bipush 1
	istore 6
	goto LabelBreakDown9
LabelIfDown24:
	goto LabelWhileUp22
LabelWhileDown22:
LabelBreakDown9:
	return
.end method
