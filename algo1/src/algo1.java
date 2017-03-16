import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by odsptc13 on 3/16/2017.
 */
public class algo1 {
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1,4,2,7,3,87);
        List<String> ar2 = Arrays.asList("a1","a4","a2","a7","a3","a87");

        test(algo1::search,ar,5,1);
        test(algo1::search,ar,5,-1);
        test(algo1::search,ar2,"a22", 2);
    }


    private static <T> int binary_search(List<T> ar, T key)
    {
        assert ar.stream().sorted().collect(Collectors.toList()).equals(ar);

        if()

        int m = ar.size() / 2;
        //[0, s] = [0, m] U [m, s]

        int rl = binary_search();
        if(rl != -1)
        {
            return rl;
        }

        return binary_search();


    }

    private static <T> int search(List<T> ar, T key)
    {
        for(int i = 0; i < ar.size(); i++)
        {
            if(ar.get(i) == key)
            {
                return i;
            }
        }

        return -1;
    }

    private static <T> void test(BiFunction<List<T>, T, Integer> function, List<T> ar, T arg, Integer exp)
    {
        if(function.apply(ar, arg) != exp)
        {
            System.out.println("failed");
        }
        else
        {
            System.out.println("passed");
        }
    }

}



