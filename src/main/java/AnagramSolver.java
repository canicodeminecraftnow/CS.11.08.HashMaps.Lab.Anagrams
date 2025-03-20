import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Collections.*;
import java.io.*;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */

    public static String sort(String original) {
        char[] temp = original.toCharArray();
        Arrays.sort(temp);
        String abc = new String(temp);
        return abc;
    }

    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();
        Scanner scanner = new Scanner(new File(filename));
        while( scanner.hasNextLine()){
            String current = scanner.nextLine().trim();
            String sorted = sort(current);

            ArrayList<String> read;
            read = anagramMap.get(sorted);
            if(read == null){
                read = new ArrayList<>();
            }
            read.add(current);
            anagramMap.put(sorted, read);


        }
        scanner.close();
        return anagramMap;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> longest = new ArrayList<>();
        for (ArrayList<String> anagramList : anagrams.values()){
            if (anagramList.size() > longest.size()){
                longest = anagramList;
            }
        }
        return longest;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
