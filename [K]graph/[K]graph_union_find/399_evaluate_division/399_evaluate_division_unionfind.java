import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EvaluateDivision_UnionFind {
    /*
        intput: equations = [["a","b"],["b","c"]], values = [2.0,3.0]

        N = số biến khác nhau (a, b, c, ...)
        E = số phương trình trong equations
        Q = số queries

        Time: O(E + Q)
        Space = O(N)
    


        dfs dễ implement nhưng số lương query lớn time sẽ tăng lên

        áp dụng unionfind đế giảm time

        tại sao union-find lại tốt hơn dfs?
            - với dfs mỗi query sẽ tìm đường đi đến target
            - union-find lưu trước quan hệ giữa node - parent - root
     */

    private Map<String, String> parent = new HashMap<>();
    private Map<String, Double> weight = new HashMap<>();

    public void add(String x) {
        if(!parent.containsKey(x)) {
            parent.put(x, x);
            weight.put(x, 1.0);
        }
    }

    public String find(String x) {
        if(!parent.get(x).equals(x)) {
            String p = parent.get(x);
            String root = find(p);
            parent.put(x, p);
            weight.put(x, weight.get(x) * weight.get(root));
        }

        return parent.get(x);
    }

    public void union (String x, String y, double v) {
        add(x);
        add(y);

        String rootX = find(x);
        String rootY = find(y);

        if(rootX.equals(rootY)) return;

        parent.put(rootX, rootY);
        double weightRootX =  (v * weight.get(rootX)) / weight.get(rootY);
        weight.put(rootX, weightRootX);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            union(x, y, values[i]);
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            // kiểm tra có tồn tại
            if(!parent.containsKey(a) || !parent.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }

            String rootA = find(a);
            String rootB = find(b);

            // kiểm tra có cung component
            if(!rootA.equals(rootB)) {
                ans[i] = -1.0;
            } else {
                ans[i] = weight.get(a) / weight.get(b);
            }
        }
        
        return ans;
    }
}



/*

parent: {
    a: a,
    b: b
}
weight: {
    a: 1.0,
    b: 1.0
}

weight[x] cho biết tỷ lệ của nodeX với node cha trực tiếp

["a","b"]
    rootA = a
    rootB = b
    value = 2
    khác -> 
        parent.put(a, b)
        weightA = (2 * weight[b]) / weight[a])
        weight.put(a,  weightA) = weight.put(a, 2)

["b","c"]
    rootB = b
    rootC = c
    value = 3
    khác -> 
        parent.put(b, c)
        weightB = (3 * weight[c]) / weight[b])
        weight.put(b,  weightB) = weight.put(b, 3)

SAU KHI UNION
parent: {
    a: b,
    b: c,
    c: c
}
weight: {
    a: 2.0,
    b: 3.0,
    c: 1.0
}

 */