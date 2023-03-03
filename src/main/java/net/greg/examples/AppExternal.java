package net.greg.examples;

import java.util.*;

/**
 * Leverages External Iterative Logic
 */
public final class AppExternal {

	public static final String NC = "\u001B[0m";
	public static final String GRN = "\u001B[32m";

	/**
	 * Process External Iterative Logic
	 */
	public static final void process(String model) {

		// rejects nullity
	 final Map<Character, Integer> workArea =
			new HashMap();


		final char[] charArray = model.toCharArray();

		//snarky
   	final List<char[]> asList = Arrays.asList(charArray);

		// convert
   	final List<Character> charList = new ArrayList();
		for (char item : charArray) {

		 	charList.add(item);
 		}

		// populate
		for (Character key : charList) {

			if (workArea.keySet().contains(key)) {

				int value = workArea.get(key);
				workArea.put(key, ++value);
			}

			workArea.putIfAbsent(key, 1);
		}

		// transform/aggregate
		String answer = workArea.toString();

		answer = answer.replace("{", "");
		answer = answer.replace("}", "");
		answer = answer.replace(",", "");
		answer = answer.replace("=", "");

		System.err.println(
			"\n" + GRN + answer.replace(" ", "") + NC);
	}
}
