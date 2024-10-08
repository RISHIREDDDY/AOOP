import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecord {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        String sql = "DELETE FROM Registration WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 101);
            statement.executeUpdate();

            System.out.println("Record deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

