package enums;

public class Main {

    public static void main(String[] args) {
        final Month month = Month.MARCH;

        System.out.println(month);
        System.out.println(month.getName(Language.AZERBAIJANI));
        System.out.println(month.getName(Language.HUNGARIAN));
        System.out.println(month.getName(Language.ENGLISH));

        final Weekday weekday = Weekday.MONDAY;
        System.out.println(weekday.getName(Language.AZERBAIJANI));
        System.out.println(weekday.getName(Language.HUNGARIAN));
        System.out.println(weekday.getName(Language.ENGLISH));

        System.out.println(weekday.isEarlierThan(Weekday.TUESDAY));
        System.out.println(Weekday.nextDay(weekday));
        System.out.println(Weekday.nextDay(weekday, 3));
        System.out.println(Weekday.getWeekDay(Month.NOVEMBER, 6));

    }
}

