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
    void shouldGetErrorWhenLeaveFieldsEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getAllEmptyFields());
        creditPage.emptyForm();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedShortCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getShotCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputEnAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }
    @Test
    void shouldGetErrorWhenInputRuAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRussAlphabCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputSymbolCardNumber() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbolCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorIfLeaveCardNumberEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorIfLeaveMonthEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputInValidMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonth());
        creditPage.inValMonthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputUnAlphabMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputRuAlphabMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRusAlphabMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsSymbolMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsOneDigitMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getOntDigitMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorIfLeaveYearEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsPastYearEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getPastYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsEnAlphabYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEnAlphabYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsRuAlphabYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getRusAlphabYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorIfLeaveOwnerEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsSymbolOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getSymbolsCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsNumericOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getNumericCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorIfLeaveCvcEmpty() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getEmptyCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsIncorrectCardNum() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectCardNumber());
        creditPage.cardFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsIncorrectMonth() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getZeroMonth());
        creditPage.monthFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsIncorrectYear() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectYear());
        creditPage.yearFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsInputIncorrectOwner() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getIncorrectCardOwner());
        creditPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsIncorrectCvc() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getTwoDigitCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }

    @Test
    void shouldGetErrorWhenInputsOneDigitCvc() {
        MainPage mainPage = new MainPage();
        CreditPage creditPage = mainPage.chooseCreditPage();
        creditPage.fillForm(DataHelper.getOneDigitCvc());
        creditPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsCreditPurchase());
    }
}
