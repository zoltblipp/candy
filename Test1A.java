class Test1A {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
  
    we.expectReturn("new Candy(99, \"M and M\") creates new candy",
        () -> new Candy(99, "M and M").toString(),
        "M and M {99}");
    we.expectReturn("new Candy(99, \"M and M\").getAmount()",
        () -> new Candy(99, "M and M").getAmount(),
        99);
    we.expectReturn("new Candy(99, \"M and M\").getName()",
        () -> new Candy(99, "M and M").getName(),
        "M and M");
    we.expectReturn("new Candy(99, \"M and M\").isOpened()",
        () -> new Candy(99, "M and M").isOpened(),
        false);
  
    we.expectReturn("new Candy(99, \"M and M\").eat() does not affect candy",
        () -> new Candy(99, "M and M").eat().toString(),
        "M and M {99}");
    we.expectReturn("new Candy(99, \"M and M\").eat().getAmount()",
        () -> new Candy(99, "M and M").eat().getAmount(),
        99);
    we.expectReturn("new Candy(99, \"M and M\").eat().getName()",
        () -> new Candy(99, "M and M").eat().getName(),
        "M and M");
    we.expectReturn("new Candy(99, \"M and M\").eat().isOpened()",
        () -> new Candy(99, "M and M").eat().isOpened(),
        false);
  
    we.expectReturn("new Candy(99, \"M and M\").open().eat() does affect candy",
        () -> new Candy(99, "M and M").open().eat().toString(),
        "M and M [98]");
    we.expectReturn("new Candy(99, \"M and M\").open().eat().getAmount()",
        () -> new Candy(99, "M and M").open().eat().getAmount(),
        98);
    we.expectReturn("new Candy(99, \"M and M\").open().eat().getName()",
        () -> new Candy(99, "M and M").open().eat().getName(),
        "M and M");
    we.expectReturn("new Candy(99, \"M and M\").open().eat().isOpened()",
        () -> new Candy(99, "M and M").open().eat().isOpened(),
        true);

    we.expectReturn("new Candy(1, \"M and M\").open().eat().eat().getAmount()",
        () -> new Candy(1, "M and M").open().eat().eat().getAmount(),
        0);
  }
}
