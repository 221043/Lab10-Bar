package it.polito.tdp.bar.model;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Core {

	public static final int M = 15;
	
	Queue<Evento> listaEventi = new PriorityQueue<Evento>();
	Tavolo[] tavoli = new Tavolo[M];
	List<GruppoClienti> clienti = new LinkedList<GruppoClienti>();
	
	int totale=0;
	int soddisfatti=0;
	int insoddisfatti=0;
	
	public void generation(){
		Random random = new Random();
		int time=0;
		int dato=0;
		for(int i=0; i<2000; i++){
			int a = 1; // numero minimo
			int b = 10; // numero massimo
			int c = ((b-a) + 1);
			int temp = random.nextInt(c) + a;
			time += temp;
			int num_persone = random.nextInt(c) + a;
			int d = 60;
			int e = 120;
			int f = ((e-d) + 1);
			int durata = random.nextInt(f) + d;
			float tolleranza = (float) (random.nextFloat()-0.1);
			dato++;
			Evento evento = new Evento(time, dato, Evento.TipoEvento.ARRIVO_GRUPPO_CLIENTI);
			listaEventi.add(evento);
			clienti.add(new GruppoClienti(num_persone, dato, tolleranza, durata));
		}
	}
	
	public void create(){
		Tavolo t;
//		for(int i=0; i<M; i++){
//			if(i<5){
//				t = new Tavolo(i+1, 4);
//				tavoli[i] = t;
//			}
//			else if(i<9){
//				t = new Tavolo(i+1, 6);
//				tavoli[i] = t;
//			}
//			else if(i<13){
//				t = new Tavolo(i+1, 8);
//				tavoli[i] = t;
//			}
//			else if(i<M){
//				t = new Tavolo(i+1, 10);
//				tavoli[i] = t;
//			}
//		}
		for(int i=0; i<M; i++){
			if(i<5){
				t = new Tavolo(i+1, 4);
				tavoli[i] = t;
			}
			else if(i<7){
				t = new Tavolo(i+1, 6);
				tavoli[i] = t;
			}
			else if(i<11){
				t = new Tavolo(i+1, 8);
				tavoli[i] = t;
			}
			else if(i<M){
				t = new Tavolo(i+1, 10);
				tavoli[i] = t;
			}
		}
	}
	
	public Tavolo getTavoloFree(int num_persone){
		Tavolo t;
		for(int i=0; i<M; i++){
			t = tavoli[i];
			if(t.isLibero() && t.getPosti()>=num_persone && (t.getPosti()-num_persone/t.getPosti())>0.9)
				return t;
		}
		return null;
	}
	
	public GruppoClienti getClienti(int dato){
		return clienti.get(dato-1);
	}
	
	public void passo(){
		Evento e = listaEventi.remove();
		switch(e.getType()){
		case ARRIVO_GRUPPO_CLIENTI:
			GruppoClienti gc = this.getClienti(e.getDato());
			System.out.println("Arrivo: "+gc.toString());
			totale += gc.getNumero();
			Tavolo t = this.getTavoloFree(gc.getNumero());
			if(t!=null){
				gc.setTavolo(t);
				t.setLibero(false);
				soddisfatti += gc.getNumero();
				this.addEvento(new Evento(e.getTime()+gc.getDurata(), t.getNumber(), Evento.TipoEvento.LIBERO_TAVOLO));
				System.out.println("Attribuisco a "+gc.getDato()+" il tavolo "+t.getNumber());
			}
			else{
				Random rnd = new Random();
				float p = (float) (rnd.nextFloat()-0.1);
				if(p<=gc.getTolleranza())
					soddisfatti += gc.getNumero();
				else
					insoddisfatti += gc.getNumero();
			}
			break;
		case LIBERO_TAVOLO:
			System.out.println("Libero tavolo "+(e.getDato()));
			tavoli[e.getDato()-1].setLibero(true);
			break;
		default:
			System.err.println("Panik!");		
		}
	}
	
	public void addEvento(Evento e){
		listaEventi.add(e);
	}
	
	public void simula(){
		while(!listaEventi.isEmpty()){
			passo();
		}
	}
	
	public int getClientiTotali(){
		return totale;
	}
	
	public int getClientiSoddisfatti(){
		return soddisfatti;
	}
	
	public int getClientiInsoddisfatti(){
		return insoddisfatti;
	}
	
	public void clear(){
		listaEventi.clear();
		clienti.clear();
		for(int i=0; i<M; i++)
			tavoli[i]=null;
		totale = 0;
		soddisfatti = 0;
		insoddisfatti = 0;
	}
	
}
