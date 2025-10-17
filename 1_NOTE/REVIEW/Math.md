### Công thức chia lấy ra tưng chữ số
```java
int x = 123
int res = 0 // -> 123 (giữ nguyên thứ tự)
int res_2 = 0 // -> 321 (đảo ngược)
while (x > 0) {
    int digit = x % 10;   // Lấy chữ số cuối
    x = x / 10;           // Bỏ chữ số cuối
    res = digit * 10 + res
    res_2 = res * 10 + digit
}
```