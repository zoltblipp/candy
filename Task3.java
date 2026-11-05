import java.util.ArrayList;
import java.util.List;

/**
 * Task 3.
 *
 * @author XXXX
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
  public static Bag<Candy> eatAllUnopened(Bag<Candy> bag) {
    List<Candy> res = new ArrayList<>();
    for (Candy candy : bag.getCandies()) {
      if (!candy.isOpened()) {
        res.add(candy.open().eat());
      }
    }
    return Bag.of(res);
  }
}
