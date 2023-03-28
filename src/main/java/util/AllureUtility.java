package util;

import io.qameta.allure.Allure;

public class AllureUtility {

    public void getResponseTime(long responseTime)
    {

        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+" MiliSeconds");
    }

}
