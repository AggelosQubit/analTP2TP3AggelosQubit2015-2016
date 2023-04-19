package algLin;

import static java.lang.System.*;

import java.util.*;
/**
 * This class contains some useful operations (mainly described as static)
 * for linear computation (based on mathematical vectors and matrices).
 * It's not expected to be instanciated but to be used by its static methods.
 * @author Cyrille Bertelle & Rawan Ghnemat
 *
 */
public class OpV {

	
	private static MVecteur produitByScalaire(double x, MVecteur x1) {
		// TODO Auto-generated method stub
		MVecteur z = new MVecteur(x1.dim());
		for (int i=0; i<x1.dim(); i++)
			z.setCoef(i,x1.getCoef(i)*x);
		return z;
	}
	/**
	 * This static method return the addition of the 2 Mvecteur in parameter.<br>
	 * We consider her that the 2 MVecteur can be added and so are of the same dimension
	 * @param x the first MVecteur to add
	 * @param y the second MVecteur to add
	 * @return
	 */
	public static MVecteur add(MVecteur x, MVecteur y)
		throws IllegalOperationException
	{
		if (x.dim()!= y.dim()) throw new IllegalOperationException("Vector of different sizes"); 
		MVecteur z = new MVecteur(x.dim());
		for (int i=0; i<x.dim(); i++)
			z.setCoef(i,x.getCoef(i)+y.getCoef(i));
		return z;
	}
	

/**** TO COMPLETE ****/
	
	/**
	 * This main method is just a test program for the class
	 * @param args not used
	 */
	public static void main(String[] args) {
		MVecteur x1 = new MVecteur("vec1.txt");
		MVecteur x2 = new MVecteur("vec2.txt");
		try {
			MVecteur x3 = add(x1, x2);
			out.println("la somme des vecteurs \n"+x1+"\n et \n"+x2+"\n vaut \n"+x3);
		}
		catch (IllegalOperationException x){
			System.out.println(x);
		}
		Scanner scanner = new Scanner (System.in);
		scanner.useLocale(Locale.US);
		out.println("please enter an number \n" );
		double x = scanner.nextDouble ();
		MVecteur x4= produitByScalaire( x, x1);
		out.println("produit Scalaire of "+x +x1 + "="+ x4);
	}

}