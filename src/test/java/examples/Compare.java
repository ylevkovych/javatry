package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {

    class Comp1 implements Comparable<Comp1> {
        int value;

        Comp1 (int v) {
            this.value = v;
        }

        @Override
        public int compareTo(Comp1 o) {
            return this.value - o.value;
        }
    }

    class Comp2 {
        int value;

        Comp2 (int v) {
            this.value = v;
        }

    }

    @Test
    public void testComparable() {
        Comp1 c1 = new Comp1(1);
        Comp1 c2 = new Comp1(2);

        List<Comp1> list = new ArrayList<>();
        list.add(c2);
        list.add(c1);

        Collections.sort(list);

        Assertions.assertTrue(list.get(0).equals(c1));
    }

    @Test
    public void testCamparator() {
        Comp2 c1 = new Comp2(1);
        Comp2 c2 = new Comp2(2);

        List<Comp2> list = new ArrayList<>();
        list.add(c2);
        list.add(c1);

        Comparator<Comp2> desc = (o1, o2) -> o2.value - o1.value;
        Comparator<Comp2> asc = (o1, o2) -> o1.value - o2.value;

        Collections.sort(list, desc);
        Assertions.assertTrue(list.get(0).equals(c2));

        Collections.sort(list, asc);
        Assertions.assertTrue(list.get(0).equals(c1));
    }

}
