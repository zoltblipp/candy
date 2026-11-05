import cs2030s.fp.Transformer;
import java.util.Arrays;
import java.util.List;

/**
 * A representation of a bag of Candies.
 *
 * TODO: Make into functor.
 *
 * @author XXXX
 */
public class Bag<T extends Candy> {
  /** The candies in the bag. */
  private T[] candies;

  /**
   * Private constructor for Bag of candies.
   * NOTE: You are NOT allowed to change this.
   *
   * @param candies Candies inside the bag.
   */
  private Bag(T[] candies) {
    this.candies = candies;
  }

  /**
   * Factory method for Bag of candies.
   *
   * @param <T>     The type of candies.
   * @param candies The candies.
   * @return        A new Bag of candies.
   */
  public static <T extends Candy> Bag<T> of(List<T> candies) {
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) new Candy[0];
    return new Bag<>(candies.toArray(arr));
  }

  /**
   * Get the candies as list.
   *
   * @return The candies as list.
   */
  public List<T> getCandies() {
    return Arrays.asList(this.candies);
  }

  /*
   * TODO: Implement `map` for Bag.  The following
   *       method signature does not compile.  You
   *       need to make it more flexible and no
   *       rawtypes.  It is given only as reference.
   *
   * HINT: Create another array.
   *
   * NOTE: You can solve the rest of the problems
   *       without using `map` but it may be more
   *       complicated.
   *
   * public <R> Bag<R> map(Transformer<T, R> fn) {
   *   ...
   * }
   */

  /**
   * A String representation of a Bag of candies.
   *
   * @return The String representation of a Bag of candies.
   */
  @Override
  public String toString() {
    String res = "[ ";
    for (int i = 0; i < this.candies.length; i += 1) {
      res += this.candies[i] + " ";
    }
    return res + "]";
  }

  /**
   * Checking if two Bag candies are equal.  Two Bags are
   * equal if they have equal candies at each position based
   * on the Candy::equals method.
   *
   * @param obj The other Bag to be compared.
   * @return    True of the two Bags are equal.
   *            Return false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Bag<?>) {
      Bag<?> bag = (Bag<?>) obj;

      if (this.candies.length != bag.candies.length) {
        return false;
      }
      for (int i = 0; i < this.candies.length; i += 1) {
        if (!this.candies[i].equals(bag.candies[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
