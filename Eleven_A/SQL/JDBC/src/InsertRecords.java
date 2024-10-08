import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        String sql = "INSERT INTO Registration (id, name, address, program) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 100);
            statement.setString(2, "John Doe");
            statement.setString(3, "123 Main St");
            statement.setString(4, "Computer Science");
            statement.executeUpdate();

            statement.setInt(1, 101);
            statement.setString(2, "Jane Smith");
            statement.setString(3, "456 Oak Ave");
            statement.setString(4, "Mechanical Engineering");
            statement.executeUpdate();

            statement.setInt(1, 102);
            statement.setString(2, "Sam Wilson");
            statement.setString(3, "789 Pine Dr");
            statement.setString(4, "Electrical Engineering");
            statement.executeUpdate();

            statement.setInt(1, 103);
            statement.setString(2, "Lucy Brown");
            statement.setString(3, "321 Elm St");
            statement.setString(4, "Civil Engineering");
            statement.executeUpdate();

            System.out.println("Records inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

