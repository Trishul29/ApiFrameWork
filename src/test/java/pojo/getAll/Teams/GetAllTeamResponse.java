package pojo.getAll.Teams;
import lombok.Getter;
import lombok.Setter;
import javax.lang.model.type.NullType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetAllTeamResponse {
   @Setter
   int statusCode;
   @Setter
   long responseTime;
   private Data data;

   private String success;

   private String error;
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
      private String playerCount;

      private String isActive;

      private String name;

      private String logo;

      private String id;

      private String shortName;

      private String secondaryColor;

   }

   public void assertGetAllTeamResponse()
   {
      assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
      assertEquals(this.getStatusCode(),200);
      assertEquals(this.getSuccess(),"true","Success Failure");
   }

}
