import java.util.List;
import java.util.Random;

class Test4B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
        
    we.expectReturn("bag4 is (0 + 0 + 0 + 0 + 0) / 3 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(0, "M and M"),
                new Candy(0, "Snicker"),
                new Candy(0, "Strapsil"),
                new Candy(0, "Strapsil"),
                new Candy(0, "Strapsil")
            ))),
        (0 + 0 + 0 + 0 + 0) / 3);
        
    we.expectReturn("bag5 is (1) / 1 rounded down",
        () -> Task4.findAverage(Bag.of(List.of(
                new Candy(1, "M and M")
            ))),
        (1) / 1);
    
    Random rng = new Random();
    for (int i = 0; i < 5; i += 1) {
        int val = rng.nextInt(1, 200);
        we.expectReturn("if all equal amount, the average is equal",
            () -> Task4.findAverage(Bag.of(List.of(
                    new Candy(val, "M and M"),
                    new Candy(val, "M and M"),
                    new Candy(val, "M and M"),
                    new Candy(val, "M and M"),
                    new Candy(val, "M and M"),
                    new Candy(val, "M and M")
                ))),
            val);
    }
  }
}