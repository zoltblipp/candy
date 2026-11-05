import java.util.List;

class Test3C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectCompile("Can take Bag<Candy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Task3.eatAllUnopened(" +
        "Bag.<Candy>of(java.util.List.of(" +
        "new SubCandy(), new SubCandy())))",
        true);
    we.expectCompile("Can take Bag<SubCandy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Task3.eatAllUnopened(" +
        "Bag.<SubCandy>of(java.util.List.of(" +
        "new SubCandy(), new SubCandy())))",
        true);

    we.expectCompile("Can return Bag<Candy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Bag<Candy> sub3 = Task3.eatAllUnopened(Bag.of(" +
        "java.util.List.of(" +
        "new SubCandy(), new SubCandy())));",
        true);

    we.expectCompile("No need to return Bag<SubCandy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Bag<SubCandy> sub4 = Task3.eatAllUnopened(Bag.of(" +
        "java.util.List.of(" +
        "new SubCandy(), new SubCandy())));",
        false);
  }
}