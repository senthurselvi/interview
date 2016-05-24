package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * Usecase to get the unique values Set always hold unique values. So it is
	 * simple to remove duplicates. Performance wise it is slower than hashMap
	 * 
	 * @return uniqueArray
	 * 
	 */
	private int[] uniqueValSetImplementation() {

		Set<Integer> uniqueSet = new HashSet<Integer>();
		if (randomIntegers != null) {
			System.out.println("input array length " + randomIntegers.length);
			for (int i : randomIntegers) {
				uniqueSet.add(i);
			}
			int[] uniqueArray = new int[uniqueSet.size()];
			int index = 0;
			for (Iterator<Integer> iterator = uniqueSet.iterator(); iterator.hasNext();) {
				Integer value = (Integer) iterator.next();
				uniqueArray[index++] = value;
			}
			return uniqueArray;
		}
		return randomIntegers;
	}

	/**
	 * Usecase to get the unique values. HashMap is faster than HashSet
	 * performance wise.
	 * 
	 * @return uniqueArray
	 */
	private int[] uniqueValMapImplementation() {
		Map<Integer, Integer> uniqueMap = new HashMap<Integer, Integer>();
		if (randomIntegers != null) {
			System.out.println("input array length " + randomIntegers.length);

			for (int i : randomIntegers) {
				if (!uniqueMap.containsKey(i)) {
					uniqueMap.put(i, 1);
				}
			}
			int[] uniqueArray = new int[uniqueMap.size()];

			int index = 0;
			final Set<Map.Entry<Integer, Integer>> entries = uniqueMap.entrySet();
			for (Map.Entry<Integer, Integer> entry : entries) {
				uniqueArray[index++] = entry.getKey();
			}
			return uniqueArray;
		}
		return randomIntegers;
	}

	/**
	 * Usecase to get the unique value maintaining the original order List is
	 * used to maintain the original order. contains()method of List has
	 * O(n)complexity so performance wise it is slower than hashmap.
	 * 
	 * @return uniqueArray
	 */
	private int[] uniqueValListImplementation() {
		List<Integer> uniqueList = new ArrayList<Integer>();
		if (randomIntegers != null) {
			System.out.println("input array length" + randomIntegers.length);

			for (int i : randomIntegers) {
				if (uniqueList.contains(i)) {
					continue;
				} else {
					uniqueList.add(i);
				}
			}
			int[] uniqueArray = new int[uniqueList.size()];
			int index = 0;
			for (Iterator<Integer> iterator = uniqueList.iterator(); iterator.hasNext();) {
				Integer value = (Integer) iterator.next();
				uniqueArray[index++] = value;
			}
			return uniqueArray;
		}
		return randomIntegers;
	}

	public static void main(String[] args) {

		DeDup nodup = new DeDup();
		int[] array = nodup.uniqueValSetImplementation();
		if (array != null) {
			System.out.println("Set implementation Unique numbers count " + array.length);
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
				System.out.print(",");
			}
			System.out.println();
		} else {
			System.out.println("The input array was null");
		}
		int[] array2 = nodup.uniqueValMapImplementation();
		if (array != null) {
			System.out.println("Map implementation Unique numbers count " + array2.length);

			for (int j = 0; j < array2.length; j++) {
				System.out.print(array2[j]);
				System.out.print(",");
			}
			System.out.println();
		} else {
			System.out.println("The input array was null");
		}
		int[] array3 = nodup.uniqueValListImplementation();
		if (array != null) {
			System.out
					.println("List implementation orginal order is maintained Unique numbers count  " + array3.length);

			for (int k = 0; k < array3.length; k++) {
				System.out.print(array3[k]);
				System.out.print(",");
			}
		} else {
			System.out.println("The input array was null");
		}

	}

}
