
## Mô tả bài toán

Bạn được cho một danh sách liên kết, trong đó mỗi node có 2 con trỏ:

```java
class Node {
    int val;
    Node next;
    Node random;
}
```

- next: trỏ đến node kế tiếp (như linked list bình thường).
- random: trỏ đến bất kỳ node nào trong danh sách hoặc null.


## Nhiệm vụ

Tạo một bản sao sâu (deep copy) của danh sách này:

Mỗi node trong danh sách mới phải là object mới hoàn toàn, không được trỏ đến node cũ.

Nhưng cấu trúc next và random phải giống hệt danh sách ban đầu.

## Điểm khó của bài

Nếu chỉ copy next thì rất dễ.Nhưng vấn đề là:

Con trỏ random có thể trỏ lung tung, kể cả node phía sau hoặc phía trước.

Vậy nên:
- Không thể copy node theo cách đơn giản là duyệt rồi gán ngay random được.
- Vì lúc copy node A, có thể node mà random của A trỏ tới vẫn chưa được copy xong.

## Mấu chốt logic

Bạn cần đảm bảo rằng:

Mỗi node gốc chỉ được tạo đúng 1 node copy duy nhất,
và mọi random đều phải trỏ tới node copy tương ứng.


## Những bẫy thường gặp

- ✅ Không được tạo random trỏ về node cũ
- ✅ Không được làm thay đổi danh sách ban đầu
- ✅ Phải xử lý tốt trường hợp random = null

