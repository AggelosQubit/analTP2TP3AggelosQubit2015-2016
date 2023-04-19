package algLin;

public abstract class SysLin {
	//private int le;
	public final double Eps=7;//Ce sera notre « zéro numérique »
	protected int ordre;//taille du systeme
	protected Matrice matriceSystem;
	protected MVecteur secondMembre;
	
	public SysLin(Matrice matriceSystem,MVecteur secondMembre)
	{
		this.matriceSystem=matriceSystem;
		this.secondMembre=secondMembre;
	}
	public int getOrdre(){return ordre;} //) est un accesseur en lecture de l'attribut ordre 
	public Matrice getMatriceSystem(){ //est un accesseur en lecture de l'attribut matriceSystem ;
		return matriceSystem;
	}
	public MVecteur getSecondMembre(){//est un accesseur en lecture de l'attribut secondMembre ;
		return secondMembre;
	}
	
	//renvoie la résolution du système et est susceptible de
	//lever l'exception IrregularSysLinException
	abstract public MVecteur resolution() throws IrregularSysLinException;

	//Naturellement on ne fais pas de method Main car c'est une classe abstraite qui n'est donc pas instanciable
}