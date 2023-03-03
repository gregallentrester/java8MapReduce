package net.greg.examples;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * External Iterative Logic
 *
 * The method 'String.chars()' converts a String to a Stream, but it's an
 * Integer Stream, not a Character Stream.
 *
 * The method 'Stream.maptoObj()' converts an Integer to a Character.
 *
 * https://www.educative.io/edpresso/how-to-calculate-a-frequency-map-in-java-8p
 */
public final class AppInternal {

	public static final String NC = "\u001B[0m";
	public static final String GRN = "\u001B[32m";

  /**
	 * Implements Internal Iterative Logic
	 */
	public static final void process(String model) {

    Stream<Character> elements =
      model.
        chars().
          mapToObj(c -> (char) c);

		Map workarea = frequencyMap(elements);

		// transform/aggregate
		String answer = workarea.toString();

		answer = answer.replace("{", "");
		answer = answer.replace("}", "");
		answer = answer.replace(",", "");
		answer = answer.replace("=", "");

		System.err.println(
			"\n" + GRN + answer.replace(" ", "") + NC);
	}


  /**
	 * Helper
	 */
	public static Map<Character, Long> frequencyMap(Stream<Character> elements) {

		return
		  elements.
			  collect(
          Collectors.groupingBy(
            Function.identity(), Collectors.counting()));
	}
}
