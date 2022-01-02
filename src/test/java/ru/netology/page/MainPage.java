package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement debitButton = $("button:nth-child(3) >span");
    private SelenideElement creditButton = $(".button_view_extra.button_size_m.button_theme_alfa-on-white > span");


    public DebitPage chooseDebitPage() {
        debitButton.click();
        return new DebitPage();
    }

    public CreditPage chooseCreditPage() {
        creditButton.click();
        return new CreditPage();
    }

}