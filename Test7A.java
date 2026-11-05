import java.util.List;

class Test7A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("All open",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M").open(),
              new Candy(2, "Strapsil").open()
            ))).toString(),
        "[ Snicker {99} M and M {1} Strapsil {2} ]");
        
    we.expectReturn("All open",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(0, "Snicker").open(),
              new Candy(0, "M and M").open(),
              new Candy(0, "Strapsil").open()
            ))).toString(),
        "[ Snicker {0} M and M {0} Strapsil {0} ]");

    we.expectReturn("All open",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open()
            ))).toString(),
        "[ Snicker {99} ]");
        
    we.expectReturn("Works with no candy",
        () -> Task7.taste(Bag.of(List.of())).toString(),
        "[ ]");
  }
}