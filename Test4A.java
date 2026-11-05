import java.util.List;

class Test4A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("bag1 is (5 + 1 + 2) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(5, "M and M"),
                new Candy(1, "Snicker"),
                new Candy(2, "Skittle")
            ))),
        (5 + 1 + 2) / 3);
        
    we.expectReturn("bag2 is (5 + 1 + 2) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(5, "M and M").open(),
                new Candy(1, "Snicker").open(),
                new Candy(2, "Strapsil").open()
            ))),
        (5 + 1 + 2) / 3);
  
    we.expectReturn("bag1 is (5 + 1 + 2) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(5, "M and M"),
                new Candy(1, "Snicker"),
                new Candy(2, "Skittle"),
                new Candy(10, "M and M"),
                new Candy(0, "Snicker"),
                new Candy(20, "Skittle"),
                new Candy(3, "M and M"),
                new Candy(8, "Snicker"),
                new Candy(7, "Skittle")
            ))),
        (5 + 1 + 2 + 10 + 0 + 20 + 3 + 8 + 7) / 9);
        
    we.expectReturn("bag2 is (5 + 1 + 2) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(5, "M and M").open(),
                new Candy(1, "Snicker").open(),
                new Candy(2, "Strapsil").open(),
                new Candy(10, "M and M").open(),
                new Candy(0, "Snicker").open(),
                new Candy(20, "Strapsil").open(),
                new Candy(3, "M and M").open(),
                new Candy(8, "Snicker").open(),
                new Candy(7, "Strapsil").open()
            ))),
        (5 + 1 + 2 + 10 + 0 + 20 + 3 + 8 + 7) / 9);
        
    we.expectReturn("bag3 is (4 + 0 + 1) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(5, "M and M").open().eat(),
                new Candy(1, "Snicker").open().eat(),
                new Candy(2, "Strapsil").open().eat(),
                new Candy(7, "M and M").open().eat(),
                new Candy(0, "Snicker").open().eat(),
                new Candy(3, "Strapsil").open().eat()
            ))),
        (4 + 0 + 1 + 6 + 0 + 2) / 6);
  }
}