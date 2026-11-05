/**
 * A Representation of a Candy.
 * 
 * TODO: Make immutable.
 * NOTE: Do NOT make the class final.
 */
public class Candy {
  /** The amount of Candy. */
  private int amount;

  /** The kind of Candy. */
  private String kind;

  /** A flag if the Candy is opened or not. */
  private boolean opened;

  /**
   * Constructor for Candy.
   * 
   * @param amount The amount of Candy.
   * @param kind   The kind of Candy.
   */
  public Candy(int amount, String kind) {
    this.amount = amount;
    this.kind = kind;
    this.opened = false;
  }

  /**
   * Get the amount of Candy.
   * 
   * @return The amount of Candy.
   */
  public int getAmount() {
    return this.amount;
  }

  /**
   * Get the kind of Candy.
   * 
   * @return The kind of Candy.
   */
  public String getName() {
    return this.kind;
  }

  /**
   * Check if the Candy is opened or not.
   * 
   * @return True if the Candy is opened,
   *         false otherwise.
   */
  public boolean isOpened() {
    return this.opened;
  }

  /**
   * Eat one Candy if it is opened.
   * 
   * @return A Candy with amount subtracted by one
   *         if the Candy is opened.  Otherwise,
   *         return the Candy unchanged.
   */
  public Candy eat() {
    if (this.opened && this.amount > 0) {
      Candy candy = new Candy(this.amount - 1, this.kind);
      candy.opened = this.opened;
      return candy;
    }
    return this;
  }

  /**
   * Open the Candy.  Does not matter if the
   * Candy is already opened.
   * 
   * @return An opened Candy.
   */
  public Candy open() {
    if (this.opened) {
      return this;
    }
    Candy candy = new Candy(this.amount, this.kind);
    candy.opened = true;
    return candy;
  }

  /**
   * Return a String representation of Candy.
   * 
   * @return A String representation of a Candy.
   */
  @Override
  public String toString() {
    if (this.opened) {
      return this.kind + " [" + this.amount + "]";
    } else {
      return this.kind + " {" + this.amount + "}";
    }
  }

  /**
   * Check if two Candies are equal.  Two Candies
   * are equal if they are the same kind regardless
   * of the amount or if the Candy is opened.
   * 
   * @param obj The other Candy to be compared.
   * @return    True of the two Candies are equal.
   *            Return false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Candy) {
      Candy candy = (Candy) obj;
      return this.kind.equals(candy.kind);
    }
    return false;
  }
}
