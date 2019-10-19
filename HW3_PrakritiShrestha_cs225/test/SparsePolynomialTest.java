import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SparsePolynomialTest {
	SparsePolynomial p1 = new SparsePolynomial (3, 6);  // 3x^6

	@Before
	public void setUp() throws Exception {
		
		SparsePolynomial p2 = new SparsePolynomial(1, 5); // x^5
		SparsePolynomial p3 = new SparsePolynomial (5, 3); // 5x^3
		SparsePolynomial p4 = new SparsePolynomial(8, 2); // 0x^2
		SparsePolynomial p5 = new SparsePolynomial(0, 1); // 2x^1
		p1.getListOfTerms().add(p2);
		p1.getListOfTerms().add(p3);
		p1.getListOfTerms().add(p4);
		p1.getListOfTerms().add(p5);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCoeff() {
		assertEquals( "The coefficient should be 1. ", 1, p1.getCoeff(5));
		assertEquals( "The coefficient should be 8. ", 8, p1.getCoeff(2));
		assertEquals( "The coefficient should be 0. ", 0, p1.getCoeff(1));
	}
	
	@Test 
	public void testGetMinExponent() {
		assertEquals(2, p1.getMinExponent());
	}
	
	@Test 
	public void testGetMaxExponent() {
		assertEquals(6, p1.getMaxExponent());
	}
	
	@Test 
	public void testMinus() {
		Polynomial temp = p1;
		SparsePolynomial sTemp = (SparsePolynomial) temp;
		Polynomial minusP1 = sTemp.minus();
		SparsePolynomial sMinusP1 = (SparsePolynomial) minusP1;
		
		assertEquals(-3, sMinusP1.getListOfTerms().get(0).getCoefficient());
		assertEquals(-8, sMinusP1.getListOfTerms().get(3).getCoefficient());
	}
	
	@Test
	public void testMultiply () {
		Polynomial temp = p1;
		SparsePolynomial sTemp = (SparsePolynomial) temp;
		Polynomial multiplyP1 = sTemp.multiply(3);
		SparsePolynomial sMultiplyP1 = (SparsePolynomial) multiplyP1;
		
		assertEquals(9, sMultiplyP1.getListOfTerms().get(0).getCoefficient());
		assertEquals(3, sMultiplyP1.getListOfTerms().get(1).getCoefficient());
		assertEquals(0, sMultiplyP1.getListOfTerms().get(4).getCoefficient());
	}
	
	@Test
	public void testInsert () {
		Polynomial temp = p1;
		SparsePolynomial sTemp = (SparsePolynomial) temp;
		
		Polynomial insertPolynomial = new SparsePolynomial(2, 4);
		Polynomial pInserted = sTemp.insert(insertPolynomial);
		SparsePolynomial spInserted = (SparsePolynomial) pInserted;
		
		assertEquals(5, spInserted.getListOfTerms().get(1).getExponent());
		assertEquals(4, spInserted.getListOfTerms().get(2).getExponent());
		assertEquals(3, spInserted.getListOfTerms().get(3).getExponent());
		
	}
	
	@Test
	public void testAdd () {
		Polynomial temp = p1;
		SparsePolynomial sTemp = (SparsePolynomial) temp;
		
		Polynomial addPolynomial = new SparsePolynomial(4, 3);
		Polynomial pAdded = sTemp.addOneTerm(addPolynomial);
		SparsePolynomial spAdded = (SparsePolynomial) pAdded;
		
		assertEquals(9, spAdded.getListOfTerms().get(2).getCoefficient());
		
	}
	
	@Test
	public void testSubtract () {
		Polynomial temp = p1;
		SparsePolynomial sTemp = (SparsePolynomial) temp;
		
		Polynomial subtractPolynomial = new SparsePolynomial(4, 1);
		Polynomial pSubtracted = sTemp.subtract(subtractPolynomial);
		SparsePolynomial spSubtracted = (SparsePolynomial) pSubtracted;
		
		assertEquals(-4, spSubtracted.getListOfTerms().get(4).getCoefficient());
	}
}


