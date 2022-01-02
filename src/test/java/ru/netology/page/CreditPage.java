package ru.netology.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardInfo;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField =$("[placeholder='22']");
    private SelenideElement ownerField = $("div:nth-child(3)  span:nth-child(1) > span > span > span.input__box > input");
    private SelenideElement CVCField = $("[placeholder='999']");

    private SelenideElement continueButton = $("div:nth-child(4) > button");

    private SelenideElement successNotif = $(".notification_status_ok div.notification__content");
    private SelenideElement failedNotif = $(".notification_status_error > div.notification__content");

    private SelenideElement incorrectCardField = $("fieldset > div:nth-child(1)  span.input__sub");
    private SelenideElement incorrectMonthField = $("div:nth-child(2) > span > span:nth-child(1) span.input__sub");
    private SelenideElement inValidMonthField = $("div:nth-child(2) > span > span:nth-child(1)   span.input__sub");
    private SelenideElement incorrectYearField = $("div:nth-child(2) > span > span:nth-child(2)  span.input__sub");
    private SelenideElement incorrectOwnerField = $("div:nth-child(3) > span > span:nth-child(1)   span.input__sub");
    private SelenideElement incorrectCVCField = $("div:nth-child(3) > span > span:nth-child(2) span.input__sub");
    private SelenideElement сardNotif = $("div:nth-child(2) > span > span:nth-child(2)  span.input__sub");

    public void fillForm(CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        ownerField.setValue(cardInfo.getCardOwner());
        CVCField.setValue(cardInfo.getCVC());
        continueButton.click();
    }

    public void emptyForm() {
        continueButton.click();
    }

    public void successNotif() {
        successNotif.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void failNotif() {
        failedNotif.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void cardFail() {
        incorrectCardField.shouldBe(Condition.visible);
    }

    public void monthFail() {
        incorrectMonthField.shouldBe(Condition.visible);
    }

    public void inValMonthFail() {
        incorrectMonthField.shouldBe(Condition.visible);
    }

    public void yearFail() {
        incorrectYearField.shouldBe(Condition.visible);
    }

    public void ownerFail() {
        incorrectOwnerField.shouldBe(Condition.visible);
    }

    public void CVCFail() {
        incorrectCVCField.shouldBe(Condition.visible);
    }
}