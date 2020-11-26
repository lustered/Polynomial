 /*
 Carlos Luis
 U08
 Term.java
 I affirm that this program is entirely my own work and none of it
 is the work of any other person.
 */

 /**
 * Models a class to represent a term in an algebraic expression:
 * Consists of: integer coefficient and a nonnegative integer exponent
 */
public class Term
{
    // Coefficient of a term.
    private final int coefficient ;
    // Exponent of a term.
    private final int exponent ;

    /**
     * Create a term.
     * @param coefficient coefficient of the term.
     * @param exponent exponent of the term.
     */
    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient ;
        this.exponent = exponent ;
    }

    /**
     * Get the coefficient of the term.
     * @return the coefficient.
     */
    public int getCoefficient() 
    {
        return coefficient ;
    }

    /**
     * Get the exponent of the term.
     * @return the exponent.
     */
    public int getExponent() 
    {
        return exponent ;
    }

    /** Get the String representation of a term eg 2x^3.
     * @return the term's String representation.
     */
    @Override
    public String toString()
    {
        // Check for the following cases:
        // 1.a=1, b=1
        // 2.a=1
        // 3.b=1
        // 4.b=0
        if(getCoefficient() == 1 && getExponent() == 1)
            return "x" ;
        else if(getCoefficient() == 1)
            return String.format("x^%s", getExponent()) ;
        else if(getExponent() == 1)
            return String.format("%sx", getCoefficient()) ;
        else if(getExponent() == 0)
            return Integer.toString(getCoefficient()) ;

        // Otherwise return the proper Polynomial term.
        return String.format("%sx^%s", getCoefficient(), getExponent()) ;
    }
}
