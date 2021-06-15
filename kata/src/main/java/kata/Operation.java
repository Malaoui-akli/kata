package kata;

import java.time.LocalDateTime;

public class Operation {

	private LocalDateTime date =  LocalDateTime.now();
	public enum type {  
		DEBIT, CREDIT 
	}

	private String type;
	private double montant;
	
	private Compte compte;

	

	
	public Operation(LocalDateTime date, String type, double montant, Compte compte) {
		
		this.date = date;
		this.type = type;
		this.montant = montant;
		this.compte = compte;
	}



	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
