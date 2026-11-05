import java.util.List;

class Test6A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectReturn("distinct amounts",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Strapsil")
            ))).toString(),
        "[[ M and M {5} ], [ Snicker {1} ], [ Strapsil {2} ]]");
    we.expectReturn("distinct amounts",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(50, "M and M"),
              new Candy(10, "Snicker"),
              new Candy(20, "Strapsil")
            ))).toString(),
        "[[ M and M {50} ], [ Snicker {10} ], [ Strapsil {20} ]]");
    
    we.expectReturn("Non distinct amount",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(1, "Strapsil")
            ))).toString(),
        "[[ M and M {1} Snicker {1} Strapsil {1} ]]");
    we.expectReturn("Non distinct amount",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(99, "M and M"),
              new Candy(99, "Snicker"),
              new Candy(99, "Strapsil")
            ))).toString(),
        "[[ M and M {99} Snicker {99} Strapsil {99} ]]");

    we.expectReturn("Non distinct amount",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(1, "M and M"),
              new Candy(99, "Snicker"),
              new Candy(1, "Strapsil"),
              new Candy(99, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(99, "Strapsil")
            ))).toString(),
        "[[ M and M {1} Strapsil {1} Snicker {1} ], [ Snicker {99} M and M {99} Strapsil {99} ]]");

    we.expectReturn("Non distinct amount",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(100, "M and M"),
              new Candy(99, "Snicker"),
              new Candy(100, "Strapsil"),
              new Candy(99, "M and M"),
              new Candy(100, "Snicker"),
              new Candy(99, "Strapsil")
            ))).toString(),
        "[[ M and M {100} Strapsil {100} Snicker {100} ], [ Snicker {99} M and M {99} Strapsil {99} ]]");

    we.expectReturn("Non distinct amount",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(0, "M and M"),
              new Candy(2, "Snicker"),
              new Candy(1, "Strapsil"),
              new Candy(1, "M and M"),
              new Candy(0, "Snicker"),
              new Candy(2, "Strapsil")
            ))).toString(),
        "[[ M and M {0} Snicker {0} ], [ Snicker {2} Strapsil {2} ], [ Strapsil {1} M and M {1} ]]");
  }
}