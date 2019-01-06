package pers.panqt.algorithm.sort;

/**
 *  @time       2019年01月06日	19:36
 *	@since      V0.1
 *	@author     panqt
 *	@comment    堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,6,2,0,3,4,8};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        long l1 = System.currentTimeMillis();
        // 获得大顶堆
        for (int i = (arr.length-1-1) / 2; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length);
        }

        // 进行n-1次循环，完成排序
        for (int i = arr.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(arr, 0, i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("堆排序时间："+(l2-l1));
    }

    //堆调整
    private static void HeapAdjust(int[] arr,int parent, int length){

        int temp = arr[parent]; // temp保存调整堆的根节点父节
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[child])
                break;

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        arr[parent] = temp;
    }
}
