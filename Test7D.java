import java.util.List;

class Test7D {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "C").open(),
              new Candy(1, "A"),
              new Candy(2, "B").open()
            ))).toString(),
        "[ C {99} A [0] B {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "C").open(),
              new Candy(1, "A"),
              new Candy(2, "B").open(),
              new Candy(99, "C").open(),
              new Candy(1, "A"),
              new Candy(2, "B").open()
            ))).toString(),
        "[ C {99} A [0] B {2} C {99} A [0] B {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "C").open(),
              new Candy(2, "B").open(),
              new Candy(99, "C").open(),
              new Candy(1, "A"),
              new Candy(1, "A"),
              new Candy(2, "B").open()
            ))).toString(),
        "[ C {99} B {2} C {99} A [0] A [0] B {2} ]");

    we.expectReturn("Mixed open/closed",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "C").open(),
              new Candy(1, "A"),
              new Candy(2, "B").open(),
              new Candy(99, "C"),
              new Candy(1, "A").open(),
              new Candy(2, "B")
            ))).toString(),
            "[ C {99} A [0] B {2} C [98] A {1} B [1] ]");

    we.expectReturn("All open",
        () -> Task7.taste(Bag.of(List.of(
              new Candy(99, "C").open(),
              new Candy(1, "A").open(),
              new Candy(2, "B").open()
            ))).toString(),
        "[ C {99} A {1} B {2} ]");
        
    we.expectReturn("Works with no candy",
        () -> Task7.taste(Bag.of(List.of())).toString(),
        "[ ]");
  }
}