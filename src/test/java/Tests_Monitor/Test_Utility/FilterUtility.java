package Tests_Monitor.Test_Utility;

import com.github.javafaker.Faker;

public class FilterUtility {
    public String[] filterTypes = {"batting", "bowling", "fielding", "wicketKeeping", "mvp"};
    public String[] bowlingSubFilterTypes = {"bowlingAvg", "mostWickets", "strikeRate"};
    public String[] battingSubFilterTypes = {"battingAvg", "mostRuns", "strikeRate"};
    public String[] fieldingSubFilters = {"catches", "runOuts"};
    public String[] wicketKeepingSubFilterTypes = {"stumping", "caughtBehind", "catches"};

    public String[] leaderBoardType = {"batting", "bowling"};
    public String[] dateType = {"1", "2", "3"};
    public String[] matchType = {"1", "2"};

}

