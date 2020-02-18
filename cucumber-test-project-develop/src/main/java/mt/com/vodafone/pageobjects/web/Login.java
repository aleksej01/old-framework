package mt.com.vodafone.pageobjects.web;

import mt.com.vodafone.pageobjects.interfaces.LoginPage;
import mt.com.vodafone.testframework.BasePage;
import mt.com.vodafone.testframework.context.RunningContext;
import mt.com.vodafone.testframework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by piecar
 * Date: 14/03/2019
 */
public class Login extends BasePage implements LoginPage {

    // Start elements.

    private By usernameTextBox = By.id("ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_txtUsername_txtInput");

    private By passwordTextBox = By.id("ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_txtPassword_txtInput");

    private By loginButton = By.id("ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_btnLogin");

    private By logoutButton = By.className("i-logout-sml");

    private By headerSixTag;

    // End elements.

    private List<WebElement> elements = null;

    public Login() {
        super(Driver.getWebDriver());
        navigateTo(RunningContext.getInstance().getDefaultEnvironment().getWebsiteUrl());
    }

    @Override
    public void enterCredentials(String username, String password) {
        sendKeys(webDriver, usernameTextBox, DEFAULT_TIMEOUT, username);
        sendKeys(webDriver, passwordTextBox, DEFAULT_TIMEOUT, password);
    }

    @Override
    public void signIn() {
        click(webDriver, loginButton, DEFAULT_TIMEOUT);
    }

    @Override
    public String getUsername() {

        try {
            fetchHeaderSixTagElements();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        // We know that the username is in the first element of the list.
        return elements.get(0).getText().trim();
    }

    @Override
    public String getNumber() {

        // We know that the number is in the second element of the list.
        return elements.get(1).getText().trim();
    }

    @Override
    public void signOut() {
        click(webDriver, logoutButton, DEFAULT_TIMEOUT);
    }

    /**
     * <p>
     * Retrieves all the {@code h6} header tags.
     * </p>
     */
    private void fetchHeaderSixTagElements() throws IllegalAccessException, InstantiationException {

        headerSixTag = By.tagName("h6");
        elements = webDriver.findElements(headerSixTag);
    }

}
