package shangguigu.d01_array;

/**
 * @Author: Patrick
 * @Date: 2023-03-09-15:24
 * @Description:   数组模拟环形 队列
 */
public class CircleArray {

    private int maxSize;

    private int front;
    private int rear;
    private int[] arr;
    private int hh;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {

        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        if (this.isEmpty()) {
            System.out.println("队列满，不能加入数据~");
            throw new RuntimeException(" is empty");
        } else {

            int hh = arr[front];
            front = (front + 1) % maxSize;
            return hh;
        }
    }


}
