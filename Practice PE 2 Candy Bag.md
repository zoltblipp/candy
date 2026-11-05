# Practice PE 2: Candy Bag

Nov 5, 2026 · @Chan Darrel

CS2030S Programming Methodology II

NATIONAL UNIVERSITY OF SINGAPORE SCHOOL OF COMPUTING

Reconstructed from the AY2024/25 Semester 1 PA2 test files Time Allowed: 120 minutes

---

## INSTRUCTIONS TO CANDIDATES

1. Marks for each question are indicated below. The original marks are unknown, so these are suggested weights for self-marking (40 in total). We may deduct marks for style violations and design issues.
2. This is a CLOSED-BOOK assessment. You are only allowed to refer to one (1) double-sided A4-size paper.
3. Only `Candy.java`, `Bag.java` and `Task3.java` to `Task7.java` will be graded.
4. Skeletons are provided for you. You may add new files if you need to.
5. Write your student number on top of EVERY FILE you created or edited as part of the `@author` tag. Do not write your name.
6. You are not allowed to add any `import` statement unless otherwise specified.
7. To compile your code, run:

```shell
javac -Xlint:unchecked -Xlint:rawtypes *.java
```

IMPORTANT: Any code you wrote that cannot be compiled may result in 0 marks being given for the question(s) that depend on it. Make sure your program compiles before submission.

---

## Preliminary

Ensure that the following files are present in your home directory:

- `Candy.java`
- `Bag.java`
- `Task3.java`, `Task4.java`, `Task5.java`, `Task6.java`, `Task7.java`
- `CS2030STest.java`
- `Test1A.java` to `Test7D.java` (test files for every question)

Ensure that the following directory is also present:

- `cs2030s/fp`

**You may add new files as needed.**

---

## Provided Classes

The `cs2030s.fp` package has been provided for you. The package contains the following classes and interfaces.

- `BooleanCondition<T>`
- `Combiner<S, T, R>`
- `Consumer<T>`
- `Lazy<T>`
- `Maybe<T>`
- `Producer<T>`
- `Transformer<T, R>`

The abridged APIs are available in `MaybeAPI.md`, `ListAPI.md` and `StreamAPI.md`.

## Constraints

If **functional style** is needed (Questions 3 to 7), your code must conform to our functional style. Any attempt at circumventing this restriction will invalidate the entire submission.

You are not allowed to do any of the following. This list follows the usual CS2030S functional-style rules, since the original wording is unknown, and is not meant to be complete.

- You are not allowed to modify the method name or return type of any given method. You may only widen a parameter type where the question says so.
- You are not allowed to use loops (`for`, `while`, `do-while`).
- You are not allowed to use conditional statements or expressions. This includes the ternary operator `?:`.
- You are not allowed to use block-statement in lambda (e.g., `() -> { .. }`).
- You are not allowed to add new methods except those stated in the question.
- You are not allowed to add new classes.
- You are not allowed to add import.
- You are not allowed to use raw types.
- You are not allowed to use `Optional`.
- You are not allowed to change the `Bag` constructor, or make `Candy` final.

---

## Question 1 \[5 marks\]

Rewrite the Java class named `Candy` in `Candy.java`. Some code is already given; you may modify it but you are not allowed to add additional fields or public methods not mentioned below.

- The class is an **immutable** class.
- The class must NOT be `final`; it must still be possible to subclass `Candy`.
- The class has three fields.
  - `amount` of type `int`.
  - `kind` of type `String`.
  - `opened` of type `boolean`.
- The class has a public constructor that takes in 2 parameters, `amount` of type `int` and `kind` of type `String`. A new candy is unopened.
- The class has 3 accessors.
  - `Candy::getAmount` that returns `amount`.
  - `Candy::getName` that returns `kind`.
  - `Candy::isOpened` that returns `opened`.
- Re-implement the following methods to satisfy immutability.
  - `Candy::open` returns an opened candy with the same amount and kind. If the candy is already opened, it returns the same object.
  - `Candy::eat` returns an opened candy with one less, if the candy is opened and its amount is above 0. Otherwise it returns the same object.
- `Candy::toString` prints `kind {amount}` when unopened and `kind [amount]` when opened.
- `Candy::equals` compares the kind only, ignoring amount and opened state.

### Sample Run

```text
jshell> Candy close = new Candy(99, "M and M")
close ==> M and M {99}
jshell> close.getAmount()
$.. ==> 99
jshell> close.getName()
$.. ==> "M and M"
jshell> close.isOpened()
$.. ==> false

jshell> close.eat()
$.. ==> M and M {99}
jshell> close.eat() == close
$.. ==> true

jshell> Candy open = close.open()
open ==> M and M [99]
jshell> open.open() == open
$.. ==> true
jshell> Candy eat1 = open.eat()
eat1 ==> M and M [98]
jshell> Candy eat2 = eat1.eat()
eat2 ==> M and M [97]

jshell> close
close ==> M and M {99}
jshell> open
open ==> M and M [99]

jshell> new Candy(1, "M and M").open().eat().eat().getAmount()
$.. ==> 0
jshell> class SubCandy extends Candy { SubCandy() { super(1, ""); } }
|  created class SubCandy
```

