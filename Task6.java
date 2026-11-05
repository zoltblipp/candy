import java.util.ArrayList;
import java.util.List;

/**
 * Task 6.
 */
public class Task6 {
  /**
   * TODO: Rewrite in functional-style.
   * 
   * @param bag The initial bag.
   * @return    Solution to Task 6.
   */
  public static List<Bag<Candy>> splitByAmount(Bag<Candy> bag) {
    return bag.getCandies().stream()
              .filter(candy -> !candy.isOpened())
              .map(candy -> candy.getAmount())
              .distinct()
              .map(amt -> bag.getCandies().stream()
                             .filter(candy -> !candy.isOpened())
                             .filter(candy -> candy.getAmount() == amt)
                             .toList())
              .map(list -> Bag.of(list))
              .toList();
  }
}
