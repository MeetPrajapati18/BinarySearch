import javax.swing.*;

public class RBSWithDuplicates {
    public static void main(String[] args) {
        int [] arr = {5,9,2,2,3,3,4,4,4,4};
        int target = 4;
        System.out.println(search(arr,target));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else if (nums[pivot] == target) {
            return pivot;
        }
        if (nums[0] <= target) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] == nums[start] && nums[mid] == nums[end]){
                //Note : wht if start or end is pivot....so first check are those numbers are pivot or not
                if (nums[start] > nums[start + 1]){
                    return start;
                }
                start++;

                if (nums[end] < nums[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //if left side is sorted then pivot should be in right
            else if (nums[start] < nums[mid] || (nums[mid] > nums[end] && nums[start] == nums[mid])) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
