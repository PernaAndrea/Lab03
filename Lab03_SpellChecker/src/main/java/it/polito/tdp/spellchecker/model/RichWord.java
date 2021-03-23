package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	boolean presente ;
	String parola ;
	
	public RichWord(String parola,boolean presente) {
		
		this.presente =presente;
		this.parola=parola ;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
}
