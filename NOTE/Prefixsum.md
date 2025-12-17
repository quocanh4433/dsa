## Prefixsum inclusive and exclusive
<b>Inclusive:</b> tính luôn giá trị nums[i]<br>
<b>Exclusive:</b> không tính giá trị nums[i]


## Tính prefix và suffix exclusive với 1 vòng lặp
```java
int[] nums;
int[] leftSum;
int[] rightSum;

for(int i = 1; i < n; i++) {
    leftSum[i] = leftSum[i - 1] + nums[i - 1];
    rightSum[n - i - 1] = rightSum[n - i] + nums[n - i];
}
```


## Rolling Sum: 
- “Rolling Sum” (hay còn gọi là <b>Running Sum / Prefix Accumulation</b>) là một khái niệm cực kỳ cơ bản và quan trọng trong lập trình, đặc biệt là Dynamic Programming, Prefix Sum, và tối ưu vòng lặp.
- Có thể dùng cho prefix exclusive và inclusive
- Ứng dụng 🧩: tính rightSum khi biết leftSum và totalSum(tổng toàn mảng)
- Ưu điểm 👏: tiết kiệm bộ nhớ do không cần tạo mảng <b>int[] leftSum</b> và <b>int[] rightSum</b>;


```java
int total = Arrays.stream(nums).sum(); // tổng toàn mảng
int leftSum = 0;

// Rolling sum for ixclusive
for (int i = 0; i < nums.length; i++) {
    leftSum += nums[i]; // rolling update
    int rightSum = total - leftSum - nums[i];
}
```