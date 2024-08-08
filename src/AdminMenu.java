import java.util.Scanner;

public class AdminMenu {
    public static void runAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View User Data");
            System.out.println("2. Update User Data");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the email of the user to view: ");
                    String email = scanner.nextLine();
                    UserUtils.viewUserData(email);
                    break;
                case 2:
                    System.out.print("Enter the email of the user to update: ");
                    String updateEmail = scanner.nextLine();
                    System.out.print("Enter new first name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter new role (ADMIN/PATIENT): ");
                    String newRole = scanner.nextLine();
                    System.out.print("Enter new date of birth (YYYY-MM-DD): ");
                    String newDateOfBirth = scanner.nextLine();
                    System.out.print("Enter new country ISO code: ");
                    String newCountryISO = scanner.nextLine();
                    System.out.print("Is HIV Positive (true/false): ");
                    boolean newIsHIVPositive = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("Enter new diagnosis date (YYYY-MM-DD): ");
                    String newDiagnosisDate = scanner.nextLine();
                    System.out.print("On ART Medication (true/false): ");
                    boolean newOnARTMed = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("Enter new ART start date (YYYY-MM-DD): ");
                    String newStartARTDate = scanner.nextLine();

                    UserUtils.updateUser(updateEmail, newFirstName, newLastName, newPassword, newRole, newDateOfBirth, newCountryISO, newIsHIVPositive, newDiagnosisDate, newOnARTMed, newStartARTDate);
                    System.out.println("User data updated successfully!");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
