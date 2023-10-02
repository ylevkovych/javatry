package examples.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    int[] test;
    int[] result;

    private boolean equals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;

        return true;
    }

    private void doQuicksort(int[] a, int lo, int hi) {

        if (lo >= hi)
            return;

        int p = a[lo];
        int i = lo; int j = hi;

        while (i < j) {

            while(a[i] <= p && i < hi) i++;

            while(p <= a[j] && j > lo) j--;

            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        if (j > lo) {
            a[lo] = a[j];
            a[j] = p;
        }

        doQuicksort(a, lo, j);
        doQuicksort(a, j+1, hi);

    }

    @BeforeEach
    public void setup() {
        test = new int[]{7, 8, 1, 3, 9, 7, 2, 4, 6, 5, 7};

        result = test.clone();
        Arrays.sort(result);
    }

    @Test
    public void testQuicksort() {
        doQuicksort(test, 0, test.length-1);

        Assertions.assertTrue(equals(test,result));
    }



}
