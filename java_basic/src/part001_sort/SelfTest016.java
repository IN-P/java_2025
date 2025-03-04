package part001_sort;

public class SelfTest016 {

	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		for (int y=0,num=100;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=num+x;
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
			num=200;
		}
	}

}
