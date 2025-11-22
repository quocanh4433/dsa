## Understading the problem
Một con Alien đang sử dụng chữ cái latin từ a -> z giống con người đề giao tiếp nhưng khác thứ tự.

Là một Predator, bạn vô tình có được danh sách ***words = ["hrn","hrf","er"]*** là danh sách những từ được sắp xếp theo bảng chữ cái của Alien.

Nhiệm vụ của bạn là giải mã danh sách ***words*** để tìm thứ tự các chữ cái theo ngôn ngữ của Alien.

***Giải thích:***

👉 So sánh từng cặp

"hrn" vs "hrf" -> thứ tự: h - r - n - f

🧩 Tại sao *"n"* đứng trước *"f"*?

Do "hrn" có index là 0 đứng trước "hrf" index là 1

👉 So sánh cặp tiếp theo

"hrf" vs "er" -> thứ tự: h - e - r - n - f

👉Thứ tự chữ cái của Alien: ***"h-e-r-n-f"***


## Xác định cấu trúc dữ liệu cho bài này
Đầu tiên, các chữ cái phải đi theo thư tự. Ví dụ, h phải đứng trước e. Nghỉ ngay đến ***LINKEDLIST***, ***TREE*** và ***GRAPH***.

🧩 Vậy sử dụng cấu trúc nào phù hợp hơn?

***❌ LINKEDLIST*** : Nếu từ điển của Alien CHỈ thay đổi vị trí của chữ cái thì vẫn có thể sử dụng. Quan hệ các chữ cái chỉ là 1 đường thằng duy nhất.

```java
z → r → g → q
```

***❌ TREE*** : 
Một tree phải thỏa đủ 3 điều này:

1.  Mỗi node chỉ có 1 cha duy nhất (trừ root).
2.  Không có chu trình.
3.  Tồn tại một node gốc (root) mà mọi node đều đi ra từ đó.

Nhưng bài này vi phạm điều 1, vì có thể có nhiều hơn 1 root

```java
["za", "zb", "ya", "yb" ,"ca", "cb"]

z → y → c
a → b

👉 có 2 root z và a
```

Không có một kết quả duy nhất — mọi chuỗi thỏa các ràng buộc đều hợp lệ. Hai ví dụ hợp lệ:

👉 ***azbyc***

👉***zaybc***

## Xác định thuật toán
Nhắc đến đồ thị thì DFS hoặc BFS. Trong bài này mình chọn BFS vì dễ tiếp cận hơn.

👏 Let's go
