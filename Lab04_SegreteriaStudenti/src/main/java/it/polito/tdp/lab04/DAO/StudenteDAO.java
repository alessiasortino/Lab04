package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;



public class StudenteDAO {
	public List<Studente> getTuttiICorsi() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String nome = rs.getString("nome");
				String cognome= rs.getString("cognome");
				String codCorso=rs.getString("CDS");
				
				Studente s= new Studente(matricola, nome, cognome, codCorso);
				studenti.add(s);			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public Studente getStudente(int matricola) {
		final String sql = "SELECT * FROM studente where matricola=?";

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

			
				String nome = rs.getString("nome");
				String cognome= rs.getString("cognome");
				String codCorso=rs.getString("CDS");
				
				Studente s= new Studente(matricola, nome, cognome, codCorso);
				
				return s;
		}
				conn.close();
			} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return null;
		
		
		
	}
	public List <Studente> getStudentiIscrittiAlCorso(String codCorso){
		final String sql = "SELECT matricola FROM iscrizione where codins=?";

	List<Studente> studenti = new LinkedList<Studente>();

	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, codCorso);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			int matricola = rs.getInt("matricola");
			
			Studente s= this.getStudente(matricola);
			studenti.add(s);			}

		conn.close();
		
		return studenti;
		

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
		
	}
	
	public List <Corso> getCorsiStudente(int matricola){
		final String sql = "SELECT c.codins, c.crediti, c.nome, c.pd FROM corso as c, studente as s, iscrizione i WHERE s.matricola=i.matricola AND c.codins=i.codins  AND s.matricola=?";

		List<Corso> corsi = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricola );
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins=rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso c= new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);

							}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
			
		
	}

	
	

}
