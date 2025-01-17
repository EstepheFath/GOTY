import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

//        String url = "mongodb+srv://estephefath:pEvnBG12qNj9cFAb@test1.2ufoq.mongodb.net/?retryWrites=true&w=majority&appName=test1";
//
//        try (MongoClient mongoClient = MongoClients.create(url)) {
//            System.out.println("Connected to MongoDB");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        try (MongoClient mongoClient = MongoClients.create(url)) {
////            MongoDatabase database = mongoClient.getDatabase("test1");
////            MongoCollection<Document> collection = database.getCollection("personnages");
////
////            Document personnage = new Document("name", "Arthas")
////                    .append("classe", "Guerrier")
////                    .append("niveau", "20");
////            collection.insertOne(personnage);
////
////            System.out.println("Personnage crée avec succée");
////        }
//
//        try (MongoClient mongoClient = MongoClients.create(url)) {
//            MongoDatabase database = mongoClient.getDatabase("test1");
//            MongoCollection<Document> collection = database.getCollection("personnages");
//
//            collection.updateOne(
//                    Filters.eq("nom", "Arthas"),
//                    Updates.set("niveau", "20")
//            );
//            System.out.println("Niveau mis a jour");
//
//            for (Document personnage : collection.find()) {
//                System.out.println(personnage.toJson());
//            }
//        }
//
//        try(MongoClient mongoClient = MongoClients.create(url)){
//            MongoDatabase database = mongoClient.getDatabase("test1");
//            MongoCollection<Document> collection = database.getCollection("personnages");
//
//            collection.deleteOne(Filters.eq("nom", "Arthas"));
//            System.out.println("Personnages Arthas supprimé");
//        }
//
    }
}