package sorts;

import java.util.Scanner;

public class InsertionSort {

	public static int compare(double left, double right) {
		// use Double.compare to better handle the values
		return Double.compare(left, right);
	}

	public static void insertionSort(double[] arr, int start, int end) {
		for (int i = start + 1; i < end; i++) {
			int j = i; double t = arr[i];
			while (j > start && compare(t, arr[j - 1]) < 0) {
				arr[j] = arr[j - 1];
				j--;
			}
			if (j < i) arr[j] = t;
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the array size:");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.close();
		double[] array = new double[len];
		for(int i = 0; i<len;i++) {
			array[i] = Math.random();
		}
		long start = System.nanoTime();
		insertionSort(array, 0, len);
		long time = System.nanoTime() - start;
		System.out.println("Estimated real time: " + time/1000000.0 + "ms");

	}

}
