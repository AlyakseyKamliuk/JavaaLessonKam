import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        System.out.println("     Задача 1");
        intToString(18);
        System.out.println("     Задача 2");
        stringToInt("152");
        System.out.println("     Задача 3");
        evenNumberTest(12);
        evenNumberTest(11);
        System.out.println("     Задача 4");
        endsAtSevenTest(127567);
        endsAtSevenTest(1275);
        System.out.println("     Задача 5");
        System.out.println(containsChar("sdfgjfgnjn", 'a'));
        System.out.println(containsChar("sdfgjfgnjn", 'd'));
        System.out.println("     Задача 6");
        timeConvert(20);
        System.out.println("     Задача 7");
        timeConvert2((long) 200000);
        System.out.println("     Задача 8");
        System.out.println(stringtoUpLowCase("SdfsaddDD"));
        System.out.println("     Задача 9");
        calcOfAreaAndCircum(5);
        System.out.println("     Задача 10");
        System.out.println(ovRectAroun(12, 16, 6));
        System.out.println("     Задача 11");
        ageCalculate(1984, 6, 30);
    }

    public static void intToString(int a) {
        String s;
        s = "" + a;
        System.out.println("Способ 1:" + s);

        s = String.valueOf(a);
        System.out.println("Способ 2:" + s);

        s = Integer.toString(a);
        System.out.println("Способ 3:" + s);

        Integer a2 = a;
        s = a2.toString();
        System.out.println("Способ 4:" + s);
    }

    public static void stringToInt(String s) {
        int a;
        a = Integer.valueOf(s);
        System.out.println("Способ 1:" + a);

        a = Integer.parseInt(s);
        System.out.println("Способ 2:" + a);

        char[] chars;
        chars = s.toCharArray();
        a = 0;
        for (int i = 0; i < chars.length; i++) {
            a = a + chars[i];
        }
        System.out.println("Способ 3:" + a);

    }

    public static void evenNumberTest(int a) {
        if (a % 2 == 1) System.out.println("Не четное");
        else System.out.println("Четное");
    }

    public static void endsAtSevenTest(int a) {
        String s = "" + a;
        s = s.substring(s.length() - 1);
        if (Integer.parseInt(s) == 7) System.out.println("Последняя цифра равна 7");
        else System.out.println("Последняя цифра не равна 7");
    }

    public static boolean containsChar(String s, char c) {
        return s.contains(String.valueOf(c));
    }

    public static void timeConvert(int hours) {
        System.out.println(hours + " час(ов) это " + hours * 60 + " минут, или " + hours * 3600 + " секунд");
    }


    public static void timeConvert2(Long seconds) {
        Long day=seconds/86400;
        Long ostatok=seconds%86400;
        Long hours=ostatok/3600;
        Long minutes=ostatok%3600/60;
        Long secondsRez=ostatok%3600%60%60;
        System.out.println(seconds+" секунд это:"+day+" дней "+hours+" часов "+minutes+" минут "+secondsRez +" секунд");

    }

    public static String stringtoUpLowCase(String s) {
        char[] chars = s.toCharArray();
        String rez = "";
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                s = "" + chars[i];
                rez = rez + s.toUpperCase();
            } else {
                s = "" + chars[i];
                rez = rez + s.toLowerCase();
            }
        }
        return rez;
    }

    public static void calcOfAreaAndCircum(int radius) {
        System.out.println("Площадь " + Math.PI * radius * radius);
        System.out.println("Длина окружности " + 2 * Math.PI * radius);
    }

    public static boolean ovRectAroun(int length, int width, int radius) {
        double diagonal = Math.sqrt(length * length + width * width);
        return diagonal <= radius * 2;
    }

    public static void ageCalculate(int year, int month, int day) {

        Calendar age = new GregorianCalendar();
        age.add(Calendar.MONTH, -month - 1);
        age.add(Calendar.YEAR, -year);
        age.add(Calendar.DAY_OF_MONTH, -day);
        System.out.println(age.getTime());
        System.out.println("Ваш возраст:"+age.get(1)+" лет");
    }

}
