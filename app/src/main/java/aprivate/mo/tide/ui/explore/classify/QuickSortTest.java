package aprivate.mo.tide.ui.explore.classify;

/**
 * Created by Mo on 2020/3/27
 */

public class QuickSortTest {

    static int[] i = {1,4,5,8,2,3,10};

    public static void main(String args[]) {
        test(i);
    }

    public static void test(int[] numbers) {
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }


    public static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = getMiddle(numbers, low, high);

        quickSort(numbers, low, middle - 1);
        quickSort(numbers, middle + 1, high);

    }


    public static int getMiddle(int numbers[], int low, int high) {
        //设第一个作为中轴
        int temp = numbers[low];

        while (low < high) {

            //大于中间值则位置不动
            while (numbers[high] > temp && high > low) {
                high--;
            }
            //否则交换至低半区
            numbers[low] = numbers[high];


            while (numbers[low] < temp && high > low) {
                low++;
            }
            numbers[high] = numbers[low];


        }


        numbers[low] = temp;

        return low;

    }

}
