import java.util.Scanner;

public class SignUp {
    public static void runSignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (ADMIN/PATIENT): ");
        String role = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter country ISO code: ");
        String countryISO = scanner.nextLine();
        System.out.print("Is HIV Positive (true/false): ");
        boolean isHIVPositive = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter diagnosis date (YYYY-MM-DD): ");
        String diagnosisDate = scanner.nextLine();
        System.out.print("On ART Medication (true/false): ");
        boolean onARTMed = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter ART start date (YYYY-MM-DD): ");
        String startARTDate = scanner.nextLine();

        UserUtils.saveUser(firstName, lastName, email, password, role, dateOfBirth, countryISO, isHIVPositive, diagnosisDate, onARTMed, startARTDate);
        System.out.println("User registered successfully!");
    }
}
