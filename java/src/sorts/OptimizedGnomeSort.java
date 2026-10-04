package sorts;

import java.util.*;

/**
 * @author Flanlaina
 *
 */
public class OptimizedGnomeSort {

	/**
	 * Main array.
	 * 
	 */
	public static double[] array;

	public static long comps = 0;

	public static long swaps = 0;

	public static long writes = 0;

	public static int compare(double left, double right) {
		comps++;
		// use Double.compare to better handle the values
		return Double.compare(left, right);
	}

	public static int compareIndices(double[] array, int left, int right) {
		return compare(array[left], array[right]);
	}

	public static void swap(double[] array, int left, int right) {
		double temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		swaps++;
		writes += 2;
	}

    public static void smartGnomeSort(double[] array, int lowerBound, int upperBound) {
        int pos = upperBound;
        
        while(pos > lowerBound && compare(array[pos - 1], array[pos]) == 1) {
            swap(array, pos - 1, pos);
            pos--;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter the array size:");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.close();
		array = new double[len];
		for(int i = 0; i<len;i++) {
			array[i] = Math.random();
		}
		long start = System.nanoTime();
		for(int i = 1; i < len; i++) {
			smartGnomeSort(array, 0, i);
		}
		long time = System.nanoTime() - start;
		System.out.println("Comparisons:" + comps);
		System.out.println("Swaps:" + swaps);
		System.out.println("Writes:" + writes);
		System.out.println("Estimated real time: " + time/1000000.0 + "ms");

	}

}
