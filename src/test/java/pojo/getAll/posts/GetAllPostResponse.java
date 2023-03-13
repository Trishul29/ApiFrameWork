package pojo.getAll.posts;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

import javax.lang.model.type.NullType;

@Getter
public class GetAllPostResponse {
    @Setter
    int statusCode;

    private Data data;

    private String success;

    private NullType error;
    @Getter

    public static class Data{

        private String hasPrevPage;

        private Docs[] docs;

        private String hasNextPage;

        private String pagingCounter;

        private String nextPage;

        private String limit;

        private String totalPages;

        private NullType prevPage;

        private String page;

        private String totalDocs;
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
    @Getter
    public static class Docs
    {
        private String resourceId;

        private Author author;

        private String isLiked;

        private String link;

        private Videos[] videos;

        private String resourceName;

        private String isVisible;
        private String matchId;
        private  String matchName;

        private String isActive;

        private String content;

        private String shareCount;

        private String isLive;

        private String replies;

        private String isDeleted;

        private String[] imageUrls;

        private String following;

        private String time;

        private String id;

        private String likes;

    }
    @Getter
    public static class Videos
    {
        private String thumbnail;

        private String videoUrl;

        private String isProcessed;
        private String poster;

        private String videoId;

        private String aspectRatio;

        private String _id;

    }


}
