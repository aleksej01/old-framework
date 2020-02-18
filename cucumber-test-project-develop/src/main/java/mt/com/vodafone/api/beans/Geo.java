package mt.com.vodafone.api.beans;

import mt.com.vodafone.testframework.JsonObject;

/**
 * Created by piecar
 * Date: 07/03/2019
 */
public class Geo extends JsonObject {

    private String lat;

    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
