public class Main {
    public static void main(String[] args) {
        // Insert data into the database
        // Update data in the database
        MongoConnection.updateData("monRpg", "personnages", "flo", 15);

        // Consult data from the database
        MongoConnection.consultData("monRpg", "personnages");

        // Close the connection
        MongoConnection.close();
    }
}