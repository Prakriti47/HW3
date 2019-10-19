import java.util.ArrayList;

public class SparsePolynomial implements Polynomial {

	/** variable refers to the unknown value in the polynomial expression*/
	private static final String variable = "x";
	/** cap refers the symbol used to represent exponent in the polynomial's string representation */
	private static final String cap = "^";
	/** coefficient is the number that precedes the variable (x) in a polynomial term*/
	private int coefficient;
	/** exponent is the power of the variable in a given polynomial term */
	private int exponent;
	/** listOfTerms is a list of individual monomial terms that, when stringed together, make up a polynomial*/
	private ArrayList<Polynomial> listOfTerms= new ArrayList<Polynomial>();
	/** initial length of the listOfTerms (when the polynomial is first created) */
	private int lenOfList = 0;

	/**
	 * Constructor for the SparsePolynomial object
	 *
	 * @param coefficient the coefficient of the polynomial when it is first instantiated
	 * @param exponent the exponent of the polynomial when it is first instantiated
	 */

	public SparsePolynomial(int coefficient, int exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
		this.listOfTerms.add(this);
		this.lenOfList = listOfTerms.size();
	}

	/**
	 * Main method to test the other methods
	 *
	 * @param args not used
	 */

	public static void main(String[] args) {

		SparsePolynomial p10 = new SparsePolynomial (7, 9); //7x^9
		SparsePolynomial p9 = new SparsePolynomial(1, 5); //x^5
		SparsePolynomial p8 = new SparsePolynomial (5, 6); //5x^6
		SparsePolynomial p7 = new SparsePolynomial(0, 2); //0
		SparsePolynomial p6 = new SparsePolynomial(1, 1); //x
		SparsePolynomial p5 = new SparsePolynomial (3, 0); //3
		SparsePolynomial p4 = new SparsePolynomial(1, 4); //x^4
		SparsePolynomial p3 = new SparsePolynomial (3, 1); //3x
		SparsePolynomial p2 = new SparsePolynomial(4, 3); //4x^3
		SparsePolynomial p1 = new SparsePolynomial(2, 0); //0

	}

	/**
	 * getter for the polynomial's coefficient
	 * @precondition the coefficient should not be null.
	 * @postcondition should return a real number.
	 *
	 * @return the value of the coefficient
	 */

	public int getCoefficient() {
		return this.coefficient;
	}

	/**
	 * getter for the polynomial's exponent
	 * @precondition the exponent should not be null.
	 * @postcondition should return a real number.
	 *
	 * @return the value of the exponent
	 */

	public int getExponent() {
		return this.exponent;
	}

	/**
	 * getter for the polynomial's listOfTerms
	 * @precondition the listOfTerms should not be null.
	 * @postcondition should return a valid ArrayList of Polynomials.
	 *
	 * @return listOfTerms
	 */

	public ArrayList<Polynomial> getListOfTerms() {
		return this.listOfTerms;
	}

	/**
	 * getter for the polynomial's lenOfList
	 * @precondition the exponent should not be null.
	 * @postcondition should return a real number.
	 *
	 * @return the value of the exponent
	 */

	public int getLenOfList () {
		return this.lenOfList;
	}

	/**
	 * setter for the polynomial's lenOfList
	 * @precondition the parameter should not be a null value.
	 * @postcondition lenOfList should return a real number.
	 *
	 * @param len is the new length of the listOfTerms
	 */

	public void setLenOfList (int len) {
		this.lenOfList = len;
	}

	/**
	 * getMinExponent() gives the value of the minimum exponent in the polynomial
	 * @precondition the exponent should not be null.
	 * @postcondition should return a real number.
	 *
	 * @return the value of the minimum exponent in the polynomial
	 */

