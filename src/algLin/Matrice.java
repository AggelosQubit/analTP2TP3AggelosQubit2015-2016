package algLin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Matrice {
	private double[][] coef;//stock les coefficients d'une matrice

	public Matrice(int dim1,int dim2){this.coef=new double[dim1][dim2];}
	public Matrice(double tableau[][])
	{
		this.coef=tableau;
	}
	
	public Matrice(String nomFichier)
	{
		try{
			Scanner sc = new Scanner(new File(nomFichier));
			sc.useLocale(Locale.US);
			int ndim=sc.nextInt();
			int ndim2=sc.nextInt();
			
			this.coef= new double[ndim][ndim2];
			for (int i=0; i<ndim; i++)
				for (int j=0; j<ndim2; j++)
					this.coef[i][j]= sc.nextDouble();
		}
		catch (FileNotFoundException e){
			System.out.println("fichier inexistant");
		}
	}
	public int nbLignes(){return this.coef.length;}
	public int nbColonnes(){return this.coef[0].length;}
	
	public double getCoef(int i, int j){return this.coef[i][j];}
	public void setCoef(int i,int j,double x){this.coef[i][j]=x;}
	
	public void recopier(Matrice m)
	{
		double tableau[][]=new double[m.nbLignes()][m.nbColonnes()];
		for(int i=0;i<m.nbLignes();i++)
			for(int j=0;j<m.nbColonnes();j++)
				tableau[i][j]=m.getCoef(i,j);
	}
	
	public String toString()
	{
		String sRet="\nMatrice\n----------------\n";
		for(int i=0;i<this.coef.length;i++)
		{	
			for(int j=0;j<this.coef[0].length;j++){	sRet+=this.coef[i][j]+" ";}
			sRet+="\n";
		}		
		return sRet;
	}
	public static void main(String args[])
	{
		double [][] tab={	{1,2,3},
							{4,5,6},
							{7,8,9} };
		Matrice maMatrice=new Matrice(tab);
		System.out.print(maMatrice.toString());
		System.out.print("getCoef en  2,2 : "+maMatrice.getCoef(2,2)+"\n");//9
		maMatrice.setCoef(2,2,4.0);
		System.out.print("setCoef en  2,2 :"+maMatrice.getCoef(2,2)+"\n");
		System.out.print(maMatrice.toString());
		
		System.out.print("NbColonnes  : "+ maMatrice.nbColonnes()+"\n");
		System.out.print("NbLignes : "+maMatrice.nbLignes()+"\n");
		Matrice maMatrice2=new Matrice("vec2.txt");
		
		System.out.print("\nMatrice creer avec le fichier vec2.txt\n"+maMatrice2.toString());
	}
}
