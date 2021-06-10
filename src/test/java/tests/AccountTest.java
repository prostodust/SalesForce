package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest implements ITestConstants{

    @Test
    public void createAccountTest() {
        Account account = new Account("FirstAccount", "Customer", "www.tut.by", "375296352412", "Banking", "150");
        loginPage.openPage(BASE_URL);
        loginPage.login(LOGIN, PASSWORD);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL);
        newAccountModalPage.waitPageLoaded();
        newAccountModalPage.create(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getAccountName("FirstAccount"), account.getAccountName());
        Assert.assertEquals(accountListPage.getPhone("375296352412"),account.getPhone());
    }
}