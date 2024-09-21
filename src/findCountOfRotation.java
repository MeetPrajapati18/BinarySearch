public class findCountOfRotation {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        System.out.println("Array is rotated " + countRotations(arr) + " times.");
    }
    static int countRotations(int[]nums){
        int pivot = findPivot(nums);
        return pivot + 1;
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
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
