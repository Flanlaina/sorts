package sort2;
import java.util.*;

/**
 * @author Flanlaina
 *
 */
public class BubbleSort {
	
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
		//use Double.compare to better handle the values
        int cmpVal = Double.compare(left, right);
		return cmpVal;
	}
	
	public static int compareIndices(double[] array, int left, int right) {
        return compare(array[left], array[right]);
	}
	
	public static void swap(double[] array, int left, int right) {
		double temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		swaps++;
		writes+=2;
	}
	
	public static void shuffle(double[] array, int start, int end) {
		Random random = new Random();
		for(int i = start; i < end; i++){
			int randomIndex = random.nextInt(end - i) + i;
            swap(array, i, randomIndex);
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
		shuffle(array,0,len);
		swaps = 0;
		writes = 0;
		for(int i = len - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(compareIndices(array, j, j + 1) == 1) {
					swap(array, j, j + 1);
				}
			}
		}
		System.out.println("Comparisons:" + comps);
		System.out.println("Swaps:" + swaps);
		System.out.println("Writes:" + writes);

	}

}
