package interpreter.visitors.evaluation;

import org.w3c.dom.ranges.Range;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;

public class RangeValue implements Value,Iterable<Value> {


    private Value start;
    private  Value end;


  private ArrayList<Value> collection;

  public RangeValue(){
      this.collection=new ArrayList<>();
  }


    public RangeValue(Value start, Value end) {
        this();

            this.start =checkValue(requireNonNull(start));
            this.end = checkValue(requireNonNull(end));

        this.collection=init(this.start,this.end);

    }

    private ArrayList<Value> init(Value start, Value end) {

        //SEQUENZA CRESCENTE
        if (start.toInt() < end.toInt()) {

            for ( var i= start; !i.equals(end);i=new IntValue(i.toInt()+1)){

                this.collection.add(i);
            }

            //SEQUENZA DECRESCENTE
        } else if (start.toInt() > end.toInt()) {
            for (Value i = start; !i.equals(end); i=new IntValue(i.toInt()-1)) {
                this.collection.add(i);
            }

        }
        //SEQUENZA VUOTA
        return collection;
    }

    private Value checkValue(Value index){
        if(index instanceof IntValue) return index;

        throw new EvaluatorException("Expecting a Integer");
    }


    public Value GetStart(){ return start;}

    public Value GetEnd(){return end;}

    public ArrayList<Value> getSet(){
        return collection;
    }

    @Override
    public RangeValue toRange(){return this;}

    @Override
    public String toString() { return "[" + start + ":" + end + "]"; }

    @Override
    public int hashCode(){ return hash(start,end);}

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof RangeValue))
            return false;
        var op = (RangeValue) obj;
        if(this.start.equals(this.end) && op.start.equals(op.end)) return  true;
        return start.equals(op.start) && end.equals(op.end);
    }

    @Override
    public Iterator<Value> iterator() {
        return getSet().iterator();
    }
}
