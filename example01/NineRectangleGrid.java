/**
* 九宫格   
*/
public class NineRectangleGrid {
	public static void main(String[] args) {
		System.out.println("aaa");
		int[][] grid = new int[9][9];
		int[] test = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("test == " + isSafeArray(test, 4));
		solve(grid, 0, 0);
		printGrid(grid);

	}

	public static boolean solve(int[][] grid, int row, int column) {
		if ((row == 8) && (column == 9)) {
			return true;
		}
		if (column == 9) {
			column = 0;
			row ++;
		}
		if (grid[row][column] != 0) {
			return solve(grid, row, column + 1);	
		}
		for (int num = 1; num <= 9; num++) {
			if (isSafe(grid, row, column, num)) {
				grid[row][column] = num;
				if (solve(grid, row, column + 1)) {
					return true;	
				}
			}	
		}
		grid[row][column] = 0;
		return false;
	}

	/**
	* 判断某个数是否能够放置在数独中
	*/
	public static boolean isSafe(int[][] grid, int row, int column, int value) {
		return isRowSafe(grid, row, value) && isColumnSafe(grid, column, value) && isSmallMatrixSafe(grid, row, column, value);		
	}

	/**
	* 判断某个值能否放置在某行
	*/
	public static boolean isRowSafe(int[][] grid, int row, int value) {
		int[] rowArray = grid[row];
		return isSafeArray(rowArray, value);
	}

	/**
	* 判断某个值能否放置在某列
	*/
	public static boolean isColumnSafe(int[][] grid, int column, int value) {
		int[] columnArray = new int[9];
		for (int i =0; i < 9; i++) {
			columnArray[i] = grid[i][column];
		}
		return isSafeArray(columnArray, value);	
	}

	/**
	* 判断某个 3 * 3 小矩阵中能否放置某个数据
	*/
	public static boolean isSmallMatrixSafe(int[][] grid, int row, int column, int value) {
		int rowFirst = row / 3 * 3;
		int columnFirst = column / 3 * 3;
		int[] smallArray = new int[9];
		for (int i = rowFirst; i < rowFirst + 3; i++) {
			for (int j = columnFirst; j < columnFirst + 3; j ++) {
				smallArray[(i % 3) * 3 + j % 3] = grid[i][j] ; 
			}
		}
		return isSafeArray(smallArray, value);
	}

	/**
	* 打印九宫格数据
	*/
	public static void printGrid(int[][] grids) {
		for (int i =0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("-----------------------");			  
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");	
				}	
				System.out.print(grids[i][j] == 0 ? " " : grids[i][j]);
				System.out.print(" ");
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}

	/**
	* 判断某个数在一维数组中是否存在
	*/
	public static boolean isSafeArray(int[] array, int value) {
		int flag = (1 << 9) - 1;
		for(int i = 0; i < array.length; i++ ) {
			if (array[i] < 1) 
				continue;
			int tmp = 1 << (array[i] -1);
			if((flag & tmp) != 0) {
				flag &= ~tmp;	
			} else {
				return false;
			}
		}
		return (flag & (1 << (value -1))) != 0;	
	}
}
