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
        List<String> ar2 = Arrays.asList("a1","a2","a3","a7","a87");
        List<Integer> ar3 = Arrays.asList(1,4,7,9,87);
        List<Integer> ar4 = Arrays.asList(1,4,7,8,8,8,8,8,8,8,8,9,87);
/*
        test(algo1::search,ar,5,1);
        test(algo1::search,ar,5,-1);
        test(algo1::search,ar2,"a22", 2);

        test(algo1::binary_search, ar, 7, 2);*/

        //test(algo1::binary_search_lb, ar3,8, ar3.size());
        //test(algo1::binary_search_lb, ar3,87, 4);

        //test(algo1::binary_search_lb, ar4,87, 4);
        //test(algo1::binary_search_lb, ar4,8, 3);

        test(algo1::binary_search_ub, ar4, 8, 10);
        //test(algo1::binary_search_lb, ar2, "a2", 1);
        //test(algo1::binary_search_lb, ar2, "a4", 1);
        //test(algo1::binary_search_lb, ar2, "a4", ar2.size());

    }

    private static <T extends Comparable> int binary_search(List<T> ar, T key)
    {
        return binary_search_r(ar,key, 0, ar.size()-1);
    }

    private static <T extends Comparable> int binary_search_r(List<T> ar, T key, Integer start, Integer end)
    {
        assert ar.stream().sorted().collect(Collectors.toList()).equals(ar);

        if(start < end) {

            int m = (end + start) / 2;
            //[0, s] = [0, m] U [m, s]

            if (ar.get(m).compareTo(key) > 0) {
                return binary_search_r(ar, key, start, m);
            } else if (ar.get(m).compareTo(key) < 0) {
                return binary_search_r(ar, key, m, end);
            } else {
                return m;
            }
        }

        return -1;
    }

    private static <T extends Comparable> int binary_search_r_i(List<T> ar, T key, Integer start, Integer end)
    {
        assert ar.stream().sorted().collect(Collectors.toList()).equals(ar);

        if(start < end) {

            int m = (end + start) / 2;
            //[0, s] = [0, m] U [m, s]

            if (ar.get(m).compareTo(key) > 0) {
                return binary_search_r(ar, key, start, m);
            } else if (ar.get(m).compareTo(key) < 0) {
                return binary_search_r(ar, key, m, end);
            } else {
                return m;
            }
        }

        return -1;
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

    private static <T extends Comparable> int lower_bound(List<T> ar, T key)
    {
        int b = 0;
        int e = ar.size();

        while(b < e)
        {
            int m = b + (e - b) / 2;

            if(ar.get(m).compareTo(key) < 0)
            {
                b = m + 1;
            }
            else
            {
                e = m;
            }
        }
        return b;
    }

    private static <T extends Comparable> int upper_bound(List<T> ar, T key)
    {
        int b = 0;
        int e = ar.size();

        while(b < e)
        {
            int m = (b + e) / 2;

            if(ar.get(m).compareTo(key) > 0)
            {
                e = m -1;
            }
            else
            {
                b = m;
            }
        }
        return b;
    }

    private static <T extends Comparable> int binary_search_lb(List<T> ar, T key)
    {
        int ind = lower_bound(ar, key);

        if (ar.get(ind).compareTo(key) > 0)
        {
            return ar.size();
        }
        else
        {
            return ind;
        }
    }

    private static <T extends Comparable> int binary_search_ub(List<T> ar, T key)
    {
        int ind = upper_bound(ar, key);

        if (ar.get(ind).compareTo(key) < 0)
        {
            return ind;
        }
        else
        {
            return ar.size();
        }
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



