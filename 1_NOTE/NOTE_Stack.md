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
