package interpreter.parser.ast;

import interpreter.visitors.Visitor;

import static java.util.Objects.requireNonNull;

public class ForStmt implements Stmt {

    private VarIdent ident;
    private Exp exp;
    private Block block;

    public ForStmt(VarIdent ident, Exp exp, Block block) {
        this.ident = requireNonNull(ident);
        this.exp = requireNonNull(exp);
        this.block = requireNonNull(block);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + ident + "," + exp + "," + block + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitFor(ident,exp,block);
    }
}
