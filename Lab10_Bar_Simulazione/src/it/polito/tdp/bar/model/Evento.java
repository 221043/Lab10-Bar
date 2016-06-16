package it.polito.tdp.bar.model;

public class Evento implements Comparable<Evento>{

	public enum TipoEvento { ARRIVO_GRUPPO_CLIENTI, LIBERO_TAVOLO};
	
	private int time;
	private TipoEvento type;
	private int dato;
	
	public Evento(int time, int dato, TipoEvento type ) {
		this.type = type;
		this.time = time;
		this.dato = dato;
	}

	public int getTime() {
		return time;
	}

	public int getDato() {
		return dato;
	}

	public TipoEvento getType() {
		return type;
	}

	@Override
	public int compareTo(Evento e) {
		return Long.compare(this.time, e.time);
	}

	@Override
	public String toString() {
		return "Evento [time=" + time + ", type=" + type + ", dato=" + dato + "]";
	}
	
}
