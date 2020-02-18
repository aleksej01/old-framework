package mt.com.vodafone.api.request;

import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import mt.com.vodafone.api.response.GetUserResponse;
import mt.com.vodafone.testframework.api.ApiRequest;
import mt.com.vodafone.testframework.api.ApiResponse;

/**
 * Created by piecar
 * Date: 07/03/2019
 */
public class GetUserRequest extends ApiRequest {

    private int id;

    public GetUserRequest(int id) {
        this.id = id;
    }

    @Override
    public ApiResponse execute() throws Exception {

        HttpResponse<String> response = Unirest.get(runningContext.getDefaultEnvironment().getUsersApiUrl() + id)
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .basicAuth("username", "password")
                .asString();

        String json = response.getBody();

        GetUserResponse userResponse = new GsonBuilder().create().fromJson(json, GetUserResponse.class);
        userResponse.setStatusCode(response.getStatus());
        userResponse.setRawJson(json);
        return userResponse;
    }

}
