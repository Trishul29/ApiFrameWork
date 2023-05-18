package util;

import com.github.javafaker.Faker;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Setter
@Getter
public class DatabaseUtility {
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);

    String teamId;
    String userId;
    String highlightmatchId;
    String editMatch_TeamId;
    String edit_match_id;
    String teamid_getplayeraccordingtogametype;
    String matchid_getplayeraccordingtogametype;
    String umpire_id;
    String streamer_id;
    String Edit_teamTwoId;
    String match_id;
    String tournament_id_aggregate_stat;
    String id_edit_tournament;
    String tournament_leaderboard_id;
    List<String> playerIds = new ArrayList<>();
    public List<String> getPlayerIds() {
        return playerIds;
    }
    String roundId;
    String parentPostId;
    public String teamOneId;
    public String teamTwoId;
    private List<String> playersTeamOne = new ArrayList<>();
    List<String> playersTeamTwo = new ArrayList<>();
    public String rosterID;
    public String rosterID1;
    String videosId;
    String player_1;
    String rosterPlayer_1;
    String rosterPlayer_2;
    String rosterPlayer_3;
    String rosterPlayer_4;
    String roster2Player_1;
    String roster2Player_2;
    String roster2Player_3;
    String roster2Player_4;
    String editMatchPlayer_1;
    String editMatchPlayer_2;
    String editMatchPlayer_3;
    String editMatchPlayer_4;
    String editMatchPlayer_5;


    MongoClientSettings settings;
    MongoClient mongoClient;

    public List<String> getPlayersTeamOne() {
        return playersTeamOne;
    }

    public List<String> getPlayersTeamTwo() {
        return playersTeamTwo;
    }

    // String connectionString
    //myysports-staging_string=mongodb+srv\://myysports-admin\:JU6k7mg4TUECNMoz@myysports-internal.qihe3.mongodb.net/myysports-staging?retryWrites\=true&w\=majority
   // @Test
    public void setDbEnvironment() throws IOException {
        ConnectionString connString = new ConnectionString("mongodb+srv://admin:vgOE3nS6GFPU34Hv@staging.e08qv.mongodb.net/myysports-staging");

        // Create the client settings
        settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();


        // Create the client instance
        mongoClient = MongoClients.create(settings);


        retrieveDataAndStore();


    }


    public void retrieveDataAndStore() throws IOException {
        try {
            retrieveTeamsWithMoreThanFourPlayersForCreateMatchApi(mongoClient);
            this.userId = retrieveUserId(mongoClient);
            this.teamId = retrieveTeamId(mongoClient);
            this.highlightmatchId = retrieveHighlightmatchId(mongoClient);
            this.editMatch_TeamId = retrieveEditMatchTeamId(mongoClient);
            this.playerIds = retrieve_playerIds_from_roaster(mongoClient, rosterID);
            this.playersTeamOne = retrievePlayersTeamOneFromRosterForCreateMatchApi(mongoClient, teamOneId);
            this.playersTeamTwo = retrievePlayersTeamTwoFromRosterForCreateMatchApi(mongoClient, teamTwoId);
            this.teamid_getplayeraccordingtogametype = retrieve_teamid_getplayeraccordingtogametype(mongoClient);
            this.matchid_getplayeraccordingtogametype = retrieve_matchid_getplayeraccordingtogametype(mongoClient);
            this.videosId = retrieve_VideoId(mongoClient);
            this.player_1 = retrievePlayerOneId(mongoClient);
            this.umpire_id = retrieve_umpireId(mongoClient);
            this.streamer_id = retrieve_streamerId(mongoClient);
            this.match_id = retrieveEndedMatchId(mongoClient);
            this.tournament_id_aggregate_stat = retrieveTournamentAggregateStat(mongoClient);
            this.id_edit_tournament = retrieveTournamentAndRoundIds(mongoClient);
            this.tournament_leaderboard_id = retrieve_tournamentLeaderBoardId(mongoClient);
            this.parentPostId = retrieve_parentPost(mongoClient);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }

        updateProperties();
    }

    private String retrieve_parentPost(MongoClient mongoClient) {
        MongoCollection<Document> userPostCollection = mongoClient.getDatabase("myysports-staging").getCollection("userposts");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userPostCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId postId = users.get(0).getObjectId("_id");
        return postId.toString();

    }

    private String retrieve_tournamentLeaderBoardId(MongoClient mongoClient) {
        MongoCollection<Document> tournamentsCollection = mongoClient.getDatabase("myysports-staging").getCollection("tournaments");

        // Query the collection to find documents where tournamentStatus.status equals "pending" or "live"
        Document query = new Document("tournamentStatus.status", "end");
        // Find the first matching document and apply the projection
        Document result = tournamentsCollection.find(query).first();
        // Extract the value of the _id field
        ObjectId tournamentId = result.getObjectId("_id");

        return tournamentId.toString();
    }

    private String retrieve_tournamentId(MongoClient mongoClient) {
        MongoCollection<Document> tournamentsCollection = mongoClient.getDatabase("myysports-staging").getCollection("tournaments");

        // Query the collection to find documents where tournamentStatus.status equals "pending" or "live"
        Document query = new Document("tournamentStatus.status", new Document("$in", Arrays.asList("pending", "started")));


        // Find the first matching document and apply the projection
        Document result = tournamentsCollection.find(query).first();

        // Extract the value of the _id field
        ObjectId tournamentId = result.getObjectId("_id");

        return tournamentId.toString();
    }

    private String retrieveTournamentAndRoundIds(MongoClient mongoClient) {
        MongoCollection<Document> tournamentsCollection = mongoClient.getDatabase("myysports-staging").getCollection("tournaments");

        // Query the collection to find documents where tournamentStatus.status equals "pending" or "started"
        // and rounds array has size of 1 or more
        Document query = new Document("tournamentStatus.status", new Document("$in", Arrays.asList("pending", "started")))
                .append("rounds.0", new Document("$exists", true));


        // Projection to return only the _id and rounds fields
        Document projection = new Document("_id", 1).append("rounds", 1);

        // Find all matching documents and apply the projection
        FindIterable<Document> results = tournamentsCollection.find(query).projection(projection);

        // Check if there are any matching documents
        if (!results.iterator().hasNext()) {
            throw new RuntimeException("No matching documents found in the tournaments collection");
        }

        // Create a list to hold the tournament and round IDs
        List<String> ids = new ArrayList<>();
        ObjectId tournamentId = null;
        // Loop through each matching document and extract the tournament and round IDs
        for (Document result : results) {

            // Extract the value of the _id field
            tournamentId = result.getObjectId("_id");

            ids.add(tournamentId.toString());

            // Extract the list of round IDs
            List<ObjectId> roundIds = result.getList("rounds", ObjectId.class);
            roundId = roundIds.get(0).toString();

            ids.add(roundId);
        }

        // Combine the tournament and round IDs into a single string and return it
        return tournamentId.toString();
    }


    private String retrieveTournamentAggregateStat(MongoClient mongoClient) {
        MongoCollection<Document> TournamentCollection = mongoClient.getDatabase("myysports-staging").getCollection("tournamentaggregatestats");
        // Query the collection to find documents where matchStatus.status equals "end"

        // Sort by createdAt in descending order
        Document sort = new Document("createdAt", -1);


        // Limit to one result document
        FindIterable<Document> cursor = TournamentCollection.find().sort(sort).limit(1);

        // Extract the value of the _id field from the first result document
        ObjectId tournamentId = cursor.first().getObjectId("tournamentId");

        return tournamentId.toString();
    }


    private String retrieveEndedMatchId(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("myysports-staging").getCollection("matches");
        // Query the collection to find documents where matchStatus.status equals "end"
        Document query = new Document("matchStatus.status", "end");

        // Sort by createdAt in descending order
        Document sort = new Document("createdAt", -1);

        // Limit to one result document
        FindIterable<Document> cursor = matchesCollection.find(query).sort(sort).limit(1);

        // Extract the value of the _id field from the first result document
        ObjectId matchId = cursor.first().getObjectId("_id");

        return matchId.toString();
    }


