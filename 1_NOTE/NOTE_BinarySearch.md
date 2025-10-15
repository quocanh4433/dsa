## 🔹 Quy tắc tổng quát của Binary Search

| 🎯 Mục tiêu | 🧭 Khi điều kiện **thỏa mãn** | 🔁 Dạng vòng lặp | 💡 Ghi chú |
|--------------|-------------------------------|------------------|------------|
| **Tìm giá trị nhỏ nhất** thỏa mãn điều kiện | `right = mid;` | `while (left < right)` | Dạng “tìm min thỏa mãn” (như bài **Koko Eating Bananas**) |
| **Tìm giá trị lớn nhất** thỏa mãn điều kiện | `left = mid;` | `while (left < right)` *(có thể cần điều chỉnh `+1/-1`)* | Dạng “tìm max thỏa mãn” |
| **Tìm giá trị chính xác** (exact match) | So sánh `nums[mid]` với `target` | `while (left <= right)` | Dạng Binary Search cổ điển |
| **Tìm vị trí chèn (insert position)** | `if (nums[mid] >= target)` → `right = mid;` | `while (left < right)` | Dạng “lower bound” |
| **Tìm phần tử cuối ≤ target** | `if (nums[mid] <= target)` → `left = mid;` | `while (left < right)` | Dạng “upper bound” |

---

### 📘 Ghi nhớ nhanh
| Mục tiêu | Quy tắc nhớ nhanh |
|-----------|------------------|
| Tìm **min** thỏa mãn | ✅ Giữ `mid` lại → `right = mid` |
| Tìm **max** thỏa mãn | ✅ Giữ `mid` lại → `left = mid` |
| Tìm **chính xác** | ⚖️ Kiểm tra `==`, `<`, `>` |
| Tìm **vị trí chèn** | 🪜 `while (left < right)` + cập nhật `right = mid` khi `>= target` |

---

💡 **Mẹo phân biệt nhanh**  
> - Nếu muốn **giữ lại mid** làm ứng viên hợp lệ → không trừ `1` hay cộng `1`.  
> - Nếu mid **chắc chắn sai**, thì **loại bỏ** bằng `±1`.  
> - Khi mục tiêu là **giá trị nhỏ nhất thỏa mãn**, dùng `right = mid`.  
> - Khi mục tiêu là **giá trị lớn nhất thỏa mãn**, dùng `left = mid`.

---



### Tìm middle
```java             
int m = l + (r - l)/2; ✅
int m =  (l + r) / 2;  ❌// Nếu l và r quá lớn thì int m =  (l + r) / 2 gây OVERFLOW
```

### Phép chia làm tròn lên
```java
int a = 5;
int b = 2;

❌ int ans = Math.ceil(a/b) // ceil trả về kiểu double
✅ int ans2 = (int) Math.ceil((double) a / b);  // ép kiểu sang double trước khi chia.Giải thích (double) a / b = 2.5 → ceil(2.5) = 3.0 → ép kiểu về int = 3
✅ int ans = (a + b - 1) / b // trả về kiểu double
```


