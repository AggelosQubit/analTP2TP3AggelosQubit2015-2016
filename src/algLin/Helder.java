package algLin;

public class Helder extends SysLin{

	public Helder(Matrice matriceSystem, MVecteur secondMembre) {
		super(matriceSystem, secondMembre);
		// TODO Auto-generated constructor stub
	}

	public void factorLDR() throws IrregularSysLinException {
		
	}
	public MVecteur resolutionPartielle() throws IrregularSysLinException {
		return null;
	}
	
	public void setSecondMembre(MVecteur mvec){
		this.secondMembre=mvec;
	}
	
	@Override
	public MVecteur resolution() throws IrregularSysLinException {
		// TODO Auto-generated method stub
		//LA MATRICE DOIT ETRE CARRE
		int n =matriceSystem.nbColonnes();
		if(n!= matriceSystem.nbLignes())throw new IrregularSysLinException();
		//MATRICE DOIT ETRE INVERSIBLE
		
		return null;
	}

}
