import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by odsptc13 on 3/16/2017.
 */
public class algo1 {
    public static void main(String[] args) {
        List<Integer> iii = Arrays.asList(1,4,2,7,3,87);
        Integer[] ar = {1,4,2,7,3,87};
        String[] ar2 = {"a1","a4","a2","a7","a3","a87"};

        test(algo1::search,ar,5,-11);

        test(algo1::search,ar2,"a22", 2);
    }

    private static <T> int search(T[] ar, T key)
    {
        for(int i = 0; i < ar.length; i++)
        {
            if(ar[i] == key)
            {
                return i;
            }
        }

        return -1;
    }



    private static <T> void test(BiFunction<T[], T, Integer> function, T[] ar, T arg, Integer exp)
    {
        if(function.apply(ar, arg) != exp)
        {
            System.out.println("failed");
        }
    }

}



