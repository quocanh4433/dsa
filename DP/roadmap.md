1D → String → Knapsack → LIS → Stock → Interval

## 1. DP cơ bản / 1D DP (Easy → Medium)
✳️ Easy

- 70 – Climbing Stairs

- 198 – House Robber

- 256 – Paint House

- 62 – Unique Paths

- 63 – Unique Paths II

- 64 – Minimum Path Sum

- 55 – Jump Game (thường giải Greedy nhưng có DP)

📒 Medium

- 91 – Decode Ways

- 279 – Perfect Squares

- 376 – Wiggle Subsequence

- 152 – Maximum Product Subarray

- 487 – Max Consecutive Ones II

👉 Đặc điểm:

dp[i] = kết quả tốt nhất đến vị trí i

Thường tối ưu được xuống O(1) space

## 2. DP Chuỗi (String DP)

📒 Medium

- 139 – Word Break

- 647 – Palindromic Substrings

- 516 – Longest Palindromic Subsequence

- 72 – Edit Distance

- 97 – Interleaving String

⛔️ Hard

- 10 – Regular Expression Matching

- 115 – Distinct Subsequences

- 1092 – Shortest Common Supersequence

- 1278 – Palindrome Partitioning III

👉 Đặc điểm:

dp[i][j] biểu diễn substring / prefix

Hay gặp: LCS, palindrome, regex

## 3. Knapsack / Subset Sum (rất quan trọng)

📒 Medium

- 416 – Partition Equal Subset Sum

- 494 – Target Sum

- 474 – Ones and Zeroes

- 377 – Combination Sum IV

- 518 – Coin Change II

⛔️ Hard

- 1049 – Last Stone Weight II

👉 Đặc điểm:

dp[sum] hoặc dp[i][sum]

Bài toán “chọn / không chọn”

## 4. DP Subsequence / LIS / LCS

📒 Medium

- 300 – Longest Increasing Subsequence

- 1143 – Longest Common Subsequence

- 354 – Russian Doll Envelopes

- 368 – Largest Divisible Subset

- 1964 – Longest Valid Obstacle Course

👉 Đặc điểm:

LIS: dp[i] hoặc Binary Search

LCS: dp[i][j]



## 5. DP Chứng khoán (State Machine DP)

📒 Medium
- 123 – Best Time to Buy and Sell Stock III

- 309 – Best Time to Buy and Sell Stock with Cooldown

👉 Đặc điểm:

dp[i][state]

State = buy / sell / cooldown / k transactions

## 6. Grid / Probability DP

📒 Medium

- 221 – Maximal Square

- 688 – Knight Probability in Chessboard


## 7. Interval DP (Khó – nâng cao)
⛔️ Hard

- 312 – Burst Balloons

- 1547 – Minimum Cost to Cut a Stick

- 1335 – Minimum Difficulty of a Job Schedule

- 410 – Split Array Largest Sum

👉 Đặc điểm:

dp[l][r]

Chia đoạn → chọn điểm cắt tối ưu