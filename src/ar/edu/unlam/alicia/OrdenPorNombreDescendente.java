package ar.edu.unlam.alicia;

import java.util.Comparator;

public class OrdenPorNombreDescendente implements Comparator<Alimento> {

	@Override
	public int compare(Alimento o1, Alimento o2) {
		// TODO Auto-generated method stub
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
