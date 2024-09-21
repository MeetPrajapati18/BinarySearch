import java.util.Arrays;

public class firstAndLastPosition {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,4,4,4,5,5,6,7,8,9,9,9,9,9};
        int target = 4;
        int [] ans = searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] ans = {-1,-1};
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    static int search(int[] nums, int target, boolean findIndex){
        int ans = -1;
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
            else {
                ans = mid;
                if (findIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
