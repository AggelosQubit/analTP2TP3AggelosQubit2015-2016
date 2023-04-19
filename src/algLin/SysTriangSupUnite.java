package algLin;

public class SysTriangSupUnite extends SysTriangSup{

	public SysTriangSupUnite(Matrice matriceSystem, MVecteur secondMembre) {
		super(matriceSystem, secondMembre);
		// TODO Auto-generated constructor stub
	}
	@Override
	public MVecteur resolution() throws IrregularSysLinException {
		// TODO Auto-generated method stub
		if(matriceSystem.nbColonnes()!= matriceSystem.nbLignes())throw new IrregularSysLinException();
		//SI JAMAIS IL Y A UN 0 SUR LA DIAGONALE 
		//OU BIEN DANS LA PARTIE SUPERIEUR DE LA MATRICE 
		//ALORS CE N'AI PAS UN SYSTEM LINEAIRE TRIANGULAIRE SUP
		for(int i=0;i<matriceSystem.nbLignes();i++){
			for(int j=0;j<matriceSystem.nbColonnes();j++){
				if(j>i){
					if(matriceSystem.getCoef(i, j)==0){
						throw new IrregularSysLinException();
					}
				} else if(i==j){
					if(matriceSystem.getCoef(i, j)!=1){
						throw new IrregularSysLinException();
					}
				}else{
					if(matriceSystem.getCoef(i, j)!=0){
						throw new IrregularSysLinException();
					}
				}
			}
		}
		//RESOLUTION
		MVecteur mvec = new MVecteur(matriceSystem.nbColonnes());
		double somme=0;
		int n=matriceSystem.nbColonnes()-1;
		mvec.setCoef(n,secondMembre.getCoef(n)/matriceSystem.getCoef(n,n));
		for(int i=n-1;i>=0;i--){
			for(int j=i+1;j<=n;j++){
				somme+=matriceSystem.getCoef(i, j)*mvec.getCoef(j);
			}
			mvec.setCoef(i, (secondMembre.getCoef(i)-somme));
		}
		return mvec;
	}
	public static void main(String []args){
		MVecteur x1 = new MVecteur("vec1.txt");
		double [][] tab={{1,8,7},{0,1,5},{0,0,1}};
		Matrice m1= new Matrice(tab);
		
		System.out.println("Second Membre"+ x1.toString());
		System.out.println(" Matrice Systeme"+m1.toString());
		System.out.println("RESOLUTION System triangulaire Sup");
		System.out.println("Vecteur resolution");
		SysTriangSupUnite sysTSupU = new SysTriangSupUnite(m1, x1);
		try {
			System.out.println(sysTSupU.resolution().toString());
		} catch (IrregularSysLinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
