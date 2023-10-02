package examples.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSort {


    private int[] test;

    private int[] result;

    private boolean equals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;

        return true;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("");
    }

    private void doBubbleSortToLeft(int[] arr) {

        System.out.println("bubble to left: ");

        if (arr.length == 0)
            return;

        for (int a = 0; a < arr.length; a++) {
            for (int i = arr.length-1; i > a; i--) {
                if (arr[i] < arr[i - 1]) {
                    int t = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = t;
                }
            }
            print(arr);
        }

    }

    private void doBubbleSortToRight(int[] arr) {

        System.out.println("bubble to right: ");

        if (arr.length == 0)
            return;

        for (int a = arr.length-1; a >= 0; a--) {
            for (int i = 0; i < a; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = t;
                }
            }
            print(arr);
        }

    }

    @BeforeEach
    public void setup() {
        test = new int[]{7, 1, 3, 9, 2, 4, 6, 7, 5};

        result = test.clone();
        Arrays.sort(result);
    }

    @Test
    public void testBubleSortToLeft() {
        doBubbleSortToLeft(test);
        Assertions.assertTrue(equals(test, result));
    }

    @Test
    public void testBubleSortToRight() {
        doBubbleSortToRight(test);
        Assertions.assertTrue(equals(test, result));
    }
}
