### Heap for preferenct type
lỗi này là “kinh điển” khi bạn dùng PriorityQueue<int[]> mà không truyền comparator.
```java
Queue<int[]> minHeap = new PriorityQueue<>(); ❌
Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); ✅

//-----------------

Queue<String[]> minHeap = new PriorityQueue<>(); ❌
Queue<String[]> minHeap = new PriorityQueue<>(
    (a, b) -> a[1].compareTo(b[1])  // so sánh theo giá trị tại index 1
);✅

```

Java cố gắng ép int[] sang Comparable để so sánh thứ tự — nhưng mảng không thể so sánh trực tiếp

Vì bạn không cung cấp Comparator cho PriorityQueue, nên nó mặc định cố dùng compareTo, dẫn đến lỗi này.


| Kiểu dữ liệu của `a[1]` | Cách viết đúng | Ghi chú |
|--------------------------|----------------|----------|
| `int`                   | `Integer.compare(a[1], b[1])` | `int` là kiểu nguyên thủy, không có `compareTo()` |
| `Integer`               | `a[1].compareTo(b[1])` **hoặc** `Integer.compare(a[1], b[1])` | Cả hai đều hợp lệ |
| `String`                | `a[1].compareTo(b[1])` | So sánh theo thứ tự từ điển |
| `double`                | `Double.compare(a[1], b[1])` | Tương tự như với `int` |
