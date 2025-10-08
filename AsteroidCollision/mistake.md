## 735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



## Phân tích đề bài
Cho một array số nguyên asteroids (tiểu hành tính - THT) với:
- value: kích thước của tiếu hành tinh
- dấu: (-) THT di chuyển sang TRÁI
- dấu: (+) THT di chuyển sang PHẢI

Tìm các THT còn tồn tại sau va chạm. Nếu 2 THT va chạm thì:
- THT có kích thước nhỏ hơn sẽ biến mất 
- 2 THT cùng kích thước thì cùng biến mất
- 2 THT cùng hướng (cùng dấu) sẽ không va chạm


## Sai lầm khi phân tích đề bài

⚠️ Hai THT va chạm khi ngược hướng (khác dấu) - Đúng 1 phần <br>
⟵🔴      🔴⟶         

✅ Hai THT va chạm khi ngược hướng (khác dấu) VÀ hướng về nhau <br>
🔴⟶       ⟵🔴   


## Hướng giải
Duyệt từng THT (ast)
- nếu stack thêm ast vào stack
- nếu ast > 0 thêm vào stack
- nếu ast < 0:
    - cùng hướng ast trong stack.peek (peek) - thêm vào stack
    - ngược với ast trong stack
        - |ast| < |peek| -> break
        - |ast| == |peek| -> pop - > break
        - |ast| > |peek| -> pop -> while
