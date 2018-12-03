/*
 * ��������Ҫ��ע�㷨ʵ��
 * 
 * judge(x1,y1,x2,y2)����������4���������ж�9(x1,y1)��(x2,y2)�ܷ����� 
 * 
 * horizon(x1,y1,x2,y2)���ж�λ��ͬһ���ϵ��������ܷ�ͨ��ֱ������
 * vertical(x1,y1,x2,y2)���ж�λ��ͬһ���ϵ��������ܷ�ͨ��ֱ������
 * turnOnce(x1,y1,x2,y2)���ж��������ܷ�ͨ��һ�ι�������
 * turnTwice(x1,y1,x2,y2)���ж��������ܷ�ͨ�����ι�������
 * 
 */


package demo;

import java.lang.Math;

public class Main {

	int num_row = 3;
	int num_column = 6;

	int a[][] = { { 1, 0, 1, 2, 1, 2 }, { 2, 1, 0, 0, 0, 3 }, { 3, 0, 0, 2, 2, 2 } };

	int judge(int x1, int y1, int x2, int y2) {
		if (a[x1][y1] != a[x2][y2])
			return 0;
		if (x1 == x2) {
			if (horizon(x1, y1, x2, y2) == 1)
				return 1;
			else if (turnTwice(x1, y1, x2, y2) == 1)
				return 1;
			else
				return 0;
		}
		if (y1 == y2) {
			if (vertical(x1, y1, x2, y2) == 1)
				return 1;
			else if (turnTwice(x1, y1, x2, y2) == 1)
				return 1;
			else
				return 0;
		}
		if (turnOnce(x1, y1, x2, y2) == 1)
			return 1;
		if (turnTwice(x1, y1, x2, y2) == 1)
			return 1;
		return 0;
	}

	int getStatu(int x, int y) {
		return a[x][y];
	}

	int horizon(int x1, int y1, int x2, int y2) {

		System.out.println("horizon");
		System.out.print("(" + x1 + "," + y1 + ",s��" + a[x1][y1]);
		System.out.println(")��(" + x2 + "," + y2 + ",s��" + a[x2][y2] + ")");

		if (x1 == x2 && y1 == y2) {
			return 0;
		}

		if (x1 != x2) {
			return 0;
		}

		int start_y = Math.min(y1, y2);
		int end_y = Math.max(y1, y2);

		for (int j = start_y + 1; j < end_y; j++) {
			if (getStatu(x1, j) != 0) {
				return 0;
			}
		}

		return 1;
	}

	int vertical(int x1, int y1, int x2, int y2) {

		System.out.println("vertical");
		System.out.print("(" + x1 + "," + y1 + ",s��" + a[x1][y1]);
		System.out.println(")��(" + x2 + "," + y2 + ",s��" + a[x2][y2] + ")");

		if (x1 == x2 && y1 == y2) {
			return 0;
		}

		if (y1 != y2) {
			return 0;
		}

		int start_x = Math.min(x1, x2);
		int end_x = Math.max(x1, x2);

		for (int j = start_x + 1; j < end_x; j++) {
			if (getStatu(j, y1) != 0) {
				return 0;
			}
		}

		return 1;
	}

	int turnOnce(int x1, int y1, int x2, int y2) {

		System.out.println("turnOnce");
		System.out.print("(" + x1 + "," + y1 + ",s��" + a[x1][y1]);
		System.out.println(")��(" + x2 + "," + y2 + ",s��" + a[x2][y2] + ")");

		if (x1 == x2 && y1 == y2) {
			return 0;
		}

		int x3 = x1, y3 = y2;// �Ⱥ��������
		int x4 = x2, y4 = y1;// ����������

		if (getStatu(x3, y3) == 0) {
			if (horizon(x1, y1, x3, y3) == 1 && vertical(x3, y3, x2, y2) == 1)
				return 1;
		}

		if (getStatu(x4, y4) == 0) {
			if (vertical(x1, y1, x4, y4) == 1 && horizon(x4, y4, x2, y2) == 1)
				return 1;
		}
		return 0;
	}

	int turnTwice(int x1, int y1, int x2, int y2) {

		System.out.println("turnTwice");
		System.out.print("(" + x1 + "," + y1 + ",s��" + a[x1][y1]);
		System.out.println(")��(" + x2 + "," + y2 + ",s��" + a[x2][y2] + ")");

		if (x1 == x2 && y1 == y2) {
			return 0;
		}

		// ��������turnOnce
		System.out.println("����Ѱ��");
		for (int y = y1 - 1; y > -1; y--) {
			if (getStatu(x1, y) != 0)
				break;
			if (horizon(x1, y1, x1, y) == 1) {
				if (turnOnce(x1, y, x2, y2) == 1)
					return 1;
			} else
				break;
		}

		// ���Һ����turnOnce
		System.out.println("����Ѱ��");
		for (int y = y1 + 1; y < num_column; y++) {
			if (getStatu(x1, y) != 0)
				break;
			if (horizon(x1, y1, x1, y) == 1) {
				if (turnOnce(x1, y, x2, y2) == 1)
					return 1;
			} else
				break;
		}

		// ���������turnOnce
		System.out.println("����Ѱ��");
		for (int x = x1 - 1; x > -1; x--) {
			if (getStatu(x, y1) != 0)
				break;
			if (vertical(x1, y1, x, y1) == 1) {
				if (turnOnce(x, y1, x2, y2) == 1)
					return 1;
			} else
				break;
		}

		// ���������turnOnce
		System.out.println("����Ѱ��");
		for (int x = x1 + 1; x < num_row; x++) {
			if (getStatu(x, y1) != 0)
				break;
			if (vertical(x1, y1, x, y1) == 1) {
				if (turnOnce(x, y1, x2, y2) == 1)
					return 1;
			} else
				break;
		}

		return 0;
	}

	public static void main(String[] args) {
		Main m = new Main();

		System.out.println("result:" + m.judge(2, 3, 2, 4));
		System.out.println();
		System.out.println("result:" + m.judge(0, 5, 2, 5));
		System.out.println();
		System.out.println("result:" + m.judge(1, 3, 0, 4));
		System.out.println();
		System.out.println("result:" + m.judge(2, 0, 1, 5));
		System.out.println();
		System.out.println("result:" + m.judge(0, 5, 2, 3));
		System.out.println();
	}
}
