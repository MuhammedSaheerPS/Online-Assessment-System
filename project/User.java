package Com.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User extends Database {
	 static Scanner scanner = new Scanner(System.in);

	     void signUp() {
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();
	        System.out.print("Enter role (student/teacher): ");
	        String role = scanner.nextLine();

	        try  {
	            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
	            PreparedStatement stmt = super.connection.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmt.setString(3, role);
	            stmt.executeUpdate();
	            System.out.println("Sign-up successful!");
	        } catch (SQLException e) {
	            System.out.println("Error: already user exits"); }
	        }

	        boolean login() {
	            System.out.print("Enter username: ");
	            String username = scanner.nextLine();
	            System.out.print("Enter password: ");
	            String password = scanner.nextLine();

	            try  {
	                String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
	                PreparedStatement stmt = super.connection.prepareStatement(sql);
	                stmt.setString(1, username);
	                stmt.setString(2, password);
	                ResultSet rs = stmt.executeQuery();

	                if (rs.next()) {
	                    String role = rs.getString("role");
	                    System.out.println("Login successful!");
	                    if (role.equals("student")) {
	                    	Quiz Quiz=new Quiz();
	                        Quiz.startQuiz(username);
	                    } else {
	                        Teacher.teacherMenu();
	                    }
	                    return true;
	                } else {
	                    System.out.println("Invalid credentials.");
	                }
	            } catch (SQLException e) {
	                System.out.println("Error: user not found");
	            }
	            scanner.close();
	            return false;
	        
	    }
}
