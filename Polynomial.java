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
     Node<Term> node = p.head ;
     this.head = new Node<>(p.head.info) ;
     Node adder = this.head ;
     node = node.next ;

     while(node.next != null)
     {
        adder.next = new Node(node.info) ;
        node = node.next ;
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

      if(head == null)
      {
         System.out.println("Added node to head");
         head = term;
      }
      else
      {
         Node<Term> trav = head ;
         term.next = null ;

         while(trav.next != null)
            trav = trav.next;

        System.out.println("New Polynomial = " + trav.info);
        trav.next = term;
      }

   }      
  
   /**
    * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
    * @return the polynomial as a String
    */
   public String toString()
   {
      String ret = "";

      if(head == null)
         return "Empty polynomial";

      // Pointing the head node to the traversing var.
      Node<Term> trav = this.head;

      // Add the term at the head to the return
      ret += trav.info;
      trav = trav.next;

      // while(trav != null)
      while(trav != null)
      {
          ret += " + " + trav.info;
          trav = trav.next;
      }

      return ret ;
   }
   
   // collect terms of a Polynomial object. I.e. replace all terms having the 
   // same exponent with a single term which is their sum
   private void collectTerms()
   {
       // TO DO: write body of this method
   }
   
   /**
    * Multiply this Polynomial by another Polynomial
    * @param p the other Polynomial
    * @return the product of the two Polynomials
    */
   public Polynomial polyMultiply(Polynomial p)
   {
       // TO DO: write body of this method
       // temporary return so class skeleton will compile and run
       return null ;
   }
   
   /**
    * Add this Polynomial and another Polynomial
    * @param p the other Polynomial
    * @return the sum of the two Polynomials
    */
   public Polynomial polyAdd(Polynomial p)
   {      
       // TO DO: write body of this method
       // temporary return so class skeleton will compile and run
       return null ;
   }
   
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