//    private String retrieve_teamOneId(MongoClient mongoClient) {
//        MongoCollection<Document> teamsCollection = mongoClient.getDatabase("myysports-staging").getCollection("teams");
//        Document query = new Document("shortName", "Mi");
//        FindIterable<Document> cursor = teamsCollection.find(query);
//        ObjectId teamOneId = cursor.first().getObjectId("_id");
//        return teamOneId.toString();
//
//    }
//
//    private String retrieve_teamTwoId(MongoClient mongoClient) {
//        MongoCollection<Document> teamsCollection = mongoClient.getDatabase("myysports-staging").getCollection("teams");
//        Document query = new Document("shortName", "pbks");
//        FindIterable<Document> cursor = teamsCollection.find(query);
//        ObjectId teamTwoId = cursor.first().getObjectId("_id");
//        return teamTwoId.toString();
//
//    }

    private String retrieve_VideoId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("myysports-staging").getCollection("videos");
        Document query = new Document("isProcessed", true);
        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> videos = userCollection.find(query).sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId videoId = videos.get(0).getObjectId("_id");
        return videoId.toString();


    }

    private String retrieve_matchid_getplayeraccordingtogametype(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("myysports-staging").getCollection("matches");
        // Query the collection to find documents where matchStatus.status equals "pending"
        Document query = new Document("matchStatus.status", "pending");

        // Sort by createdAt in descending order
        Document sort = new Document("createdAt", -1);

        // Limit to one result document
        FindIterable<Document> cursor = matchesCollection.find(query).sort(sort).limit(1);

        // Extract the value of the _id field from the first result document
        ObjectId matchId = cursor.first().getObjectId("_id");

        return matchId.toString();

    }

    private String retrieve_teamid_getplayeraccordingtogametype(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("myysports-staging").getCollection("matches");

        // Query the collection to find documents where matchStatus.status equals "pending"
        Document query = new Document("matchStatus.status", "pending");

        // Projection to return only the team one ID field
        Document projection = new Document("teamOne.teamId", 1).append("teamOne.rosterId", 1).append("_id", 1);
        Document sort = new Document("createdAt", -1);

        // Find the first matching document and apply the projection
        Document result = matchesCollection.find(query).projection(projection).sort(sort).first();

        if (result == null) {
            // Handle case where query did not find any matching documents
            return "result is null";
        }

        Document teamOne = result.get("teamOne", Document.class);
        if (teamOne == null) {
            // Handle case where "teamOne" field is not present in the document
            return "team one null";
        }

        ObjectId rosterId = teamOne.getObjectId("rosterId");
        //  rosterID = rosterId.toString();


        ObjectId teamOneId = teamOne.getObjectId("teamId");
        return teamOneId.toString();
    }


    private String retrieveEditMatchTeamId(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("myysports-staging").getCollection("matches");

        // Query the collection to find documents where matchStatus.status equals "pending"
        Document query = new Document("matchStatus.status", "pending");

        // Projection to return only the team one ID field
        Document projection = new Document("teamOne.teamId", 1).append("teamOne.rosterId", 1).append("teamTwo.teamId", 1).append("teamTwo.rosterId", 1).append("_id", 1);
        Document sort = new Document("createdAt", -1);

        // Find the first matching document and apply the projection
        Document result = matchesCollection.find(query).projection(projection).sort(sort).first();

        // Extract the value of the team one ID field
        Document teamOne = (Document) result.get("teamOne");
        Document teamTwo = (Document) result.get("teamTwo");
        ObjectId matchId = result.getObjectId("_id");
        edit_match_id = matchId.toString();
        ObjectId rosterId = teamOne.getObjectId("rosterId");
        rosterID = rosterId.toString();
        ObjectId rosterId1 = teamTwo.getObjectId("rosterId");
        rosterID1 = rosterId1.toString();


        ObjectId teamOneId = teamOne.getObjectId("teamId");
        ObjectId teamTwo_Id = teamTwo.getObjectId("teamId");
        Edit_teamTwoId = teamTwo_Id.toString();

        return teamOneId.toString();

    }

    private List<String> retrieve_playerIds_from_roaster(MongoClient mongoClient, String rosterID) {
        MongoCollection<Document> rostersCollection = mongoClient.getDatabase("myysports-staging").getCollection("rosters");

        // Query the collection to find documents where the roster ID equals the input rosterId
        Document query = new Document("_id", new ObjectId(rosterID));

        // Projection to return only the players array
        Document projection = new Document("players", 1).append("_id", 1);

        // Find the matching document and apply the projection
        Document result = rostersCollection.find(query).projection(projection).first();

        // Extract the value of the players array
        List<Document> players = (List<Document>) result.get("players");

        // Check that the players array has at least 5 players
        if (players.size() < 4) {
            throw new IllegalArgumentException("The roster with ID " + rosterID + " does not have at least 4 players.");
        }

        // Extract the IDs of each player in the players array

        for (Document player : players) {
            playerIds.add(player.getObjectId("id").toString());

        }
        editMatchPlayer_1 = playerIds.get(0);
        editMatchPlayer_2 = playerIds.get(1);
        editMatchPlayer_3 = playerIds.get(2);
        editMatchPlayer_4 = playerIds.get(3);
        editMatchPlayer_5 = playerIds.get(4);

        return playerIds;

    }


    private String retrieveHighlightmatchId(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("myysports-staging").getCollection("highlights");
        // Query the collection to find documents where matchStatus.status equals "end"
        Document query = new Document("isProcessed", true);

        // Sort by createdAt in descending order
        Document sort = new Document("createdAt", -1);

        // Limit to one result document
        FindIterable<Document> cursor = matchesCollection.find(query).sort(sort).limit(1);

        // Extract the value of the _id field from the first result document
        ObjectId matchId = cursor.first().getObjectId("matchId");

        return matchId.toString();
    }

    private String retrieveTeamId(MongoClient mongoClient) {
        MongoCollection<Document> teamCollection = mongoClient.getDatabase("myysports-staging").getCollection("teams");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> teams = teamCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId tId = teams.get(0).getObjectId("_id");

        return tId.toString();
    }

    private void retrieveTeamsWithMoreThanFourPlayersForCreateMatchApi(MongoClient mongoClient) {
        MongoCollection<Document> rosterCollection = mongoClient.getDatabase("myysports-staging").getCollection("rosters");


        // Create a query to retrieve only the documents where the size of the players array is greater than 4
        Document query = new Document("$expr", new Document("$gt", Arrays.asList(new Document("$size", "$players"), 4)));


        // Query the collection to find all documents that match the query and sort by createdAt in descending order
        List<Document> rosters = rosterCollection.find(query).into(new ArrayList<>());

        if (!rosters.isEmpty()) {
            teamOneId = rosters.get(0).get("team").toString();

            if (rosters.size() > 1) {
                teamTwoId = rosters.get(1).get("team").toString();
            } else {

                teamTwoId = ""; // Example: Assigning an empty string as default value
            }
        } else {

            teamOneId = "";
            teamTwoId = "";
        }

    }



    private List<String> retrievePlayersTeamOneFromRosterForCreateMatchApi(MongoClient mongoClient, String teamOneId) {
        MongoCollection<Document> rostersCollection = mongoClient.getDatabase("myysports-staging").getCollection("rosters");

        // Query the collection to find documents where the roster ID equals the input teamId
        Document query = new Document("team", teamOneId);


        // Projection to return only the players array and their IDs
        Document projection = new Document("players.id", 1);
        Document sort = new Document("createdAt", -1);


        // Find the matching document and apply the projection
        Document result = rostersCollection.find(query).sort(sort).projection(projection).first();

        // Extract the value of the players array
        List<Document> players = (List<Document>) result.get("players");

        // Check that the players array has at least 5 players
        if (players.size() < 4) {
            throw new IllegalArgumentException("The roster with ID " + rosterID + " does not have at least 4 players.");
        }

        // Extract the IDs of each player in the players array
        // List<String> playersTeamOne = new ArrayList<>();
        for (Document player : players) {
            playersTeamOne.add(player.getObjectId("id").toString());
        }
        rosterPlayer_1 = playersTeamOne.get(0);
        rosterPlayer_2 = playersTeamOne.get(1);
        rosterPlayer_3 = playersTeamOne.get(2);
        rosterPlayer_4 = playersTeamOne.get(3);


        return playersTeamOne;
    }


    private List<String> retrievePlayersTeamTwoFromRosterForCreateMatchApi(MongoClient mongoClient, String teamTwoId) {
        MongoCollection<Document> rostersCollection = mongoClient.getDatabase("myysports-staging").getCollection("rosters");

        // Query the collection to find documents where the roster ID equals the input teamId
        Document query = new Document("team", teamTwoId);
        Document sort = new Document("createdAt", -1);

        // Projection to return only the players array
        Document projection = new Document("players", 1).append("_id", 0);

        // Find the matching document and apply the projection
        Document result = rostersCollection.find(query).sort(sort).projection(projection).first();

        // Extract the value of the players array
        List<Document> players = (List<Document>) result.get("players");

        // Check that the players array has at least 5 players
        if (players.size() < 4) {
            throw new IllegalArgumentException("The roster with ID " + rosterID + " does not have at least 4 players.");
        }

        // Extract the IDs of each player in the players array

        for (Document player : players) {
            playersTeamTwo.add(player.getObjectId("id").toString());
        }

        roster2Player_1 = playersTeamTwo.get(0);
        roster2Player_2 = playersTeamTwo.get(1);
        roster2Player_3 = playersTeamTwo.get(2);
        roster2Player_4 = playersTeamTwo.get(3);

        return playersTeamTwo;

    }


    private String retrieveUserId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("myysports-staging").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(0).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerOneId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("myysports-staging").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(1).getObjectId("_id");
        return uId.toString();
    }


    private String retrieve_umpireId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("myysports-staging").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(6).getObjectId("_id");
        return uId.toString();
    }

    private String retrieve_streamerId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("myysports-staging").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(Faker.instance().number().numberBetween(1, 10)).getObjectId("_id");
        return uId.toString();
    }


    private void updateProperties() throws IOException {
        FileInputStream in = new FileInputStream(propertyPath);
        properties.load(in);
        in.close();
        properties.setProperty("userid", userId);
        properties.setProperty("teamid", teamId);
        properties.setProperty("HighlightmatchId", highlightmatchId);
        properties.setProperty("edit_match_teamId", editMatch_TeamId);
        properties.setProperty("Edit_teamTwoId", Edit_teamTwoId);
        properties.setProperty("matchid_edit_match", edit_match_id);
        properties.setProperty("teamid_getplayeraccordingtogametype", teamid_getplayeraccordingtogametype);
        properties.setProperty("matchid_getplayeraccordingtogametype", matchid_getplayeraccordingtogametype);
        properties.setProperty("create_match_teamone_id", teamOneId);
        properties.setProperty("create_match_teamtwo_id", teamTwoId);
        properties.setProperty("umpire_id", umpire_id);
        properties.setProperty("streamer_id", streamer_id);
        properties.setProperty("matchid", match_id);
        properties.setProperty("score_card_match_id", match_id);
        properties.setProperty("tournament_id_aggregate_stat", tournament_id_aggregate_stat);
        properties.setProperty("id_edit_tournament", id_edit_tournament);
        properties.setProperty("tournament_leaderboard_id", tournament_leaderboard_id);
        properties.setProperty("editmatch_tournament_id", id_edit_tournament);
        properties.setProperty("rosterplayer_1", rosterPlayer_1);
        properties.setProperty("rosterplayer_2", rosterPlayer_2);
        properties.setProperty("rosterplayer_3", rosterPlayer_3);
        properties.setProperty("rosterplayer_4", rosterPlayer_4);

        properties.setProperty("roster_1_player_1", roster2Player_1);
        properties.setProperty("roster_1_player_2", roster2Player_2);
        properties.setProperty("roster_1_player_3", roster2Player_3);
        properties.setProperty("roster_1_player_4", roster2Player_4);

        properties.setProperty("editMatchPlayer_1", editMatchPlayer_1);
        properties.setProperty("editMatchPlayer_2", editMatchPlayer_2);
        properties.setProperty("editMatchPlayer_3", editMatchPlayer_3);
        properties.setProperty("editMatchPlayer_4", editMatchPlayer_4);
        properties.setProperty("editMatchPlayer_5", editMatchPlayer_5);
        properties.setProperty("author_id", userId);
        properties.setProperty("parentPost_id", parentPostId);
        properties.setProperty("roundId", roundId);

        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "//src//main//java//spec.properties");
        properties.store(out, "Edit now");
        out.close();
    }


}











