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



### Cho một chuỗi String s = "abc100xyz" lấy ra số trong chuỗi
```java
int num = 0;
for(char c : s.toCharArray()) {
    if(Character.isDigit()) {
        num = num * 10 + (c - '0');
    }
}
```


### Cho một chuỗi String s = "ab12cd34" lấy ra các số trong chuỗi
```java
import java.util.regex.*;

String s = "ab12cd34";
Matcher m = Pattern.compile("\\d+").matcher(s);

while (m.find()) {
    System.out.println(m.group()); // in ra: 12 và 34
}
```


### duyệt qua các phần từ trong stack
```java
// ✅ Duyêt bằng WHILE thay vì FOR
// 👉 duyệt bằng for không thể kiểm tra stack rỗng cho lần duyệt tiếp theo gây ra EmptyStackException
Stack<String> stack = new Stack<>();
while (!stack.isEmpty()) {
    // Không gây lỗi cho lần duyệt tiếp nếu xư lý xóa hết stack
}

for(int i = stack.size(); i >= 0 ; i-->) {

}
```


### remove phần tử cuối cùng của ArrayList - O(1)
```java
List<String> validString = new ArrayList<>();
validString.add("a");
validString.add("b");
validString.add("c");
validString.remove(validString.size() - 1);
System.out.println(validString); // [a, b]
// 👉 chỉ gán null và giảm size
```


### remove phần tử cuối cùng của LinkedList - O(n)
```java
List<String> list = new LinkedList<>();
list.remove(list.size() - 1);
//👉  phải duyệt đến phần tử cuối
```

### tạo chuỗi từ ArrayList
```java
List<String> subFolder = {"doc", "math", "exercise"};
String path = String.join("/", subFolder); // 👉 "doc/math/exercise"
```