## 1. Lower Bound
Lower bound(x) = vị trí đầu tiên mà ``nums[i] >= x``.

```java
int l = 0;
int r = nums.length;

while (l < r) {
    int m = l + (r - l) / 2;

    if (nums[m] < target) {
        l = m + 1;
    } else {
        r = m;
    }
}

return l;
```

Điểm quan trọng

```java
if (nums[m] < target)
    l = m + 1;
else
    r = m;
```


```
nums[m] < target
    → m chắc chắn không phải đáp án
    → l = m + 1

nums[m] >= target
    → m CÓ THỂ là đáp án
    → giữ m lại
    → r = m
```


## 2. Upper Bound
Upper bound(x) = vị trí đầu tiên mà ``nums[i] > x``.

```java
int l = 0;
int r = nums.length;

while (l < r) {
    int m = l + (r - l) / 2;

    if (nums[m] <= target) {
        l = m + 1;
    } else {
        r = m;
    }
}

return l;
```

Khác ``lower_bound`` đúng một dấu:

```java
lower_bound:
nums[m] < target
    → l = m + 1
else
    → r = m


upper_bound:
nums[m] <= target
    → l = m + 1
else
    → r = m
```


## 3. Ứng dụng rất hay: đếm số lần xuất hiện

Nếu mảng sorted:

``[1, 2, 2, 2, 4, 5, 7]``

Số lượng ``2``:

```java
upper_bound(2) - lower_bound(2)
= 4 - 1
= 3
```