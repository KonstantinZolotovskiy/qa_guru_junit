package pages;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JetbrainsPage {

    SelenideElement
            languageGrid = $("[data-test='language-grid']");
    ElementsCollection
            localeButton = $$("[data-test='language-picker']"),
            locales = $$("[data-test='list-item']"),
            mainMenuItems = $$("[data-test='main-menu-item']");

    public JetbrainsPage openJetbrainsPage() {
        open("/");
        return this;
    }

    public JetbrainsPage selectLocale(String locale) {
        localeButton.first().should(visible).click();
        languageGrid.should(visible);
        locales.findBy(text(locale)).click();
        return this;
    }

    public void checkMainMenuItemsText(List<String> text) {
        mainMenuItems.shouldHave(CollectionCondition.texts(text));
    }

    public void checkUrlAfterChangeLocale(String text) {
        String currentUrl = WebDriverRunner.url();
        assertTrue(currentUrl.contains(text));
    }
}
