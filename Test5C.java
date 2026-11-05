import java.util.List;

class Test5C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("correct empty",
        () -> Task5.split(Bag.of(List.of(
              new Candy(5, "M and M"),
              new Candy(1, "Snicker"),
              new Candy(2, "Skittle")
            ))).toString(),
        "[ ]");
        
    we.expectReturn("correct empty",
        () -> Task5.split(Bag.of(List.of(
              new Candy(0, "M and M").open().eat(),
              new Candy(0, "Snicker").open().eat(),
              new Candy(0, "Skittle").open().eat()
            ))).toString(),
        "[ ]");
        
    we.expectReturn("Works on empty bag",
        () -> Task5.split(Bag.of(List.of())).toString(),
        "[ ]");
  }
}