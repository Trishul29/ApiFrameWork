package pojo.getAll.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)


public class GetShowListResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private boolean success;
    private List<Data>data;
    private String error;

    @Getter
    public static class Data
    {
        private String name;

        private List<Videos> videos;

        private String id;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Videos{
        private String thumbnail;

        private String videoUrl;

        private boolean isProcessed;

        private long videoId;

        private float aspectRatio;

        private String _id;

        private String poster;
        private int likes;
        private int replies;
        private int shareCount;
        private String isLiked;
        private Author author;
        private String content;
        private String[] imageUrls;
        private String time;
        private String isActive;
        private String isVisible;
        private String isDeleted;
        private String link;
        private String id;

    }
    @Getter
    public static class Author
    {
        private String firstName;

        private String lastName;

        private String isVerified;

        private String id;

        private String profileImage;

    }
    public void assertGetShowList()
    {
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200);
        assertNotNull(this.getData().size(),"No Show is Present");
        assertTrue(this.success,"Success Failure");
    }
}
