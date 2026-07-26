package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class EvotorDashboardPage {
    private final SelenideElement chooseTariffButton = $("evo-header-base-sub-button.show-for-attached-menu .go-to-base-sub");

    public EvotorBaseSubscriptionPage clickChooseTariffButton() {
        chooseTariffButton.shouldBe(visible, enabled)
                .shouldHave(text("Выбрать тариф"))
                .click();
        return new EvotorBaseSubscriptionPage();

    }
}
