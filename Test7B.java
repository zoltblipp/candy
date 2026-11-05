import java.util.List;

class Test7B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("All closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker"),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil")
            ))).toString(),
        "[ Snicker [98] M and M [0] Strapsil [1] ]");

    we.expectReturn("All closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(0, "Snicker"),
              new Candy(0, "M and M"),
              new Candy(0, "Strapsil")
            ))).toString(),
        "[ Snicker [0] M and M [0] Strapsil [0] ]");

    we.expectReturn("Works with single closed candy",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker")
            ))).toString(),
        "[ Snicker [98] ]");
        
    we.expectReturn("Works with no candy",
        () -> Task7.taste(Bag.of(List.of())).toString(),
        "[ ]");
  }
}