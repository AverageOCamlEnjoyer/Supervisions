
public class ControlFlow {
	public static int sum(int[] a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		return total;
	}	
	public static int[] cumsum(int[] a) {
		int length = a.length;
		int total = 0;
		
		int[] result = new int[length];
		for (int i=0; i < (length-1); i++) {
			total += a[i];
			result[i] = total;
		}
		return result;
	}
	public static int[] positives(int[] a) {
		int length = 0;
		
		for (int i : a) {
			if (i > 0) {
				length += 1;
			}
		}
		int[] result = new int[length];
		int counter = 0;
		for (int i=0; i < (a.length); i++) {
			
			if (a[i] > 0) {
				result[counter] = a[i];
				counter += 1;
			}
		}
		return result;
	}
}
