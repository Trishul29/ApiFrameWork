package pojo.get.Tournaments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetTournamentLeaderBoardFilterListResponse {

    @Setter
    int statusCode;
    @Setter
    long responseTime;


    private Data data;

    private String success;

    private String error;

    @Getter
    public static class Data {

        private Icon icon;

        private SubOptions[][] subOptions;
        private TopFilters[] topFilters;



        private String value;

    }

    @Getter
    public static class Icon {
        private String icon;

        private String type;

    }

    @Getter
    public static class SubOptions {
        private String label;
        private String value;

    }

    @Getter
    public static class TopFilters {
        private SelectedIcon selectedIcon;

        private Icon icon;

        private String label;

        private String value;

    }

    @Getter
    public static class SelectedIcon {
        private String icon;

        private String type;

    }

    public void assertTournamentLeaderBoardFilterListResponse() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");
        assertNotNull(this.getData().subOptions, "SubOptions Not present");
        assertNotNull(this.getData().topFilters, "Top Filter Not Present");
      //  assertNotNull(this.getData().label,"Label Not Present");

    }
}
