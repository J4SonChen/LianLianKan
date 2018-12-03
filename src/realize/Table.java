package realize;
import java.util.Random;

import java.lang.Math;
public class Table {
	
	private Chess[][] table;
	
	private int num_row;
	
	private int num_column;

	public Table(int[][] a, int num_row, int num_column) {
		this.table = new Chess[num_row][num_column];
		this.num_row = num_row;
		this.num_column = num_column;
		for(int i = 0;i<num_row;i++)
			for(int j = 0;j<num_column;j++) {

			}
	}
	
	
}
