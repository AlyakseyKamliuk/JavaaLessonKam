package Lesson4;

import java.util.List;
import java.util.Map;

public class Mathematics {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public byte add(byte a, byte b) {
        return (byte) (a + b);
    }

    public short add(short a, short b) {
        return (short) (a + b);
    }

    public long add(long a, long b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public int[] add(int a[], int b[]) {
        String stingArray = a.toString() + b.toString();
        int[] rezArray = new int[a.length + b.length];
        for (int i = 0; i < rezArray.length; i++) {
            rezArray[i] = Integer.parseInt(stingArray.substring(i, i + 1));
        }
        return rezArray;
    }

    public List add(List a, List b) {

        a.addAll(b);
        return a;
    }

    public Map add(Map a, Map b) {
        a.putAll(b);
        return a;
    }

}
