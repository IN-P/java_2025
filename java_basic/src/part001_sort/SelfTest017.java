package part001_sort;

public class SelfTest017 {

	public static void main(String[] args) {
		int[][] arr = new int[4][5];
		for (int y=0,num=1;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=num++;
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
