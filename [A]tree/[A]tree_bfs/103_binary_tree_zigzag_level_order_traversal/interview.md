>To solve this problem, I'm using Breadth-First Search (BFS) with a Queue.

>First, I handle the edge case: if the root is null, I simply return an empty result list. Otherwise, I initialize a Queue and push the root node into it to start the traversal.

>Then, I run a while loop that continues as long as the queue is not empty. Inside the loop, the critical step is taking int size = q.size(). This snapshot tells us exactly how many nodes belong to the current level, so we don't accidentally mix nodes from different levels.

Sau đó, tôi chạy một vòng lặp while tiếp diễn cho đến khi queue rỗng. Bên trong vòng lặp, bước quan trọng nhất là lấy int size = q.size(). Việc chốt kích thước này cho chúng ta biết chính xác có bao nhiêu node thuộc về tầng hiện tại, tránh bị lẫn lộn các node ở các tầng khác nhau.

>After finishing the level loop, if reverse is true, I flip the list using ```Collections.reverse()```. I then add the list to the result and flip the flag ```reverse = !reverse (Đọc là reverse equals not reverse)``` .

>The time complexity is $O(N)$, where $N$ is the total number of nodes in the binary tree, because we visit each node exactly once.

>The space complexity is $O(N)$ because, in the worst case (a full binary tree), the queue will hold up to $N/2$ ```(đọc là N over 2)``` nodes at the leaf level, plus $O(N)$ space to store the output list.
