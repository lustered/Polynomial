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
      // TODO:Thought question: what happens if the exponent of the new term is less than the exponent of the first term on the list?

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
         this.head = term;
         // Break out.
         return;
      }

      // Check for in-between 
      while(leader.next != null)
      {
         // If the exponent of the next node is >= new term's exponent
         if(leader.next.info.getExponent() >= expo)
         {
            // Point the new term to that node.
            term.next = leader.next;
            // Inser the node
            leader.next = term;
            // Break out.
            break;
         }
         else
         {
            // Otherwise, go to the next node.
            leader = leader.next;
         }
      }

      // Insert the new term at the end of the list.
      leader.next = term;

   }// End of the addTerm method      
  
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
   public void collectTerms()
   {

      Polynomial ret = new Polynomial();

      if(head == null) 
         return;

      // Point temp node to head to traverse linked list.
      Node<Term> t = head ;
      Node<Term> rt = ret.head;
      Node<Term> t2 = head;

      while(t.next != null)
      {
         if(t.info.getExponent() == t.next.info.getExponent())
         {
            int newCoeff = t.info.getCoefficient() + t.next.info.getCoefficient();

            Node<Term> combined = new Node<Term>(new Term(newCoeff, t.info.getExponent()));

            t.info = combined.info;

            // .If there is a term after the n2-node we combined: link the combined 
            // node to the next valid node.
            // .else, delete the node we combined.
            t.next = (t.next.next != null) ? t.next.next : null ;
         }
         else
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
      if(this.head == null) return null ;

       // TODO:
       // Notes: 
       // .Create a polynomial 
       // REMEMBER to assume that terms are ordered by exponent: x^2 + 5x^2 + 3x^3 ...
       // Therefore we can just check until the exponent isn't the same then:
       //  
       // .and pivot at the new one
       Node<Term> tmp = head ;
       Node<Term> other = p.head ;

       Polynomial ret = new Polynomial();
       // ret.head = new Node<Term>(new Term(5, 10));

       while(tmp != null)
       {
          System.out.println("This polynomial: " + tmp.info.getExponent());
          tmp = tmp.next ;

          while(other != null)
          {
             System.out.println("Param polynomial: " + other.info.getExponent());
             other = other.next ;
          }
       }

       return ret ;
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
