///////CLASSE RANGELITERAL PER RAPPRESENTARE IL LITERAL RANGE,


package interpreter.parser.ast;

import interpreter.visitors.Visitor;

import static java.util.Objects.requireNonNull;

public class RangeLit implements Exp {

    private Exp start;
    private Exp end;


    public RangeLit(Exp start, Exp end){
                this.start=requireNonNull(start);
                this.end=requireNonNull(end);
}




    @Override
    public <T> T accept(Visitor<T> visitor) {

        return  visitor.visitRange(start,end);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + start + "," + end + ")";
    }

    }






