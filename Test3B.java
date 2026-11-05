import java.util.List;

class Test3B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("All opened result in empty bag",
        () -> Task3.eatAllUnopened(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker").open()
            ))).toString(),
        "[ ]");
    we.expectReturn("All opened result in empty bag",
        () -> Task3.eatAllUnopened(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker").open(),
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker").open(),
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker").open()
            ))).toString(),
        "[ ]");

    we.expectReturn("Works with empty bag",
        () -> Task3.eatAllUnopened(Bag.of(List.of())).toString(),
        "[ ]");
  }
}