import java.util.Arrays;

public class MyHeap {
    private int MAX_SIZE = 5;
    private int[] arr = new int[MAX_SIZE + 1];
    private int size;

    public boolean isEmpty() {
        return size <= 0;
        // OR 
        // return size == 0;
    }

    public int peek() {
        if(isEmpty()) { 
            return -1;
        }
        return arr[1];
    }

    private void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void add(int num) {
        // 1: tăng kích thước mảng + thêm num vào cuối mảng
        size++;
        arr[size] = num;

        // 2: heapifyup
        int curIndex = size;
        int parentIndex= curIndex / 2;

        // chừng nào giá trị của cha còn lớn hơn con
        while(parentIndex != 0 && arr[parentIndex] > arr[curIndex]) {
            swap(parentIndex, curIndex);
            curIndex = parentIndex;
            parentIndex = curIndex / 2;
        }
    }

    private void heapifyDown(int i) { // heapifyDown từ vị trí i
        int smallestIndex = i;
        int leftChildIndex = 2 * smallestIndex;
        int rightChildIndex= 2 * smallestIndex + 1;

        if(leftChildIndex <= size && arr[leftChildIndex] < arr[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex <= size && arr[rightChildIndex] < arr[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if(smallestIndex != i) {
            swap(i, smallestIndex);
            heapifyDown(smallestIndex); // 🔥 tại sao tiếp tục ở đây?
        }

    }

    public int poll() {
        if(isEmpty()) {
            return  -1;
        }
        int min = arr[1];
        arr[1] = arr[size];
        size--;
        heapifyDown(1);
        return min;
    }

    public void remove(int num) {
        int curIndex = -1;
        for(int i = 0; i <= size; i++) {
            if(arr[i] == num) {
                curIndex = i;
                break;
            }
        }

        if(curIndex == -1) {
            return;
        }

        arr[curIndex] = arr[size];
        size--;
        heapifyDown(curIndex);
    }
    public static void main(String[] args) {
        MyHeap mh = new MyHeap();
        mh.add(5);
        mh.add(10);
        mh.add(15);
        mh.add(3);
        mh.add(2);
        System.out.println(Arrays.toString(mh.arr));
        mh.poll();
        // System.out.println(Arrays.toString(mh.arr));
        // System.out.println(mh.size);

        //Mảng chuẩn sau khi poll()
        System.out.println(Arrays.toString(Arrays.copyOfRange(mh.arr, 0, mh.size + 1)));

        mh.remove(15);
        System.out.println(Arrays.toString(Arrays.copyOfRange(mh.arr, 0, mh.size + 1)));


    }
}
