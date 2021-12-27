package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardInfo;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DebitPage {

    private SelenideElement cardNumber = $(byText("Номер карты")).parent().$(".input__control");
    private SelenideElement month = $(byText("Месяц")).parent().$(".input__control");
    private SelenideElement year = $(byText("Год")).parent().$(".input__control");
    private SelenideElement owner = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement CVC = $(byText("CVC/CVV")).parent().$(".input__control");

    private SelenideElement continueButton = $(byText("Продолжить"));

    private SelenideElement successNotif = $(byText("Операция одобрена Банком."));
    private SelenideElement failedNotif = $(byText("Ошибка! Банк отказал в проведении операции."));

    private SelenideElement incorrectCard = $(byText("Номер карты")).parent().$(".input__sub");
    private SelenideElement incorrectMonth = $(byText("Месяц")).parent().$(".input__sub");
    private SelenideElement inValidMonth = $(byText("Неверно указан срок действия карты")).parent().$(".input__sub");

    private SelenideElement incorrectYear = $(byText("Год")).parent().$(".input__sub");
    private SelenideElement incorrectOwner = $(byText("Владелец")).parent().$(".input__sub");
    private SelenideElement incorrectCVC = $(byText("CVC/CVV")).parent().$(".input__sub");
    private SelenideElement сardNotif = $(byText("Истёк срок действия карты"));

    public void fillForm(CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        owner.setValue(cardInfo.getCardOwner());
        CVC.setValue(cardInfo.getCVC());
        continueButton.click();
    }

    public void emptyForm() {
        continueButton.click();
    }

    public void successNotif() {
        successNotif.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void failedNotif() {
        failedNotif.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void cardNumberFail() {
        incorrectCard.shouldBe(Condition.visible);
    }

    public void monthFail() {
        incorrectMonth.shouldBe(Condition.visible);
    }

    public void inValMonthFail() {
        incorrectMonth.shouldBe(Condition.visible);
    }

    public void yearFail() {
        incorrectYear.shouldBe(Condition.visible);
    }

    public void ownerFail() {
        incorrectOwner.shouldBe(Condition.visible);
    }

    public void CVCFail() {
        incorrectCVC.shouldBe(Condition.visible);
    }

}