/*
 * 1) find the pivot in the array.
 * pivot means where the particulate thing is being changed. (the largest number in the array).
 * 2) search in first half (0, pivot)
 * 3)otherwise search in 2nd half
 * case 1 : mid-element > mid + 1 element pivot = mid-element
 * case 2 : mid-element < mid - 1 element pivot = mid - 1
 * case 3 : start-element > mid-element => part (start to mid-1) > part (mid+1 to end)  || all element from mid will be smaller than start
 * So, if you are looking for pivot then ignore all number from mid to end in case 3.
 * case 4: start-element < mid-element
 * as the case number 3 in case no. 4 you can check numbers from mid to end if you are looking for pivot number.
 * if (mid < end && arr[mid] > arr[mid + 1]){
 *     return mid;
 * }
 * else if (mid > start && arr[mid] < arr[mid - 1]) {
 *     return mid - 1;
 * }
 */

public class rotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search(arr,target));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
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

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
