package it.polito.tdp.lab04.model;

public class Studente {
private int matricola;
private String nome;
private String cognome;
private String codCorso;
/**
 * @param matricola
 * @param nome
 * @param cognome
 * @param codCorso
 */
public Studente(int matricola, String nome, String cognome, String codCorso) {
	super();
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;
	this.codCorso = codCorso;
}
public int getMatricola() {
	return matricola;
}
public void setMatricola(int matricola) {
	this.matricola = matricola;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getCodCorso() {
	return codCorso;
}
public void setCodCorso(String codCorso) {
	this.codCorso = codCorso;
}
@Override
public String toString() {
	return  matricola + " " + nome + " " + cognome ;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codCorso == null) ? 0 : codCorso.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Studente other = (Studente) obj;
	if (codCorso == null) {
		if (other.codCorso != null)
			return false;
	} else if (!codCorso.equals(other.codCorso))
		return false;
	return true;
}
}

