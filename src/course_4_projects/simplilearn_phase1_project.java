package course_4_projects;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class simplilearn_phase1_project {
    
    private static final String FILE_DIRECTORY = "D:\\simpli learn projects\\simplilearn phase1 project\\";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<String> FILE_NAMES = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("Welcome to our application!");
        int choice = -1;
        while (choice != 5) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. list of files ");
            System.out.println("2. Add a file to the application");
            System.out.println("3. Delete a file from the application");
            System.out.println("4. Search for a file");
            System.out.println("5. Exit");
            System.out.print("enter Your choice: ");
            choice = SCANNER.nextInt();
            switch (choice) {
                case 1:
                    retrieveFileNames();
                    break;
                case 2:
                    addFile();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    searchFile();
                    break;
                case 5:
                    System.out.println("Thank you for using our application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        SCANNER.close();
    }
    
    private static void retrieveFileNames() {
        System.out.println("list of files :");
        File directory = new File(FILE_DIRECTORY);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    FILE_NAMES.add(file.getName());
                }
            }
            Collections.sort(FILE_NAMES);
            for (String fileName : FILE_NAMES) {
                System.out.println(fileName);
            }
            FILE_NAMES.clear();
        } else {
            System.out.println("Error: " + FILE_DIRECTORY + " is not a directory.");
        }
    }
    
    private static void addFile() {
        System.out.print("Please enter the name of the file you want to add: ");
        String fileName = SCANNER.next();
        File file = new File(FILE_DIRECTORY + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File " + fileName + " has been added to the application.");
            } else {
                System.out.println("Error: File " + fileName + " already exists.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void deleteFile() {
        System.out.print("Please enter the name of the file you want to delete: ");
        String fileName = SCANNER.next();
        File file = new File(FILE_DIRECTORY + fileName);
        if (file.delete()) {
            System.out.println("File " + fileName + " has been deleted from the application.");
        } else {
            System.out.println("Error: File " + fileName + " does not exist.");
        }
    }
    
    private static void searchFile() {
        System.out.print("Please enter the name of the file you want to search: ");
        String fileName = SCANNER.next();
        File directory = new File(FILE_DIRECTORY);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    System.out.println("File " + fileName + " has been found in the application.");
                    return;
                }
            }
            System.out.println("Error: File " + fileName + " does not exist in the application");
        }
    }
}
