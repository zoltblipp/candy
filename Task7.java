import cs2030s.fp.Maybe;

/**
 * Task 7.
 */
public class Task7 {
  /**
   * TODO: Implement in functional-style.
   * 
   * @param bag The initial bag.
   * @return    Solution to Task 7.
   */
  public static Bag<Candy> taste(Bag<Candy> bag) {
    return Bag.of(bag.getCandies().stream()
                     .map(candy ->
                          Maybe.of(candy)
                               .filter(cdy -> cdy.isOpened())
                               .map(cdy ->
                                  new Candy(cdy.getAmount(), cdy.getName()))
                               .orElse(() -> candy.open().eat())
                        )
                     .toList());
  }
}
