package modules.service;

import io.restassured.response.Response;
import modules.client.SearchClient;
import pojo.getAll.globalsearch.GetGlobalSearchResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class SearchService {
    public GetGlobalSearchResponse getSearchByKeyword()
    {
        Response response = new SearchClient().getSearch();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetGlobalSearchResponse getGlobalSearchResponse=response.as(GetGlobalSearchResponse.class);
        getGlobalSearchResponse.setStatusCode(statusCode);
        getGlobalSearchResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return  getGlobalSearchResponse;
    }
}
