- Cách duyệt phần tử trong HashMap và HashSet
- Return về empty array trong java
- Hàm yêu cầu trả về kiểu double thì viết "return 0;" - Đúng, java tự hiểu "return 0.0"
- Thay vì so sánh  s == "";  thi s.isEmpty();

### Trong Java khi so sánh Integer (hay các wrapper class như Long, Double…) bạn nên dùng .equals() thay vì ==.

```java 
Integer a = 128;
Integer b = 128;
System.out.println(a == b);      // ❌ false (không cùng reference)
System.out.println(a.equals(b)); // ✅ true  (cùng giá trị)

// 📌 Ngoại lệ nhỏ (tạo cảm giác dễ nhầm): 
// Trong khoảng từ -128 đến 127, Java cache sẵn các Integer nên == có thể trả về true:

Integer x = 127;
Integer y = 127;
System.out.println(x == y);      // ✅ true (vì cùng cache object)
```


## Sắp xếp Array 2D
```java
int[][] intervals = {{1,2},{2,4},{0,4}};

Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]))

// {{0,4}, {1,2}, {2,4}}
```
