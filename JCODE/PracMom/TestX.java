import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class TestX {
//     public static void main(String args[]){
//         List<Integer> st = new ArrayList<>();
//         st.add(1);
//         st.add(2);
//         Iterator<Integer> it = st.iterator();

//         while(it.hasNext()){
//             System.out.println(it.next());
//             // st.add(5);
//         }

//         Object [] myOb = {
//             new Integer(50),
//             new String("foo"),
//             new Integer(50),
//             new Integer(50),
//             new Integer(50),
//             new Boolean(true)
//         };
//         Arrays.sort(myOb);

//         for (int i = 0; i < myOb.length; i++) {
//                 System.out.print(myOb[i].toString());
//                 System.out.print(" ");
//         }
//     }

static int count =0 ;
static TestX t;
public static void main(String[] args) {
    TestX t1 = new TestX();
    t1 = null;
    System.gc();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    t = null;
    System.gc();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Value of count "+count);
}

protected void finalize(){
    count++;
    t = this;
}
}
