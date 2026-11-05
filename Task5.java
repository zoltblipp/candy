import java.util.ArrayList;
import java.util.List;

/**
 * Task 5.
 *
 * @author XXXX
 */
public class Task5 {
  /**
   * TODO: Make parameter more flexible.
   * TODO: Rewrite in functional-style.
   *
   * @param bag The initial bag.
   * @return    Solution to Task 5.
   */
  public static Bag<Candy> split(Bag<Candy> bag) {
    List<Candy> res = new ArrayList<>();
    for (Candy candy : bag.getCandies()) {
      if (candy.isOpened()) {
        for (int i = 0; i < candy.getAmount(); i += 1) {
          res.add(new Candy(1, candy.getName()).open());
        }
      }
    }
    return Bag.of(res);
  }
}
