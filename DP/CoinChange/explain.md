## Dynamic Programming

### 📌 Understading the problem
Cho danh sách các đồng xu ***coins[]*** và một số ***amount***.

Tìm số lương đồng xu ***ít nhất*** để tổng giá trị bằng ***amount***.

### 📌 Ý tưởng theo Dynamic programming (Bottom-Up)
Sử dụng mảng dp[] trong đó:

> ***dp[i]***: số lượng đồng xu ***ít nhất*** từ mảng ***coins[]*** để tạo ra ***i***

Mảng dp[] giúp lưu giá trị bài toàn nhỏ hơn để không tính lặp đi lặp lại



```java
int[] coins = {1, 2, 5};
int amount = 11;

dp[0] = 0      // tạo 0 tiền cần 0 coin
dp[1] = 1      // (1)
dp[2] = 1      // (2)
dp[3] = 2      // (1+2)
dp[4] = 2      // (2+2)
dp[5] = 1      // (5)
dp[6] = 2      // (5+1)
dp[7] = 2      // (5 + 2)
dp[8] = 3       
dp[9] = 3
dp[10] = 2     // (5 + 5)
dp[11] = 3     // (5 + 5 + 1)
```





