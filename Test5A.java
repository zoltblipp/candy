import java.util.List;

class Test5A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectReturn("Unique candies",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open()
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] ]");

    we.expectReturn("Unique candies",
        () -> Task5.split(Bag.of(List.of(
              new Candy(1, "Snicker").open()
            ))).toString(),
        "[ Snicker [1] ]");

    we.expectReturn("Unique candies",
        () -> Task5.split(Bag.of(List.of(
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ Skittle [1] Skittle [1] ]");

    we.expectReturn("Unique candies",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker").open(),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] " +
        "Snicker [1] Skittle [1] Skittle [1] ]");

    we.expectReturn("Non-unique candies",
        () -> Task5.split(Bag.of(List.of(
              new Candy(1, "Snicker").open(),
              new Candy(2, "Skittle").open(),
              new Candy(5, "Snicker").open()
            ))).toString(),
        "[ Snicker [1] Skittle [1] Skittle [1] " +
        "Snicker [1] Snicker [1] Snicker [1] Snicker [1] Snicker [1] ]");
  }
}