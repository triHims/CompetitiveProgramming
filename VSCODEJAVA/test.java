import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test{
    public static void main(String[] args) {
        System.out.println("Hello Codiva");
    
        Stream<Integer> s = Stream.iterate(10, val -> val < 1000000, val-> val+1 );


        long t1 = System.currentTimeMillis();
        Integer o = s.reduce(0,(old,now)-> old+=now);
        System.out.println(String.format("Time taken is for stream reduce - %d",System.currentTimeMillis()-t1));



        t1 = System.currentTimeMillis();
        List<Integer> valList = s.collect(Collectors.toList());
        Integer out = 0;
        for (Integer val : valList) {
            out+=val;
        }        
        System.out.println(String.format("Time taken is for stream forEach - %d",System.currentTimeMillis()-t1));


    }
}