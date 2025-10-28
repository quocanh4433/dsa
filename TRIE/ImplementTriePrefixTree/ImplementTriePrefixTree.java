package ImplementTriePrefixTree;
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
     * Time: O(n)
     * Space: O(n) mỗi từ chưa một new TrieNode
     * 
     * n: độ dài của từ được thêm vào
     */
    public void insert(String word) {
        TrieNode node = root; // 1️⃣ Bắt đầu từ nút gốc của Trie
        for (char c : word.toCharArray()) { // 2️⃣ Duyệt qua từng ký tự của từ
            int idx = c - 'a';             // 3️⃣ Tính chỉ số vị trí trong mảng children (0 → 25)
            if (node.children[idx] == null) { // 4️⃣ Nếu chưa có nhánh tương ứng với ký tự này
                node.children[idx] = new TrieNode(); // 5️⃣ Tạo một node con mới
            }
            node = node.children[idx]; // 6️⃣ Di chuyển xuống node con vừa tạo (hoặc đã tồn tại)
        }
        node.isEnd = true; // 7️⃣ Đánh dấu node cuối cùng là kết thúc của 1 từ
    }

    /*
     * Time: O(n)
     * Space: O(1)
     * 
     * n: độ dài của từ 
     */
    public boolean search(String word) { // Kiểm tra 1 từ đầy đủ có tồn tại trong cây hay không
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }

    /*
     * Time: O(n)
     * Space: O(1)
     * 
     * n: độ dài của từ 
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}

class TrieNode {

    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("apple");
        myTrie.insert("apply");
        myTrie.insert("application");

        System.out.println(myTrie.search("apply")); 
        System.out.println(myTrie.startsWith("applo")); // false
        System.out.println(myTrie.startsWith("appli")); // true 
        System.out.println(myTrie.startsWith("app")); // false
    }
}
