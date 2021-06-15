package kata;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CompteTest {

	public final static String CREDIT = "CREDIT";
	public final static String DEBIT = "DEBIT";
	public final static String NUM_COMPTE = "456789YG";
	public final static int  ID_COMPTE = 11;
	

	LocalDateTime today = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss");
	String formattedString = today.format(formatter);
	

	
	// Crétion d'un client

	Client client = new Client(11, "nomClient", "nomClient");

	// Création d'un compte
	Compte compte = new Compte(ID_COMPTE, NUM_COMPTE, client);

	@Test
	public void testProprietairDeCompte() {
		assertEquals("nomClient nomClient", client.getNom() + " " + client.getPrenom());
	}

	@Test
	public void testNumeroDeCompte() {
		assertEquals(NUM_COMPTE, compte.getNumero());
	}

	// test solde initial

	@Test
	public void testSoledInitial() {
		this.compte.setSolde(5000.0);
		Assertions.assertEquals(5000.0, compte.getSolde());
	}

	// Effectuer une opération de versement
	@Test
	public void testCredit() {
		this.compte.setSolde(5000.0);
		Operation op1 = new Operation(today, CREDIT, 2000.0, compte);
		this.compte.addOperation(op1);
		Assertions.assertEquals(today, op1.getDate());
		Assertions.assertEquals(NUM_COMPTE, compte.getNumero());
		Assertions.assertEquals(7000.0, compte.getSolde());
		Assertions.assertEquals(CREDIT, op1.getType());

	}

	// Effectuer une opération de retrait
	@Test
	public void testDebit() {
		compte.setSolde(5000.0);
		Operation op2 = new Operation(today, DEBIT, 3000.0, compte);
		compte.addOperation(op2);
		Assertions.assertEquals(today, op2.getDate());
		Assertions.assertEquals(NUM_COMPTE, compte.getNumero());
		Assertions.assertEquals(2000.0, compte.getSolde());
		Assertions.assertEquals(DEBIT, op2.getType());

	}
}
