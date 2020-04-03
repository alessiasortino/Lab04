package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	public List<Corso> getTuttiICorsi() {
		CorsoDAO dao= new CorsoDAO();
		return dao.getTuttiICorsi();
	}

	public Studente getStudente( int matricola) {
		StudenteDAO dao= new StudenteDAO();
		return dao.getStudente(matricola);
	}
	public String getStudentiPerCorso( String codCorso) {
		String stringa="";
		StudenteDAO dao= new StudenteDAO();
	  for(Studente s: dao.getStudentiIscrittiAlCorso(codCorso)) 
		  stringa+=s.getMatricola()+"\n";
		  
		  return stringa;

}
	
	public String getCorsiStudente(int matricola) {
		String stringa="";
		StudenteDAO dao= new StudenteDAO();
	  for(Corso c:  dao.getCorsiStudente(matricola)) {
		  stringa+= c+"\n";
	  }
		  return stringa;
	}
}
