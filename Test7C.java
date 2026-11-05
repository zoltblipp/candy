import java.util.List;

class Test7C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil").open()
            ))).toString(),
        "[ Snicker {99} M and M [0] Strapsil {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil").open(),
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil").open()
            ))).toString(),
        "[ Snicker {99} M and M [0] Strapsil {2} Snicker {99} M and M [0] Strapsil {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open(),
              new Candy(2, "Strapsil").open(),
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M"),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil").open()
            ))).toString(),
        "[ Snicker {99} Strapsil {2} Snicker {99} M and M [0] M and M [0] Strapsil {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "Snicker").open(),
              new Candy(1, "M and M"),
              new Candy(2, "Strapsil").open(),
              new Candy(99, "Snicker"),
              new Candy(1, "M and M").open(),
              new Candy(2, "Strapsil")
            ))).toString(),
            "[ Snicker {99} M and M [0] Strapsil {2} Snicker [98] M and M {1} Strapsil [1] ]");
            
    we.expectReturn("Works with no candy",
        () -> Task7.taste(Bag.of(List.of())).toString(),
        "[ ]");
  }
}