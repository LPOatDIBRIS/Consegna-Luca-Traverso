package interpreter.visitors;

import interpreter.parser.ast.*;

public interface Visitor<T> {


	T visitAdd(Exp left, Exp right);

	T visitAssignStmt(VarIdent ident, Exp exp);

	T visitIntLiteral(int value);

	T visitEq(Exp left, Exp right);

	T visitNot_Eq(Exp left, Exp right); // parte del progetto, visita del operatore !=

	T visitMoreStmt(Stmt first, StmtSeq rest);

	T visitMul(Exp left, Exp right);

	T visitPrintStmt(Exp exp);

	T visitProg(StmtSeq stmtSeq);

	T visitSign(Exp exp);

	T visitVarIdent(VarIdent id); // the only corner case ...

	T visitSingleStmt(Stmt stmt);

	T visitVarStmt(VarIdent ident, Exp exp);

	T visitNot(Exp exp);

	T visitAnd(Exp left, Exp right);

	T visitBoolLiteral(boolean value);

	T visitIfStmt(Exp exp, Block thenBlock, Block elseBlock);

	T visitBlock(StmtSeq stmtSeq);

	T visitPairLit(Exp left, Exp right);

	T visitFst(Exp exp);

	T visitSnd(Exp exp);

	///L++
	T visitRange(Exp left, Exp right);

	T visitBounds(Exp exp);

	T visitFor (VarIdent ident,Exp exp, Block block);

}
