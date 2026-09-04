## Trie pruning?	
Dừng DFS sớm khi prefix hiện tại không thuộc Trie


## khi bao class TrieNode
```java
class TrieNode { // ✅ ĐÚNG
    TrieNode[] children;
    boolean isEnd; 

    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
```
👉 Giải thích:
- children và isEnd là biến instance (thuộc về đối tượng).
- Khi bạn tạo new TrieNode(), constructor sẽ gán giá trị cho các thuộc tính của đối tượng đó.

<br>

```java
class TrieNode { // ❌ SAI
    TrieNode() {
        TrieNode[] children = new TrieNode[26]; 
        boolean isEnd = false; 
    }
}
```

👉 Giải thích:
- Ở đây, children và isEnd chỉ là biến cục bộ trong hàm khởi tạo (local variables).
- Chúng không thuộc về class, nên sẽ bị huỷ ngay sau khi constructor kết thúc.
- Kết quả: class này không có bất kỳ thuộc tính nào!