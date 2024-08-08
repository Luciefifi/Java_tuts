import java.io.*;
import java.util.UUID;

public class UserUtils {
    private static final String USERS_FILE = "data/users.txt";

    public static void saveUser(String firstName, String lastName, String email, String password, String role, String dateOfBirth, String countryISO, boolean isHIVPositive, String diagnosisDate, boolean onARTMed, String startARTDate) {
        String uuid = UUID.randomUUID().toString();
        String hivPositive = isHIVPositive ? "true" : "false";
        String onART = onARTMed ? "true" : "false";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(uuid + "," + firstName + "," + lastName + "," + email + "," + password + "," + role + "," + dateOfBirth + "," + countryISO + "," + hivPositive + "," + diagnosisDate + "," + onART + "," + startARTDate);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    public static String authenticate(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(email) && parts[4].equals(password)) {  // parts[3] is email, parts[4] is password
                    return parts[5];  // parts[5] is role
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file.");
        }
        return null;
    }

    public static void viewUserData(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(email)) {  // parts[3] is email
                    System.out.println("UUID: " + parts[0]);
                    System.out.println("First Name: " + parts[1]);
                    System.out.println("Last Name: " + parts[2]);
                    System.out.println("Email: " + parts[3]);
                    System.out.println("Role: " + parts[5]);
                    System.out.println("Date of Birth: " + parts[6]);
                    System.out.println("Country ISO: " + parts[7]);
                    System.out.println("Is HIV Positive: " + parts[8]);
                    System.out.println("Diagnosis Date: " + parts[9]);
                    System.out.println("On ART Med: " + parts[10]);
                    System.out.println("Start ART Date: " + parts[11]);
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file.");
        }
    }

    public static void updateUser(String email, String newFirstName, String newLastName, String newPassword, String newRole, String newDateOfBirth, String newCountryISO, boolean newIsHIVPositive, String newDiagnosisDate, boolean newOnARTMed, String newStartARTDate) {
        File inputFile = new File(USERS_FILE);
        File tempFile = new File("data/temp_users.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean userFound = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(email)) {  // parts[3] is email
                    writer.write(parts[0] + "," + newFirstName + "," + newLastName + "," + email + "," + newPassword + "," + newRole + "," + newDateOfBirth + "," + newCountryISO + "," + newIsHIVPositive + "," + newDiagnosisDate + "," + newOnARTMed + "," + newStartARTDate);
                    writer.newLine();
                    userFound = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!userFound) {
                System.out.println("User not found.");
            }

        } catch (IOException e) {
            System.out.println("Error updating user data.");
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}
