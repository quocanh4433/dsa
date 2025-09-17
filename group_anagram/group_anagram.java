
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_anagram {
    /**
     * Group Anagrams
     * 
     * Given an array of strings strs, group the anagrams together. You can return
     * the answer in any order.
     * 
     * Example 1:
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * Explanation:
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form
     * each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
     * form each other.
     * 
     * Example 2:
     * Input: strs = [""]
     * Output: [[""]]
     * 
     * Example 3:
     * Input: strs = ["a"]
     * Output: [["a"]]
     * 
     * Constraints:
     * 
     * 1 <= strs.length <= 10^4
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     * 
     */

    /**
     * SOLUTION 1:
     * 
     * strs = ["acb", "abc", "bc", "cb"] => [["acb", "abc"], ["bc", "cb"]] 
     * 
     * acbc -> {1,1,2,....0}(26) -> "112...0" -> save into hashmap
     * abc -> {1,1,1,....0}(26) -> "111...0"
     * cabc -> {1,1,2,....0}(26) -> "112...0"
     * ...
     * 
     * hashmap (key: 112...0, value: [acbc, cabc] )
     * 
     * return 
     * 
     * time complexity: O(n*100) 100: length of string
     * space complexity: O(n) there are 3 var: map O(n), count O(26), chars O(100)
     * 
     * 
     */

    public static List<List<String>> groupAnagram (String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String string : strs) {
            int[] count = new int[26];
            char[] chars = string.toCharArray();

            for (char c : chars) {
                count[c - 'a']++;
            }

            String s = Arrays.toString(count);

            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(string);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(strs));
    }
}
