import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://flo3321o32:AvTKllxas6hrLvlb@clusterflo.qlhkb.mongodb.net/?retryWrites=true&w=majority&appName=Clusterflo";
    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase(String dbName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(dbName);
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void insertData(String dbName, String collectionName, String name, String className, int level) {
        MongoDatabase database = getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document document = new Document("name", name)
                .append("class", className)
                .append("level", level);

        collection.insertOne(document);
        System.out.println("Data inserted successfully: " + document.toJson());
    }

    public static void consultData(String dbName, String collectionName) {
        MongoDatabase database = getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    public static void updateData(String dbName, String collectionName, String name, int newLevel) {
        MongoDatabase database = getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        collection.updateOne(Filters.eq("name", name), Updates.set("level", newLevel));
        System.out.println("Data updated successfully for name: " + name);
    }
}