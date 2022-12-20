import java.util.Random;
import java.util.Scanner;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main 
{
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SIMBOLS = "!#$%&'()*+,-./:;<=>?@[]^_`{}~";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + SIMBOLS + CHAR_UPPER + NUMBER;
    private static Random random = new Random();

    public static String generateRandomPassword(int length) 
    {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) 
        {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n   .d8888b.  8888888b.  888       888  .d8888b.  ");
        System.out.println("  d88P  Y88b 888   Y88b 888   o   888 d88P  Y88b ");
        System.out.println("  Y88b.      888    888 888  d8b  888 888    888 ");
        System.out.println("   oY888b.   888   d88P 888 d888b 888 888        ");
        System.out.println("      oY88b. 8888888Po  888d88888b888 888  88888 ");
        System.out.println("        o888 888        88888P Y88888 888    888 ");
        System.out.println("  Y88b  d88P 888        8888P   Y8888 Y88b  d88P ");
        System.out.println("   oY8888Po  888        888P     Y888  oY8888P88 ");
        System.out.print("\n\033[1;34m[---]    Safe PassWord Generator (\033[1;33mSPWG\033[1;34m).   [---]\033[0;0m");
        System.out.print("\n\033[1;34m[---]          Created by: \033[1;31mJMKTT\033[1;34m          [---]\033[0;0m");
        System.out.print("\n\033[1;34m[---]            Version: \033[1;31m 1.0 \033[0;0m \033[1;34m          [---] \n");
        System.out.print("\n\033[1;92m  Welcome to The Safe PassWord Generator (SPWG).\033[0;0m\n");
        System.out.print("\nEnter the length of the password: ");
        int length = scanner.nextInt();
        String password = generateRandomPassword(length);
        System.out.println("\n     8 8 8 8                     ,ooo.");
        System.out.println("     8a8 8a8                    oP   ?b");
        System.out.println("    d888a888zzzzzzzzzzzzzzzzzzzz8     8b");
        System.out.println("     `oo^oo                     ?o___oP'");
        System.out.println("\nGenerated password: " + password);
    
        // SHA-256 HASH
        MessageDigest digest;
        try {
          digest = MessageDigest.getInstance("SHA-256");
        } 
        catch (NoSuchAlgorithmException e) {
          System.err.println("Error: Unable to hash password.");
          return;
        }
        byte[] hash = digest.digest(password.getBytes());
    
        // BASE64 ENCODE
        String encodedHash = Base64.getEncoder().encodeToString(hash);
    
        // SAVE ENCODED HASH
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outpwd.txt"))) {
          writer.write("\nEncoded Password: ");
          writer.write(encodedHash);
          writer.write("\n");
          System.out.println("Encoded password hash saved to outpwd.txt.");
        } 
        catch (IOException e) {
          System.err.println("Error: Unable to save password hash to file.");
        }
      }
}
//Author: JMKTT
