package kata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompteMain {

	public final static String CREDIT = "CREDIT";
	public final static String DEBIT = "DEBIT";

	public static void main(String... arg) {
		
		LocalDateTime today = LocalDateTime.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss");
		
		
		
		// Création d'un client
		Client client = new Client(11, "nomClient", "prenomClient");

		// Création d'un compte
		Compte compte = new Compte(11, "456789", client);
		// Ajouter un compte du client
		client.setCompte(compte);

		// Affichage de propriètaire de compte
		System.out.println("Client : " + client.getNom() + " " + client.getPrenom());

		// Affichage l'identifient de compte
		System.out.println("Compte : " + compte.getNumero() + "\n");

		// Solde initial
		System.out.println("Solde initial  --------------------------------------  " + compte.getSolde() + " € \n");

		// Effectuer une opération de versement
		Operation op1 = new Operation(today, CREDIT, 1000, compte);
		compte.addOperation(op1);

		// Effectuer une opération de versement
		Operation op2 = new Operation(today, CREDIT, 5000, compte);
		compte.addOperation(op2);

		// Effectuer une opération de retrait
		Operation op3 = new Operation(today, DEBIT, 1000, compte);
		compte.addOperation(op3);

		// Effectuer une opération de retrait
		Operation op4 = new Operation(today, DEBIT, 2000, compte);
		compte.addOperation(op4);

		// Affichage l'historique de compte
		System.out.println("Opérations ");

		System.out.println("Type d'opération \t  Date \t\t\t  Montant \t ");
		System.out.println("__________________________________________________________________");
		for (Operation op : compte.getOperations()) {
			System.out.println(
					op.getType() + "\t\t " + op.getDate().format(formatter)
							+ "\t\t" + op.getMontant() + " €");
		}

		System.out.println("__________________________________________________________________");

		System.out.println("Solde \t\t\t\t\t\t" + compte.getSolde() + " €");
	}

}
