/**
 * Task 4.
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
  public static int findAverage(Bag<? extends Candy> bag) {
    return bag.getCandies().stream()
              .map(candy -> candy.getAmount())
              .reduce(0, (acc,val) -> acc + val) /
           bag.getCandies().size();
  }
}
