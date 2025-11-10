package enums;

/**
 * Represents the twelve months of the Gregorian calendar.
 * <p>
 * Each month enum constant includes:
 * <ul>
 *   <li>its name in English, Hungarian, and Azerbaijani</li>
 *   <li>its number of days (not accounting for leap years)</li>
 * </ul>
 *
 * Example usage:
 * <pre>{@code
 * Month month = Month.MARCH;
 * System.out.println(month.getName(Language.AZERBAIJANI)); // "Mart"
 * System.out.println(month.getDayCount()); // 31
 * }</pre>
 */
enum Month implements Localizable {

    /** January — 31 days. */
    JANUARY("January", "Januar", "Yanvar", 31),

    /** February — 28 days (ignores leap years). */
    FEBRUARY("February", "Februar", "Fevral", 28),

    /** March — 31 days. */
    MARCH("March", "Marcius", "Mart", 31),

    /** April — 30 days. */
    APRIL("April", "Aprilis", "Aprel", 30),

    /** May — 31 days. */
    MAY("May", "Majus", "May", 31),

    /** June — 30 days. */
    JUNE("June", "Junius", "Iyun", 30),

    /** July — 31 days. */
    JULY("July", "Julius", "Iyul", 31),

    /** August — 31 days. */
    AUGUST("August", "Augusztus", "Avqust", 31),

    /** September — 30 days. */
    SEPTEMBER("September", "Szeptember", "Sentyabr", 30),

    /** October — 31 days. */
    OCTOBER("October", "Oktober", "Oktyabr", 31),

    /** November — 30 days. */
    NOVEMBER("November", "November", "Noyabr", 30),

    /** December — 31 days. */
    DECEMBER("December", "December", "Dekabr", 31);

    private final String englishName;
    private final String hungarianName;
    private final String azerbaijaniName;
    private final Integer dayCount;

    /**
     * Constructs a {@code Month} constant with localized names and day count.
     *
     * @param englishName    the English name of the month
     * @param hungarianName  the Hungarian name of the month
     * @param azerbaijaniName the Azerbaijani name of the month
     * @param dayCount       the number of days in the month (without leap year adjustment)
     */
    Month(String englishName, String hungarianName, String azerbaijaniName, Integer dayCount) {
        this.englishName = englishName;
        this.hungarianName = hungarianName;
        this.azerbaijaniName = azerbaijaniName;
        this.dayCount = dayCount;
    }

    /**
     * Returns the name of this month in the specified language.
     *
     * @param lang the {@link Language} in which the name should be returned
     * @return the localized month name
     */
    public String getName(Language lang) {
        return lang.getName(this);
    }

    /**
     * Returns the number of days in this month.
     * <p>
     * Note: This value does not account for leap years.
     *
     * @return the number of days in this month
     */
    public Integer getDayCount() {
        return dayCount;
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
