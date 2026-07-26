package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.EvotorStartPage;
import pages.YandexSearchPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class QaTest {

    @Test
    @DisplayName("Проверить что цена обучения 47000 рублей")
    @Tag("POSITIVE")
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

        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                .openLink("ivanbulgakovqa.ru")
                .openPricePage()
                .clickJoinQAButton()
                .clickProccedToCheckoutButton()
                .priceShouldBe("₽ 47 000.00");
    }

    @Test
    @DisplayName("Проверка что кнопка 'Выбрать тариф'открывает страницу базовой подписки")
    @Tag("POSITIVE")
    void clickTariffButtonOpensBaseSubPageTest() {

        open("https://market.evotor.ru/", EvotorStartPage.class)
                .clickPersonalCabinetButton()
                .selectPhonePasswordLoginMethod()
                .inputPhone("71000001315")
                .inputPassword("123456aA")
                .clickSubmitButton()
                .clickChooseTariffButton()
                .verifyBaseSubscriptionPageOpened();
    }
}
