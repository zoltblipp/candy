import java.util.List;

class Test2B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectReturn("bag.map(candy -> candy.open()).map(candy -> candy.eat())",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                            new Candy(1, "Menthis"),
                            new Candy(2, "Strapsil")))
                 .map(candy -> ((Candy) candy).open())
                 .map(candy -> ((Candy) candy).eat()).toString(),
        "[ Kat Kit [4] Menthis [0] Strapsil [1] ]");
    we.expectReturn("bag.map(candy -> candy.open().eat())",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                            new Candy(1, "Menthis"),
                            new Candy(2, "Strapsil")))
                    .map(candy -> ((Candy) candy).open().eat()).toString(),
        "[ Kat Kit [4] Menthis [0] Strapsil [1] ]");
    we.expectReturn("bag.map(candy -> candy)",
        () -> Bag.of(List.of(new Candy(5, "Kat Kit"),
                            new Candy(1, "Menthis"),
                            new Candy(2, "Strapsil")))
                    .map(candy -> candy).toString(),
        "[ Kat Kit {5} Menthis {1} Strapsil {2} ]");
  }
}
  