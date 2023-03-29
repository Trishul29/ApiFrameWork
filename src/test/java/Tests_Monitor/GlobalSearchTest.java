package Tests_Monitor;

import modules.service.SearchService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.globalsearch.GetGlobalSearchResponse;

public class GlobalSearchTest {
    SearchService searchService;

    @BeforeClass
    public void beforeClass()
    {
        searchService=new SearchService();
    }
    @Test
    public void shouldGetSearchResults()
    {

     GetGlobalSearchResponse getGlobalSearchResponse =   searchService.getSearchByKeyword();
     getGlobalSearchResponse.assertGlobalSearch();

    }

}
