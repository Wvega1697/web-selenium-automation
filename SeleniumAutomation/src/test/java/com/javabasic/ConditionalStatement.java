package com.javabasic;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int velocidad = 50;
		int limiteVelocidad = 60;
		// IF
		System.out.println("--------------------IF--------------------");
		if (velocidad > limiteVelocidad) {
			System.out.println("multa");
		}
		// IF ELSE
		System.out.println("--------------------IF ELSE--------------------");
		if (velocidad > limiteVelocidad) {
			System.out.println("multa");
		} else {
			System.out.println("Sin multa");
		}
		// IF ANIDADO
		System.out.println("--------------------IF ANIDADO--------------------");
		boolean carretera = false;
		if (carretera == true) {
			System.out.println("Vamos en Carretera");
			limiteVelocidad = 100;
			if (velocidad > limiteVelocidad) {
				System.out.println("multa");
			} else {
				System.out.println("Sin multa");
			}
		}
		System.out.println("--------------------IF ELSE IF--------------------");
		if (carretera == true) {
			System.out.println("Vamos en Carretera");
			limiteVelocidad = 100;
			if (velocidad > limiteVelocidad) {
				System.out.println("multa");
			} else {
				System.out.println("Sin multa");
			}
		} else if (velocidad > limiteVelocidad) {
			System.out.println("Vas en una calle y con exceso de velocidad");
		} else {
			System.out.println("Vas en una calle y con la velocidad adecuada");
		}
		System.out.println("--------------------SWITCH CASE--------------------");
		int temperatura = 10;
		switch (temperatura) {
		case 10:
			System.out.println("Frio");
			break;
		case 20:
			System.out.println("Normal");
			break;
		case 30:
			System.out.println("Calor");
			break;
		case 40:
			System.out.println("Desierto");
			break;
		default:
			System.out.println("Pela");
			break;
		}
		do {
			System.out.println("Do-While False");
		}while(false);
		int x = 5;
		do {
			System.out.println("Do-While #" + x);
			x--;
		}while(x >= 0);
	}

}
