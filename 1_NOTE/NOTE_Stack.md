### Chuyển String s = "123" sang số 
```java
int num = Integer.parseInt(s) // -> trả về kiểu int
int num = Integer.valueOf(s) // -> trả về wrapper class Integer

Stack<Integer> stack = new Stack<>();
stack.push(Integer.parseInt(s)) // -> autoboxing int -> Integer ⚠️
stack.push(Integer.valueOf(s)) ✅
```




### Thêm StringBuilder onto List<String>
```java
StringBuilder s = "String"
List<String> result = new ArrayList<>();

result.add(s.toString()) ✅
result.add(s) // ❌ error: incompatible types: StringBuilder cannot be converted to String
```




### Nối chuỗi với String và StringBuilder
```java
String s = "abc";
s = s + "->" + "xyz"; // Kết quả: "abc->xyz" 
// Java thực sự tạo ra một đối tượng String mới trong bộ nhớ (Heap).


StringBuilder sb = "";
sb.append("->").append("xyz"); // Kết quả: "abc->xyz"
```



### Chuyển StringBuilder và String thành rỗng
```java
String s = "abc";
s = "";     // ✅ Cách phổ biến nhất
// hoặc
s = null;   // ⚠️ Không phải “rỗng” mà là “không trỏ đến chuỗi nào”


StringBuilder sb = new StringBuilder("abc");
sb.setLength(0);    // ✅ Nhanh (không tạo đối tượng mới)
```



### Thêm phần từ vào Stack và Queue
```java
Stack<Integer> stack = new Stack<>();
Queue<Integer> queue = new LinkedList<>();

stack.push(1);   // ✅ Trả về phần tử vừa thêm.
// hoặc
stack.add(1); // ❌ Không trả về phần tử vừa thêm, mà trả về boolean (true nếu thêm thành công).


queue.add(1); // ⚠️ Nếu hàng đợi đầy (với queue có giới hạn, như ArrayBlockingQueue) → ném Exception (IllegalStateException).
//hoặc
queue.offer(1); // 🚫 Chính là “anh em” của queue.add(), nhưng an toàn hơn.  Nhưng không ném exception nếu đầy — chỉ trả về false.
```

### Kiểm tra two numbers have opposite signs
```java
int a = 2;
int b = -18;

// 1: Highly Recommended
boolean oppositeSigns = a * b < 0;
// 2: XOR
boolean oppositeSigns = (a ^ b) < 0;
// 3
boolean oppositeSigns =  (a > 0 && b < 0) || (a < 0 && b > 0);
```