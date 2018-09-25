package com.intv.number;

import java.util.ArrayList;
import java.util.List;

public class CommonNumberProblems {

  /**
   * Given a number n, print all primes smaller than or equal to n. It is also given that n is a
   * small number. For example, if n is 10, the output should be “2, 3, 5, 7”. If n is 20, the
   * output should be “2, 3, 5, 7, 11, 13, 17, 19”.
   *
   * @param n - upper limit
   * @return array of prime numbers till n
   */
  public List<Integer> sieveOfEratosthenes(final int n) {
    if (n < 0) {
      return null;
    }

    if (n == 0 || n == 1) {
      return null;
    }

    boolean[] isNotPrime = new boolean[n + 1];
    // iterate through the whole array starting at 2, as 0 and 1 are not prime numbers
    for (int i = 2; i * i <= n; i++) {
      if (!isNotPrime[i]) {
        for (int j = 2; j <= n; j++) {
          // mark all the elements which are multiplier of the base as not prime
          if (i * j <= n) {
            isNotPrime[i * j] = Boolean.TRUE;
          }
        }
      }
    }

    final List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (!isNotPrime[i]) {
        primes.add(i);
      }
    }

    return primes;
  }
}
