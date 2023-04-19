package algLin;

public class SysDiagonal extends SysLin{
	public SysDiagonal(Matrice matriceSystem, MVecteur secondMembre) {
		super(matriceSystem, secondMembre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MVecteur resolution() throws IrregularSysLinException {
		// TODO Auto-generated method stub
		//LA MATRICE DOIT ETRE CARRE
		if(matriceSystem.nbColonnes()!= matriceSystem.nbLignes())throw new IrregularSysLinException();
		//SI JAMAIS IL Y A UN 0 SUR LA DIAGONALE ALORS CE N'AI PAS UN SYSTEM LINEAIRE DIAGONAL
		for(int i=0;i<matriceSystem.nbLignes();i++){
			for(int j=0;j<matriceSystem.nbColonnes();j++){
				if(i==j){
					if(matriceSystem.getCoef(i, j)==0){
						throw new IrregularSysLinException();
					}
				} else {
					if(matriceSystem.getCoef(i, j)!=0){
						throw new IrregularSysLinException();
					}
				}
			}
		}
		//RESOLUTION
		MVecteur mvec = new MVecteur(matriceSystem.nbColonnes());
		for(int i=0;i<matriceSystem.nbColonnes();i++){
			for(int j=0;j<matriceSystem.nbColonnes();j++){
				if(i==j){
					mvec.setCoef(i, secondMembre.getCoef(i)/matriceSystem.getCoef(i, j));
				}
			}
		}
			
		return mvec;
	}
	/*public static void main(String []args){
		MVecteur x1 = new MVecteur("vec1.txt");
		double [][] tab={{9,0,0},{0,5,0},{0,0,1}};
		Matrice m1= new Matrice(tab);
		
		System.out.println("Second Membre"+ x1.toString());
		System.out.println(" Matrice Systeme"+m1.toString());
		System.out.println("RESOLUTION System diagonal");
		System.out.println("Vecteur resolution");
		SysDiagonal sysDiag = new SysDiagonal(m1, x1);
		try {
			System.out.println(sysDiag.resolution().toString());
		} catch (IrregularSysLinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
}