You are encouraged to test your code in jshell first. You can run the tests for Question 1 as follows:

```shell
java Test1A
java Test1B
java Test1C
java Test1D
```

---

## Question 2 \[8 marks\]

Make the Java class `Bag<T extends Candy>` in `Bag.java` into a functor. Some code is already given; you may modify it but you are not allowed to add additional fields or methods not mentioned below.

- The class has one field, `candies` of type `T[]`.
- The class has a private constructor that takes in a `T[]`. You are NOT allowed to change it.
- The class has a factory method `Bag::of` that takes in a `List<T>` and returns a `Bag<T>`.
- The class has an accessor `Bag::getCandies` that returns the candies as a `List<T>`.
- `Bag::toString` prints ` [  `, then each candy followed by a space, then `]`.
- `Bag::equals` returns true if both bags hold equal candies at each position.
- Implement `Bag::map`, which applies a `Transformer` to every candy and returns a new `Bag` in the same order.
  - The reference signature given in the skeleton does not compile. Make it as flexible as possible, with no raw types.
  - Hint: create another array.

You can solve the rest of the questions without using `map`, but it may be more complicated.

The types must behave as follows, where `SubCandy extends Candy` and `fn` is a `Transformer<Candy, SubCandy>`:

| Statement | Compiles? |
| --- | --- |
| `new Bag<Candy>(new Candy[] { ... })` | No |
| `Bag<Candy> b = Bag.of(List.of(new SubCandy()))` | Yes |
| `Bag<SubCandy> b = Bag.of(List.of(new SubCandy()))` | Yes |
| `Bag<Object> b = Bag.of(List.of(new Candy(1, "Candy")))` | No |
| `Bag<SubCandy> res = bag.map(fn)` | Yes |
| `Bag<Candy> res = bag.map(fn)` | Yes |
| `Bag<Object> res = bag.map(fn)` | No |

### Sample Run

```text
jshell> Bag<Candy> bag = Bag.of(List.of(new Candy(5, "Kat Kit"),
   ...>     new Candy(1, "Menthis"), new Candy(2, "Strapsil")))
bag ==> [ Kat Kit {5} Menthis {1} Strapsil {2} ]

jshell> bag.map(c -> c.open())
$.. ==> [ Kat Kit [5] Menthis [1] Strapsil [2] ]
jshell> bag.map(c -> c.eat())
$.. ==> [ Kat Kit {5} Menthis {1} Strapsil {2} ]
jshell> bag.map(c -> c.open()).map(c -> c.eat())
$.. ==> [ Kat Kit [4] Menthis [0] Strapsil [1] ]
jshell> bag.map(c -> c.open().eat())
$.. ==> [ Kat Kit [4] Menthis [0] Strapsil [1] ]
jshell> bag.map(c -> new Candy(c.getAmount() / 2, c.getName() + "0"))
$.. ==> [ Kat Kit0 {2} Menthis0 {0} Strapsil0 {1} ]
jshell> bag.map(c -> c)
$.. ==> [ Kat Kit {5} Menthis {1} Strapsil {2} ]
```

You are encouraged to test your code in jshell first. You can run the tests for Question 2 as follows:

```shell
java Test2A
java Test2B
java Test2C
java Test2D
```

---

## Question 3 \[4 marks\]

Rewrite the following method in `Task3.java` into functional style, and make its parameter type more flexible.

| Method Name | eatAllUnopened |
| --- | --- |
| Description | Keeps only the candies that are unopened, and opens and eats each of them once. Candies that are already opened are dropped. The original order is kept. |
| Parameters | Takes one input: `bag` (a bag of candies). |
| Return | Returns a `Bag<Candy>` of the opened-and-eaten candies. |
| Hint | Convert to a list, then to a bag. |

The types must behave as follows, where `SubCandy extends Candy`:

| Statement | Compiles? |
| --- | --- |
| `Task3.eatAllUnopened(Bag.<Candy>of(List.of(new SubCandy())))` | Yes |
| `Task3.eatAllUnopened(Bag.<SubCandy>of(List.of(new SubCandy())))` | Yes |
| `Bag<Candy> r = Task3.eatAllUnopened(Bag.of(List.of(new SubCandy())))` | Yes |
| `Bag<SubCandy> r = Task3.eatAllUnopened(Bag.of(List.of(new SubCandy())))` | No |

### Sample Run

