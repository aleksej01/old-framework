package mt.com.vodafone.pageobjects.interfaces;

/**
 * Created by piecar
 * Date: 18/02/2019
 */
public interface LoginPage {

    void enterCredentials(String username, String password);

    void signIn();

    String getUsername();

    String getNumber();

    void signOut();

}
