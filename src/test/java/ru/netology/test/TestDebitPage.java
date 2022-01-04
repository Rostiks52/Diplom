package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlUtils;
import ru.netology.page.DebitPage;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDebitPage {


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
    void shouldApprovedOperationUsingApprCard() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getApprovedCardInfo());
        debitPage.successNotif();
        assertEquals("APPROVED", SqlUtils.getStatusDebitPurchase());
        assertEquals(1, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldDeclineOperationUsingDeclCard() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getDeclinedCardInfo());
        debitPage.failedNotif();
        assertEquals("DECLINED", SqlUtils.getStatusDebitPurchase());
        assertEquals(1, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveFieldsEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getAllEmptyFields());
        debitPage.emptyForm();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenShortCardNumberUsed() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getShotCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedEnAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedSymbolCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbolCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedRuAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRussAlphabCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveCardNumberEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveMonthEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedInvalidMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getInvalidMonth());
        debitPage.inValMonthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedEnAlphabMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUGetErrorWhenUsedRuAlphabMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRusAlphabMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedSymbolMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedOneDigitMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getOntDigitMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveYearEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedPastYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getPastYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedEnAlphabYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedRuAlphabYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRusAlphabYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveOwnerEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedSymbolOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbolsCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenUsedNumericOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getNumericCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenLeaveCvcEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputIncorrectCardNum() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputIncorrectMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getZeroMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputIncorrectYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputIncorrectOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputIncorrectCvc() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getTwoDigitCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldGetErrorWhenInputOneDigitCvc() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getOneDigitCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }
}
