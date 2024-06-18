package ar.edu.unlam.alicia;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestAlicia {

	@Test
	public void dadoQueAliciaPuedeComprarAlimentosEnElSuperQueSeDescuenteElDineroDisponibleAlComprarUnAlimento()
			throws DineroNoDisponibleExcepcion {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 2000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;

		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);

		Double dineroEsperado = 1800.0;
		Double dineroActual = alicia.getDineroParaComprar();

		assertEquals(dineroEsperado, dineroActual);

	}

	@Test(expected = DineroNoDisponibleExcepcion.class)
	public void dadoQueAliciaPuedeComprarAlimentosEnElSuperQueNoSeExcedaDelDineroDisponible()
			throws DineroNoDisponibleExcepcion {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 2000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;

		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;

		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);

		assertEquals(1800.0, alicia.getDineroParaComprar(), 0.1);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);

		assertEquals(1500.0, alicia.getDineroParaComprar(), 0.1);

		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;

		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);

	}

	@Test
	public void dadoQueAliciaComproAlimentosQueAlConsumirUnAlimentoAgrandadorSeAumenteSuEstatura()
			throws DineroNoDisponibleExcepcion, ExcesoDeAgrandamientoException {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 3000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;

		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;

		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);

		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;

		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);

		alicia.consumirAlimentoAgrandador(bocaditoChocolate);

		Double alturaEsperada = 220.0;
		Double alturaObtenida = alicia.getAltura();

		assertEquals(alturaEsperada, alturaObtenida);

	}

	@Test
	public void dadoQueAliciaComproAlimentosQueAlConsumirUnAlimentoAchicadorSeDisminuyaSuEstatura()
			throws DineroNoDisponibleExcepcion, ExcesoDeAchicamientoException {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 3000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;

		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;

		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);

		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;

		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);

		alicia.consumirAlimentoAchicador(masita);

		Double alturaEsperada = 130.0;
		Double alturaObtenida = alicia.getAltura();

		assertEquals(alturaEsperada, alturaObtenida);

	}

	@Test(expected = ExcesoDeAgrandamientoException.class)
	public void dadoQueAliciaComproAlimentosConsumiblesNoSeAgrandeMasDe280cm()
			throws DineroNoDisponibleExcepcion, ExcesoDeAgrandamientoException {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 5000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		// achicador
		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;
		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		// achicador
		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;
		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		// achicador
		String nombreBagelsito = "Bagelcito";
		Double precioBagelsito = 120.0;
		Alimento bagelsito = new Bagelsito(nombreBagelsito, precioBagelsito);
		alicia.agregarAlimentosAlSuper(supermercado, bagelsito);

		// agrandador
		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;
		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		// agrandador
		String nombreCaramelito = "Super caramelin";
		Double precioCaramelito = 0.50;
		Alimento caramelito = new Caramelito(nombreCaramelito, precioCaramelito);
		alicia.agregarAlimentosAlSuper(supermercado, caramelito);

		// agrandador
		String nombreGomita = "Super gomin";
		Double precioGomita = 10.0;
		Alimento gomita = new Gomita(nombreGomita, precioGomita);
		alicia.agregarAlimentosAlSuper(supermercado, gomita);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);
		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);
		alicia.comprarAlimentoEnElSuper(supermercado, bagelsito);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);
		alicia.comprarAlimentoEnElSuper(supermercado, gomita);
		alicia.comprarAlimentoEnElSuper(supermercado, caramelito);

		alicia.consumirAlimentoAgrandador(bocaditoChocolate);

		Double alturaEsperada = 220.0;
		Double alturaObtenida = alicia.getAltura();

		assertEquals(alturaEsperada, alturaObtenida);

		alicia.consumirAlimentoAgrandador(caramelito);

		Double alturaEsperada2 = 260.0;
		Double alturaObtenida2 = alicia.getAltura();

		assertEquals(alturaEsperada2, alturaObtenida2);

		alicia.consumirAlimentoAgrandador(gomita);

	}

	@Test(expected = ExcesoDeAchicamientoException.class)
	public void dadoQueAliciaComproAlimentosConsumiblesNoSeAchiqueMasDe50cm()
			throws DineroNoDisponibleExcepcion, ExcesoDeAchicamientoException {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 5000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		// achicador
		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;
		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		// achicador
		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;
		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		// achicador
		String nombreBagelsito = "Bagelcito";
		Double precioBagelsito = 120.0;
		Alimento bagelsito = new Bagelsito(nombreBagelsito, precioBagelsito);
		alicia.agregarAlimentosAlSuper(supermercado, bagelsito);

		// agrandador
		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;
		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		// agrandador
		String nombreCaramelito = "Super caramelin";
		Double precioCaramelito = 0.50;
		Alimento caramelito = new Caramelito(nombreCaramelito, precioCaramelito);
		alicia.agregarAlimentosAlSuper(supermercado, caramelito);

		// agrandador
		String nombreGomita = "Super gomin";
		Double precioGomita = 10.0;
		Alimento gomita = new Gomita(nombreGomita, precioGomita);
		alicia.agregarAlimentosAlSuper(supermercado, gomita);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);
		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);
		alicia.comprarAlimentoEnElSuper(supermercado, bagelsito);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);
		alicia.comprarAlimentoEnElSuper(supermercado, gomita);
		alicia.comprarAlimentoEnElSuper(supermercado, caramelito);

		alicia.consumirAlimentoAchicador(masita);

		Double alturaEsperada = 130.0;
		Double alturaObtenida = alicia.getAltura();

		assertEquals(alturaEsperada, alturaObtenida);

		alicia.consumirAlimentoAchicador(alfajorcito);

		Double alturaEsperada2 = 80.0;
		Double alturaObtenida2 = alicia.getAltura();

		assertEquals(alturaEsperada2, alturaObtenida2);

		alicia.consumirAlimentoAchicador(bagelsito);

	}

	@Test
	public void dadoQueExistenAlimentosCompradosPorAliciaQueSeOrdenenPorNombreDeManeraDescendente()
			throws DineroNoDisponibleExcepcion {

		Alicia alicia = new Alicia("Alicia", 19, 60.0, 5000.0);

		Supermercado supermercado = new Supermercado("La tiendita");

		// achicador
		String nombreMasita = "Super Choco";
		Double precioMasita = 200.0;
		Alimento masita = new Masita(nombreMasita, precioMasita);
		alicia.agregarAlimentosAlSuper(supermercado, masita);

		// achicador
		String nombreAlfajorcito = "Nieve de alfajorcitos";
		Double precioAlfajorcito = 1600.0;
		Alimento alfajorcito = new Alfajorcito(nombreAlfajorcito, precioAlfajorcito);
		alicia.agregarAlimentosAlSuper(supermercado, alfajorcito);

		// achicador
		String nombreBagelsito = "Bagelcito";
		Double precioBagelsito = 120.0;
		Alimento bagelsito = new Bagelsito(nombreBagelsito, precioBagelsito);
		alicia.agregarAlimentosAlSuper(supermercado, bagelsito);

		// agrandador
		String nombreBocadito = "Dulzura Chocolate";
		Double precioBocadito = 300.0;
		Alimento bocaditoChocolate = new BocaditoDeChocolate(nombreBocadito, precioBocadito);
		alicia.agregarAlimentosAlSuper(supermercado, bocaditoChocolate);

		// agrandador
		String nombreCaramelito = "Super Caramelin";
		Double precioCaramelito = 0.50;
		Alimento caramelito = new Caramelito(nombreCaramelito, precioCaramelito);
		alicia.agregarAlimentosAlSuper(supermercado, caramelito);

		// agrandador
		String nombreGomita = "Super Gomin";
		Double precioGomita = 10.0;
		Alimento gomita = new Gomita(nombreGomita, precioGomita);
		alicia.agregarAlimentosAlSuper(supermercado, gomita);

		alicia.comprarAlimentoEnElSuper(supermercado, masita);
		alicia.comprarAlimentoEnElSuper(supermercado, alfajorcito);
		alicia.comprarAlimentoEnElSuper(supermercado, bagelsito);

		alicia.comprarAlimentoEnElSuper(supermercado, bocaditoChocolate);
		alicia.comprarAlimentoEnElSuper(supermercado, gomita);
		alicia.comprarAlimentoEnElSuper(supermercado, caramelito);

		TreeSet<Alimento> obtenidos = alicia.obtenerAlimentosOrdenadosPorNombreDescendente();

		Integer i = 0;
		for (Alimento alimento : obtenidos) {
			switch (i) {
			case 0:
				assertEquals("Super Gomin", alimento.getNombre());
				break;
			case 1:
				assertEquals("Super Choco", alimento.getNombre());
				break;
			case 2:
				assertEquals("Super Caramelin", alimento.getNombre());
				break;
			case 3:
				assertEquals("Nieve de alfajorcitos", alimento.getNombre());
				break;
			case 4:
				assertEquals("Dulzura Chocolate", alimento.getNombre());
				break;
			case 5:
				assertEquals("Bagelcito", alimento.getNombre());
				break;
			default:
				break;
			}
			i++;

		}

	}

}