```text
jshell> Task3.eatAllUnopened(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Skittle"),
   ...>     new Candy(2, "Snicker"))))
$.. ==> [ M and M [4] Skittle [0] Snicker [1] ]
jshell> Task3.eatAllUnopened(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Skittle").open(),
   ...>     new Candy(2, "Snicker"))))
$.. ==> [ M and M [4] Snicker [1] ]
jshell> Task3.eatAllUnopened(Bag.of(List.of(
   ...>     new Candy(5, "M and M").open(), new Candy(1, "Skittle").open(),
   ...>     new Candy(2, "Snicker").open())))
$.. ==> [ ]
jshell> Task3.eatAllUnopened(Bag.of(List.of()))
$.. ==> [ ]
```

You are encouraged to test your code in jshell first. You can run the tests for Question 3 as follows:

```shell
java Test3A
java Test3B
java Test3C
```

---

## Question 4 \[4 marks\]

Rewrite the following method in `Task4.java` into functional style, and make its parameter type more flexible.

| Method Name | findAverage |
| --- | --- |
| Description | Returns the average amount of all candies in the bag, rounded down by integer division. Opened and unopened candies both count. You may assume the bag is not empty. |
| Parameters | Takes one input: `bag` (a bag of candies). |
| Return | Returns an `int`, the average amount. |
| Hint | Convert to a list, then compute. |

The method must accept both a `Bag<Candy>` and a `Bag<SubCandy>`, where `SubCandy extends Candy`.

### Sample Run

```text
jshell> Task4.findAverage(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Snicker"),
   ...>     new Candy(2, "Skittle"))))
$.. ==> 2
jshell> Task4.findAverage(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Snicker"),
   ...>     new Candy(2, "Skittle"), new Candy(10, "M and M"),
   ...>     new Candy(0, "Snicker"), new Candy(20, "Skittle"),
   ...>     new Candy(3, "M and M"), new Candy(8, "Snicker"),
   ...>     new Candy(7, "Skittle"))))
$.. ==> 6
jshell> Task4.findAverage(Bag.of(List.of(
   ...>     new Candy(5, "M and M").open().eat(), new Candy(1, "Snicker").open().eat(),
   ...>     new Candy(2, "Strapsil").open().eat(), new Candy(7, "M and M").open().eat(),
   ...>     new Candy(0, "Snicker").open().eat(), new Candy(3, "Strapsil").open().eat())))
$.. ==> 2
jshell> Task4.findAverage(Bag.of(List.of(new Candy(1, "M and M"))))
$.. ==> 1
```

You are encouraged to test your code in jshell first. You can run the tests for Question 4 as follows:

```shell
java Test4A
java Test4B
java Test4C
```

---

## Question 5 \[5 marks\]

Rewrite the following method in `Task5.java` into functional style, and make its parameter type more flexible.

| Method Name | split |
| --- | --- |
| Description | Splits each opened candy with amount n into n opened candies of the same kind with amount 1 each. Unopened candies are dropped, and an opened candy with amount 0 produces nothing. The original order is kept. |
| Parameters | Takes one input: `bag` (a bag of candies). |
| Return | Returns a `Bag<Candy>` of the split candies. |

### Sample Run

```text
jshell> Task5.split(Bag.of(List.of(new Candy(2, "Skittle").open())))
$.. ==> [ Skittle [1] Skittle [1] ]
jshell> Task5.split(Bag.of(List.of(
   ...>     new Candy(1, "Snicker").open(), new Candy(2, "Skittle").open(),
   ...>     new Candy(5, "Snicker").open())))
$.. ==> [ Snicker [1] Skittle [1] Skittle [1] Snicker [1] Snicker [1] Snicker [1] Snicker [1] Snicker [1] ]
jshell> Task5.split(Bag.of(List.of(
   ...>     new Candy(5, "M and M").open(), new Candy(1, "Snicker"),
   ...>     new Candy(2, "Skittle"))))
$.. ==> [ M and M [1] M and M [1] M and M [1] M and M [1] M and M [1] ]
jshell> Task5.split(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Snicker"),
   ...>     new Candy(2, "Skittle"))))
$.. ==> [ ]
jshell> Task5.split(Bag.of(List.of(new Candy(0, "M and M").open())))
$.. ==> [ ]
jshell> Task5.split(Bag.of(List.of()))
$.. ==> [ ]
```

You are encouraged to test your code in jshell first. You can run the tests for Question 5 as follows:

```shell
java Test5A
java Test5B
java Test5C
```

---

## Question 6 \[7 marks\]

Rewrite the following method in `Task6.java` into functional style. Its parameter type stays `Bag<Candy>`.

| Method Name | splitByAmount |
| --- | --- |
| Description | Groups the unopened candies by amount, with one bag per distinct amount. Opened candies are ignored. Bags are ordered by where each amount first appears among the unopened candies, and candies inside a bag keep their original order. |
| Parameters | Takes one input: `bag` (a bag of candies). |
| Return | Returns a `List<Bag<Candy>>`, or an empty list if there are no unopened candies. |

