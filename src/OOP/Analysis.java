package OOP;

import java.util.*;

public class Analysis {
    public static void main(String[] args) {
        String str1 = "Hello, world! This is a test string for frequency analysis.";
        String str2 = "This is another string for testing purposes.";
        int n = 3;

        // проводим частотный анализ символов первой строки
        HashMap<Character, Integer> charMap1 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            if (charMap1.containsKey(c)) {
                charMap1.put(c, charMap1.get(c) + 1);
            } else {
                charMap1.put(c, 1);
            }
        }

        // проводим частотный анализ символов второй строки
        HashMap<Character, Integer> charMap2 = new HashMap<>();
        for (char c : str2.toCharArray()) {
            if (charMap2.containsKey(c)) {
                charMap2.put(c, charMap2.get(c) + 1);
            } else {
                charMap2.put(c, 1);
            }
        }

        // символы, которые входят и в первую, и во вторую строку
        System.out.println("Символы, которые входят и в первую, и во вторую строку:");
        for (char c : charMap1.keySet()) {
            if (charMap2.containsKey(c)) {
                System.out.print(c + " ");
            }
        }
        System.out.println();

        // символы, которые входят в первую и не входят во вторую
        System.out.println("Символы, которые входят в первую и не входят во вторую:");
        for (char c : charMap1.keySet()) {
            if (!charMap2.containsKey(c)) {
                System.out.print(c + " ");
            }
        }
        System.out.println();

        // символы, которые содержатся хотя бы в одной строке
        System.out.println("Символы, которые содержатся хотя бы в одной строке:");
        HashSet<Character> charSet = new HashSet<>();
        for (char c : str1.toCharArray()) {
            charSet.add(c);
        }
        for (char c : str2.toCharArray()) {
            charSet.add(c);
        }
        for (char c : charSet) {
            System.out.print(c + " ");
        }
        System.out.println();

        // символы, выводимые в обратном порядке
        System.out.println("Символы, выводимые в обратном порядке:");
        ArrayList<Character> charList = new ArrayList<>(charMap1.keySet());
        Collections.reverse(charList);
        for (char c : charList) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
