## Ý tưởng của thuật toán Rapin-Karp

Ý tưởng cốt lõi của thuật toán Rabin-Karp (viết đúng là Rabin-Karp) là biến bài toán so sánh chuỗi (String Matching) từ việc so sánh từng ký tự thành so sánh giá trị số (Hash).

Thay vì tốn thời gian kiểm tra từng ký tự một của mẫu ```needle``` với từng đoạn con của ```haystack```, Rabin-Karp tính mã Hash cho ```needle``` và cho tất cả các chuỗi con có cùng độ dài trong ```haystack```.

### 1. Cơ chế hoạt động chính

- Bước 1 (Mã hóa): Tính giá trị Hash của ```needle``` (độ dài $M$) và Hash của chuỗi con đầu tiên gồm $M$ ký tự của ```haystack```.

- Bước 2 (So sánh Hash):

    - Nếu $\text{Hash}(\text{chuỗi con}) \neq \text{Hash}(\text{needle})$: Chắc chắn 2 chuỗi không giống nhau. Ta trượt sang vị trí tiếp theo.

    - Nếu $\text{Hash}(\text{chuỗi con}) == \text{Hash}(\text{needle})$: Có khả năng 2 chuỗi giống nhau (xác suất cao). Ta chỉ cần duyệt lại từng ký tự để xác nhận xem có bị va chạm Hash (Collision) hay không.


### 2. Kỹ thuật then chốt: Rolling Hash (Hash cuộn)

Kỹ thuật này giúp Rabin-Karp đạt hiệu năng cao. Khi trượt cửa sổ từ vị trí này sang vị trí tiếp theo, chuỗi con chỉ thay đổi đúng 2 ký tự: bỏ ký tự đầu tiên và thêm ký tự mới vào cuối.

Hình dung qua số học (Hệ thập phân $\text{BASE} = 10$):

Giả sử cửa sổ hiện tại đang giữ số 4352, bạn trượt sang phải để lấy số 3527:

1. Bỏ chữ số đầu 4: $4352 - 4 \times 10^3 = 352$

2. Nhân với cơ số $10$ để dịch các chữ số sang trái: $352 \times 10 = 3520$

3. Thêm chữ số mới 7: $3520 + 7 = 3527$

Công thức tổng quát với cơ số $\text{BASE}$ và lấy dư $\text{MOD}$:


$$\text{Hash}_{\text{mới}} = \left( (\text{Hash}_{\text{cũ}} - \text{val}(\text{ký tự cũ}) \times \text{BASE}^{M-1}) \times \text{BASE} + \text{val}(\text{ký tự mới}) \right) \pmod{\text{MOD}}$$


### 3. Đánh giá độ phức tạp
- Độ phức tạp thời gian (Time Complexity):
    - Trung bình / Tốt nhất: $\mathcal{O}(N + M)$ — do phép tính Rolling Hash chỉ tốn $\mathcal{O}(1)$ cho mỗi bước dịch chuyển ($N$ là độ dài haystack, $M$ là độ dài needle).
    
    - Xấu nhất: $\mathcal{O}(N \times M)$ — xảy ra khi bị va chạm Hash liên tục (chọn $\text{BASE}$ và $\text{MOD}$ kém), khiến thuật toán phải kiểm tra từng ký tự ở mọi vị trí.
    
- Độ phức tạp bộ nhớ (Space Complexity): $\mathcal{O}(1)$ — chỉ cần vài biến lưu giá trị Hash hiện tại.


### 4. Tại sao chọn $\text{BASE} = 31$, $\text{MOD} = 10^9 + 7$.


Việc chọn $\text{BASE} = 31$ và $\text{MOD} = 10^9 + 7$ là một "tiêu chuẩn vàng" trong lập trình thi đấu và phỏng vấn giải thuật. Lựa chọn này xuất phát từ các lý do toán học và kỹ thuật sau:

#### 1. Tại sao chọn $\text{MOD} = 10^9 + 7$?

- Là một số nguyên tố cực lớn (Large Prime Number):

    - Theo lý thuyết số, phép chia lấy dư với số nguyên tố giúp phân bổ các giá trị Hash một cách ngẫu nhiên và đồng đều nhất trên dải $[0, \text{MOD} - 1]$, giảm xác suất đụng độ (collision) xuống mức tối thiểu ($\approx \frac{1}{\text{MOD}}$).

- Tránh tràn số (Integer Overflow) khi tính toán:

    - Giá trị $10^9 + 7$ vừa đủ nhỏ để khi bạn thực hiện phép nhân giữa hai số dư:
    
        $$\text{MOD} \times \text{MOD} \approx (10^9 + 7)^2 \approx 10^{18}$$


    - Giá trị $10^{18}$ vẫn nằm hoàn toàn trong giới hạn bộ nhớ của kiểu dữ liệu 64-bit (```long long``` trong C++ / Java, hoặc kiểu integer tự động mở rộng trong Python với giới hạn $\approx 9.22 \times 10^{18}$). Bạn sẽ không bao giờ lo bị trật kết quả do tràn số trung gian.


#### 2. Tại sao chọn $\text{BASE} = 31$?

- Là số nguyên tố lớn hơn kích thước bảng chữ cái: 

    - Bảng chữ cái tiếng Anh thường có 26 ký tự. Số nguyên tố nhỏ nhất lớn hơn 26 là 31.
    
    - Chọn cơ số lớn hơn dải ký tự đảm bảo mỗi chuỗi ký tự phân biệt có một đại diện duy nhất trước khi $\bmod$.