### Sample Run

```text
jshell> Task6.splitByAmount(Bag.of(List.of(
   ...>     new Candy(5, "M and M"), new Candy(1, "Snicker"),
   ...>     new Candy(2, "Strapsil"))))
$.. ==> [[ M and M {5} ], [ Snicker {1} ], [ Strapsil {2} ]]
jshell> Task6.splitByAmount(Bag.of(List.of(
   ...>     new Candy(1, "M and M"), new Candy(99, "Snicker"),
   ...>     new Candy(1, "Strapsil"), new Candy(99, "M and M"),
   ...>     new Candy(1, "Snicker"), new Candy(99, "Strapsil"))))
$.. ==> [[ M and M {1} Strapsil {1} Snicker {1} ], [ Snicker {99} M and M {99} Strapsil {99} ]]
jshell> Task6.splitByAmount(Bag.of(List.of(
   ...>     new Candy(1, "Skittle").open(), new Candy(2, "Skittle"),
   ...>     new Candy(1, "Skittle"))))
$.. ==> [[ Skittle {2} ], [ Skittle {1} ]]
jshell> Task6.splitByAmount(Bag.of(List.of(
   ...>     new Candy(7, "M and M").open(), new Candy(1, "Snicker").open(),
   ...>     new Candy(7, "Strapsil").open())))
$.. ==> []
jshell> Task6.splitByAmount(Bag.of(List.of()))
$.. ==> []
```

You are encouraged to test your code in jshell first. You can run the tests for Question 6 as follows:

```shell
java Test6A
java Test6B
java Test6C
java Test6D
```

---

## Question 7 \[7 marks\]

Implement the following method in `Task7.java` in functional style, using `Maybe<T>` from `cs2030s.fp`. Its parameter type stays `Bag<Candy>`.

| Method Name | taste |
| --- | --- |
| Description | Flips the state of every candy. An unopened candy is opened and eaten once, so `{n}` becomes `[n-1]` and `{0}` becomes `[0]`. An opened candy is replaced by a new unopened candy of the same kind and amount, so `[n]` becomes `{n}`. The original order is kept. |
| Parameters | Takes one input: `bag` (a bag of candies). |
| Return | Returns a `Bag<Candy>` of the tasted candies. |

### Sample Run

```text
jshell> Task7.taste(Bag.of(List.of(
   ...>     new Candy(99, "Snicker").open(), new Candy(1, "M and M").open(),
   ...>     new Candy(2, "Strapsil").open())))
$.. ==> [ Snicker {99} M and M {1} Strapsil {2} ]
jshell> Task7.taste(Bag.of(List.of(
   ...>     new Candy(99, "Snicker"), new Candy(1, "M and M"),
   ...>     new Candy(2, "Strapsil"))))
$.. ==> [ Snicker [98] M and M [0] Strapsil [1] ]
jshell> Task7.taste(Bag.of(List.of(
   ...>     new Candy(99, "Snicker").open(), new Candy(1, "M and M"),
   ...>     new Candy(2, "Strapsil").open(), new Candy(99, "Snicker"),
   ...>     new Candy(1, "M and M").open(), new Candy(2, "Strapsil"))))
$.. ==> [ Snicker {99} M and M [0] Strapsil {2} Snicker [98] M and M {1} Strapsil [1] ]
jshell> Task7.taste(Bag.of(List.of(new Candy(0, "Snicker"))))
$.. ==> [ Snicker [0] ]
jshell> Task7.taste(Bag.of(List.of()))
$.. ==> [ ]
```

You are encouraged to test your code in jshell first. You can run the tests for Question 7 as follows:

```shell
java Test7A
java Test7B
java Test7C
java Test7D
```

---

## Appendix: notes on your saved solutions (not part of the paper)

Your files already pass all 113 checks across the 25 test files, compiled with no unchecked or raw-type warnings. The tests cannot see everything a grader would, though:

1. **`Candy` is not yet immutable.** Its three fields are not `final`, and `eat()` and `open()` set `candy.opened` after construction. A tutor marking Task 1 would likely deduct for this. Make the fields `final` and add a private three-argument constructor that also takes `opened`.
2. **Unused imports.** `Task3`, `Task5` and `Task6` still import `java.util.ArrayList`, which checkstyle will flag.
3. **Leftover pseudo-code.** `Bag.java` still has the `for each candy in candied` comment under `map`.
4. **`Task7` can use your functor.** Each candy maps to exactly one candy, so `bag.map(...)` replaces the list round trip, which is what the skeleton's note about `map` points at.
5. **`Task6` scans the bag once per distinct amount.** That is fine for these test sizes.

To practise properly, attempt the paper from blank files under a 2-hour limit before comparing against your saved solutions.
