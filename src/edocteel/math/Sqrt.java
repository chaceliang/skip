package edocteel.math;

public class Sqrt {
	
	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}
		long low = 1;
		long high = x;
		long mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
				break;
			}
			if (mid * mid > x) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return new Long(mid).intValue();
	}
	
	public double sqrt(double x) {
		if (x == 0 || x == 1) {
			return x;
		}
		double e = 0.0000000000001;
		double low, high;
		if (x < 1) {
			low = x;
			high = 1;
		} else {
			low = 1;
			high = x;
		}
		double mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (mid * mid - x <= e && (mid + 1) * (mid + 1) - x > e) {
				break;
			}
			if (mid * mid - x > e) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return mid;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
