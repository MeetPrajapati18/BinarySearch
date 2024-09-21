public class splitLargeSum {
    public static void main(String[] args) {
        int[]nums = {7,2,5,10,8};
        int k = 2;

        int ans = splitArray(nums,k);
        System.out.println(ans);
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // This will contain the max item from the array
            end += nums[i];
        }

        // Binary search
        while (start < end) {
            // Try for the middle as a potential answer
            int mid = start + (end - start) / 2;

            // Calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // You can't add this in this subArray, make a new one
                    // Say you add this in the new subArray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

}
