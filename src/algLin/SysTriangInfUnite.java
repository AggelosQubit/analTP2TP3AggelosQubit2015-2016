package algLin;

public class SysTriangInfUnite extends SysTriangInf{

	public SysTriangInfUnite(Matrice matriceSystem, MVecteur secondMembre) {
		super(matriceSystem, secondMembre);
		// TODO Auto-generated constructor stub
	}
	@Override
	public MVecteur resolution() throws IrregularSysLinException {
		// TODO Auto-generated method stub
		//LA MATRICE DOIT ETRE CARRE
		if(matriceSystem.nbColonnes()!= matriceSystem.nbLignes())throw new IrregularSysLinException();
		//SI JAMAIS IL Y A UN 0 SUR LA DIAGONALE 
		//OU BIEN DANS LA PARTIE INFERIEURE DE LA MATRICE 
		//ALORS CE N'AI PAS UN SYSTEM LINEAIRE TRIANGULAIRE INF
		for(int i=0;i<matriceSystem.nbLignes();i++){
			for(int j=0;j<matriceSystem.nbColonnes();j++){
				if(i>j){
					if(matriceSystem.getCoef(i, j)==0){
						throw new IrregularSysLinException();
					}
				} else if(i==j){
					if(matriceSystem.getCoef(i, j)!=1){
						throw new IrregularSysLinException();
					}
				}else {
					if(matriceSystem.getCoef(i, j)!=0){
						throw new IrregularSysLinException();
					}
				}
			}
		}
		//RESOLUITION
		MVecteur mvec = new MVecteur(matriceSystem.nbColonnes());
		double somme=0;
		int n=matriceSystem.nbColonnes()-1;
		mvec.setCoef(0,secondMembre.getCoef(0)/matriceSystem.getCoef(0,0));
		for(int i=1;i<=n;i++){
			for(int j=0;j<=i;j++){
				somme+=matriceSystem.getCoef(i, j)*mvec.getCoef(j);
			}
			mvec.setCoef(i, (secondMembre.getCoef(i)-somme));
		}
		return mvec;
	}
	public static void main(String []args){
		MVecteur x1 = new MVecteur("vec1.txt");
		double [][] tab={{1,0,0},{8,1,0},{6,5,1}};
		Matrice m1= new Matrice(tab);
		
		System.out.println("Second Membre"+ x1.toString());
		System.out.println(" Matrice Systeme"+m1.toString());
		System.out.println("RESOLUTION System diagonal");
		System.out.println("Vecteur resolution");
		SysTriangInfUnite sysTInfU = new SysTriangInfUnite(m1, x1);
		try {
			System.out.println(sysTInfU.resolution().toString());
		} catch (IrregularSysLinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
