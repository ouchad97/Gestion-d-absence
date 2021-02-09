package model;

public class Promotion {

	private int idPromotion;
	private int annee;
	public Promotion(int idPromotion, int annee) {
		super();
		this.idPromotion = idPromotion;
		this.annee = annee;
	}
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
}