	@Override
	public int getMinExponent() {

		int lastExp = listOfTerms.get(0).getExponent(); //stores the exponent value of the last term in the loop shown below
		int currentExp = listOfTerms.get(0).getExponent(); //stores the exponent value of the current term in the loop shown below
		int resultExp = listOfTerms.get(0).getExponent(); //the exponent term to be returned

		//loop through all the terms in the listOfTerms
		for (int i = 0; i < listOfTerms.size(); i++) {
			currentExp= listOfTerms.get(i).getExponent();
			//will update the value of the result if current value of exponent is smaller than last value
			//if it is the first term in the list, it will be compared to the initial value of lastExp i.e. 0
			if ( (currentExp < lastExp) && (listOfTerms.get(i).getCoefficient() != 0)) {
				resultExp = listOfTerms.get(i).getExponent();
				lastExp = listOfTerms.get(i).getExponent();
			}
		}
		return resultExp;
	}

	/**
	 * getMaxExponent() gives the value of the maximum exponent in the polynomial
	 * @precondition exponent should not be null.
	 * @postcondition should return a real number.
	 *
	 * @return the value of the maximum exponent in the polynomial
	 */

	@Override
	public int getMaxExponent() {

		int lastExp = listOfTerms.get(0).getExponent();//stores the exponent value of the last term in the loop shown below
		int currentExp = listOfTerms.get(0).getExponent();//stores the exponent value of the current term in the loop shown below
		int resultExp = listOfTerms.get(0).getExponent(); //the exponent term to be returned

		//will update the value of the result if current value of exponent is greater than last value
		//if it is the first term in the list, it will be compared to the initial value of lastExp i.e. 0
		for (int i = 0; i < listOfTerms.size(); i++) {
			currentExp= listOfTerms.get(i).getExponent();
			if ((currentExp > lastExp) && (listOfTerms.get(i).getCoefficient() != 0 )) {
				resultExp = listOfTerms.get(i).getExponent();
				lastExp = listOfTerms.get(i).getExponent();
			}
		}
		return resultExp;
	}

	/**
	 * getCoeff() returns the coefficient value of the polynomial with the given exponent
	 *
	 * @precondition exponent should be not be a null value.
	 * @postcondition should return a real number.
	 * @param exp is the value of the exponent
	 * @return the value of the coefficient corresponding to the given exponent
	 */

	@Override
	public int getCoeff(int exp) {
		int currentExp = 0;
		//loops through the listOfTerms
		for (int i = 0; i < listOfTerms.size(); i++) {
			currentExp = listOfTerms.get(i).getExponent();
			//returns the coefficient if the exponent value of this term is equal to the parameter
			if ( currentExp == exp) {
				return listOfTerms.get(i).getCoefficient();
			}
		}
		return 0;
	}

	/**
	 * isZero() returns a polynomial by adding the parameter to this. Neither this nor
	 * the parameter are modified.
	 * @precondition the list of terms should not have have more than 1 term
	 * @postcondition it should always return a boolean value
	 *
	 *  @return whether the polynomial has a zero constant or not
	 */

