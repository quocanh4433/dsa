1. chọn k cần tìm

2. chọn pivot (vd: cuối mảng)

3. partition()
    
    - `<= pivot`: trái
    
    - `pivot`: vị trí pivot

    - `> pivot`: phải

    
4. so sánh pivot với k

    - `pivot == k`: index cần tìm

    - `pivot < k`: tăng left

    - `pivot > k`: giảm right