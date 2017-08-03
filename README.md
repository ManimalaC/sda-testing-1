### Deadline
This work should be completed before **Friday 17th November**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-17/course-instructions#assignments).

### Homework
Study the sections outlined below and be prepared to discuss the contents.

* **5th ed:** All of chapter 7.
* **6th ed:** All of chapter 9.

### Github Task:
Complete the following exercises:

- 7.13 (9.13 in 6th ed)
- 7.15 (9.15 in 6th ed)
- 7.16 (9.16 in 6th ed)
- 7.18 (Not availabe in 6th ed)

After doing these exercises, proceed to the last section in which you will
test and extend an algorithm for checking primes!

Please commit any Java code developed to the src folder of your KTH Github
repo. Remember to push to KTH Github.

### Testing Online Shop

#### Exercise 7.13 (9.13 in 6th ed)
Create a test class for the `Comment` class in the online-shop-junit project.

#### Exercise 7.15 (9.15 in 6th ed)
Create a test to check that `addComment` returns false when a comment from the
same author already exists.

#### Exercise 7.16 (9.16 in 6th ed)
Create a test that performs negative testing on the boundaries of the `rating`
range. That is, test the values 0 and 6 as a rating (the values just outside
the legal range). We expect these to return false, so assert false in the
result dialog. You will notice that one of these actually (incorrectly) returns
true. This is the bug we uncovered earlier in manual testing. Make sure that
you assert false anyway. The assertion states the expected result, not the
actual result.

#### Exercise 7.18 (Not available in 6th ed)
Create a test that checks whether the author and rating details are stored
correctly after creation. Record separate tests that check whether the `upvote`
and `downvote` methods work as expected.

### The Sieve of Eratosthenes
A prime number is a natural number greater than 1 that is divisible only by
itself and 1. The 
[Sieve of Eratosthenes (Wikipedia link)](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
is a classic algorithm for finding out which numbers are prime, and which are
not. It does so by first assuming that all numbers are prime, and then,
starting from 2 (the first prime), marking all _multiples_ (i.e. 4, 6, 8, 10
etc) as _not_ prime. Obviously, a multiple of a prime is not a prime. Then it
finds the next prime (in this case, 3), and does the same thing, and then for
5, 7 and so on. See th animation on the Wikipedia entry to get a sense of how
it works.

In this exercise, you will be given a working but not quite bulletproof
implementation of the Sieve algorithm. Your task is to test it, fix the bugs,
refactor it, and finally make an optimization. The concepts demonstrated in
this exercise are the following:

1. How to learn about code by writing tests for it.
2. How a test suite makes refactoring less error prone.
3. How to do some rudimentary Test Driven Development (TDD), that is to say,
implementing tests first and production code later.
4. What to test.
5. How to name tests. There are many patterns one can follow, but here we have
chosen to go with _someResultWhenDoingSomething_.

The implemented algorithm looks like this:
```java
public boolean isPrime(int number) {
    boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
    Arrays.fill(prime, true); // assume all numbers are prime
    int sqrt = (int) Math.sqrt(number);
    for (int i = 2; i <= sqrt; i++) {
        if (prime[i]) {
            for (int j = i*2; j < prime.length; j+=i) {
                prime[j] = false; // mark multiples of i as not prime
            }
        }
    }
    return prime[number];
}
```
and is available your `src` folder ([here](src/Sieve.java)). Take some time to
go over the lines of code, look at the Wikipedia animation and the description
and try to get a rough idea of how it works. A test class with a few tests has
also been provided in the `src` folder ([here](src/SieveTest.java)), and the
type of each test (e.g. negative, positive, boundary) is noted. When you have
had a chance to look everything over, proceed with the exercises.

#### Exercise S.1
There are only positive tests in the test class. But what happens if we pass
values that are not even reasonable to consider for prime status? Implement
two tests, `isPrimeThrowsWhenPassed0` and `isPrimeThrowsWhenPassed1`, that
assert that `isPrime` throws an `IllegalArgumentException` when passed
0 and 1 respectively. A very neat way of asserting an exception is like this:

```java
@Test(expected=IllegalArgumentException.class)
public void isPrimeThrowsWhenPassed0 {
    // test code
}
```
Both tests are expected to _fail_.  Note that throwing an exception instead of
returning `false` is a design decision, and depending on the situation, it may
make more sense to do one or the other.  Here, it is mostly used to demonstrate
how to assert exceptions. Both of these tests are _negative boundary tests_.

#### Exercise S.2
If you did `S.1` correctly, you will notice that `isPrime` does not throw at all
when passed a 1, and throws the wrong exception when passed a 0. Modify the
implementation of `isPrime` so that it throws an `IllegalArgumentException` when
passed a value less than 2! Make sure to pass along an appropriate error
message as well, so the user knows what went wrong.

> **Assistant's note:** Don't remember how to throw exceptions? Have a look at
> [How to throw exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)!

#### Exercise S.3
The Sieve algorithm has one major weakness: it cannot handle large primes as it
is dependent on an array the size of the prime being checked. There are several
optimizations that can be implemented to combat this problem, but we will
simply decide that the largest prime we can handle is smaller than `2^29` (~0.5
billion).  This should be a safe number on most operating systems and JVM
implementations.  Implement the following three tests:

* `isPrimeTrueWhenPassed2Pow29Minus1`: Should assert that `isPrime` returns
  true when passed `2^29-1`. This is a _positive boundary_ test.
* `isPrimeThrowsWhenPassed2Pow29`: Should assert that an
  `IllegalArgumentException` is thrown when the value `2^29` is passed to
  `isPrime`. This is a _negative boundary_ test.
* `isPrimeThrowsWhenPassedLargeValues`: Should assert that `isPrime` throws an
  `IllegalArgumentException` when passed values larger than `2^29`. Just throw
  a few values in there that are significantly larger than `2^29` (but keep
  below `2^31-1`, the max value for an `int`!). This is a _negative_ test.

#### Exercise S.4
`isPrime` is doing a lot right now and is starting to get fairly bloated, so it
should be refactored. There are two major and largely unrelated tasks that can
be identified:

1. Error-handling on the input (all of your exception-throwing)
2. Calculating the `prime` array.

Write two new helper methods to handle these tasks, with the following headers:

* `private void checkInput(int)`: Should run all of the error handling on `number`
and throw your exceptions as per usual.
* `private boolean[] sieve(int)`: Should return the `prime` array.

`isPrime` should then look like this:

```java
public boolean isPrime(int number) {
    checkInput(number);
    boolean[] prime = sieve(number);
    return prime[number];
}
```

#### Exercise S.5
For this final exercise, you will make a major optimization for when multiple
values are checked: you will _cache_ the `prime` array. To do this, you need to
add `primeCache` as a field to `Sieve`, and initialize it as an empty array
(whether you do it in a constructor or in-line is up to you).
When `isPrime(number)` is called, you need to check if `primeCache.length <= number`.
If it is, then the number is not an index of the `primeCache`, and you need to
calculate a new array of the appropriate size. If `primeCache.length > number`, 
you may simply return `primeChache[number]`. Run your test suite afterwards
to make sure nothing breaks!
