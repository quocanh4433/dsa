# Backtracking

-   Là một **kỹ thuật giải thuật tổng quát** dùng để **tìm kiếm mọi khả
    năng có thể** nhằm giải quyết một bài toán tính toán.
-   Về mặt khái niệm, có thể tưởng tượng **backtracking như việc duyệt
    cây (tree traversal)**.
-   Chúng ta xem **bài toán gốc là nút gốc (root node)**.
-   Mỗi **nút trung gian** đại diện cho **một lời giải tạm thời
    (candidate solution)** có thể dẫn đến lời giải đúng cuối cùng.
-   Mỗi nút có thể **phân nhánh sang các lời giải tạm thời khác** ---
    mỗi bước lại tiến gần hơn đến lời giải hoàn chỉnh.
-   Nếu xác định rằng một nút **không thể** dẫn đến lời giải hợp lệ, ta
    **bỏ nút đó (abandon)** và **quay lui (backtrack)** về nút cha để
    thử hướng khác.
-   Về cơ bản, **backtracking là brute-force (thử tất cả)**,
    -   Nhưng vì **loại bỏ các hướng đi không cần thiết**, nên nó
        **nhanh hơn brute-force** thuần túy.
-   Thông thường, **backtracking sử dụng DFS (Depth-First Search)** để
    thực hiện.

------------------------------------------------------------------------

👉 Tóm lại:\
Backtracking là **duyệt toàn bộ không gian lời giải**, nhưng **biết dừng
sớm khi hướng đi sai**, giúp tiết kiệm thời gian so với brute-force.
