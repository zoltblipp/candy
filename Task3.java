import java.util.ArrayList;

/**
 * Task 3.
 */
public class Task3 {
  /**
   * TODO: Make parameter more flexible.
   * TODO: Rewrite in functional-style.
   * 
   * HINT: to list then array.
   * 
   * @param bag The initial bag.
   * @return    Solution to Task 3.
   */
  public static Bag<Candy> eatAllUnopened(Bag<? extends Candy> bag) {
    return Bag.of(bag.getCandies().stream()
                     .filter(candy -> !candy.isOpened())
                     .map(candy -> candy.open().eat())
                     .toList());
  }
}
