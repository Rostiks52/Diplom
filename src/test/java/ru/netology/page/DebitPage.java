package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardInfo;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitPage {

    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField =$("[placeholder='22']");
    private SelenideElement ownerField = $$("span.input__box>input").get(3);
    private SelenideElement CVCField = $("[placeholder='999']");

    private SelenideElement continueButton = $$("[class='button__text']").get(2);

    private SelenideElement successNotif = $(".notification_status_ok div.notification__content");
    private SelenideElement failedNotif = $(".notification_status_error > div.notification__content");

    private SelenideElement incorrectCardField = $("[placeholder='0000 0000 0000 0000']").parent().parent().$(".input__sub");
    private SelenideElement incorrectMonthField = $("[placeholder='08']").parent().parent().$(".input__sub");
    private SelenideElement inValidMonthField = $("[placeholder='08']").parent().parent().$(".input__sub");
    private SelenideElement incorrectYearField = $("[placeholder='22']").parent().parent().$(".input__sub");
    private SelenideElement incorrectOwnerField = $$("span.input__box>input").get(3).parent().parent().$(".input__sub");
    private SelenideElement incorrectCVCField = $("[placeholder='999']").parent().parent().$(".input__sub");
    private SelenideElement сardNotif = $("[placeholder='0000 0000 0000 0000']").parent().parent().$(".input__sub");

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

    public void failedNotif() {
        failedNotif.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void cardNumberFail() {
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