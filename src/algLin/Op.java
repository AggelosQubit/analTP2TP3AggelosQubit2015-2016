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
public class Op {

	/**
	 * This static method return the addition of the 2 Mvecteur in parameter.<br>
	 * We consider her that the 2 MVecteur can be added and so are of the same dimension
	 * @param x the first MVecteur to add
	 * @param y the second MVecteur to add
	 * @return
	 */
	public static MVecteur add(MVecteur x, MVecteur y){
		MVecteur z = new MVecteur(x.dim());
		for (int i=0; i<x.dim(); i++)
			z.setCoef(i,x.getCoef(i)+y.getCoef(i));
		return z;
	}

/**** TO COMPLETE ****/
	private static MVecteur produitByScalaire(double x, MVecteur x1) {
		// TODO Auto-generated method stub
		MVecteur z = new MVecteur(x1.dim());
		for (int i=0; i<x1.dim(); i++)
			z.setCoef(i,x1.getCoef(i)*x);
		return z;
	}
/*	private static Matrice produit2Vecteur( MVecteur x1, MVecteur x2) {
		// TODO Auto-generated method stub
		Matrice z = new MVecteur(x1.dim());
		for (int i=0; i<x1.dim(); i++)
			z.setCoef(i,x1.getCoef(i)*x);
		return z;
	}*/
	private static void matriceParVec(MVecteur mv1,Matrice m1)
	{
		if(mv1.dim()==m1.nbColonnes())
			for(int i=0;i<m1.nbLignes();i++)
				for(int j=0;j<mv1.dim();j++)
					m1.setCoef(i, j,mv1.getCoef(j)*m1.getCoef(i, j));
	}
	private static Matrice addMat(Matrice m1,Matrice m2)
	{
		if	((m1.nbLignes()==m2.nbLignes()) &&(m1.nbColonnes()==m2.nbColonnes()))
		{
			Matrice mRet=new Matrice(m1.nbLignes(), m2.nbColonnes());
			for(int i=0;i<m1.nbLignes();i++)
				for(int j=0;j<m1.nbColonnes();j++)
					mRet.setCoef(i, j, m1.getCoef(i, j)+m2.getCoef(i, j));
			return mRet;
		}
		return null;
	}
	private static Matrice sousMat(Matrice m1,Matrice m2)
	{
		if	((m1.nbLignes()==m2.nbLignes()) &&(m1.nbColonnes()==m2.nbColonnes()))
		{
			Matrice mRet=new Matrice(m1.nbLignes(), m2.nbColonnes());
			for(int i=0;i<m1.nbLignes();i++)
				for(int j=0;j<m1.nbColonnes();j++)
					mRet.setCoef(i, j, m1.getCoef(i, j)-m2.getCoef(i, j));
			return mRet;
		}
		return null;
	}
	
	private static Matrice prodMatrice(Matrice m1,Matrice m2)
	{
		if((m1.nbLignes()==m2.nbLignes()) &&(m1.nbColonnes()==m2.nbColonnes()))
		{
			Matrice mRet=new Matrice(m1.nbLignes(),m1.nbColonnes());
			for (int i = 0; i < m1.nbLignes(); i++) { // aRow
		        for (int j = 0; j < m2.nbColonnes(); j++) { // bColumn
		            for (int k = 0; k < m1.nbColonnes(); k++) { // aColumn
		                mRet.setCoef(i, j,mRet.getCoef(i, j)+ m1.getCoef(i, k)* m2.getCoef(k, j));
		            }
		        }
			}
			return mRet;
		}
		return null;
	}
	
	private static Matrice scaMat(double scalaire,Matrice m2)
	{
		Matrice mRet=new Matrice(m2.nbLignes(),m2.nbColonnes());
		for (int i = 0; i < m2.nbLignes(); i++) { // aRow
			for (int j = 0; j < m2.nbColonnes(); j++) { // bColumn
				mRet.setCoef(i, j,scalaire*m2.getCoef(i,j));
		    }
		}
		return mRet;
	}
	
	/**
	 	DONE* la somme de deux vecteurs,
		DONE• le produit d'un scalaire par un vecteur,
		UNDONE• le produit scalaire de 2 vecteurs,
		DONE• le produit d'une matrice par un vecteur colonne,
		DONE• la somme de deux matrices,
		DONE• la soustraction de deux matrices,
		DONE• le produit de deux matrices,
		• le produit d'un scalaire par une matrice,
		UNDONE• la division de deux matrices,

	 * This main method is just a test program for the class
	 * @param args not used
	 */
	public static void main(String[] args) {
		MVecteur x1 = new MVecteur("vec1.txt");
		MVecteur x2 = new MVecteur("vec3.txt");
		MVecteur x3 = add(x1, x2);
		out.println("la somme des vecteurs \n"+x1+"\n et \n"+x2+"\n vaut \n"+x3);
		Scanner scanner = new Scanner (System.in);
		scanner.useLocale(Locale.US);
		out.println("please enter an number \n" );
		double x = scanner.nextDouble ();
		MVecteur x4= produitByScalaire( x, x1);
		out.println("produit Scalaire of "+x +x1 + "="+ x4);
		
		Matrice matrice= new Matrice("vec2.txt");
		System.out.println("Matrice M1 AVANT matriceParVec \n"+matrice.toString());
		matriceParVec(x1,matrice);
		System.out.println("Matrice m1 apres matriceParVec\n"+matrice.toString());
		
		Matrice matrice2= new Matrice("vec2.txt");
		
		System.out.println("ADDITION DE DEUX MATRICE\n-------------\n"+addMat(matrice, matrice2).toString());
		
		System.out.println("Soustraction DE DEUX MATRICE\n-------------\n"+sousMat(matrice, matrice2).toString());
		
		double [][] tab={{1,2,3},{4,5,6},{7,8,9}};
		double [][] tab2={{9,8,7},{6,5,4},{3,2,1}};
		Matrice m3= new Matrice(tab);
		Matrice m4= new Matrice(tab2);
		
		System.out.println("produit matricielle\n-----------------\n"+prodMatrice(m3,m4).toString());
		
		System.out.println("produit par un scalaire sur matrice\n---------------\n"+scaMat(5.0, m3).toString());
		
		
		
	}



}