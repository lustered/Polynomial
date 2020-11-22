/**
 * Models a class to represent a term in an algebraic expression:
 * Consists of: integer coefficient and a nonnegative integer exponent
 *
 * eg: term 4x^2 - coeff is 4 and exponent is 2
 *         -6x^8 - coeff is -6 and exponent is 8
 * 
 */

public class Term
{
    private final int coefficient ;
    private final int exponent ;

    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient ;
        this.exponent = exponent ;
    }

    public int getCoefficient() 
    {
        return coefficient ;
    }

    public int getExponent() 
    {
        return exponent ;
    }

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
