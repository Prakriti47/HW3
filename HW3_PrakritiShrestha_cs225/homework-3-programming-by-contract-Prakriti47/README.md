## CS 225 Software Design
## Homework 3 - Programming by contract
## Due:  October 18, 11:30 PM

## Objectives
* Specifying preconditions and postconditions
* Specifying and checking class invariants
* Programming to an interface
* More practice with JUnit

## Background
Polynomials are a common type of mathematical function. In this assignment, we will only work with polynomials of a single variable, x, and where all terms have integer exponents and coefficients.  Examples of these types of polynomials include:

* x^2
* x^2 + x + 1
* 0
* x^100 + x^-100

There are several ways that one might implement a polynomial.  To make it easy for us to extend our polynomial functionality, you will define a Polynomial interface and an implementation of the Polynomial interface called SparsePolynomial.  While a  SparsePolynomial could represent any of the polynomials shown above, it is particularly well-suited for polynomials in which there are relatively few terms compared to the maximum exponent (also known as the degree) of the polynomial.  Your SparsePolynomial implementation should represent a polynomial as a list of terms, where each term has a coefficient and an exponent.  For example, 

x^100 + 2x^-100

would be represented as a SparsePolynomial with two terms.  The first term has a coefficient of 1 and an exponent of 100.  The second term has a coefficient of 2 and an exponent of -100.

## Assignment

I am providing the Polynomial interface.
You should turn in:
* the SparsePolynomial class that implements Polynomial and uses the representation described above, along with any other classes that SparsePolynomial needs
* SparsePolynomialTest, a JUnit test for SparsePolynomial
* a modified Polynomial interface with default implementations for methods that do not depend on the representation of SparsePolynomial.  (See page 7 of Chapter 4 for information on default methods.)

Your SparsePolynomial class should be written so that its objects are immutable, meaning that your class should not have any mutator methods.  SparsePolynomial should provide a constructor that takes a single coefficient and single exponent.  To build polynomials with more terms, you would use the methods from the Polynomial interface.  For example, to construct a SparsePolynomial for 3x^2 + 2x, you would say: 

```java
SparsePolynomial p1 = new SparsePolynomial (3, 2);  // 3x^2
SparsePolynomial p2 = new SparsePolynomial(2, 1);  // 2x
SparsePolynomial p3 = p1.add(p2);   // 3x^2 + 2x
```

When approaching this problem, you will need to address some specific questions in your design, among them:
* How should you represent the constant 0?
* What is the class invariant for this representation?

As part of your implementation, you should do the following:
* For each method, you should create a Javadoc-style comment that describes preconditions and postconditions.
* With your instance variables, you should have a comment describing the invariants related to those variables.
* You should implement a wellFormed method to check the class invariants.  Write this early and use it to help you debug your code.  
* For each public method that creates or modifies a SparsePolynomial, you should use a Java assert statement to check your class invariants (by calling the wellFormed method) before returning.  Remember to run your program with assertion checking enabled (that is, use the -ea VM argument).
* toString should display a polynomial in a standard mathematical way.  Terms should be sorted by exponent from high to low, terms with a zero coefficient should not be printed, there should be at most one term printed per exponent. For example, the following is in canonical form: 

```
2x^3 + 3x + 1
```

while these are not: 
```
2x^3 + 1 + 3x 
2x^3 + 0x^2 + 3x + 1
x^3 + x^3 + 3x + 1
```
* You should write your implementation assuming any polynomial parameters that are passed in can be any subtype of Polynomial.  However, you can write optimized code to handle the case where the parameter passed in is also a SparsePolynomial.  Use the instanceof operator to check if a SparsePolynomial was passed in, like this:
```java
public Polynomial add(Polynomial q) {
	// Check if q is a SparsePolynomial
	if (q instanceof SparsePolynomial) {
		// Cast to a SparsePolynomial.
		SparsePolynomial sparseQ = (SparsePolynomial) q;
```
* You should write a JUnit test for SparsePolynomial.
* If you find methods that can be implemented just by calling other Polynomial methods, put those in default implementations in the Polynomial interface.


## Turning assertion checking on

If you run from the command line, use the -ea argument to turn on assertion checking:

```
java -ea -classpath src:test:../junit-4.10.jar org.junit.runner.JUnitCore SparsePolynomialTest
```

If you are using Eclipse, to have Eclipse run your code with the "-ea" argument, do the following. Run your program once using Run As Application.  Quit your program.  Open the Run menu and select Run Configurations... Select your run configuration, which should have a familiar looking name, from the list on the left. Click on the Arguments tab. In the VM Arguments area, enter -ea.

## Grading

* (25 points) Correct and complete code
* (25 points) JUnit tests
* (25 points) Programming by contract 
    * Javadoc comments making preconditions and postconditions clear
    * Class invariants / wellFormed method

## Turning in your work

To turn in your work, create a zip file that contains your source code. Submit that on Moodle.
