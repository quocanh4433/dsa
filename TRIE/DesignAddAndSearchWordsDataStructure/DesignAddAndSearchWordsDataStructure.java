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
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        public boolean dfs(String word, int index, TrieNode node) {
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
