import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class FindAllPossibleRecipesFromGivenSupplies {
    /*
        time O(I + R + S)
        space O(I)


        R = số recipe
        I = tổng số ingredient xuất hiện trong tất cả recipe
        S = tổng số supplies


        build graph: mỗi recipe duyệt cho 1 mảng ingredient O(I + R)
        đưa supply vào queue: O(S)
        bfs queue O(I)
        -> time O(I + R + S) mad S <= R nen

        graph O(I)
        indegree O(R)
        queue 1 supply tương ứng với 1 recipe O(R + S)
        ans O(R)
        -> space O(I + R + S) 

    */


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>(); // đếm số lượng nguyên liệu của từng món

        for (int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[i]);
            }
        }

        Queue<String> q = new LinkedList<>();

        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();

            for (String recipe : graph.getOrDefault(curr, Collections.emptyList())) {
                indegree.put(recipe, indegree.get(recipe) - 1);

                if (indegree.get(recipe) == 0) {
                    ans.add(recipe);
                    q.offer(recipe);
                }
            }
        }

        return ans;
    }
}
