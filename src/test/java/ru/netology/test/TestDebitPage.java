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
    void shouldLeaveFieldsEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getAllEmptyFields());
        debitPage.emptyForm();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseShortCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getShotCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseEnAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseSymbolCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbolCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseRuAlphabCardNumber() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRussAlphabCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldLeaveCardNumberEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldLeaveMonthEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseInvalidMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getInvalidMonth());
        debitPage.inValMonthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseEnAlphabMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseRuAlphabMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRusAlphabMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseSymbolMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseOneDigitMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getOntDigitMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldLeaveYearEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUsePastYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getPastYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseEnAlphabYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEnAlphabYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseRuAlphabYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getRusAlphabYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldLeaveOwnerEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseSymbolOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getSymbolsCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldUseNumericOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getNumericCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldLeaveCvcEmpty() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getEmptyCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputIncorrectCardNum() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectCardNumber());
        debitPage.cardNumberFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputIncorrectMonth() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getZeroMonth());
        debitPage.monthFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputIncorrectYear() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectYear());
        debitPage.yearFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputIncorrectOwner() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getIncorrectCardOwner());
        debitPage.ownerFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputIncorrectCvc() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getTwoDigitCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }

    @Test
    void shouldInputOneDigitCvc() {
        MainPage mainPage = new MainPage();
        DebitPage debitPage = mainPage.chooseDebitPage();
        debitPage.fillForm(DataHelper.getOneDigitCvc());
        debitPage.CVCFail();
        assertEquals(0, SqlUtils.getRowsDebitPurchase());
    }
}
