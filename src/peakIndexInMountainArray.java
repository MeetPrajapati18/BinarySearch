//it is also known as Bi-tonic Array
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class peakIndexInMountainArray {
    public static void main(String[] args) {
        int[]arr = {0,1,2,3,4,5,3,2,1,0};//{0,1,2,1,0};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                /*
                 * you are in decreasing part of array
                 * this may be the answer but look at the left
                 * this is why end != mid - 1;
                 */
                end = mid;
            }
            else{
                /*
                 * you are in ascending part of array
                 * we know that mid + 1 > mid-element
                 */
                start = mid + 1;
            }
        }

        return start;
    }
}
