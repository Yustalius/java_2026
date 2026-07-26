package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private final SelenideElement priceField = $("h3[data-at='H3']");

    public PaymentPage priceShouldBe(String expectedPrice) {
        priceField.shouldHave(text(expectedPrice), Duration.ofSeconds(15));
        return this;
    }

}
