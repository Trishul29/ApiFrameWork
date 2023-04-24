package util;

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
    String videosId;



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
        } finally {
            mongoClient.close();
        }

        updateProperties();
    }

    private String retrieve_VideoId(MongoClient mongoClient) {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("dev").getCollection("videos");

        // Query the collection to find all documents and sort by createdAt in descending order
        List<Document> videos = userCollection.find().sort(new Document("createdAt", -1)).into(new ArrayList<>());

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


    private void updateProperties() throws IOException {
        FileInputStream in = new FileInputStream(propertyPath);
        properties.load(in);
        in.close();
        properties.setProperty("userid", userId);
        properties.setProperty("teamid", teamId);
        properties.setProperty("HighlightmatchId", highlightmatchId);
        properties.setProperty("edit_match_teamId", editMatch_Id);

        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "//src//main//java//spec.properties");
        properties.store(out, "Edit now");
        out.close();
    }


}











}
