public class positionOfElementInInfiniteArray {
    public static void main(String[] args) {


    }

    static int binarySearch(int[]nums, int target, int start, int end){
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
