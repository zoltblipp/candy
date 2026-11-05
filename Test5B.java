import java.util.List;

class Test5B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] " +
        "Skittle [1] Skittle [1] ]");

    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ Skittle [1] Skittle [1] ]");
  
    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle")
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] ]");


  
    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open(),
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] " +
        "Skittle [1] Skittle [1] " +
        "M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] " +
        "Skittle [1] Skittle [1] ]");

    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open(),
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ Skittle [1] Skittle [1] Skittle [1] Skittle [1] ]");
  
    we.expectReturn("Partial Open",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle"),
              new Candy(5, "M and M"),
              new Candy(1, "Snicker").open(),
              new Candy(2, "Skittle"),
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle").open()
            ))).toString(),
        "[ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] " +
        "Snicker [1] Skittle [1] Skittle [1] ]");
  }
}