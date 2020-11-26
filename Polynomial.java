/*
Carlos Luis
U08
Polynomial.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

/**
 * A class to create, add, and multiply polynomials. A polynomial is defined
 * as a sum of terms where each term has variable x, an int coefficient, and
 * a nonnegative int exponent
 */
public class Polynomial
{
   private Node head ;   // points to the first Node of a Polynomial

   /**
    * Default constructor creates a Polynomial with no terms
    */
   public Polynomial()  // DO NOT MODIFY THIS CONSTRUCTOR
   {
      head = null ;
   }
   
   /**
    * "Copy" constructor. Creates a "deep copy" of a given Polynomial. 
    * I.e. a new Polynomial with identical terms
    * @param p the Polynomial to be copied
    */
   public Polynomial(Polynomial p) 
   {

     // Add the head node for this polynomial.
     this.head = new Node<Term>(p.head.info) ;
     // Pointer to this polynomial.
     Node<Term> t = head ;
     // Pointer to param polynomial.
     Node<Term> t2 = p.head ;

     t2 = t2.next ;

     // Add nodes to this polynomial from the param polynomial.
     while(t2 != null)
     {
        t.next = new Node(t2.info) ;
        t2 = t2.next ;
        t = t.next;
     }
   }
   
   /**
    * Creates a new Term and Node containing it and inserts it in its proper
    * place in this Polynomial (i.e. in ascending order by exponent) 
    * @param coeff the coefficient of the new Term
    * @param expo the exponent of the new Term
    */
   public void addTerm(int coeff, int expo)
   {
      // Create a node with the new term to add.
      Node<Term> term = new Node<Term>(new Term(coeff, expo));
      // Point to head to traverse the linked list.
      Node<Term> leader = head ;

      // Check for empty list
      if(head == null)
      {
         // Insert term at the head node.
         head = term;
         // Break out.
         return ;
      }

      // Check for new head in case the new term has a smaller exponent than current head. 
      if(head.info.getExponent() > expo)
      {
         // Point the new term to the head since head will be the second node.
         term.next = head;
         // Set the new term as the new head.
         head = term;
         // Break out.
         return;
      }

      // Check inside terms
      while(leader.next != null)
      {
         // If the exponent of the next node is >= new term's exponent.
         if(leader.next.info.getExponent() >= expo)
         {
            // Point the new term to that node.
            term.next = leader.next;
            // Insert the node.
            leader.next = term;
            // Break out.
            return;
         }
         else
            // Otherwise, go to the next node.
            leader = leader.next;
      }

      // Insert the new term at the end of the list if needed.
      leader.next = term;

   }// End of the addTerm method      
  
   /**
    * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
    * @return the polynomial as a String
    */
   public String toString()
   {
      if(head == null)
         return "Empty polynomial";

      // String to contain the polynomial's shape.
      String ret = "";

      // Pointer to the head node.
      Node<Term> t = head;

      // Add the term at the head to the return
      ret += t.info;
      t = t.next;

      while(t != null)
      {
          ret += " + " + t.info;
          t = t.next;
      }

      return ret ;
   }
   
   // collect terms of a Polynomial object. I.e. replace all terms having the 
   // same exponent with a single term which is their sum
   private void collectTerms()
   {
      if(this.head == null) 
         return;

      // Point temp node to head to traverse linked list.
      Node<Term> t = this.head ;

      // Traverse the list
      while(t.next != null)
      {
         // If the current term and next term's exponents are equal.
         if(t.info.getExponent() == t.next.info.getExponent())
         {
            // Compute the new coefficient 
            int newCoeff = t.info.getCoefficient() + t.next.info.getCoefficient();

            // Create a temporary node with the updated information. This way we don't have to
            // have setters for the term at the node.
            Node<Term> combined = new Node<Term>(new Term(newCoeff, t.info.getExponent())) ;

            // Update the node's coefficient.
            t.info = combined.info;

            // . n1 is current node(t), n2 is n1.next (t.next).
            // 1.If there is a term after the n2-node we combined: link the combined 
            // node to the next valid node.
            // 2.else, delete the node(n2) we combined.

            // eg1. x^2 -> 5x^2 -> 2x^3 :: 6x^2 -> 2x^3
            // eg2. x^2 -> 5x^2 -> null :: 6x^2 -> null
            //    |- (Because we calculated the last 2 nodes)
            t.next = (t.next.next != null) ? t.next.next : null ;
         }
         else
            // Else, pivot at the next node.
            t = t.next ;
      }
   }
   
   /**
    * Multiply this Polynomial by another Polynomial
    * @param p the other Polynomial
    * @return the product of the two Polynomials
    */
   public Polynomial polyMultiply(Polynomial p)
   {
      // Return null if either polynomial is empty.
      if(this.head == null || p.head == null)
         return null;

      // - To multiply polynomials we'll use distributive property instead of
      // FOIL: for each t2 term | t2.term * t1.term

      // The polynomial we'll return.
      Polynomial ret = new Polynomial();
      // Pointer to the param polynomial's deep copy
      Node<Term> t2 = new Polynomial(p).head;

      // Apply distributive property 
      while(t2 != null)
      {
         // Temporary node pointing to the terms we'll need to apply
         // distributive property to.
         Node<Term> t = new Polynomial(this).head;

         // Multiply each term in t2 * each term in t. Append them to ret.
         while(t != null)
         {
            // System.out.println(t2.info + " * " + t.info);

            // Compute the new term's values.
            int newCoeff = t2.info.getCoefficient() * t.info.getCoefficient();
            int newExp = t2.info.getExponent() + t.info.getExponent();

            // Add a new term with the values to the return polynomial.
            ret.addTerm(newCoeff, newExp);

            t = t.next;
         }

         // Move to the next t2 node/term.
         t2 = t2.next;
      }

       // Combine like terms
       ret.collectTerms();

       return ret;
   }
   
   /**
    * Add this Polynomial and another Polynomial
    * @param p the other Polynomial
    * @return the sum of the two Polynomials
    */
   public Polynomial polyAdd(Polynomial p)
   {      
      // Return null if either polynomial is empty.
      if(this.head == null || p.head == null)
         return null;

      // Create copy polynomials for this; and param p.
      Polynomial tmp = new Polynomial(p);
      Polynomial ret = new Polynomial(this);

      // Pointers to the polynomial.
      Node<Term> t = ret.head;
      Node<Term> t2 = tmp.head;

      // Go to the last node of the return polynomial currently 
      // containing the terms of (this) polynomial.
      while(t != null)
         t = t.next;

      while(t2 != null)
      {
         ret.addTerm(t2.info.getCoefficient(), t2.info.getExponent());
         t2 = t2.next;
      }

       // Combine like terms
       ret.collectTerms();

       return ret ;
   }// End of polyAdd(P p) method.
   
   // Node class definition - DO NOT MODIFY!
   class Node <E extends Term>
   {
      private E info ;     // each node stores an object of the 
                           // type-parameter class...
      private Node next ;  // ...and a pointer to another node

      // Node Constructor 
      // parameter x is an object of the type-parameter class
      Node(E x)         
      {
         info = x;	// set info portion to parameter passed
         next = null;	// not pointing to another Node yet
      }
   } // end of Node class definition ============================
} // end of Polynomial class definition =========================
