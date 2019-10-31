import java.time.LocalDate;
import java.time.Period;

public enum Holiday {
    NEWYER(LocalDate.of(LocalDate.now().getYear(), 12, 30)),
    CHRISTMAS(LocalDate.of(LocalDate.now().getYear(), 1, 5)),
    LABORDAY(LocalDate.of(LocalDate.now().getYear(), 5, 1));


    LocalDate date;

    Holiday(LocalDate date) {
        this.date = date;
    }

    public void holidayPassed() {

        if (this.getDate().minus(Period.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth())).toString().substring(0,1).contains("-"))  {
            System.out.printf("%s %s Прошел \n",this.name(),this.getDate());
            }else {System.out.printf("%s %s Еще будет \n", this.name(),this.getDate());

            }

    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return "Holiday{" +
                "date=" + date +
                '}';
    }
}
