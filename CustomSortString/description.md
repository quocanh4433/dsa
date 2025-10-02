
# 791. Custom Sort String

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.


Yêu cầu:

Cho một chuỗi order và một chuỗi s. 

order là một hoán vị của các ký tự chữ cái tiếng Anh (có thể không chứa đầy đủ 26 chữ cái).

Bạn cần sắp xếp lại chuỗi s sao cho:

Các ký tự trong s sẽ xuất hiện theo đúng thứ tự trong order.

Nếu một ký tự không xuất hiện trong order, thì thứ tự của nó trong chuỗi kết quả có thể bất kỳ (nhưng vẫn giữ nguyên số lần xuất hiện).

Trả về: chuỗi s sau khi đã được sắp xếp theo quy tắc trên.
 




VD: order = "ab";    s = "baaj"    ->  result = "aabj". ✅ Đảm bảo 'a' trước 'b' theo order. 

Do 'j' không có trong order nên 'j' có thể ở bất kỳ đâu miễn là vẫn đảm bảo 'a' trước 'b' theo order 

->  result = "aabj"✅
-> result = "jaab" ✅
-> result = "aajb" ✅
-> result = "ajab" ✅
-> result = "abja" ❌ -> do 'a' không trước 'b'