	@Override
	public boolean isZero() {
		if (listOfTerms.size() == 0) {
			return true;
		}
		else {
			if (coefficient == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	/**
	 * add() returns a polynomial by adding the parameter to this.
	 *
	 * @param q the polynomial to add to this.
	 * @precondition q should not be null.
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return this + q
	 */

	@Override
	public Polynomial add (Polynomial q) {
		SparsePolynomial finalPolynomial = this;
		//loops through all the terms in q
		for (int i = 0; i < q.getListOfTerms().size();i++) {
			Polynomial tempPolynomial = q.getListOfTerms().get(i);

			//takes the term and passes it on to addOneTerm() method
			Polynomial tPolynomial = (Polynomial) (finalPolynomial.addOneTerm(tempPolynomial));
			finalPolynomial = (SparsePolynomial) tPolynomial;
		}
		return (Polynomial) finalPolynomial;
	}

	/**
	 * addOneTerm() returns a polynomial by adding the parameter to this. It is a helper method for add().
	 *
	 * @param q the polynomial to add to this.
	 * @precondition q should be a polynomial with only be one single term, for example, 4x^2 but not x^3 + 4x^2
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return this + q
	 */

	public Polynomial addOneTerm(Polynomial q) {
		boolean isAdded = false; //boolean that checks if q has been added to the new polynomial (that is to be returned)

		int tempExponent = q.getExponent();
		int tempCoeff = q.getCoefficient();
		//newPolynomial is the polynomial that will q will be added on and returned
		SparsePolynomial newPolynomial = this;

		//loop through all the values in this.
		for (int i = 0; i < this.listOfTerms.size(); i++) {
			int exponent = this.listOfTerms.get(i).getExponent();
			int coefficient = this.listOfTerms.get(i).getCoefficient();

			//adds the coefficients if the exponent of q is the same as the exponent of the term in this loop
			if (exponent == tempExponent) {
				Polynomial tempTerm = new SparsePolynomial(coefficient + tempCoeff, exponent);
				//removes the previous term with the original coefficient and replaces it with
				// the same term but with the increased value of coefficient
				newPolynomial.getListOfTerms().remove(i);
				newPolynomial.getListOfTerms().add(i, tempTerm);
				isAdded = true;
			}
		}

		//if the exponent of q didn't exist in the polynomial, q will be inserted into the polynomial separately
		if (!isAdded) {
			Polynomial finalPolynomial = newPolynomial.insert(q);

			assert this.wellFormed() : "This object has been mutated.";
			return (Polynomial)finalPolynomial;
		}
		else {
			assert this.wellFormed() : "This object has been mutated.";
			return  (Polynomial)newPolynomial;
		}
	}


	/**
	 * insert() takes the polynomial and adds it to this in a way that its list of terms
	 * maintains its descending order. It is a helper method for addOneTerm() and subtractOneTerm()
	 *
	 * @param polynomial that is to be inserted to this.
	 * @precondition the parameter should be a polynomial with only be one single term,
	 *  for example, 4x^2 but not x^3 + 4x^2
	 * @postcondition Neither this nor the polynomial should be modified.
	 * @return this + polynomial
	 */

	public Polynomial insert (Polynomial polynomial) {
		boolean isInserted = false; //boolean that checks if polynomial has been inserted

		int exponent = polynomial.getExponent();

		//new polynomial object instantiated, which is to be returned
		SparsePolynomial sortedPolynomial = new SparsePolynomial(this.coefficient, this.exponent);
		sortedPolynomial = this;
		sortedPolynomial.setLenOfList(this.getLenOfList());

		//if this only has one polynomial object in its list of expressions
		if (this.getListOfTerms().size() == 1) {

			//if the only existing term in the polynomial is smaller than the polynomial to be inserted
			if (this.getListOfTerms().get(0).getExponent() < exponent) {
				sortedPolynomial.getListOfTerms().add(0, polynomial);
				//lenOfList changed every time a term is added in order to track all the changes made
				sortedPolynomial.setLenOfList(sortedPolynomial.getLenOfList() + 1);
				return (Polynomial) sortedPolynomial;
			}
			else {

				//if the only existing term in the polynomial is larger than the polynomial to be inserted
				sortedPolynomial.getListOfTerms().add(polynomial);
				sortedPolynomial.setLenOfList(sortedPolynomial.getLenOfList() + 1);
				assert this.wellFormed() : "This object has been mutated.";
				return (Polynomial) sortedPolynomial;
			}
		}

		//else if this has more than one term
		else {
			if (this.getListOfTerms().size() > 1) {

				int lastExp = 0;

				for ( int i = 0; i < this.getListOfTerms().size(); i++) {
					int currentExp = this.getListOfTerms().get(i).getExponent();
					//checks if the value of the exponent is in between the previous and the next term's exponent
					//to check if it can be inserted in between
					if ( (i == 0 && exponent > currentExp) || ((exponent > currentExp) && (exponent < lastExp)) ) {
						sortedPolynomial.getListOfTerms().add(i, polynomial);
						sortedPolynomial.setLenOfList(sortedPolynomial.getLenOfList() + 1);
						isInserted = true;
					}

					lastExp = this.getListOfTerms().get(i).getExponent();

				}
			}
		}

	//if the exponent of the polynomial-to-be-inserted is smaller than the smallest polynomial in the list
		if (!isInserted) {
			sortedPolynomial.getListOfTerms().add(polynomial);
			sortedPolynomial.setLenOfList(sortedPolynomial.getLenOfList() + 1);
			assert this.wellFormed() : "This object has been mutated.";
			return (Polynomial)sortedPolynomial;
		}
		else {
			assert this.wellFormed() : "This object has been mutated.";
			return (Polynomial)sortedPolynomial;
		}
	}

	/**
	 * multiply() multiplies the polynomial with the given factor.
	 *
	 * @param factor is the value that the polynomial is to be multiplied with.
	 * @precondition the factor should be a real number.
	 * @postcondition the return the list should be ordered after removal of the polynomial.
	 * @return a new polynomial which is equal to this polynomial after removing the term
	 */

	@Override
	public Polynomial multiply(int factor) {
		//the 0th element in the list is already multiplied by the factor during instantiation
		SparsePolynomial newSPolynomial = new SparsePolynomial(this.getListOfTerms().get(0).getCoefficient() * factor, this.getListOfTerms().get(0).getExponent());

		//loops through the rest of the list of this
		for (int i = 1; i < this.listOfTerms.size(); i++) {
			//multiplies each term's coefficient with factor
			int newCoefficient = this.listOfTerms.get(i).getCoefficient() * factor;
			int exponent = this.listOfTerms.get(i).getExponent();
			//forms a new object for each term after multiplication and adds it to the listOfTerms
			SparsePolynomial temp = new SparsePolynomial(newCoefficient, exponent);
			newSPolynomial.getListOfTerms().add(temp);
			newSPolynomial.setLenOfList(newSPolynomial.getLenOfList() + 1);
		}
		assert this.wellFormed() : "This object has been mutated.";
		return (Polynomial) newSPolynomial;
	}

	/**
	 * subtract() returns a polynomial by subtracting the parameter from this.
	 *
	 * @param q the polynomial to subtract from this.
	 * @precondition q should not be null.
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return this - q
	 */

	@Override
	public Polynomial subtract (Polynomial q) {
		//the polynomial to be returned
		SparsePolynomial finalPolynomial = this;
		finalPolynomial.setLenOfList(this.getLenOfList());

		//loops through each term in q
		for (int i = 0; i < q.getListOfTerms().size();i++) {
			Polynomial tempPolynomial = q.getListOfTerms().get(i);
			//makes a new polynomial object for each term in q and uses subtractOneTerm() method on it
			Polynomial tPolynomial = (Polynomial) (finalPolynomial.subtractOneTerm(tempPolynomial));
			finalPolynomial = (SparsePolynomial) tPolynomial;
		}
		return (Polynomial) finalPolynomial;
	}

	/**
	 * subtractOneTerm() returns a polynomial by subtracting the parameter from this. It is a
	 * helper method for subtract().
	 *
	 * @param q the polynomial to subtract from this.
	 * @precondition q should not be null and it should be a polynomial with only be one single term,
	 *  for example, 4x^2 but not x^3 + 4x^2.
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return this - q
	 */

	public Polynomial subtractOneTerm(Polynomial q) {
		boolean isSubtracted = false;

		SparsePolynomial subtractSPolynomial = (SparsePolynomial) q;
		int tempExponent = subtractSPolynomial.getExponent();
		int tempCoeff = subtractSPolynomial.getCoefficient();

		//the polynomial to be returned is being instantiated
		SparsePolynomial newSPolynomial = new SparsePolynomial(this.coefficient, this.exponent);
		//clearing out all of the terms from the list (will add the terms later on)
		newSPolynomial.getListOfTerms().removeAll(newSPolynomial.getListOfTerms());
		newSPolynomial.setLenOfList(0);

		//loops through all the terms
		for (int i = 0; i < this.listOfTerms.size(); i++) {
			int exponent = this.listOfTerms.get(i).getExponent();
			int coefficient = this.listOfTerms.get(i).getCoefficient();

			//if the exponent of q is the same as the exponent of the term in this loop,
			//the new term now has a coefficient with the passed-on value of coefficient subtracted
			if (exponent == tempExponent) {
				SparsePolynomial spTemp = new SparsePolynomial(coefficient - tempCoeff, exponent);
				//it is made into a new polynomial object of itself and added to the new polynomial object
				newSPolynomial.getListOfTerms().add(spTemp);
				newSPolynomial.setLenOfList(newSPolynomial.getLenOfList() + 1);
				isSubtracted = true;
			}
			else {
				//if the values of exponents in that term do not match up, the same values from this are
				//added as a new term in the new polynomial
					SparsePolynomial spTemp = new SparsePolynomial(coefficient, exponent);
					newSPolynomial.getListOfTerms().add(spTemp);
					newSPolynomial.setLenOfList(newSPolynomial.getLenOfList() + 1);
				}
		}
		if (!isSubtracted) {
			//if the term with the exponent that q has is not in this at all, it will be inserted as
			//a new term
			Polynomial finalPolynomial = newSPolynomial.insert(subtractSPolynomial.minus());
			assert this.wellFormed() : "This object has been mutated.";
			return finalPolynomial;
		}
		else {
			assert this.wellFormed() : "This object has been mutated.";
			return (Polynomial) newSPolynomial;
		}
	}

	/**
	 * minus() returns a polynomial by multiplying this by -1.
	 *
	 * @precondition this should not be null.
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return -1 * this
	 */


	public Polynomial minus() {
		SparsePolynomial minusThis = new SparsePolynomial((-1) * this.coefficient, this.exponent);
		minusThis.setLenOfList(this.getLenOfList());
		SparsePolynomial sMinusThis = (SparsePolynomial) minusThis;

		//loops through each of the term in the polynomial
		for (int i = 1; i < this.getListOfTerms().size(); i++) {
			int tempCoeff = this.getListOfTerms().get(i).getCoefficient();
			int tempExp = this.getListOfTerms().get(i).getExponent();

			//multiplies the term's coefficient with -1 and adds it to the listOfTerms of the new polynomial
			SparsePolynomial temp = new SparsePolynomial((-1) * tempCoeff, tempExp);
			sMinusThis.getListOfTerms().add(temp);
			sMinusThis.setLenOfList(sMinusThis.getLenOfList() + 1);
		}
		Polynomial newMinusThis = (Polynomial) minusThis;
		assert this.wellFormed() : "This object has been mutated.";
		return (Polynomial) newMinusThis;
	}


	/**
	 * wellFormed() checks whether the initial length of listOfTerms of this is the
	 * same as its current length of listOfTerms.
	 *
	 * @precondition this should not be null
	 * @postcondition Neither this nor the parameter should be modified.
	 * @return boolean value indicating whether this has been modified.
	 */

	@Override
	public boolean wellFormed() {
		if (this.listOfTerms.size() == this.lenOfList) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * toString() prints the polynomial as a well-formatted mathematical expression.
	 *
	 * @precondition this object should not be null.
	 * @postcondition this object should not be mutated in any way.
	 * @return a String representation of this polynomial object
	 */



	public String toString () {
		String result = "";

		for (int i = 0; i < this.getListOfTerms().size();i++) {
			String exp = ""; //exponent of the term
			String coeff = ""; //coefficient of the term
			String symbol = ""; // + or -

			//determine the symbol based on whether coefficient is >0 or <0
			if (this.listOfTerms.get(i).getCoefficient() < 0) {
				symbol = "-"; //"-"
			}
			else {
				if (i == 0) {
					symbol = "";
				}
				else {
					symbol = "+";
				}
			}

			//determine whether to print the coefficient or not
			if (this.listOfTerms.get(i).getCoefficient()  != 1) {
				coeff = "" + Math.abs(this.listOfTerms.get(i).getCoefficient());
			}

			//determine whether to print the exponent or not
			if (this.listOfTerms.get(i).getExponent() != 1) {
				exp = "" + this.listOfTerms.get(i).getExponent() ;
			}

			if (this.listOfTerms.get(i).getCoefficient() == 0) {
				result += "";
			}
			else {
				if (this.listOfTerms.get(i).getExponent()  == 0) {
					result += " " + symbol + " " +  coeff;
				}
				else {
					if (this.listOfTerms.get(i).getExponent()  == 1) {
						result += " " + symbol + " " +  coeff + variable;
					}
					else {
						result += " " + symbol + " " +  coeff + variable + cap + exp;
					}
				}
			}
		}

		return result;
	}


}
