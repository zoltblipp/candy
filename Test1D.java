class Test1D {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectCompile("Candy can be subclassed",
        "class SubCandy extends Candy { SubCandy() { super(1, \"\"); } }",
        true);
  }
}
