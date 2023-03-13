package pojo.getAll.Teams;

import lombok.Getter;
import lombok.Setter;

import javax.lang.model.type.NullType;

@Getter
public class GetAllTeamResponse {
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
   public static class Docs
   {
      private String city;

      private String isVerified;

      private String players;

      private String primaryColor;

      private String link;

      private String description;

      private String matchCount;

      private String isActive;

      private String name;

      private String logo;

      private String id;

      private String shortName;

      private String secondaryColor;

   }

}
