import java.util.List;

class Test6D {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectReturn("Empty result",
        () -> Task6.splitByAmount(Bag.of(List.of(
              new Candy(7, "M and M").open(),
              new Candy(1, "Snicker").open(),
              new Candy(7, "Strapsil").open()
            ))).toString(),
        "[]");

    we.expectReturn("Empty result",
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
              new Candy(7, "Strapsil").open()
            ))).toString(),
        "[]");
        
    we.expectReturn("Works with no candy",
        () -> Task6.splitByAmount(Bag.of(List.of())).toString(),
        "[]");
  }
}