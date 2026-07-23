package ru.bulgakov.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class QaTest {

    @Test
    void MentoringPriceShouldBe47000Test() {
        /**
         * Тест-кейс: проверить, что предоплата по обучению - 47 000 рублей
         * 1. открыть поисковик
         * 2. ввести данные сайта (bulgakov qa)
         * 3. нажать кнопку поиск
         * 4. в поисковой выдаче найти нужный сайт, кликнуть на него
         * 5. нажать на кнопку "Стоимость"
         * 6. нажать на кнопку "Хочу вкатиться в QA"
         * 7. нажать на "Бегу оплачивать"
         * 8. проверить что к оплате 47 000 руб.
         */
        //Configuration.holdBrowserOpen = true; //чтобы браузер не закрывался после выполнения теста

        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();
        $(byText("ivanbulgakovqa.ru")).click();
        sleep(3000);

        switchTo().window(1);
        $$(".t-menu__list li").last().click();
        $x("//div[@data-elem-id='1741455941258']//a[@class='tn-atom']").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        sleep(3000);
        $("h3[data-at='H3']").shouldHave(text("₽ 47 000.00"));
    }

    @Test
    void testClickTariffButtonOpensBaseSubPage() {

        open("https://market.evotor.ru/");
        $("[test-id='login-button']").shouldBe(visible, enabled).click();
        $(".evo-link-button").click();

        $(".evo-input__field[type='tel']").shouldBe(visible).setValue("71000001315");
        $(".evo-input__field[type='password']").shouldBe(visible).setValue("123456aA").pressTab();
        $("button[type='submit']").shouldBe(visible, enabled).click();

        $("evo-header-base-sub-button.show-for-attached-menu .go-to-base-sub")
                .shouldBe(visible, enabled)
                .shouldHave(text("Выбрать тариф"))
                .click();

        webdriver().shouldHave(urlContaining("/store/base-sub"));
    }
}
