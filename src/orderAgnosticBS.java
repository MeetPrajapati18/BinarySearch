public class orderAgnosticBS {

    public static void main(String[] args) {
        int [] nums = {-7, -5, -3, -2, -1, 0, 1, 4, 6, 8, 9, 12, 45, 46, 89, 100};
        int target = 46;
        int ans = orderAgnosticBs(nums, target);
        System.out.println(ans);
    }

    static int orderAgnosticBs(int [] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc =  arr[start] < arr[end];

        while (start < end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == target){
                return mid;
            }
            if (isAsc){
                if (target <  arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            } else{
                if (target > arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }
}
