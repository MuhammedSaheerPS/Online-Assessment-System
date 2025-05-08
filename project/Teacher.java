package Com.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Teacher extends Database {
	  static Scanner scanner = new Scanner(System.in);

	    static void teacherMenu() {
	        while (true) {
	            System.out.println("\nTeacher Menu");
	            System.out.println("1. Add Question");
	            System.out.println("2. View Student Scores");
	            System.out.println("3. Logout");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            Teacher add=new Teacher();
	            switch (choice) {
	                case 1:
	                    add.addQuestion();
	                    break;
	                case 2:
	                    add. viewStudentScores();
	                    break;
	                case 3:
	                    return;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        }
	    }

	     public void addQuestion() {
	        System.out.print("Enter question: ");
	        String questionText = scanner.nextLine();
	        System.out.print("Enter option 1: ");
	        String option1 = scanner.nextLine();
	        System.out.print("Enter option 2: ");
	        String option2 = scanner.nextLine();
	        System.out.print("Enter option 3: ");
	        String option3 = scanner.nextLine();
	        System.out.print("Enter option 4: ");
	        String option4 = scanner.nextLine();
	        System.out.print("Enter correct option (1-4): ");
	        int correctOption = scanner.nextInt();

	        try  {
	            String sql = "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = super.connection.prepareStatement(sql);
	            stmt.setString(1, questionText);
	            stmt.setString(2, option1);
	            stmt.setString(3, option2);
	            stmt.setString(4, option3);
	            stmt.setString(5, option4);
	            stmt.setInt(6, correctOption);
	            stmt.executeUpdate();
	            System.out.println("Question added successfully!");
	        } catch (SQLException e) {
	            System.out.println("Error: not added");
	        }
	    }

	    void viewStudentScores() {
	        try {
	            String sql = "SELECT * FROM scores";
	            PreparedStatement stmt = super.connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            System.out.println("\nStudent Scores:");
	            while (rs.next()) {
	                System.out.println(rs.getString("student_name") + " -> " + rs.getInt("score"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


