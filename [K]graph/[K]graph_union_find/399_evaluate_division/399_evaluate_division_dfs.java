import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EvaluateDivision_DFS {

    /*
        intput: equations = [["a","b"],["b","c"]], values = [2.0,3.0]
    
        build weighted graph: a --2--> b --3--> c
    
        vậy a --> c = 2 * 3 = 6 
    
        bản chất đi từ a đến c là dfs

        n: node
        e: cạnh
        q: số query


        time và space với 1 query


        time    O(n + e) mỗi node và cạnh duyệt qua 1 lần
        space   O(n)
            - array visited: O(n)
            - recursion:    O(n)


              
        time và space với q query

        time    O(q * (n + e))
        space   O(n)    



        
        tại sao time là O(n + e) mà không phải O(n)?
            - mỗi node chỉ đi qua 1 lần là O(n)
            - mỗi node tạo 2 edge
                vd: a --> b và a <-- b    
                n = 10000  
                e = 2*1000 = 2000

        tại sao có những problem time là O(n + e) ~ O(n)?
            vì đó là undirected graph hoặc graph 1 chiều 
            có n node thì có n - 1 edge

            suy ra O(n + e) ~ O(2n) ~ O(n)


      
     */
    private Map<String, Map<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, v);
            graph.get(b).put(a, 1.0 / v);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }


            /*
                tại sao cần visited?                
                khi build graph là build cả 2 chiều a --> b và b --> a

                nếu không có visited:
                a đi sang b - b đi sang a - a đi sang b ... vô tận

                khi có visited:
                a đi sang b - b đi sang a (a đã có trong visited nên dừng)
             */
            Set<String> visited = new HashSet<>();
            ans[i] = dfs(start, end, 1.0, visited);
        }

        return ans;
    }

    public double dfs(String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);
        Map<String, Double> neighboors = graph.get(current);

        for (String next : neighboors.keySet()) {
            double weight = neighboors.get(next);
            /*
                ra sao nếu next không tới target?
                do "input is always valid" nên next chắc chắn đi đến target
             */
            if (visited.contains(next)) {
                continue;
            }

            double res = dfs(next, target, product * weight, visited);
            if (res != -1.0) {
                return res;
            }
        }

        return -1.0;
    }
}
