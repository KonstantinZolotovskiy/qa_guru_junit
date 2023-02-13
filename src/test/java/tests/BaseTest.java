package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        browserSize = "1920x1080";
        baseUrl = "https://www.jetbrains.com";
    }
}
