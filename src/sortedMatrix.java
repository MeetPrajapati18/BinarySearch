import java.util.Arrays;

public class sortedMatrix {
    public static void main(String[] args) {
        int [][] arr = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11}
        };
        System.out.println(Arrays.toString(search(arr,1)));
    }
    //search in the row provide between the cols provided
    static int[] binarySearch(int[][]matrix, int row, int colStart, int colEnd, int target){
        while (colStart <= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row,mid};
            }
            if (matrix[row][mid] < target){
                colStart = mid + 1;
            }else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int[][]matrix, int target){
        int row = matrix.length;
        int cols = matrix[0].length;

        if (row == 1){
            return binarySearch(matrix,0,0,cols -1, target);
        }

        //runt he loop till two rows are remaining
        int rowStart = 0;
        int rowEnd = row - 1;
        int colMid = cols / 2;

        while (rowStart < rowEnd-1){//while this is true it will have more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[mid][colMid] == target){
                return new int [] {mid,colMid};
            }
            if (matrix[mid][colMid] < target){
                rowStart = mid;
            }else {
                rowEnd = mid;
            }
        }
        //now we have 2 rows
        //check whether the target is in the column of 2 rows
        if (matrix[rowStart][colMid] == target){
            return new int[]{rowStart,colMid};
        }
        if (matrix[rowStart + 1][colMid] == target){
            return new int[]{rowStart + 1, colMid};
        }
        //search in 1st half
        if (target <= matrix[rowStart][colMid - 1]){
            return binarySearch(matrix,rowStart,0,colMid - 1,target);
        }
        //search in 2nd half
        if (target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols - 1]){
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }
        //search in 3rd half
        if (target <= matrix[rowStart + 1][colMid - 1]){
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        }
        //search in 4th half
        if (target >= matrix[rowStart + 1][colMid + 1]){
            return binarySearch(matrix, rowStart + 1, colMid + 1, cols -1, target);
        }
        return new int[]{-1,-1};
    }

}
