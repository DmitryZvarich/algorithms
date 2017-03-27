import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by odsptc13 on 3/16/2017.
 */
public class algo1<T> {
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1,4,2,7,3,87);
        List<String> ar2 = Arrays.asList("a1","a2","a3","a7","a87");
        List<Integer> ar3 = Arrays.asList(1,4,7,9,87);
        List<Integer> ar4 = Arrays.asList(1,4,7,8,8,8,8,8,8,8,8,9,87);

        Integer[] a = {1,4,7,8,8,8,8,8,8,8,8,9,87};


        //testFunction(algo1::sort, new Integer[0], new Integer[0]);

        //testFunction(algo1::sort, new Integer[]{6,9,4,2,7}, new Integer[]{2,4,6,7,9});

        Integer[] arg = new Integer[]{6,9,4,2,7};
        sort(arg);


        testFunction(algo1::sort, arg, new Integer[]{2,4,6,7,9});



        //System.out.println(min(a, 0, a.length-1));
        //test(algo1::i);
/*
        test(algo1::search,ar,5,1);
        test(algo1::search,ar,5,-1);
        test(algo1::search,ar2,"a22", 2);

        test(algo1::binary_search, ar, 7, 2);*/

        //test(algo1::binary_search_lb, ar3,8, ar3.size());
        //test(algo1::binary_search_lb, ar3,87, 4);

        //test(algo1::binary_search_lb, ar4,87, 4);
        //test(algo1::binary_search_lb, ar4,8, 3);

        //System.out.println(binary_search_ub(ar4,8));

        //test(algo1::binary_search_ub, ar4, 8, 11);





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
                e = m;
            }
            else
            {
                b = m + 1;
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

        if (ar.get(ind-1).compareTo(key) < 0)
        {
            return ar.size();

        }
        else
        {
            return ind;
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

    private static <T> void testFunction(Consumer<T[]> consumer, T[] arg, T[] exp)
    {
        consumer.accept(arg);
        if(!Arrays.equals(arg, exp))
        {
            System.out.println("failed");
        }
        else
        {
            System.out.println("passed");
        }
    }

    private static <T extends Comparable> T min(T[] ar, int b, int e)
    {
        T m = ar[0];

        int i = 1;
        while (i<ar.length)
        {
            if(ar[i].compareTo(m)<0)
            {
                m = ar[i];
            }
            i++;
        }

        return m;
    }

    private static <T extends Comparable> int min_(T[] ar, int b, int e)
    {

        int min_index = b;


        while (++b < e)
        {
            if(ar[b].compareTo(ar[min_index])<0)
            {
                min_index = b;
            }
        }

        return min_index;
    }

    private static <T extends Comparable> void sort(T[] ar)
    {
        for (int i = 0; i< ar.length; i++)
        {
            int min = min_(ar,i,ar.length);
            T buf = ar[i];
            ar[i] = ar[min];
            ar[min] = buf;
        }
    }

}



