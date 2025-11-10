package enums;

public class Main {

    public static void main(String[] args) {
        final Month month = Month.MARCH;

        System.out.println(month);
        System.out.println(month.getNameFunction().apply(Language.AZERBAIJANI));
        System.out.println(month.getName(Language.HUNGARIAN));
        System.out.println(month.getName(Language.ENGLISH));

        final Weekday weekday = Weekday.MONDAY;
        System.out.println(weekday.getName(Language.AZERBAIJANI));
        System.out.println(weekday.getName(Language.HUNGARIAN));
        System.out.println(weekday.getName(Language.ENGLISH));

        System.out.println(weekday.isEarlierThan(Weekday.TUESDAY));

        System.out.println("\nNextDays\n");
        System.out.println(Weekday.nextDay(weekday));
        System.out.println(Weekday.nextDay(weekday, 3));
        //System.out.println(Weekday.nextDayBiFunction().apply(weekday, 3));
        System.out.println(Weekday.nextDayBiFunction().andThen(x -> x == Weekday.WEDNESDAY ? "Yes" : "No").apply(weekday, 3));
        System.out.println(Weekday.getWeekDay(Month.NOVEMBER, 6));

        System.out.println(Weekday.THURSDAY.isThisDay(Month.NOVEMBER, 6));
        System.out.println(Weekday.THURSDAY.isThisDayBiFunction().apply(Month.NOVEMBER, 6));

    }
}

