package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapEquals {


    @Test
    public void testHashMapEquals() {

        int size = 1000;
        Map<Key, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            map.put(new Key(i), i);
        }

        Assertions.assertEquals(size, map.size());
    }


    class Key {

        private int value;

        public Key(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
