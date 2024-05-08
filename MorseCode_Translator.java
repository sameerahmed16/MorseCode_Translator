//Sameer Ahmed

import java.util.Scanner;
import java.io.*;

public class MorseCode_Translator {
    private static final String newFile = "MorseFile.txt"; // file path for saving and restoring data

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        // main loop to handle user input
        while (true) {
            System.out.println("Enter (Morse) to change from English to Morse Code:");
            System.out.println("Enter (English) to change from Morse Code to English:");
            System.out.println("Enter (Save) to save current data:");
            System.out.println("Enter (Restore) to restore data from file:");
            System.out.println("Enter (Exit) to exit:");
            System.out.print("Option: ");
            userChoice = input.nextLine().toLowerCase(); // handle case sensitivity

            switch (userChoice) {
                case "morse":
                    System.out.print("Convert to Morse Code: ");
                    String english = input.nextLine();
                    System.out.println("English to Morse Code: " + EngToMorse(english));
                    break;
                case "english":
                    System.out.print("Convert to English: ");
                    String morse = input.nextLine();
                    System.out.println("Morse Code to English: " + MorseToEng(morse));
                    break;
                case "save":
                    saveData(input);
                    break;
                case "restore":
                    restoreData();
                    break;
                case "exit":
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    // saves data entered by the user to a file
    private static void saveData(Scanner input) {
        System.out.print("Enter the data to save: ");
        String data = input.nextLine();
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write(data);
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // restores data from the file and displays it
    private static void restoreData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(newFile))) {
            String data = reader.readLine();
            System.out.println("Data:" + data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // converts english text to morse code
    public static String EngToMorse(String english) {
        StringBuilder morse = new StringBuilder();
        // iterate over each character and convert it to morse code
        for (int i = 0; i < english.length(); i++) {
            char letter = Character.toLowerCase(english.charAt(i));
            switch (letter) {
                case 'a': morse.append(".- "); break;
                case 'b': morse.append("-... "); break;
                case 'c': morse.append("-.-. "); break;
                case 'd': morse.append("-.. "); break;
                case 'e': morse.append(". "); break;
                case 'f': morse.append("..-. "); break;
                case 'g': morse.append("--. "); break;
                case 'h': morse.append(".... "); break;
                case 'i': morse.append(".. "); break;
                case 'j': morse.append(".--- "); break;
                case 'k': morse.append("-.- "); break;
                case 'l': morse.append(".-.. "); break;
                case 'm': morse.append("-- "); break;
                case 'n': morse.append("-. "); break;
                case 'o': morse.append("--- "); break;
                case 'p': morse.append(".--. "); break;
                case 'q': morse.append("--.- "); break;
                case 'r': morse.append(".-. "); break;
                case 's': morse.append("... "); break;
                case 't': morse.append("- "); break;
                case 'u': morse.append("..- "); break;
                case 'v': morse.append("...- "); break;
                case 'w': morse.append(".-- "); break;
                case 'x': morse.append("-..- "); break;
                case 'y': morse.append("-.-- "); break;
                case 'z': morse.append("--.. "); break;
                case '1': morse.append(".---- "); break;
                case '2': morse.append("..--- "); break;
                case '3': morse.append("...-- "); break;
                case '4': morse.append("....- "); break;
                case '5': morse.append("..... "); break;
                case '6': morse.append("-.... "); break;
                case '7': morse.append("--... "); break;
                case '8': morse.append("---.. "); break;
                case '9': morse.append("----. "); break;
                case '0': morse.append("----- "); break;
                default: morse.append(" "); // space for unhandled characters
            }
        }
        return morse.toString().trim();
    }

    // converts morse code to english text
    public static String MorseToEng(String morse) {
        StringBuilder english = new StringBuilder();
        String[] morseCode = morse.trim().split("\\s+");
        // iterate over each morse code and convert it to english
        for (String code : morseCode) {
            switch (code) {
                case ".-": english.append("a"); break;
                case "-...": english.append("b"); break;
                case "-.-.": english.append("c"); break;
                case "-..": english.append("d"); break;
                case ".": english.append("e"); break;
                case "..-.": english.append("f"); break;
                case "--.": english.append("g"); break;
                case "....": english.append("h"); break;
                case "..": english.append("i"); break;
                case ".---": english.append("j"); break;
                case "-.-": english.append("k"); break;
                case ".-..": english.append("l"); break;
                case "--": english.append("m"); break;
                case "-.": english.append("n"); break;
                case "---": english.append("o"); break;
                case ".--.": english.append("p"); break;
                case "--.-": english.append("q"); break;
                case ".-.": english.append("r"); break;
                case "...": english.append("s"); break;
                case "-": english.append("t"); break;
                case "..-": english.append("u"); break;
                case "...-": english.append("v"); break;
                case ".--": english.append("w"); break;
                case "-..-": english.append("x"); break;
                case "-.--": english.append("y"); break;
                case "--..": english.append("z"); break;
                case ".----": english.append("1"); break;
                case "..---": english.append("2"); break;
                case "...--": english.append("3"); break;
                case "....-": english.append("4"); break;
                case ".....": english.append("5"); break;
                case "-....": english.append("6"); break;
                case "--...": english.append("7"); break;
                case "---..": english.append("8"); break;
                case "----.": english.append("9"); break;
                case "-----": english.append("0"); break;
                default: english.append(" ");
            }
        }
        return english.toString();
    }
}
