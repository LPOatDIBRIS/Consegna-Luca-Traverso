package interpreter.visitors.typechecking;

import static java.util.Objects.requireNonNull;

public class RangeType implements Type{


    private Type start;
    private Type end;

    public static final String TYPE_NAME = "RANGE";



    public RangeType(Type start, Type end) {
        if (checkType(start, end)) {
            this.start = requireNonNull(start);
            this.end = requireNonNull(end);
        }
    }

    //funzione che verifica che gli indici abbiamo tipi uguali
    private boolean checkType(Type start, Type end){
        return start.checkEqual(end).equals(end.checkEqual(start));
    }

    public Type getStartType() {
        return start;
    }

    public Type getEndType() {
        return end;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof RangeType))
            return false;
        RangeType pt = (RangeType) obj;
        return start.equals(pt.start) && end.equals(pt.end);
    }

    @Override
    public int hashCode() {
        return start.hashCode() +31 * end.hashCode();
    }

    @Override
    public String toString() {
        return "RANGE";
    }


}
