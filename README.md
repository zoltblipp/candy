# CS2030S AY24/25 Sem 1 PA2 (Candy Bag) — reconstructed skeleton

This is NOT the official skeleton. It was rebuilt from a solved copy of the
PA2 files: the test files, API notes and `cs2030s/fp` classes are original;
`Candy.java`, `Bag.java` and `Task3.java` to `Task7.java` were rewritten back
to an unsolved state using the TODO comments left in them.

What you start with:

- `Candy` is mutable: `open()` and `eat()` change the candy itself.
- `Bag` has no `map`; the reference signature in the comment does not compile.
- `Task3` to `Task6` work, but use loops and take `Bag<Candy>`.
- `Task7` returns `null`.

## Compiling

Until `Bag::map` exists, `Test2A.java` to `Test2D.java` will not compile, so
`javac *.java` fails. Compile only what you are working on, for example:

    javac -Xlint:unchecked -Xlint:rawtypes Candy.java Bag.java Task3.java Test3*.java CS2030STest.java
    java Test3A

Once Question 2 is done, `javac -Xlint:unchecked -Xlint:rawtypes *.java` works.

## Expected starting results

- Test1B, Test1C: some checks fail (Candy mutates itself).
- Test2*: do not compile.
- Test3* to Test6*: pass, but you still need to rewrite them in functional
  style (and widen the parameter in Tasks 3 to 5).
- Test7*: fail.
