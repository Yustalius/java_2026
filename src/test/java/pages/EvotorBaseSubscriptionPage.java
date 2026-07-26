package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class EvotorBaseSubscriptionPage {

    public EvotorBaseSubscriptionPage verifyBaseSubscriptionPageOpened() {
        webdriver().shouldHave(urlContaining("/store/base-sub"));
        return this;
    }
}

