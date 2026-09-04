package DesignAddAndSearchWordsDataStructure;

public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx]; // 
            }
            node.isEnd = true;

            /*
             * 👉 Sau khi addWord hoan tất node sẽ đi đâu?
             * - node là một biến cục bộ (local variable) nằm trong stack frame của hàm addWord.
             * - node chỉ tồn tại trong thời gian hàm chạy.
             * - node sẽ bị xóa khỏi stack (biến mất) sau khi hàm addWord() chạy xong,
             * - nhưng các node trong Trie mà nó đã tạo ra thì vẫn tồn tại — vì root vẫn giữ tham chiếu đến toàn bộ cây.
             */
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        public boolean dfs(String word, int index, TrieNode node) {

            /**
             * dfs() duyệt từng ký tự của từ.
             * Nếu gặp ký tự thật → đi xuống đúng nhánh.
             * Nếu gặp ký tự thật → đi xuống đúng nhánh.
             * Nếu gặp '.' → thử mọi nhánh con bằng đệ quy.
             * Khi hết từ → kiểm tra isEnd để biết có trùng từ nào không.
             */


            /*
             * 👉 int index có ý nghĩa gì? - chính là chỉ số ký tự của word
             * - word = "abc" -> index = 0 -> word[0] = 'a'
             */


            // Way 1: 

            TrieNode curr = node;

            for(int k = index; k < word.length(); k++) {
                char c = word.charAt(k);
                if(c == '.') {
                    // Nếu c == '.' khớp với tất cả chũ cái từ a - z
                    // Nên kiểm tra tất cả các node con
                    for(TrieNode child : curr.children) {
                        // Node con nào không null dfs tiếp
                        if(child != null && dfs(word, k + 1, child)) {
                            return  true;
                        }
                    }
                    // không nhánh nào khớp
                    return false;
                } else {
                    int idx = c - 'a';
                    if(curr.children[idx] == null) {
                        return false;
                    }
                    curr = curr.children[idx];
                }             
            }

            return curr.isEnd;
















            
            





            //  Way 2:


            /*
            if (index == word.length()) {
                return node.isEnd;
            }

            char c = word.charAt(index);

            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                TrieNode next = node.children[idx];
                if (next == null) {
                    return false;
                }
                return dfs(word, index + 1, next);
            }
            
             */
            
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

    public static void main(String[] args) {
        
    }
}
