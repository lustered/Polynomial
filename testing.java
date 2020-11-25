
public class testing
{
   public static void main(String[] args)
   {
      Polynomial p1 = new Polynomial();
      Polynomial p2 = new Polynomial();
      Polynomial p0 = new Polynomial();
      
      Polynomial nullTest = p1.polyAdd(p2);
      System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 + p2 = " + 
                          nullTest);
      nullTest = p1.polyMultiply(p2);
      System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 * p2 is " + 
                          nullTest);
      

      p1.addTerm(5, 2);
      p1.addTerm(4, 5);
      p1.addTerm(3, 3);
      p1.addTerm(1, 2);
      p1.addTerm(5, 6);

      p2.addTerm(3, 8);
      p2.addTerm(2, 5);
      p2.addTerm(1, 2);

      p0.addTerm(1, 2);
      p0.addTerm(5, 0);
      p0.addTerm(4, 1);

      System.out.print("\np0 = " + p0);
      System.out.print("\np1 = " + p1);
      System.out.println("\np2 = " + p2);

      
      Polynomial p3 = p1.polyAdd(p2);
      System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1+p2 = " + p3);
      
      Polynomial p4 = p1.polyMultiply(p2);
      System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1*p2 = " + p4);
      
      Polynomial p5 = p2.polyMultiply(p2);
      System.out.println("\np2 = " + p2 + "\np2*p2 = " + p5);
      
      Polynomial p6 = p0.polyMultiply(p2);
      System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0*p2 = " 
                         + p6);
      
      Polynomial p7 = p0.polyAdd(p2);
      System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0+p2 = " 
                         + p7);
      
      p1 = p1.polyAdd(p2);
      System.out.println("\nAfter p1 = p1+p2  p1 = " + p1);
      
      p2 = p2.polyMultiply(p2);
      System.out.println("\nAfter p2 = p2*p2  p2 = " + p2);
      
   }
}
