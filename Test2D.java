import java.util.List;

class Test2D {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectCompile("Bag<SubCandy> res = bag.map(fn);",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "cs2030s.fp.Transformer<Candy, SubCandy> fn = candy -> new SubCandy(); " +
        "Bag<Candy> bag = Bag.of(java.util.List.of(" +
        "new Candy(1, \"Candy\"))); " +
        "Bag<SubCandy> res = bag.map(fn);",
        true);
    we.expectCompile("Bag<Candy> res = bag.map(fn);",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "cs2030s.fp.Transformer<Candy, SubCandy> fn = candy -> new SubCandy(); " +
        "Bag<Candy> bag = Bag.of(java.util.List.of(" +
        "new Candy(1, \"Candy\"))); " +
        "Bag<Candy> res = bag.map(fn);",
        true);
        
    we.expectCompile("Bag<Object> res = bag.map(fn);",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "cs2030s.fp.Transformer<Candy, SubCandy> fn = candy -> new SubCandy(); " +
        "Bag<Candy> bag = Bag.of(java.util.List.of(" +
        "new Candy(1, \"Candy\"))); " +
        "Bag<Object> res = bag.map(fn);",
        false);
  }
}
  