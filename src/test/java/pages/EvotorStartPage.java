package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EvotorStartPage {
    private final SelenideElement personalCabinetButton= $("[test-id='login-button']");

    public EvotorAuthPage clickPersonalCabinetButton() {
        personalCabinetButton.shouldBe(visible, enabled).click();
        return new EvotorAuthPage();
    }

}
