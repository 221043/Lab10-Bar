package it.polito.tdp.bar.model;

public class Tavolo {

	int number;
	int posti;
	boolean libero;
	
	public Tavolo(int number, int posti) {
		this.number = number;
		this.posti = posti;
		libero = true;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public int getNumber() {
		return number;
	}

	public int getPosti() {
		return posti;
	}
	
}
