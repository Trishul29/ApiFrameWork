package util;

import com.github.javafaker.Faker;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Getter
@Setter
public class DatabaseUtility {
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);

    String teamId;
    String userId;
    String highlightmatchId;
    String editMatch_Id;
    String teamid_getplayeraccordingtogametype;
    String matchid_getplayeraccordingtogametype;
    String create_match_teamone_id;
     String create_match_teamTwo_id;
     String umpire_id;
     String streamer_id;
     String match_id;
     String tournament_id_aggregate_stat;

    String videosId;
    String player_1;
    String player_2;
    String player_3;
    String player_4;
    String player_5;



    public void retrieveDataAndStore() throws IOException {

        ConnectionString connString = new ConnectionString("mongodb+srv://myysports-admin:JU6k7mg4TUECNMoz@myysports-internal.qihe3.mongodb.net/dev?retryWrites=true&w=majority");

        // Create the client settings
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();

        // Create the client instance
        MongoClient mongoClient = MongoClients.create(settings);

        try {
            this.userId = retrieveUserId(mongoClient);
            this.teamId = retrieveTeamId(mongoClient);
            this.highlightmatchId = retrieveHighlightmatchId(mongoClient);
            this.editMatch_Id = retrieveEditMatchId(mongoClient);
            this.teamid_getplayeraccordingtogametype = retrieve_teamid_getplayeraccordingtogametype(mongoClient);
            this.matchid_getplayeraccordingtogametype = retrieve_matchid_getplayeraccordingtogametype(mongoClient);
            this.videosId = retrieve_VideoId(mongoClient);
            this.player_1 = retrievePlayerOneId(mongoClient);
            this.player_2 =retrievePlayerTwoId(mongoClient);
            this.player_3 =retrievePlayerThreeId(mongoClient);
            this.player_4 =retrievePlayerFourId(mongoClient);
            this.player_5 =retrievePlayerFiveId(mongoClient);
            this.create_match_teamone_id=retrieve_teamOneId(mongoClient);
            this.create_match_teamTwo_id=retrieve_teamTwoId(mongoClient);
            this.umpire_id=retrieve_umpireId(mongoClient);
            this.streamer_id=retrieve_streamerId(mongoClient);
            this.match_id=retrieveEndedMatchId(mongoClient);
            this.tournament_id_aggregate_stat=retrieveTournamentAggregateStat(mongoClient);

        } finally {
            mongoClient.close();
        }

        updateProperties();
    }

    private String retrieveTournamentAggregateStat(MongoClient mongoClient) {
        MongoCollection<Document> TournamentCollection = mongoClient.getDatabase("dev").getCollection("matches");
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
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("dev").getCollection("matches");
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


    private String retrieve_teamOneId(MongoClient  mongoClient)
    {
        MongoCollection<Document> teamsCollection = mongoClient.getDatabase("dev").getCollection("teams");
        Document query = new Document("shortName", "Mi");
        FindIterable<Document> cursor = teamsCollection.find(query);
        ObjectId teamOneId = cursor.first().getObjectId("_id");
        return  teamOneId.toString();

    }
    private String retrieve_teamTwoId(MongoClient  mongoClient)
    {
        MongoCollection<Document> teamsCollection = mongoClient.getDatabase("dev").getCollection("teams");
        Document query = new Document("shortName", "pbks");
        FindIterable<Document> cursor = teamsCollection.find(query);
        ObjectId teamTwoId = cursor.first().getObjectId("_id");
        return  teamTwoId.toString();

    }

    private String retrieve_VideoId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("videos");
        Document query = new Document("isProcessed", true);
        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> videos = userCollection.find(query).sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId videoId = videos.get(0).getObjectId("_id");
        return videoId.toString();


    }

    private String retrieve_matchid_getplayeraccordingtogametype(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("dev").getCollection("matches");
        // Query the collection to find documents where matchStatus.status equals "end"
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
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("dev").getCollection("matches");

        // Query the collection to find documents where matchStatus.status equals "pending"
        Document query = new Document("matchStatus.status", "pending");

        // Projection to return only the team one ID field
        Document projection = new Document("teamOne.teamId", 1).append("_id", 0);
        Document sort = new Document("createdAt", -1);

        // Find the first matching document and apply the projection
        Document result = matchesCollection.find(query).projection(projection).sort(sort).first();

        // Extract the value of the team one ID field
        Document teamOne = (Document) result.get("teamOne");
        ObjectId teamOneId = teamOne.getObjectId("teamId");

        return teamOneId.toString();
    }


    private String retrieveEditMatchId(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("dev").getCollection("matches");

        // Query the collection to find documents where matchStatus.status equals "end"
        Document query = new Document("matchStatus.status", "pending");

        // Sort by createdAt in descending order
        Document sort = new Document("createdAt", -1);

        // Limit to one result document
        FindIterable<Document> cursor = matchesCollection.find(query).sort(sort).limit(1);

        // Extract the value of the _id field from the first result document
        ObjectId editMatch_Id = cursor.first().getObjectId("_id");

        return editMatch_Id.toString();

    }

    private String retrieveHighlightmatchId(MongoClient mongoClient) {
        MongoCollection<Document> matchesCollection = mongoClient.getDatabase("dev").getCollection("highlights");
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
        MongoCollection<Document> teamCollection = mongoClient.getDatabase("dev").getCollection("teams");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> teams = teamCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId tId = teams.get(0).getObjectId("_id");
        return tId.toString();
    }

    private String retrieveUserId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(0).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerOneId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(1).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerTwoId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(2).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerThreeId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(3).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerFourId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(4).getObjectId("_id");
        return uId.toString();
    }

    private String retrievePlayerFiveId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(5).getObjectId("_id");
        return uId.toString();
    }
    private String retrieve_umpireId(MongoClient mongoClient)
    {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> users = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

        // Extract the value of the _id field from the first result document
        ObjectId uId = users.get(6).getObjectId("_id");
        return uId.toString();
    }
    private String retrieve_streamerId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("usersports");

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
        properties.setProperty("edit_match_teamId", editMatch_Id);
        properties.setProperty("teamid_getplayeraccordingtogametype", teamid_getplayeraccordingtogametype);
        properties.setProperty("matchid_getplayeraccordingtogametype", matchid_getplayeraccordingtogametype);
        properties.setProperty("create_match_teamone_id",create_match_teamone_id);
        properties.setProperty("create_match_teamtwo_id",create_match_teamTwo_id);
        properties.setProperty("umpire_id",umpire_id);
        properties.setProperty("streamer_id",streamer_id);
        properties.setProperty("matchid",match_id);
        properties.setProperty("score_card_match_id",match_id);
        properties.setProperty("tournament_id_aggregate_stat",tournament_id_aggregate_stat);

        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "//src//main//java//spec.properties");
        properties.store(out, "Edit now");
        out.close();
    }


}











