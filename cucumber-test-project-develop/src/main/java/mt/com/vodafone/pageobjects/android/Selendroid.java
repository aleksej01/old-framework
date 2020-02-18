package mt.com.vodafone.pageobjects.android;

import mt.com.vodafone.pageobjects.interfaces.SelendroidPage;
import mt.com.vodafone.testframework.BasePage;
import mt.com.vodafone.testframework.driver.Driver;
import org.openqa.selenium.By;

/**
 * Created by piecar
 * Date: 13/03/2019
 */
public class Selendroid extends BasePage implements SelendroidPage {

    // Start elements.

    private By popupWindowButton = By.id("io.selendroid.testapp:id/visibleButtonTest");

    private By popupWindowText = By.id("io.selendroid.testapp:id/visibleTextView");

    // End elements.

    public Selendroid() {
        super(Driver.getAndroidDriver());
    }

    @Override
    public void clickTextButton() {
        click(androidDriver, popupWindowButton, DEFAULT_TIMEOUT);
    }

    @Override
    public String getText() {
        return getText(androidDriver, popupWindowText, DEFAULT_TIMEOUT);
    }

}
