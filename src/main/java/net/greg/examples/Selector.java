package net.greg.examples;

import java.util.*;

public final class Selector {

  public static final String NC = "\u001B[0m";
	public static final String GRN = "\u001B[32m";

  private static final String EXTERNAL = "E";
  private static final String FILTER = "F";
  private static final String INTERNAL = "I";
  private static final String QUIT = "Q";
  private static final String PIPE = GRN + " | " + NC;

  private static final String UNIVERSE = "AABBBCCDDEAAA";

  private static String choice = "";


  /**
   * Selector
   */
  public static void main(String[] any) {


    while ( ! choice.startsWith(QUIT)) {

      System.err.println(
        "\n\n\n" + GRN +
        "Options" + NC +
        "\nExternal" + PIPE +
        "Filter" + PIPE +
        "Internal" + PIPE +
        "Quit\n" + NC);

      String choice =
        new Scanner(System.in).
          nextLine().toUpperCase();

      if (choice.startsWith(INTERNAL)) {
        AppInternal.process(UNIVERSE);
      }
      else if (choice.startsWith(EXTERNAL)) {
        AppExternal.process(UNIVERSE);
      }
      else if (choice.startsWith(FILTER)) {
        AppFilter.process();
      }
      else if (choice.startsWith(QUIT)) {
        System.exit(0);
      }
    }
  }
}
