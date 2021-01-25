package model;

public class Absence {
	
	
	private int idAbsence;
	private int dataAbsence;
	private int duree;
	private boolean justif;
	
	
	public int getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	public int getDataAbsence() {
		return dataAbsence;
	}
	public void setDataAbsence(int dataAbsence) {
		this.dataAbsence = dataAbsence;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public boolean isJustif() {
		return justif;
	}
	public void setJustif(boolean justif) {
		this.justif = justif;
	}
	public Absence(int idAbsence, int dataAbsence, int duree, boolean justif) {
		super();
		this.idAbsence = idAbsence;
		this.dataAbsence = dataAbsence;
		this.duree = duree;
		this.justif = justif;
	}
	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
