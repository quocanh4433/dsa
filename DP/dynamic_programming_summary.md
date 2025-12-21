# Dynamic Programming --- Tổng Hợp Kiến Thức

## 1. Lịch sử ra đời

-   **1950--1953**: Richard Bellman nghiên cứu tối ưu hóa đa giai đoạn.
-   **1953**: Công bố bài báo đầu tiên về Dynamic Programming.
-   **1957**: Xuất bản sách *Dynamic Programming* --- nền tảng chính
    thức của DP.

## 2. Ý nghĩa tên gọi "Dynamic Programming"

-   **Dynamic**: mô tả quá trình thay đổi theo thời gian.
-   **Programming**: nghĩa là lập kế hoạch tối ưu (không liên quan đến
    code).
-   Bellman chọn tên này một phần để tránh sự kiểm duyệt và nghe "ngầu".

## 3. Mục đích ban đầu

DP được tạo ra để giải: - Các bài toán tối ưu nhiều giai đoạn. - Bài
toán chi phí đường đi, điều khiển tên lửa, tối ưu hóa tài nguyên.

## 4. Nguyên lý cốt lõi: Bellman Principle of Optimality

> "Một chính sách tối ưu có tính chất: phần còn lại phải là tối ưu."

Bài toán lớn = bài toán con + lời giải bài toán con.

## 5. Bài toán kinh điển đầu tiên

-   Bài toán tối ưu hóa đường đi qua nhiều giai đoạn.
-   Dẫn đến thuật toán **Bellman--Ford**.

## 6. Timeline chi tiết

-   **1950**: Bắt đầu nghiên cứu.
-   **1953**: Công bố Dynamic Programming.
-   **1955**: Giới thiệu Bellman Equation.
-   **1957**: Xuất bản sách.
-   **1960--nay**: DP phát triển mạnh trong CS, AI, kinh tế, robotics.

## 7. Ứng dụng

-   AI, Machine Learning (Q-learning dùng Bellman Equation)
-   Điều khiển robot, drone, tên lửa
-   Sinh học: alignment DNA
-   Kinh tế học: tối ưu chi phí
-   Thuật toán: knapsack, LIS, LCS, edit distance...

## 8. Các nhánh DP hiện đại

-   DP cổ điển: knapsack, coin change
-   Bitmask DP
-   Digit DP
-   Tree DP
-   DP + Binary Search
-   Convex Hull Trick
-   Divide and Conquer DP

## 9. Tóm tắt

  Nội dung          Ý chính
  ----------------- ---------------------------------
  Người phát minh   Richard Bellman
  Năm               1953--1957
  Mục đích          Tối ưu nhiều giai đoạn
  Công cụ nổi bật   Bellman Equation
  Thuật toán        Bellman-Ford, Floyd-Warshall
  Ứng dụng          AI, robotics, kinh tế, sinh học
