import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Task 5.
 */
public class Task5 {
  /**
   * TODO: Make parameter more flexible.
   * TODO: Rewrite in functional-style.
   * 
   * @param bag The initial bag.
   * @return    Solution to Task 5.
   */
  public static Bag<Candy> split(Bag<? extends Candy> bag) {
    return Bag.of(bag.getCandies().stream()
                     .filter(candy -> candy.isOpened())
                     .flatMap(candy ->
                        Stream.generate(() ->
                                new Candy(1, candy.getName()).open())
                              .limit(candy.getAmount()))
                     .toList());
  }
}
