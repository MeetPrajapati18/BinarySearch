public class BinarySearch {
    public static void main(String[] args) {
        int [] nums = {-7, -5, -3, -2, -1, 0, 1, 4, 6, 8, 9, 12, 45, 46, 89, 100};
        int target = 46;
        int ans = binarySearch(nums, target);
        System.out.println(ans);
    }

    static int binarySearch(int[]nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            //int mid = (start + end) / 2; // might be possible that stat + end exceed the range
            int mid = start + (end - start) / 2;

            if (target <  nums[mid]){
                end = mid - 1;
            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else if (target == nums[mid]){
                return mid;
            }
        }
        return -1;
    }
}
