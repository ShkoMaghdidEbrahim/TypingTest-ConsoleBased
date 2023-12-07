import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginForm {
    public LoginForm() {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Do You Have An Account?     (Yes, No)");
        boolean correctAnswer = false;
        
        while (!correctAnswer) {
            System.out.print("Input: ");
            String alreadyHaveACC = s.nextLine();
            if (alreadyHaveACC.trim().equalsIgnoreCase("No")) {
                System.out.println("---------------------------------------------");
                new RegistrationForm();
                correctAnswer = true;
            }
            else if (alreadyHaveACC.trim().equalsIgnoreCase("Yes")) {
                boolean correctCredentials = false;
                while (!correctCredentials) {
                    System.out.print("Username: ");
                    String username = s.nextLine();
    
                    System.out.print("Password: ");
                    String password = s.nextLine();
                    if (isValid(username.trim(), password.trim())) {
                        correctCredentials = true;
                        System.out.println("---------------------------------------------");
                        new TypingTest();
                    }
                    else {
                        System.out.println("Please Enter A Valid Username And/Or Password");
                    }
                }
            }
            else {
                System.out.println("Please Enter A Correct Answer!");
            }
        }
        
    }
    
    static boolean isValid(String username, String password) {
        byte[] result = new byte[1];
        try {
            //Hash the input
            result = MessageDigest.getInstance("MD5").digest(String.valueOf(password).getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Convert it to hex
        StringBuilder builder = new StringBuilder();
        for (byte bytes : result) {
            builder.append(String.format("%02x", bytes));
        }
        
        //Initializing the file reader
        File usernameAndPasswords = new File("UserAndPass/DoNotDelete!.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(usernameAndPasswords);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //read the file and put it in a string char by char
        StringBuilder fileContents = new StringBuilder();
        int i = 0;
        while (true) {
            try {
                assert reader != null;
                if ((i = reader.read()) == -1) {
                    break;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            fileContents.append((char) i);
        }
        //Split the file contents on $ sign
        String[] separated = fileContents.toString().split("\\$");
        
        //Compare the entered and already stored credentials
        for (int j = 0; j < separated.length; j += 2) {
            if (username.equals(separated[j]) && builder.toString().equals(separated[j + 1])) {
                Main.username = separated[j]; //update the username variable
                return true; //if there's a match return true
            }
        }
        return false; //if not return false
    }
}
