import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Fi implements Iterator<Integer> {

    @Override
    public boolean hasNext() {
       if(next()!=null){
           return true;
       }
       return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
