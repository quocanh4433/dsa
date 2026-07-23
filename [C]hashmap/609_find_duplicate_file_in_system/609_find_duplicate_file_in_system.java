
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindDuplicateFileInSystem {
    /*
        n: length of paths
        L: total number of character in all string

        time O(n * L)
        space O(L)
    */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];

                int idx = file.indexOf('(');

                String fileName = file.substring(0, idx);
                String content = file.substring(idx + 1, file.length() - 1);

                String fullPath = directory + "/" + fileName;

                map.computeIfAbsent(content, k -> new ArrayList<>())
                        .add(fullPath);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }

        return ans;
    }
}
