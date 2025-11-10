package enums;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Represents days of week.
 * <p>
 * Each weekday enum contains:
 * <ul>
 *     <li>its name in english, hungarian and azerbaijani<li/>
 *
 *
 */
enum Weekday implements Localizable {
    MONDAY("Monday", "Hetfo", "Bazar ertesi"),
    TUESDAY("Tuesday", "Kedd", "Cersembe axsami"),
    WEDNESDAY("Wednesday", "Szerda", "Cersembe"),
    THURSDAY("Thursday", "Csutortok", "Cume axsami"),
    FRIDAY("Friday", "Pentek", "Cume"),
    SATURDAY("Saturday", "Szombat", "Sembe"),
    SUNDAY("Sunday", "Vasarnap", "Bazar");

    private final String englishName;
    private final String hungarianName;
    private final String azerbaijaniName;


    /**
     * Constructs  a {@code Weekday} constant with localized names.
     *
     * @param englishName - English name of day
     * @param hungarianName - Hungarian name of day
     * @param azerbaijaniName - Azerbaijani name of day
     */
    Weekday(String englishName, String hungarianName, String azerbaijaniName) {
        this.englishName = englishName;
        this.hungarianName = hungarianName;
        this.azerbaijaniName = azerbaijaniName;
    }

    /**
     * A method that takes {@link Language} and based on selected language return name of day
     * @param lang Selected language
     * @return Name of day for selected language.
     */
    String getName(Language lang) {
        return lang.getName(this);
    }

    /**
     * Returns weekday based on date.
     *
     *
     * @param month Selected month {@link Month}
     * @param day Integer that represents day of month
     * @return Weekday for specified month and day.
     */
    static Weekday getWeekDay(Month month, Integer day) {

        int total = day + 2 +
                IntStream.range(0, month.ordinal())
                        .map(i -> Month.values()[i].getDayCount())
                        .sum();

        int index = total % 7 != 0 ? total % 7 - 1 : 6;
        return Weekday.values()[index];
    }


    /**
     * Check that the day of week is true for selected date
     *
     * @param month Selected month {@link Month}
     * @param day Integer that represents day of month
     * @return Boolean value; if day matches true, otherwise false.
     */
    public boolean isThisDay(Month month, Integer day) {
        return this == getWeekDay(month, day);
    }

    /**
     * Static class method that takes two different day and decide if first day is earlier than second day
     *
     * @param first First weekday entered by user
     * @param second Second weekday entered by user
     * @return Boolean value; if first day is earlier than second then true, otherwise false
     */

    public static boolean isEarlierThan(Weekday first, Weekday second) {
        return first.ordinal() < second.ordinal();
    }


    /**
     * Instance method that checks this day is earlier than entered day
     * @param other Other day entered by user
     * @return Boolean value; if this day is earlier than inputted then true, otherwise false
     */
    public boolean isEarlierThan(Weekday other) {
        return this.ordinal() < other.ordinal();
    }

    /**
     * Static class method that finds next day of selected day
     * @param weekday The day that next day of this day will be found
     * @return Next day of week for weekday. If Sunday then next day is Monday
     */
    public static Weekday nextDay(Weekday weekday) {
        return Weekday.values()[(weekday.ordinal() + 1) % 7];
    }

    /**
     * Static class method that finds next nth day of selected day
     * @param weekday The day that next nth day of this day will be found
     * @param n Integer that represents how many days (n - 1) will be skipped
     * @return Next nth day of week for weekday.
     */
    public static Weekday nextDay(Weekday weekday, Integer n) {
        return Weekday.values()[(weekday.ordinal() + n) % 7];
    }

    @Override
    public String getEnglishName() {
        return this.englishName;
    }

    @Override
    public String getHungarianName() {
        return this.hungarianName;
    }

    @Override
    public String getAzerbaijaniName() {
        return this.azerbaijaniName;
    }
}
