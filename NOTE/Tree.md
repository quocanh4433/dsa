### pass bay value  và pass by referrence
Ví dụ bài:  297. Serialize and Deserialize Binary Tree

```java
public class Demo {
    public static void main(String[] args) {
        int[] a = {0};
        modify(a);
        System.out.println(a[0]); 
        // Output: 1
        // 👉 Mảng trong Java là tham chiếu (pass by reference).
        // Khi bạn truyền a (mảng) vào hàm, mọi thay đổi a[0] sẽ cập nhật trực tiếp mảng gốc.
        // Nhờ vậy, mỗi recursion sẽ biết vị trí hiện tại trong mảng vals.

        int b = 0;
        modifyInt(b);
        System.out.println(b);    
        // Output: 0
        // 👉 Tại sao vẫn là 0 mặc dù đã đi qua hàm modifyInt ?
        // i được truyền theo giá trị (pass by value) trong Java.
        // Khi bạn thay dổi i, chỉ thay đổi bản sao cục bộ, không ảnh hưởng đến i ở ngoài.
    }

    static void modify(int[] arr) {
        arr[0] = 1;
    }

    static void modifyInt(int x) {
        x = 1;
    }
}

```