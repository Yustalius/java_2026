package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EvotorAuthPage {
    private final SelenideElement loginWithPhoneButton = $(".evo-link-button");
    private final SelenideElement phoneInputField = $(".evo-input__field[type='tel']");
    private final SelenideElement passwordInputField = $(".evo-input__field[type='password']");
    private final SelenideElement submitButton = $("button[type='submit']");

    public EvotorAuthPage selectPhonePasswordLoginMethod() {
        loginWithPhoneButton.click();
        return this;
    }

    public EvotorAuthPage inputPhone(String phoneNumber) {
        phoneInputField.shouldBe(visible).setValue(phoneNumber);
        return this;
    }

    public EvotorAuthPage inputPassword(String password) {
        passwordInputField.shouldBe(visible).setValue(password).pressTab();
        return this;
    }

    public EvotorDashboardPage clickSubmitButton() {
        submitButton.shouldBe(visible, enabled).click();
        return new EvotorDashboardPage();
    }


}
