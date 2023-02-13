package tests;

import enums.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.JetbrainsPage;

import java.util.List;
import java.util.stream.Stream;

public class JetbrainsPageTests extends BaseTest {

    JetbrainsPage jetbrains = new JetbrainsPage();

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Locale.RU.getValue(), List.of("Разработчикам", "Командам", "Образование", "Решения", "Поддержка", "Магазин")),
                Arguments.of(Locale.EN.getValue(), List.of("Developer Tools", "Team Tools", "Education", "Solutions", "Support", "Store"))
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "Для {0} локали отображаются элементы меню {1}")
    void checkMainMenuItemTextInDifferentLocalesWithMethodSource(String locale, List<String> text) {
        jetbrains.openJetbrainsPage()
                .selectLocale(locale)
                .checkMainMenuItemsText(text);
    }

    @CsvSource({
            "Français, fr-fr",
            "Deutsch, de-de"
    })
    @ParameterizedTest(name = "URL должен иметь подстроку {1} в {0} локали")
    void checkUrlAfterChangeLocaleWithCsvSource(String locale, String text) {
        jetbrains.openJetbrainsPage()
                .selectLocale(locale)
                .checkUrlAfterChangeLocale(text);
    }

    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "URL должен иметь подстроку {1} в {0} локали")
    void checkUrlAfterChangeLocaleWithCsvFileSource(String locale, String text) {
        jetbrains.openJetbrainsPage()
                .selectLocale(locale)
                .checkUrlAfterChangeLocale(text);
    }
}