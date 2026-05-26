import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AccountsMerge {

    /*
        time O(nlogn)
        space O(n)

        n: tổng sô email
     */
    Map<String, String> parent = new HashMap<>();

    private String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(String a, String b) {
        String pa = find(a);
        String pb = find(b);

        if (!pa.equals(pb)) {
            parent.put(pa, pb); // hoặc parent.put(pb, pa);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();

        // 1. tìm parent của từng email
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.put(email, email); // parent mỗi email là chính nó
                owners.put(email, name); // cho biết owner của mỗi email
            }
        }

        // 2. union các email có account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                union(firstEmail, account.get(i));
            }
        }

        // 3. gom nhóm theo root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }

        // 4. build kết quả
        List<List<String>> res = new ArrayList<>();
        for (String root : groups.keySet()) {
            String owner = owners.get(root);
            List<String> emails = groups.get(root);

            // yêu cầu từ đề bài: emails in sorted order
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(owner);
            account.addAll(emails);
            res.add(account);
        }

        return res;
    }
}


/*
input = [[John, a, b, f], [John, a, c], [Mary, m], [John, g]]

1. tìm parent của từng email

parent = {    ban đầu mỗi email là 1 group riêng
    a: a, 
    b: b, 
    f: f
    c: c, 
    m: m, 
    g: g
}
owner = {   email này thuộc owner nào
    a: John, 
    b: John, 
    c: John, 
    f: John,
    m: Mary, 
    g: John
}


2. union các email có account

    [John, a, b, f]
    firstEmail = a
    union(a, b)
        pa = a
        pb = b
        khác nhau: parent a -> b
    union(a, f)
        pa = b
        pf = f
        khác nhau: parent b -> f

    [John, a, c]
    firstEmail = a
    union(a, c)
        pa = f
        pc = c
        kacs nhau: parent f -> c


    [Mary, m]
    firstEmail = m
    không có email thứ 2 không cân union


    [John, g]
    firstEmail = g
    không có email thứ 2 không cân union

sau bước thứ 2

parent = {
    a: f, 
    b: f,
    f: c 
    c: c, 
    m: m, 
    g: g
}

owner = {
    a: John, 
    b: John, 
    c: John, 
    f: John
    m: Mary, 
    g: John
}


3. gom nhóm theo root

    parent.keySet = [a, b, c, f, m, g]

    email = a
    root = find(a) = c
    groups = {
        c: [a]
    }


    email = b
    root = find(b) = c
    groups = {
        c: [a, b]
    }

    email = f
    root = find(f) = c
    groups = {
        c: [a, b, f]
    }

    email = c
    root = find(c) = c
    groups = {
        c: [a, b, f, c]
    }

    email = m
    root = find(m) = m
    groups = {
        c: [a, b, f, c],
        m: [m]
    }

    email = g
    root = find(g) = g
    groups = {
        c: [a, b, f, c],
        m: [m],
        g: [g]
    }

sau bước 3

groups = {
    c: [a, b, f, c],
    m: [m],
    g: [g]
}

 */
