package Com.project;

public class OnlineAssessment {
    public static void main(String[] args) {
    	User User=new User();
        System.out.println("Welcome to the Online Assessment System!");
        while (true) {
            System.out.println("\n1. Sign Up\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = User.scanner.nextInt();
            User.scanner.nextLine();
            switch (choice) {
                case 1 -> User.signUp();
                case 2 -> {
                    if (User.login()) return;
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
      
    }
}
