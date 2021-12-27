package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlUtils;
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;
import ru.netology.page.DebitPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCreditPage {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void setUp() {
        SqlUtils.clearTables();
        open("http://localhost:8080");
    }

    @Test
    void shouldApproveCreditOperUsingApprCard() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getApprovedCardInfo());
        creditPage.successNotif();
        assertEquals("APPROVED", SqlUtils.getStatusCreditPurchase());
        assertEquals(1, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldDeclineOperationUsingDeclCard() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getDeclinedCardInfo());
        creditPage.failNotif();
        assertEquals("DECLINE", SqlUtils.getStatusCreditPurchase());
        assertEquals(1, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveFieldsEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getAllEmptyFields());
        creditPage.emptyForm();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseShortCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getShotCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseEnAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }
    @Test
    void shouldUseRuAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRussAlphabCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseSymbolCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbolCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveCardNumberEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveMonthEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseInValidMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonth());
        creditPage.inValMonthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLUseUnAlphabMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLUseRuAlphabMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRusAlphabMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLUseSymbolMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLUseOneDigitMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getOntDigitMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveYearEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUsePastYearEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getPastYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseEnAlphabYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseRuAlphabYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRusAlphabYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveOwnerEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseSymbolOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbolsCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldUseNumericOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getNumericCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldLeaveCvcEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputIncorrectCardNum() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputIncorrectMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getZeroMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputIncorrectYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputIncorrectOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputIncorrectCvc() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getTwoDigitCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldInputOneDigitCvc() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getOneDigitCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }
}
