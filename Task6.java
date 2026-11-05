import java.util.ArrayList;
import java.util.List;

/**
 * Task 6.
 *
 * @author XXXX
 */
public class Task6 {
  /**
   * TODO: Rewrite in functional-style.
   *
   * @param bag The initial bag.
   * @return    Solution to Task 6.
   */
  public static List<Bag<Candy>> splitByAmount(Bag<Candy> bag) {
    List<Integer> amounts = new ArrayList<>();
    for (Candy candy : bag.getCandies()) {
      if (!candy.isOpened() && !amounts.contains(candy.getAmount())) {
        amounts.add(candy.getAmount());
      }
    }

    List<Bag<Candy>> res = new ArrayList<>();
    for (int amount : amounts) {
      List<Candy> group = new ArrayList<>();
      for (Candy candy : bag.getCandies()) {
        if (!candy.isOpened() && candy.getAmount() == amount) {
          group.add(candy);
        }
      }
      res.add(Bag.of(group));
    }
    return res;
  }
}
