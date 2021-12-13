package juegoSnake;

import java.awt.Color;


import javax.swing.JFrame;

public class Inicializador {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("M A D  S N A K E");
		Juego s = new Juego();
		ventana.setBounds(10, 10, 905, 700);
		ventana.setBackground(Color.DARK_GRAY);
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(s);

	}
}