import java.util.List;

class Test3A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("All candies in `bag` are opened and eaten after",
        () -> Task3.eatAllUnopened(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Skittle"),
              new Candy(2, "Snicker"),
              new Candy(5, "M and M"),
              new Candy(1, "Skittle"),
              new Candy(2, "Snicker"),
              new Candy(5, "M and M"),
              new Candy(1, "Skittle"),
              new Candy(2, "Snicker")
            ))).toString(),
        "[ M and M [4] Skittle [0] Snicker [1] M and M [4] Skittle [0] Snicker [1] M and M [4] Skittle [0] Snicker [1] ]");
        
    we.expectReturn("Only unopened candies are opened and eaten after",
        () -> Task3.eatAllUnopened(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker"),
              new Candy(5, "M and M"),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker"),
              new Candy(5, "M and M"),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker")
            ))).toString(),
        "[ M and M [4] Snicker [1] M and M [4] Snicker [1] M and M [4] Snicker [1] ]");
  
    we.expectReturn("All candies in `bag` are opened and eaten after",
        () -> Task3.eatAllUnopened(Bag.of(List.of(
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle"),
              new Candy(2, "Snicker").open(),
              new Candy(5, "M and M"),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker").open(),
              new Candy(5, "M and M").open(),
              new Candy(1, "Skittle").open(),
              new Candy(2, "Snicker")
            ))).toString(),
        "[ Skittle [0] M and M [4] Snicker [1] ]");
  }
}