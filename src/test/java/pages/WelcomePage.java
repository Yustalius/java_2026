package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WelcomePage {

    private final SelenideElement priceButton = $$(".t-menu__list li").last();

    public MentoringCostPage openPricePage() {
        priceButton.click();
        return new MentoringCostPage();
    }

}
