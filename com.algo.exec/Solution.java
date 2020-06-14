
public class Solution {
    public boolean Find(int target, int[][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;
        // 行标
        int i = rowSize - 1;
        // 列标
        int j = 0;
        while (i >= 0 && j <= (colSize - 1)) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 5;
        int[][] array = {
                new int[]{1, 2, 8, 9},
                new int[]{2, 4, 9, 12},
                new int[]{4, 7, 10, 13},
                new int[]{6, 8, 11, 15}
        };
        Solution s = new Solution();
        System.out.println(s.Find(target, array));
    }
}