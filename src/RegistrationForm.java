import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class RegistrationForm {
    public RegistrationForm() {
        Scanner s = new Scanner(System.in);
        boolean writtenCorrectly = false;
        while (!writtenCorrectly) {
            System.out.print("Username: ");
            String username = s.nextLine();
            System.out.print("Password: ");
            String password = s.nextLine();
    
            if (password.length() > 6) {
                String[] credentials = credentials(username.trim(), password.trim());
                saveU_P(credentials);
                System.out.println("Congratulations! \nYour account has been created successfully \nYou now can LogIn");
                System.out.println("---------------------------------------------");
                writtenCorrectly = true;
                new LoginForm();
            }
            else {
                System.out.println("Please,\nEnter a valid username and password! \nIt must be longer than 6 characters! \nAnd dont leave it empty");
                writtenCorrectly = false;
            }
        }
    }
    
    static String[] credentials(String username, String password) {
        String[] credentials = new String[2];
        //Hash the input
        MessageDigest digester = null;
        try {
            digester = MessageDigest.getInstance("MD5");
            digester.update(StandardCharsets.UTF_8.encode(String.valueOf(password)));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Something went wrong! \nProgram will terminate");
            System.exit(0);
        }
        //Convert it to hex for easier saving and comparison
        StringBuilder builder = new StringBuilder();
        for (byte bytes : digester.digest()) {
            builder.append(String.format("%02x", bytes));
        }
        //save the results
        credentials[0] = username;
        credentials[1] = builder.toString();
        
        return credentials;
    }
    
    static void saveU_P(String[] username_Password) {
        File usernameAndPasswords = new File("UserAndPass/DoNotDelete!.txt");
        try {
            //Write the results in a file and separate each element by a $ sign
            FileWriter writer = new FileWriter(usernameAndPasswords, true);
            writer.write(username_Password[0] + "$" + username_Password[1] + "$");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
