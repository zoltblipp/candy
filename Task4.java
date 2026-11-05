/**
 * Task 4.
 *
 * @author XXXX
 */
public class Task4 {
  /**
   * TODO: Make parameter more flexible.
   * TODO: Rewrite in functional-style.
   *
   * HINT: to list then array.
   *
   * @param bag The initial bag.
   * @return    Solution to Task 4.
   */
  public static int findAverage(Bag<Candy> bag) {
    int total = 0;
    int count = 0;
    for (Candy candy : bag.getCandies()) {
      total += candy.getAmount();
      count += 1;
    }
    return total / count;
  }
}
