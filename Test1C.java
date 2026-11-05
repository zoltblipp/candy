class Test1C {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    Candy close = new Candy(99, "M and M");
    Candy open = close.open();
    Candy reopen = open.open();
    Candy eat1 = open.eat();
    Candy eat2 = eat1.eat();
  
    we.expectReturn("`close` is unchanged",
        () -> close.toString(),
        "M and M {99}");
    we.expectReturn("`open` is opened but uneaten",
        () -> open.toString(),
        "M and M [99]");
    we.expectReturn("`reopen` == `open`",
        () -> reopen == open,
        true);
    we.expectReturn("`eat1` is opened and eaten once",
        () -> eat1.toString(),
        "M and M [98]");
    we.expectReturn("`eat2` is opened and eaten twice",
        () -> eat2.toString(),
        "M and M [97]");
  }
}
