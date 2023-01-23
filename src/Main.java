import javax.sql.rowset.serial.SerialArray;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    static void recurse(int[] parameter) {
        int arraySize = parameter.length;
        if (arraySize < 2) {
            return;
        }
        int[] nums1 = new int[arraySize/2];
        int[] nums2 = new int[arraySize - nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = parameter[i];
        }
        for (int i = nums2.length; i < parameter.length; i++) {
            nums2[i - nums2.length] = parameter[i];
        }
            recurse(nums1);
            recurse(nums2);
            merge(parameter, nums1, nums2);

        }


    static void merge(int[] inp, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inp[k] = left[i];
                i++;
            }
            else {
                inp[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inp[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inp[k] = right[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[100000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = RandomGenerator.getDefault().nextInt(100000000);
        }
//        System.out.println(Arrays.toString(nums));
        recurse(nums);
        System.out.println(Arrays.toString(nums));
    }
}