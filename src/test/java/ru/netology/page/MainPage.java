package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement debitButton = $(byText("Купить"));
    private SelenideElement creditButton = $(byText("Купить в кредит"));


    public DebitPage chooseDebitPage() {
        debitButton.click();
        return new DebitPage();
    }

    public CreditPage chooseCreditPage() {
        creditButton.click();
        return new CreditPage();
    }

}