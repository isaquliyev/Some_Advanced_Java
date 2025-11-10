package enums;


import java.util.function.Function;

/**
 * Available languages that can be selected by methods of [getName].
 */
enum Language {
    ENGLISH(Localizable::getEnglishName),
    HUNGARIAN(Localizable::getHungarianName),
    AZERBAIJANI(Localizable::getAzerbaijaniName);

    private final Function<Localizable, String> extractor;

    Language(Function<Localizable, String> extractor) {
        this.extractor = extractor;
    }

    public String getName(Localizable localizable) {
        return extractor.apply(localizable);
    }
}
