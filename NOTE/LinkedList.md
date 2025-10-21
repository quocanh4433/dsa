### Điều kiện dừng
```java
ListNode head;
if(head == null || head.next == null) return head; ✅
if(head == null || head.next == null) return null; ❌
```

### Tại sao yên cầu trả vè ListNode nhưng trả về null vẫn đúng
```java
ListNode head;
if(head == null) return null; ✅
```
Bởi vì ListNode là một class, tức là kiểu tham chiếu (reference type) trong Java.
Mà tất cả kiểu tham chiếu (class, interface, mảng, wrapper...)
đều có thể nhận giá trị đặc biệt null.
```java
String s = null; ✅
ListNode node = null; ✅
int[] arr = null; ✅
``` 