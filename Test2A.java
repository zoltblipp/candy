import java.util.List;

class Test2A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectCompile("Bag has private constructor",
        "new Bag<Candy>(new Candy[] { new Candy(5, \"Kat Kit\") });",
        false);
    
    we.expectReturn("bag.map(candy -> candy.open())",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                             new Candy(1, "Menthis"),
                             new Candy(2, "Strapsil")))
                  .map(candy -> ((Candy) candy).open()).toString(),
        "[ Kat Kit [5] Menthis [1] Strapsil [2] ]");
    we.expectReturn("bag.map(candy -> candy.eat())",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                             new Candy(1, "Menthis"),
                             new Candy(2, "Strapsil")))
                 .map(candy -> ((Candy) candy).eat()).toString(),
        "[ Kat Kit {5} Menthis {1} Strapsil {2} ]");
    we.expectReturn("bag.map(candy -> new Candy(candy.getAmount() / 2, candy.getName() + \"0\"))",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                            new Candy(1, "Menthis"),
                            new Candy(2, "Strapsil")))
                 .map(candy -> new Candy(
                        ((Candy) candy).getAmount() / 2,
                        ((Candy) candy).getName() + "0")).toString(),
        "[ Kat Kit0 {2} Menthis0 {0} Strapsil0 {1} ]");
  }
}
  