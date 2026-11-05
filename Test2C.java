import java.util.List;

class Test2C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectCompile("Bag.of(List<SubCandy>) can return Bag<Candy>",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Bag<Candy> bag = Bag.of(java.util.List.of(" +
        "new SubCandy()));",
        true);
    we.expectCompile("Bag.of(List<SubCandy>) can return Bag<SubCandy>",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Bag<SubCandy> bag = Bag.of(java.util.List.of(" +
        "new SubCandy()));",
        true);
    we.expectCompile("Bag.of(List<Candy>) cannot return Bag<Object>",
        "Bag<Object> bag = Bag.of(java.util.List.of(" +
        "new Candy(1, \"Candy\")));",
        false);
  }
}
  