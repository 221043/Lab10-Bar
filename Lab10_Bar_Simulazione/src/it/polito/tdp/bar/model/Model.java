package it.polito.tdp.bar.model;

public class Model {

	Core core = new Core();
	
	public void simula(){
		core.create();
		core.generation();
		core.simula();
	}
	
	public int getClientiTotali(){
		return core.getClientiTotali();
	}
	
	public int getClientiSoddisfatti(){
		return core.getClientiSoddisfatti();
	}
	
	public int getClientiInsoddisfatti(){
		return core.getClientiInsoddisfatti();
	}
	
	public void clear(){
		core.clear();
	}
	
//	public static void main(String[] args){
//		Model m = new Model();
//		m.simula();
//		System.out.println("\n Clienti totali: "+m.getCore().getClientiTotali());
//		System.out.println("\n Clienti soddisfatti: "+m.getCore().getClientiSoddisfatti());
//		System.out.println("\n Clienti insoddisfatti: "+m.getCore().getClientiInsoddisfatti());
//	}
	
}
