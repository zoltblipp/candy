import java.util.List;

class Test6C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("Partially empty result",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(7, "M and M").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M"),
              new Candy(7, "Strapsil").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open()
            ))).toString(),
        "[[ M and M {7} ]]");

    we.expectReturn("Partially empty result",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(7, "M and M").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil")
            ))).toString(),
        "[[ Strapsil {7} ]]");

    we.expectReturn("Partially empty result",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(7, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "M and M").open(),
              new Candy(7, "Strapsil").open()
            ))).toString(),
        "[[ Snicker {1} ]]");
  }
}