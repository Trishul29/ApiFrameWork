package pojo.get.Tournaments;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@Setter
public class GetTournamentAggregatedStatResponse {
   int statusCode;
   long responseTime;

   private String error;
   private boolean success;

   private Data data;

   @Getter
    public static class Data
   {
       private int totalRun;
       private int totalWickets;
       private int totalSix;
       private int totalFour;
     private int totalGoals ;
       private int  totalShots;
       private int  totalShotOnTarget;
       private int  totalPasses;
       private int  totalOffside;
       private int  totalCorners;
       private int  totalThrowIns;
       private int  totalFreeKicks;
       private int totalBlocks;

   }
   public void assertAggregatedTournamentStats()
   {

       assertTrue(this.success,"Success Failure");
       assertEquals(this.getStatusCode(),200,"Request Failure");
     assertTrue(this.getResponseTime()<2000,"Response Taking More Than 2 Seconds!");
   }

}
