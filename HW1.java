import java.util.Arrays;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Welcome to the App");

        do {
            System.out.println("1. Palindrome Check");
            System.out.println("2. Anagram Check");
            System.out.println("3. Add Substring");
            System.out.println("4. Get Length");
            System.out.println("5. Count Occurances");
            System.out.println("6. Reverse Sentence");
            System.out.println("7. Quit");

            System.out.print("Choose an option: ");
            number = scanner.nextInt();
            scanner.nextLine();

            String input;
            String substring;
            int index;

            switch (number) {
                case 1 -> {
                    System.out.print("Enter String: ");
                    input = scanner.nextLine();
                    System.out.println("Is Palindrome: " + palindromeIterative(input));
                }
                case 2 -> {
                    System.out.print("Enter first String: ");
                    input = scanner.nextLine();
                    System.out.print("Enter second String: ");
                    substring = scanner.nextLine();
                    System.out.println("Is Anagram: " + anagramCheck(input, substring));
                }
                case 3 -> {
                    System.out.print("Enter String: ");
                    input = scanner.nextLine();
                    System.out.print("Substring to be inserted: ");
                    substring = scanner.nextLine();
                    System.out.print("Index placement: ");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("New string: " + addSubstring(input, substring, index));
                }
                case 4 -> {
                    System.out.print("Enter String: ");
                    input = scanner.nextLine();
                    System.out.println("Length: " + getLength(input));
                }
                case 5 -> {
                    System.out.print("Enter String: ");
                    input = scanner.nextLine();
                    System.out.print("Substring to count: ");
                    substring = scanner.nextLine();
                    System.out.println("Occurances: " + occuranceCounter(input, substring));
                }
                case 6 -> {
                    System.out.print("Enter Sentence: ");
                    input = scanner.nextLine();
                    System.out.println("Reversed Sentence: " + sentenceReversal(input));
                }
                case 7 -> System.out.println("Have a nice day:)");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (number != 7);

        scanner.close();
    }

    //Big-O notation: O(n)
    public static boolean palindromeIterative(String input) {
        StringBuilder newString = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                newString.append(Character.toLowerCase(c));
        }
        int start = 0;
        int end = newString.length() - 1;

        if (newString.length() <= 1) {
            return true;
        }
        while (start < end) {
            if (newString.charAt(start) != newString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    //Big-O notation: O(n)
    public static boolean palindromeRecursive(String input) {
        StringBuilder newString = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                newString.append(Character.toLowerCase(c));
        }

        return palindromeRecursiveHelper(newString.toString(), 0, newString.length() - 1);
    }

    private static boolean palindromeRecursiveHelper(String input, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return palindromeRecursiveHelper(input, start + 1, end - 1);
    }

    public static boolean anagramCheck(String x, String y) {
        StringBuilder newX = new StringBuilder();
        StringBuilder newY = new StringBuilder();

        for (char c : x.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newX.append(Character.toLowerCase(c));
            }
        }
        for (char c : y.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newY.append(Character.toLowerCase(c));
            }
        }
        if (newX.length() != newY.length()) {
            return false;
        }
        char[] charX = newX.toString().toCharArray();
        char[] charY = newY.toString().toCharArray();

        Arrays.sort(charX);
        Arrays.sort(charY);

        return new String(charX).equals(new String(charY));
    }


    public static String addSubstring(String input, String substring, int index) {
        if (index < 0 || index > input.length()) {
            return "Index out of Bounds";
        }
        String first = input.substring(0, index);
        String second = input.substring(index);

        return first + substring + second;
    }

    public static int getLength(String input) {
        return input.length();
    }

    public static int occuranceCounter(String input, String substring) {
        int count = 0;
        int index = 0;

        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    public static String sentenceReversal(String input) {
        char lastChar = input.charAt(input.length() - 1);
        String cleanInput = Character.isLetterOrDigit(lastChar) ? input : input.substring(0, input.length() - 1);

        String[] words = cleanInput.split(" ");
        StringBuilder sentenceReverse = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sentenceReverse.append(words[i]).append(" ");
        }
        String finalSentence = sentenceReverse.toString().trim();

        if (!Character.isLetterOrDigit(lastChar)) {
            finalSentence += lastChar;
        }

        return finalSentence;
    }
}



