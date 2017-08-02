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

### Testing Auction
In Chapter 4 the Auction project was introduced.  You should revisit this
project, but now attempt to think how you could improve it by including unit
testing.  The Auction project code has been included in your repository.

You must create a test class for all the Auction project classes.  The testing
should be as comprehensive as you can make it, and as a minimum, for each
method, you must consider:

- Positive and negative cases
- Appropriate boundary tests
