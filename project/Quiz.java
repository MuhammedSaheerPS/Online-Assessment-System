package Com.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quiz  extends Database{
	
	    void startQuiz(String studentName) {
	        Scanner scanner = new Scanner(System.in);
	        int score = 0;
	        

	        try  {
	            String sql = "SELECT * FROM questions";
	            PreparedStatement stmt = super.connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                System.out.println("\nQ: " + rs.getString("question"));
	                System.out.println("1. " + rs.getString("option1"));
	                System.out.println("2. " + rs.getString("option2"));
	                System.out.println("3. " + rs.getString("option3"));
	                System.out.println("4. " + rs.getString("option4"));
	                System.out.print("Enter your answer (1-4): ");
	                int answer = scanner.nextInt();
	                if (answer == rs.getInt("correct_option")) {
	                    score++;
	                }
	            }
	            saveScore(studentName, score);
	            System.out.println("\nQuiz Over! Your Score: " + score);
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    void saveScore(String studentName, int score) {
	        try  {
	            String sql = "INSERT INTO scores (student_name, score) VALUES (?, ?)";
	            PreparedStatement stmt = super.connection.prepareStatement(sql);
	            stmt.setString(1, studentName);
	            stmt.setInt(2, score);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	      
	    }
	  
	}

