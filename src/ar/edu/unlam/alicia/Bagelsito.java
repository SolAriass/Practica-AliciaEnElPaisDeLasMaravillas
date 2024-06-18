package ar.edu.unlam.alicia;

public class Bagelsito extends Alimento implements Achicador{

	public Bagelsito(String nombre, Double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void achicar(Alicia alicia) {
		alicia.setAltura(alicia.getAltura() - 50.0);
		
	}

}
