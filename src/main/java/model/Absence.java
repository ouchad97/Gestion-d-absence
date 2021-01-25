package model;

public class Absence {
	
	
	private int idAbsence;
	private String DataAbsence;
	private int Duree;
	private boolean justif;
	
	
	public int getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	public String getDataAbsence() {
		return DataAbsence;
	}
	public void setDataAbsence(String dataAbsence) {
		DataAbsence = dataAbsence;
	}
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int duree) {
		Duree = duree;
	}
	public boolean isJustif() {
		return justif;
	}
	public void setJustif(boolean justif) {
		this.justif = justif;
	}
	
	
	
	public Absence(int idAbsence, String dataAbsence, int duree, boolean justif) {
		this.idAbsence = idAbsence;
		DataAbsence = dataAbsence;
		Duree = duree;
		this.justif = justif;
	}
	
	
	public Absence() {

	}
	
	
	
	
	
	
	
}
