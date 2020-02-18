package mt.com.vodafone.api.beans;

import mt.com.vodafone.testframework.JsonObject;

/**
 * Created by piecar
 * Date: 07/03/2019
 */
public class Company extends JsonObject {

    private String name;

    private String catchPhrase;

    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

}
