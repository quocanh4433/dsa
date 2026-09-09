>To solve this problem, I'm using Breadth-First Search (BFS) with a Queue. BFS allows us to traverse the binary tree level by level, from top to bottom, left to right.

>First, I handle the edge case: if the root is null, I simply return an empty result list. Otherwise, I initialize a Queue and push the root node into it to start the traversal.

>Then, I run a while loop that continues as long as the queue is not empty. Inside the loop, the critical step is taking int size = q.size(). This snapshot tells us exactly how many nodes belong to the current level, so we don't accidentally mix nodes from different levels.

Sau đó, tôi chạy một vòng lặp while tiếp diễn cho đến khi queue rỗng. Bên trong vòng lặp, bước quan trọng nhất là lấy int size = q.size(). Việc chốt kích thước này cho chúng ta biết chính xác có bao nhiêu node thuộc về tầng hiện tại, tránh bị lẫn lộn các node ở các tầng khác nhau.

>Next, I iterate size times using a for loop. In each iteration, I pop a node using q.poll(), append its value to a current level list, and then enqueue its left and right children if they exist.

Tiếp theo, tôi lặp lại size lần bằng vòng lặp for. Ở mỗi lần lặp, tôi lấy node ra bằng q.poll(), thêm giá trị của nó vào danh sách của tầng hiện tại, sau đó đưa node con bên trái và bên phải của nó vào queue nếu chúng tồn tại.

>Once ```(Ngay khi)``` the for loop finishes processing all nodes of the current level, I add that level's list to my final result res. Finally, I return res.

>The time complexity is $O(N)$, where $N$ is the total number of nodes in the binary tree, because we visit each node exactly once.

>The space complexity is $O(N)$ because, in the worst case (a full binary tree), the queue will hold up to $N/2$ ```(đọc là N over 2)``` nodes at the leaf level, plus $O(N)$ space to store the output list.

