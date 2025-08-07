/*
 * PROJECT II: Polynomial.java
 *
 * This file contains a template for the class Polynomial. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file.
 *
 * This class is designed to use Complex in order to represent polynomials
 * with complex co-efficients. It provides very basic functionality and there
 * are very few methods to implement! The project formulation contains a
 * complete description.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file! You should also test this class using the main()
 * function.
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 * 
 * Tasks:
 *
 * 1) Complete this class with the indicated methods and instance variables.
 *
 * 2) Fill in the following fields:
 *
 * NAME: Archie Bevan
 * UNIVERSITY ID: 5538165
 * DEPARTMENT: maths and stats 
 */

public class Polynomial {
    /**
     * An array storing the complex co-efficients of the polynomial.
     */
    Complex[] coeff;

    // ========================================================
    // Constructor functions.
    // ========================================================

    /**
     * General constructor: assigns this polynomial a given set of
     * co-efficients.
     *
     * @param coeff  The co-efficients to use for this polynomial.
     */
    public Polynomial(Complex[] coeff) {
        // You need to fill in this function.
        // starting to initialise the counter to count the number of zeros after the last non zero coeff in the polynomial.
        // loop iterates backward through the array until i>0
        // in the loop check if the real and imaginary parts are zero, if they are then break the loop, if they are not then add 1 to the counter.
        // then initialise the coeff array of the polynomial with a new array of size (old array - counter) so it removes all zeros at the end.
        // the second loop iterates through the first element of the array up the the last element and copy the elements of the old array into the new array.
         int counter = 0;
        for (int i=coeff.length-1; i>0 ;i--) {
            if (coeff[i].getReal() == 0 && coeff[i].getImag() == 0){ 
                counter = counter +1;
            }
            else {break;}
        }

        this.coeff = new Complex[coeff.length-counter];
         
        for (int i=0 ; i<coeff.length-counter ; i++) {
            this.coeff[i] = coeff[i];
        }



    }
    
    /**
     * Default constructor: sets the Polynomial to the zero polynomial.
     */
    public Polynomial() {
        // You need to fill in this function.
        // set the array to size 1 so the polynomial only has a constant term as it is a zero polynomial.
        // this only element in the array is then set to zero.
        this.coeff = new Complex[1];
        this.coeff[0] = new Complex(0,0);


    }

    // ========================================================
    // Operations and functions with polynomials.
    // ========================================================

    /**
     * Return the coefficients array.
     *
     * @return  The coefficients array.
     */
    public Complex[] getCoeff() {
        // You need to fill in this method with the correct code.
        // this method returns a new cloned array that has the same elements as the intial array
        
        return coeff.clone();
    }

    /**
     * Create a string representation of the polynomial.
     * Use z to represent the variable.  Include terms
     * with zero co-efficients up to the degree of the
     * polynomial.
     *
     * For example: (-5.000+5.000i) + (2.000-2.000i)z + (-1.000+0.000i)z^2
     */
    public String toString() {
        // You need to fill in this method with the correct code.
        // Make a new array of strings that has equal length to the number of coefficients in the polynomial.
        // a for loop which demonstrates each coefficient of the polynomial then each element in the array representing a coefficient is stored as a string and matched to its right element in the new array.
        // 
        // We then join the two terms in the new polystring array
        String[] polystring = new String[coeff.length];
        for (int i=0; i<coeff.length;i++) {
            polystring[i] = coeff[i].toString();
            if (i>0){
                polystring[i] += "z";
            }
            if (i>1){
                polystring[i] += "^" + i;
            }
        }
        String yield = String.join("+", polystring);
        return yield;
    }

    /**
     * Returns the degree of this polynomial.
     */
    public int degree() {
        // You need to fill in this method with the correct code.
        return coeff.length-1;
    }

    /**
     * Evaluates the polynomial at a given point z.
     *
     * @param z  The point at which to evaluate the polynomial
     * @return   The complex number P(z).
     */
    public Complex evaluate(Complex z) {
        // You need to fill in this method with the correct code.
        // 
        Complex icoeff = coeff[coeff.length-1];
        for(int i=coeff.length-2;i>=0;i--){
            icoeff=coeff[i].add(z.multiply(icoeff));
        }
        return icoeff;
    }

    
    // ========================================================
    // Tester function.
    // ========================================================

    public static void main(String[] args) {
        // You can fill in this function with your own testing code.
  
        Complex[] myArr1 = {new Complex(1,0), new Complex(0,0),new Complex(0,0)};
        Polynomial p1 = new Polynomial(myArr1);
        Complex[] myArr2 = {new Complex(-0.5,4.5), new Complex(-1,3),new Complex(7,1),new Complex(0,0),new Complex(0,0),new Complex(0,0)};
        Polynomial p2 = new Polynomial(myArr2);
        Complex[] myArr3 = {new Complex(1,0), new Complex(0,0),new Complex(-2,8)};
        Polynomial p3 = new Polynomial(myArr3);



        System.out.println("Testing Constructors for p1:");
        System.out.println("p1 :" +p1.toString());
        System.out.println("Degree of p1:"+ p1.degree());
        System.out.println("p1 evaluated:"+p1.evaluate(new Complex(3,2)));

        System.out.println("Testing Constructors for p2:");
        System.out.println("p2 :" +p2.toString());
        System.out.println("Degree of p2:"+ p2.degree());
        System.out.println("p2 evaluated:"+p2.evaluate(new Complex(0,0)));

        System.out.println("Testing Constructors for p3:");
        System.out.println("p3 :" +p3.toString());
        System.out.println("Degree of p3:"+ p3.degree());
        System.out.println("p3 evaluated:"+p3.evaluate(new Complex(-1,-2.5)));


    }
}