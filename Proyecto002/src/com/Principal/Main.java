package com.Principal;

import com.Figuras.Circulo;
import com.Figuras.Cuadrado;
import com.Figuras.Triangulo;
import com.Implementacion.ArmarFigura;

public class Main {

	public static void main(String[] args) {
		ArmarFigura figura = new ArmarFigura(new Triangulo());
		ArmarFigura figura1 = new ArmarFigura(new Cuadrado());
		ArmarFigura figura2 = new ArmarFigura(new Circulo());
		

	}

}
