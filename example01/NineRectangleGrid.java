/**
* 九宫格   
*/
public class NineRectangleGrid {
	public static void main(String[] args) {
		System.out.println("aaa");
		int[][] grid = new int[9][9];
		System.out.println("test == " + isRowSafe(grid, 1, 4));
	}

	/**
	* 判断某个值能否放置在某行
	*/
	public static boolean isRowSafe(int[][] grid, int row, int value) {
		int flag = 1 << 8 - 1;
		int[] rowArray = grid[row];
		for(int i = 0; i < rowArray.length; i++ ) {
			if (rowArray[i] < 1) 
				continue;
			int tmp = 1 << (rowArray[i] -1);
			if((flag & tmp) != 0) {
				flag &= ~tmp;	
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	* 判断某个值能否放置在某列
	*/
	private boolean isColumnSafe(int[][] grid, int column, int value) {
		return true;	
	}

	/**
	* 判断某个 3 * 3 小矩阵中能否放置某个数据
	*/
	private boolean isSmallMatrixSafe(int[][] grid, int row, int column, int value) {
		return true;
	}

	/**
	* 打印九宫格数据
	*/
	private void printGrid(int[][] grid) {
	
	}
}
