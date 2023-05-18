package pojo.getAll.Teams;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.lang.model.type.NullType;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")
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

      private List<Docs> docs;

      private boolean hasNextPage;

      private String pagingCounter;

      private int nextPage;

      private int limit;

      private String totalPages;

      private int prevPage;

      private int page;

      private int totalDocs;
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
