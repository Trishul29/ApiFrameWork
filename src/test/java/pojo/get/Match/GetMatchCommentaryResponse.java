package pojo.get.Match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
public class GetMatchCommentaryResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private boolean success;

    private Object error;
    @Getter
   public static class Data{
        private boolean hasPrevPage;

        @JsonProperty("docs")

        private List<Docs> docs;

        private boolean hasNextPage;

        private int pagingCounter;

        private int nextPage;

        private int limit;

        private int totalPages;

        private int prevPage;

        private int page;

        private int totalDocs;

    }
    @Getter
    public static class Docs
    {
        private float over;
        private String[] audioClips;

        private String fillColor;

        private String outcomeBox;

        private String createdAt;

        private MetaData metaData;

        private String subHeading;

        private int __v;

        private String _id;

        private String title;

        private String textColor;

        private String matchId;

        private String updatedAt;
        private String ballId;
        private String borderColor;
        }

        @Getter
        public static class MetaData
        {
            private String image;

            private String topRightText;

            private String cardFillColor;

            private String cardTextColor;

            private String cardBorderColor;

            private String statement;

            private int type;
        }

        public void assertCommentaryDetails()
        {

            assertTrue(this.success,"Success Failure");
            assertTrue(this.getResponseTime()<3000,"Response Taking More than 3 Seconds");
            assertEquals(this.getStatusCode(),200);
          //  assertEquals(this.);

        }




}
