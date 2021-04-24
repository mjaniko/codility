package hackerrank;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> hash_map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!hash_map.containsKey(key)) {
                List<String> word = new ArrayList<>();
                word.add(strs[i]);
                hash_map.put(key, word);
            } else {
                List<String> word = hash_map.get(key);
                word.add(strs[i]);
                hash_map.put(key, word);
            }
        }
        return new ArrayList<>(hash_map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.solution(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
    }
}
