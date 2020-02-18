package mt.com.vodafone.api.request;

import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import mt.com.vodafone.api.response.GetToDoResponse;
import mt.com.vodafone.testframework.api.ApiRequest;
import mt.com.vodafone.testframework.api.ApiResponse;

/**
 * Created by piecar
 * Date: 06/02/2019
 */
public class GetToDoRequest extends ApiRequest {

    private int id;

    public GetToDoRequest(int id) {
        this.id = id;
    }

    @Override
    public ApiResponse execute() throws Exception {

        HttpResponse<String> response = Unirest.get(runningContext.getDefaultEnvironment().getToDoApiUrl() + id)
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .asString();

        String json = response.getBody();

        GetToDoResponse toDoResponse = new GsonBuilder().create().fromJson(json, GetToDoResponse.class);
        toDoResponse.setStatusCode(response.getStatus());
        toDoResponse.setRawJson(json);
        return toDoResponse;
    }

}
