![Binary Search Tree](./explain.png)

## Tìm node chung gần nhất của 2 node

- Tìm node chung gần nhất của Node 2 và 8 -> 6
- Tìm node chung gần nhất của Node 3 và 8 -> 6 (Chỉ cần 3 và 8 chung một node root)
- Tìm node chung gần nhất của Node 2 và 4 -> 2 (Một Node có thể là node chung của 2 node)

> Trong BST, nếu p và q không nằm hoàn toàn ở bên trái hoặc hoàn toàn ở bên phải của root, thì root chính là Lowest Common Ancestor của p và q.