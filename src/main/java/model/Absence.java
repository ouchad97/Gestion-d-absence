package model;

public class Absence {
	
	
	private int idAbscence;
	private int DateAbscence;
	private boolean justif;
	
	public int getIdAbscence() {
		return idAbscence;
	}
	public void setIdAbscence(int idAbscence) {
		this.idAbscence = idAbscence;
	}
	public int getDateAbscence() {
		return DateAbscence;
	}
	public void setDateAbscence(int dateAbscence) {
		DateAbscence = dateAbscence;
	}
	public boolean isJustif() {
		return justif;
	}
	public void setJustif(boolean justif) {
		this.justif = justif;
	}
	public Absence(int idAbscence, int dateAbscence, boolean justif) {
		super();
		this.idAbscence = idAbscence;
		DateAbscence = dateAbscence;
		this.justif = justif;
	}

	
	
	
	
}
