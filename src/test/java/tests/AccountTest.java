package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest implements ITestConstants {

    @Test
    public void createAccountTest() {
        Account firstAccount = Account.builder()
                .accountName("FirstAccount")
                .type("Customer")
                .website("www.tut.by")
                .phone("375296352412")
                .industry("Banking")
                .build();
        firstAccount.setEmployees("150");
        loginPage.openPage(BASE_URL);
        loginPage.login(LOGIN, PASSWORD);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL);
        newAccountModalPage.waitPageLoaded();
        newAccountModalPage.create(firstAccount);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getName(firstAccount.getAccountName()), firstAccount.getAccountName());
        Assert.assertEquals(accountListPage.getPhoneNumber(firstAccount.getPhone()), firstAccount.getPhone());
    }

    @Test
    public void createTwoAccountTest() {
        Account firstAccount = Account.builder()
                .accountName("FirstAccount")
                .type("Customer")
                .website("www.tut.by")
                .phone("375296352412")
                .industry("Banking")
                .employees("150")
                .build();
        Account secondAccount = Account.builder()
                .accountName("SecondAccount")
                .type("Analyst")
                .website("www.onliner.by")
                .phone("375447425961")
                .industry("Retail")
                .build();
        secondAccount.setEmployees("220");
        loginPage.openPage(BASE_URL);
        loginPage.login(LOGIN, PASSWORD);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL);
        newAccountModalPage.waitPageLoaded();
        newAccountModalPage.create(firstAccount);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL);
        newAccountModalPage.waitPageLoaded();
        newAccountModalPage.create(secondAccount);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getName(firstAccount.getAccountName()), firstAccount.getAccountName());
        Assert.assertEquals(accountListPage.getPhoneNumber(firstAccount.getPhone()), firstAccount.getPhone());
        Assert.assertEquals(accountListPage.getName(secondAccount.getAccountName()), secondAccount.getAccountName());
        Assert.assertEquals(accountListPage.getPhoneNumber(secondAccount.getPhone()), secondAccount.getPhone());
    }
}