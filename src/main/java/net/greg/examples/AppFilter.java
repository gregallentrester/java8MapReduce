package net.greg.examples;

import java.io.*;

import java.util.*;
import java.util.concurrent.*;


/**
 * Leverages Linux-Filters Logic
 */
public final class AppFilter {

	public static final String NC = "\u001B[0m";
	public static final String GRN = "\u001B[32m";

	private static final String ROOT_RELATVE_PATH =
		System.getProperty("user.dir");

	private static final String BASH_FILTER = "/stats";

	/**
	 * Process Linux-Filters Logic
	 */
	public static final void process() {

		ProcessBuilder pb =
			new ProcessBuilder(
				ROOT_RELATVE_PATH + BASH_FILTER);

		try {

			Process process = pb.start();

			BufferedReader reader =
				new BufferedReader(
					new InputStreamReader(
						process.getInputStream()));

			StringBuilder builder = new StringBuilder();

			StringBuilder result = new StringBuilder();

			builder.append(reader.readLine());

			/*
			 * Use when file contains multiple lines
			 *
			 * String line = null;
		   * while (null != (line = reader.readLine())) {
		   *	builder.append(line);
		   *	}
       */

			// transform/aggregate
			String answer =
				builder.
					reverse().
						toString().
							replace(" ", "");

      final Stack<Character> stack = new Stack();

			char temp = ' ';
			char candidate = ' ';

		 	for (int i = 0; i < answer.length(); i++) {

			 	candidate = answer.charAt(i);

			 	if (Character.isDigit(candidate)) {

						stack.push(candidate);
						stack.push(temp);
				 }
				 else {
					 temp = candidate;
				 }
			 }

       for (int i = 0; i < answer.length(); i++) {

         result.append(stack.pop());
       }

			System.err.print("\n" + GRN + result + NC + "\n");
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
