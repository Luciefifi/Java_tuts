import java.util.Scanner;

public class Login {
    public static String runLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String role = UserUtils.authenticate(email, password);
        if (role != null) {
            System.out.println("Login successful as " + role);
            return role;
        } else {
            System.out.println("Login failed. Check your email and password.");
            return null;
        }
    }
}
