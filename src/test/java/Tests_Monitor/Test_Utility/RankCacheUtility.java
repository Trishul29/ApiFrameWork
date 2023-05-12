package Tests_Monitor.Test_Utility;


import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.HashMap;
import java.util.Map;

public class RankCacheUtility {
    private Map<String, PlayerRank> playerRanks;

    public RankCacheUtility() {

        playerRanks = new HashMap<>();
    }

    public void updatePlayerRank(String playerId, int rank, int rankMovement) {
        PlayerRank playerRank = new PlayerRank(rank, rankMovement);
        playerRanks.put(playerId, playerRank);
    }

    public PlayerRank getPlayerRank(String playerId) {
        return playerRanks.get(playerId);
    }

    public static class PlayerRank {
        private int rank;
        private int rankMovement;

        public PlayerRank(int rank, int rankMovement) {
            this.rank = rank;
            this.rankMovement = rankMovement;
        }

        public int getRank() {
            return rank;
        }

        public int getRankMovement() {
            return rankMovement;
        }
    }

}


