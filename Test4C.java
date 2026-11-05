class Test4C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    we.expectCompile("Can take Bag<Candy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Task4.findAverage(" +
        "Bag.<Candy>of(java.util.List.of(" +
        "new SubCandy(), new SubCandy())))",
        true);
    we.expectCompile("Can take Bag<SubCandy> containing SubCandy",
        "class SubCandy extends Candy { SubCandy() { super(0, \"\"); } } " +
        "Task4.findAverage(" +
        "Bag.<SubCandy>of(java.util.List.of(" +
        "new SubCandy(), new SubCandy())))",
        true);
  }
}