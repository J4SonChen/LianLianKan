package realize;

/**
 * 棋子封装类
 * 
 * @author laixl
 * 
 */

public class Chess {

	// 图片的 状态 //1.....20
	// 0表示消掉
	private int row;
	private int column;
	private int status;

	public Chess(int row, int column, int status) {
		super();
		this.row = row;
		this.column = column;
		this.status = status;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}