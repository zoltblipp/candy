class Test1B {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    Candy candy1 = new Candy(1, "Permen");
    we.expectReturn("candy1.eat() == candy1",
        () -> candy1.eat() == candy1,
        true);

    Candy candy2 = candy1.open();
    we.expectReturn("candy2.open() == candy2",
        () -> candy2.open() == candy2,
        true);

    Candy candy3 = candy2.eat();    
    we.expectReturn("candy3.eat() == candy3",
        () -> candy3.eat() == candy3,
        true);
    
    we.expectReturn("candy1 != candy2",
        () -> candy1 != candy2,
        true);
    we.expectReturn("candy1 != candy3",
        () -> candy1 != candy3,
        true);
    we.expectReturn("candy2 != candy3",
        () -> candy2 != candy3,
        true);
  }
}
