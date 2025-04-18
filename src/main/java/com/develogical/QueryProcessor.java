package com.develogical;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
              + "English poet, playwright, and actor, widely regarded as the greatest "
              + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("football")) {
      return "Football is a game";
    }

    if (query.toLowerCase().contains("name")) {
      return "football-66";
    }

    if (query.toLowerCase().contains("largest")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+")) // split by non-digits
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      String max = Collections.max(numbers).toString();

      return max;
    }

    if (query.toLowerCase().contains("plus")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+"))
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      int total = numbers.stream().mapToInt(Integer::intValue).sum();

      return String.valueOf(total);
    }

    if (query.toLowerCase().contains("multiplied")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+"))
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      int product = numbers.stream().reduce(1, (a, b) -> a * b);
      return String.valueOf(product);
    }

    if (query.toLowerCase().contains("cube")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+"))
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      for (int num : numbers) {
        double squareRoot = Math.sqrt(num);
        double cubeRoot = Math.cbrt(num);

        // Check if both the square root and cube root are integers
        if ((squareRoot == (int) squareRoot) && (cubeRoot == (int) cubeRoot)) {
          return String.valueOf(num);
        }

      }


    }

    if (query.toLowerCase().contains("minus")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+"))
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      //int total = numbers.stream().mapToInt(Integer::intValue).sum();

      int total = numbers.get(0);

      // Subtract all the subsequent numbers
      for (int i = 1; i < numbers.size(); i++) {
        total -= numbers.get(i);
      }

      return String.valueOf(total);
    }

    if (query.toLowerCase().contains("primes")) {
      List<Integer> numbers = Arrays.stream(query.split("\\D+"))
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());

      StringBuilder primes = new StringBuilder();
      for (int num : numbers) {
        if (isPrime(num)) {
          primes.append(num).append(", ");
        }
      }

      return primes.length() > 0 ? primes.toString().trim() : "No prime numbers found.";
    }

    return "";
  }

  public static boolean isPrime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
}
