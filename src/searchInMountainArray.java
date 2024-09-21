public class searchInMountainArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int ans = search(arr,target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBs(arr,target,0,peak);
        if (firstTry != -1){
            return firstTry;
        }
        else {
            return orderAgnosticBs(arr,target,peak + 1, arr.length - 1);
        }
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

    static int orderAgnosticBs(int [] arr, int target, int start, int end){

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
/*
 * class Solution {
 *     public int findInMountainArray(int target, MountainArray mountainArr) {
 *             int p = peak(mountainArr);
 *             int ans=bs(target,mountainArr,0,p);
 *             if(ans!=-1){
 *                 System.gc();
 *                 return ans;
 *             }
 *             else{
 *                 System.gc();
 *                 return bs(target,mountainArr,p,mountainArr.length()-1);
 *             }
 *     }
 *       public  int bs(int target, MountainArray mountainArr, int l, int r){
 *             boolean asc=mountainArr.get(r)>mountainArr.get(l);
 *             while(l<=r){
 *                 int m = l+(r-l)/2;
 *                 if(mountainArr.get(m)==target){
 *                     return m;
 *                 }
 *                 else if(asc){
 *                     if(mountainArr.get(m)>target){
 *                         r=m-1;
 *                     }
 *                     else{
 *                         l=m+1;
 *                     }
 *                 }
 *                 else{
 *                     if(mountainArr.get(m)>target){
 *                         l=m+1;
 *                     }
 *                     else{
 *                         r=m-1;
 *                     }
 *                 }
 *             }
 *             System.gc();
 *             return -1;
 *         }
 *         public int peak(MountainArray mountainArr){
 *             int l = 0;
 *         int r = mountainArr.length()-1;
 *         while(l<r){
 *             int m  = l+(r-l)/2;
 *             if(mountainArr.get(m)>mountainArr.get(m+1)){
 *                 r=m;
 *             }
 *             else if(mountainArr.get(m)<mountainArr.get(m+1)){
 *                 l=m+1;
 *             }
 *         }
 *         System.gc();
 *         return l;
 *         }
 *     }
 */

/*
 * class Solution {
 *     public int findInMountainArray(int target, MountainArray mountainArr) {
 *         int peak = peakIndexInMountainArray(mountainArr);
 *         int firstTry = orderAgnosticBs(mountainArr, target, 0, peak);
 *         if (firstTry != -1) {
 *             return firstTry;
 *         } else {
 *             return orderAgnosticBs(mountainArr, target, peak + 1, mountainArr.length() - 1);
 *         }
 *     }
 *
 *     int peakIndexInMountainArray(MountainArray mountainArr) {
 *         int start = 0;
 *         int end = mountainArr.length() - 1;
 *
 *         while (start < end) {
 *             int mid = start + (end - start) / 2;
 *             if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
 *                 // you are in decreasing part of array
 *                 end = mid;
 *             } else {
 *                 // you are in ascending part of array
 *                 start = mid + 1;
 *             }
 *         }
 *
 *         return start; // start and end converge to the peak
 *     }
 *
 *     int orderAgnosticBs(MountainArray mountainArr, int target, int start, int end) {
 *         boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
 *
 *         while (start <= end) { // Changed condition to <=
 *             int mid = start + (end - start) / 2;
 *
 *             if (mountainArr.get(mid) == target) {
 *                 return mid;
 *             }
 *
 *             if (isAsc) {
 *                 if (target < mountainArr.get(mid)) {
 *                     end = mid - 1;
 *                 } else {
 *                     start = mid + 1;
 *                 }
 *             } else {
 *                 if (target > mountainArr.get(mid)) {
 *                     end = mid - 1;
 *                 } else {
 *                     start = mid + 1;
 *                 }
 *             }
 *         }
 *
 *         return -1; // Target not found
 *     }
 * }
 */
