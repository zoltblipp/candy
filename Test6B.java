import java.util.List;

class Test6B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M"),
              new Candy(1, "M and M"),
              new Candy(1, "M and M")
            ))).toString(),
        "[[ M and M {1} M and M {1} M and M {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "Skittle"),
              new Candy(2, "Skittle"),
              new Candy(1, "Skittle")
            ))).toString(),
        "[[ Skittle {1} Skittle {1} ], [ Skittle {2} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "Snicker"),
              new Candy(2, "Snicker"),
              new Candy(1, "Snicker"),
              new Candy(1, "Snicker"),
              new Candy(4, "Snicker"),
              new Candy(1, "Snicker"),
              new Candy(1, "Snicker"),
              new Candy(3, "Snicker"),
              new Candy(1, "Snicker")
            ))).toString(),
        "[[ Snicker {1} Snicker {1} Snicker {1} Snicker {1} Snicker {1} Snicker {1} ], [ Snicker {2} ], [ Snicker {4} ], [ Snicker {3} ]]");

    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M").open(),
              new Candy(1, "M and M"),
              new Candy(1, "M and M")
            ))).toString(),
        "[[ M and M {1} M and M {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M"),
              new Candy(1, "M and M").open(),
              new Candy(1, "M and M")
            ))).toString(),
        "[[ M and M {1} M and M {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M"),
              new Candy(1, "M and M"),
              new Candy(1, "M and M").open()
            ))).toString(),
        "[[ M and M {1} M and M {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "Skittle").open(),
              new Candy(2, "Skittle"),
              new Candy(1, "Skittle")
            ))).toString(),
        "[[ Skittle {2} ], [ Skittle {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "Skittle"),
              new Candy(2, "Skittle").open(),
              new Candy(1, "Skittle")
            ))).toString(),
        "[[ Skittle {1} Skittle {1} ]]");
    we.expectReturn("Duplicate Candy",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "Skittle"),
              new Candy(2, "Skittle"),
              new Candy(1, "Skittle").open()
            ))).toString(),
        "[[ Skittle {1} ], [ Skittle {2} ]]");
  }
}