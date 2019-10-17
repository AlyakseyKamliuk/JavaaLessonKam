import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("     Задача 1");
        intToString(500000000);
        System.out.println("     Задача 2");
        stringToInt("1231233456");
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
        timeConvert((long) 50000000);
        System.out.println("     Задача 7");
        timeConvert2((long) 50000000);
        System.out.println("     Задача 8");
        System.out.println(stringtoUpLowCase("SdfsaddDD"));
        System.out.println("     Задача 9");
        calcOfAreaAndCircum(5);
        System.out.println("     Задача 10");
        System.out.println(isCircleCoversRectangle(10, -16, -6));
        System.out.println("     Задача 11 (три способа)");
        ageCalculate1(1984, 6, 30);
        System.out.println(ageCalculate2(30,6,1984));
        ageCalculate3(7,7,1972);

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
        long rez;
        rez = Integer.valueOf(s);
        System.out.println("Способ 1:" + rez);

        rez = Integer.parseInt(s);
        System.out.println("Способ 2:" + rez);

      char[] chars;
        chars = s.toCharArray();

        rez = 0;
        for (int i = 0; i < chars.length; i++) {
            rez = rez*10 + Integer.parseInt((""+chars[i]));
        }
        System.out.println("Способ 3:" + rez);

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

    public static void timeConvert(long hours) {
        System.out.println(hours + " час(ов) это " + hours * 60 + " минут, или " + hours * 3600 + " секунд");
    }


    public static void timeConvert2(Long seconds) {
        Long day = TimeUnit.SECONDS.toDays(seconds);
        Long remainderOfDivision = seconds % 86400;
        Long hours = remainderOfDivision / 3600;
        Long minutes = remainderOfDivision % 3600 / 60;
        Long secondsRez = remainderOfDivision % 3600 % 60 % 60;
        System.out.println(seconds + " секунд это:" + day + " дней " + hours + " часов " + minutes + " минут " + secondsRez + " секунд");

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

    public static boolean isCircleCoversRectangle(int length, int width, int radius) {
        double diagonal = Math.sqrt(length * length + width * width);
        return diagonal <= radius * 2;
    }

    public static void ageCalculate1(int year, int month, int day) {
        Calendar age = new GregorianCalendar();
        age.add(Calendar.DAY_OF_MONTH, -day);
        age.add(Calendar.MONTH, -(month));
        age.add(Calendar.YEAR, -year);
        String buf = age.toString();
        String[] chars = buf.split(",");
        System.out.println("Ваш возраст составляет:" + chars[13].substring(chars[13].lastIndexOf('=') + 1) + " лет " + (Integer.parseInt(chars[14].substring(chars[14].lastIndexOf('=') + 1)) + 1) + " месяцев " + chars[17].substring(chars[17].lastIndexOf('=')+1) + " дней");
    }

        public static String ageCalculate2(int day, int month, int year){

            LocalDate birthday = LocalDate.of(year, month, day);
            Period vozrast = Period.between(birthday, LocalDate.now());
            return "Ваш возраст составляет:" + vozrast.getYears() + " лет " + vozrast.getMonths() + " месяцев " + vozrast.getDays() + " дней";

    }

    public static void ageCalculate3(int day, int month, int year) {
        LocalDate rez = LocalDate.now().minus(Period.of(year, month, day));
        System.out.println("Ваш возраст составляет:" + rez.getYear() + " лет " + rez.getMonthValue() + " месяцев " + rez.getDayOfMonth() + " дней");
    }
}
