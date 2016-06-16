package it.polito.tdp.bar.model;

public class GruppoClienti {

	Tavolo tavolo;
	int numero;
	int dato;
	float tolleranza;
	int durata;
	
	public GruppoClienti(int numero, int dato, float tolleranza, int durata) {
		this.numero = numero;
		this.dato = dato;
		this.tolleranza = tolleranza;
		tavolo = null;
		this.durata = durata;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public int getNumero() {
		return numero;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public int getDurata() {
		return durata;
	}

	public int getDato() {
		return dato;
	}

	@Override
	public String toString() {
		return "GruppoClienti [numero=" + numero + ", dato=" + dato + ", tolleranza=" + tolleranza + ", durata="
				+ durata + "]";
	}

}
