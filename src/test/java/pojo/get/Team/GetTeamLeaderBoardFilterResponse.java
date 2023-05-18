package pojo.get.Team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetTeamLeaderBoardFilterResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;


    private Data data;

    private String success;

    private String error;

    @Getter
    public static class Data {
        private String[] subTimeFilter;

        private List<TopFilters> topFilters;

        private SubOptions[][] subOptions;

    }

    @Getter
    public static class SubOptions {
        private String label;

        private String value;
        private String type;
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

    @Getter
    public static class Icon {
        private String icon;

        private String type;
    }

    public void assertGetTeamLeaderBoardFilterResponse() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");

        for (TopFilters topFilter : this.getData().getTopFilters()) {

            assertNotNull(topFilter.getLabel(), "label not present");
            assertNotNull(topFilter.getValue(), "Label Value not present");
            assertNotNull(topFilter.getIcon().getType(), "Icon type not present");
            assertNotNull(topFilter.getIcon().getType(), "Icon  not present");
          //  assertNotNull(topFilter.getSelectedIcon().getIcon(), "Selected Icon  not present");
            assertNotNull(topFilter.getSelectedIcon().getType(), "Selected Icon type not present");

        }
        SubOptions[][] subOptions = this.getData().getSubOptions();

        for (SubOptions[] subOption : subOptions) {

            for (SubOptions options : subOption) {
                assertNotNull(options.getLabel(), "SubOptions label not present");
                assertNotNull(options.getValue(), "SubOptions Value not present");

            }
        }
        for (String s : this.getData().getSubTimeFilter()) {
            assertNotNull(s, "SubTime Filter values not presenet");

        }


    }

}