- Mối quan hệ "nguyên tố cùng nhau" (Coprime):

    - Cả $\text{BASE} = 31$ và $\text{MOD} = 10^9 + 7$ đều là số nguyên tố, nên chúng nghiễm nhiên nguyên tố cùng nhau ($\gcd(31, 10^9+7) = 1$). Điều này đảm bảo thuật toán nhân dồn theo quy tắc Ho1. Hãy nhìn cách ta đọc số $4352$ ở hệ thập phân (cơ số 10)Khi bạn nhìn số $4352$, máy tính hay não bạn tạo ra số này như thế nào nếu đi từ trái sang phải từng chữ số một?Bắt đầu từ số $0$.Gặp chữ số $4$: Lấy $0 \times 10 + 4 = \mathbf{4}$Gặp chữ số $3$: Lấy $4 \times 10 + 3 = \mathbf{43}$Gặp chữ số $5$: Lấy $43 \times 10 + 5 = \mathbf{435}$Gặp chữ số $2$: Lấy $435 \times 10 + 2 = \mathbf{4352}$Mỗi lần có chữ số mới, bạn lấy kết quả cũ nhân với 10 (để đẩy các chữ số cũ sang bên trái 1 hàng) rồi cộng chữ số mới vào.rner phủ đều tập giá trị Hash mà không bị rơi vào các chu kỳ lặp ngắn.


- Tối ưu phần cứng (Đặc tính máy tính):

    - $31$ có dạng $2^5 - 1$. Trình biên dịch (Compiler) có thể tối ưu phép nhân với 31 thành các phép dịch bit và phép trừ cực nhanh:

    $$x \times 31 = (x \ll 5) - x$$


#### Tóm lại

Sự kết hợp giữa $\text{BASE} = 31$ (số nguyên tố phủ đủ 26 chữ cái) và $\text{MOD} = 10^9 + 7$ (số nguyên tố lớn an toàn với kiểu dữ liệu 64-bit) tạo nên một cấu hình hoàn hảo giúp Rolling Hash hoạt động chính xác với xác suất va chạm cực kỳ thấp.


### 5. Hash chuỗi chữ cái cũng hệt như vậy!

Hãy quên hết các công thức phức tạp đi. Bạn hãy tưởng tượng thuật toán này đơn giản như cách chúng ta đọc một số có nhiều chữ số ở trường tiểu học.

#### 1. Hãy nhìn cách ta đọc số $4352$ ở hệ thập phân (cơ số 10)

Khi bạn nhìn số $4352$, máy tính hay não bạn tạo ra số này như thế nào nếu đi từ trái sang phải từng chữ số một?

- Bắt đầu từ số $0$.Gặp chữ số $4$: Lấy $0 \times 10 + 4 = \mathbf{4}$

- Gặp chữ số $3$: Lấy $4 \times 10 + 3 = \mathbf{43}$

- Gặp chữ số $5$: Lấy $43 \times 10 + 5 = \mathbf{435}$

- Gặp chữ số $2$: Lấy $435 \times 10 + 2 = \mathbf{4352}$

Mỗi lần có chữ số mới, bạn lấy kết quả cũ nhân với 10 (để đẩy các chữ số cũ sang bên trái 1 hàng) rồi cộng chữ số mới vào.


#### 2. Hash chuỗi chữ cái cũng hệt như vậy!


Thay vì dùng cơ số $10$, ta đổi sang dùng cơ số $\text{BASE} = 31$.

Thay vì dùng chữ số $0 \rightarrow 9$, ta đổi chữ cái thành số: 'a'=1, 'b'=2, ```'c'=3, 'o'=15, 'd'=4, 'e'=5.```

Bây giờ ta tính Hash cho chuỗi "code" đi từ trái sang phải y hệt như đọc số ở trên:

1. Bắt đầu: $\text{hash} = 0$

2. Đọc chữ ```'c'``` (giá trị 3):$$\text{hash} = 0 \times 31 + 3 = \mathbf{3}$$

3. Đọc chữ ```'o'``` (giá trị 15):Nhân 31 để đẩy chữ 'c' sang trái, rồi cộng 'o' vào:$$\text{hash} = 3 \times 31 + 15 = \mathbf{108}$$

4. Đọc chữ ```'d'``` (giá trị 4):Nhân 31 để đẩy 'c' và 'o' sang trái, rồi cộng 'd' vào:$$\text{hash} = 108 \times 31 + 4 = \mathbf{3352}$$

5. Đọc chữ ```'e'``` (giá trị 5):Nhân 31 để đẩy 'c', 'o', 'd' sang trái, rồi cộng 'e' vào:$$\text{hash} = 3352 \times 31 + 5 = \mathbf{103917}$$


### 6. Tại sao trong code lại có % MOD?

Vì nếu chuỗi dài $20$ hay $100$ ký tự, phép nhân $31$ liên tục sẽ tạo ra một số cực kỳ dài mà máy tính không chứa nổi (bị tràn bộ nhớ).Vì vậy, ở mỗi bước tính ra kết quả, ta chỉ cần làm thêm một việc: lấy phần dư cho $\text{MOD}$ ($10^9 + 7$) để ép số đó luôn nhỏ gọn, chui tọt vào vừa vặn bộ nhớ của máy tính.Java

