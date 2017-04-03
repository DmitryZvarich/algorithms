import java.lang.reflect.Array;
import java.util.*;
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
        assert false;

        assert true;

        List<Integer> ar = Arrays.asList(1,4,2,7,3,87);
        List<String> ar2 = Arrays.asList("a1","a2","a3","a7","a87");
        List<Integer> ar3 = Arrays.asList(1,4,7,9,87);
        List<Integer> ar4 = Arrays.asList(1,4,7,8,8,8,8,8,8,8,8,9,87);

        Integer[] a = {1,4,7,8,8,8,8,8,8,8,8,9,87};


        List<Integer> ar5 = Arrays.asList(7,2,9,1,0,43);

        assert ar5.stream().sorted().collect(Collectors.toList()).equals(ar);






        Integer[] aa = {1,3,5,7};
        Integer[] bb = {2,4,6,8,9,19,20};

        Arrays.asList(merge(aa,bb)).stream().forEach(System.out::println);




        //System.out.println(insertion_sort(ar5));


        //System.out.println(lower_bound(ar4,6));


        //testFunction(algo1::sort, new Integer[0], new Integer[0]);

        //testFunction(algo1::sort, new Integer[]{6,9,4,2,7}, new Integer[]{2,4,6,7,9});

        Integer[] arg = new Integer[]{6,9,4,2,7};
        sort(arg);

        //testFunction(algo1::sort, arg, new Integer[]{2,4,6,7,9});

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




    private static <T extends Comparable> List<T> insertion_sort(List<T> unsorted)
    {
        List<T> sorted = new ArrayList<>();
        sorted.add(unsorted.get(0));

        for(int i = 1; i < unsorted.size(); i++)
        {
            int pos = lower_bound(sorted,unsorted.get(i));

            List<T> tmp = new ArrayList<>();

            if(pos > 0) {
                tmp.addAll(sorted.subList(0, pos - 1));
            }
            tmp.add(unsorted.get(pos));
            tmp.addAll(sorted.subList(pos,sorted.size()-1));



            sorted = tmp;
        }

        return sorted;
    }
    //private static <T extends Comparable> int getPos(T[] ar, int e, T key)


    private static <T> void merge_sort(T[] ar)
    {
        if(ar.length > 1)
        {
            int m = ar.length/2;

            Arrays.copyOfRange(ar, 0, m);
            Arrays.copyOfRange(ar, m+1, ar.length);

        }
    }

    private static Integer[] merge(Integer[] ar1, Integer[]ar2)
    {
        Integer[] result = new Integer[ar1.length+ar2.length];
        int ind1 = 0;
        int ind2 = 0;
        for(int i = 0; i < result.length; i++) {
            if (ind1 < ar1.length && ind2 < ar2.length) {
                result[i] = (ar1[ind1] < ar2[ind2]) ? ar1[ind1++] : ar2[ind2++];
                continue;
            }

            result[i] = (ind2 == ar2.length) ? ar1[ind1++] : ar2[ind2++];
        }
        return result;
    }


    private static void quickSort(Integer[] ar)
    {
        int b2 = 0;
        int e2 = 0;

        while (e2 < ar.length - 1)
        {
            b2++;
            if(ar[e2] < pivot)
            {
                swap(ar, b2, e2);
                b2++;
            }
        }
    }




    private static void swap(Integer[] ar, int i, int j)
    {
        Integer tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    private static


}



