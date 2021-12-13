package juegoSnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.*;
import javax.swing.Timer;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;


public class Juego extends JPanel implements KeyListener, ActionListener {

	private ImageIcon image;
	

	private int[] snakex = new int[750];
	private int[] snakey = new int[750];

	private boolean left = false, right = false, up = false, down = false;

	private ImageIcon cabeza;
	private ImageIcon cuerpo;
	private ImageIcon comida;
	private ImageIcon comidaMala;
	

	private int length = 3;

	private Timer timer;
	private int delay = 120;

	private int move = 0;

	private int[] comidax = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] comiday = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
			525, 550, 575, 600, 625 };

	private int[] comidaMalaX = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] comidaMalaY = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525,
			550, 575, 600, 625 };

	private Random random = new Random();

	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);

	private int xbom = 0, ybom = 0, xbom1 = 0, ybom1 = 0, xbom2 = 0, ybom2 = 0, xbom3 = 0, ybom3 = 0;

	private int scores;
	

	public Juego() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		


	}

	public void paint(Graphics g) { // Se dibuja todo en el panel
		if (move == 0) {
			snakex[2] = 50;
			snakex[1] = 75;
			snakex[0] = 100;

			snakey[2] = 100;
			snakey[1] = 100;
			snakey[0] = 100;
		}
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);

		image = new ImageIcon("cabecera.png");
		image.paintIcon(this, g, 25, 11);

		//background=new ImageIcon(getClass().getResource("fondo.png"));
		// g.drawImage(background.getImage(), 25, 74, 851, 577);
		
		g.setColor(Color.WHITE);
		g.drawRect(25, 74, 851, 577);

		g.setColor(Color.gray);
		g.fillRect(25, 75, 850, 575);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Puntos: " + scores, 780, 30);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Largo: " + length, 780, 50);

		cabeza = new ImageIcon("cabezaVibora.gif");
		cabeza.paintIcon(this, g, snakex[0], snakey[0]);

		for (int i = 0; i < length; i++) {
			if (i == 0) {
				cabeza = new ImageIcon("cabezaVibora.gif");
				cabeza.paintIcon(this, g, snakex[i], snakey[i]);
			} else {
				cuerpo = new ImageIcon("cuerpo1.gif");
				cuerpo.paintIcon(this, g, snakex[i], snakey[i]);
			}
		}

		comida = new ImageIcon("hongoVerde.gif");
		comidaMala = new ImageIcon("hongoVioleta.gif");
		comida.paintIcon(this, g, comidax[xpos], comiday[ypos]);
		
		
		if (scores > 10 && scores <= 20) {
			comidaMala.paintIcon(this, g, comidaMalaX[xbom], comidaMalaY[ybom]);
		} else if (scores > 20) {
			comidaMala.paintIcon(this, g, comidaMalaX[xbom], comidaMalaY[ybom]);
			comidaMala.paintIcon(this, g, comidaMalaX[xbom1], comidaMalaY[ybom1]);
			comidaMala.paintIcon(this, g, comidaMalaX[xbom2], comidaMalaY[ybom2]);
			comidaMala.paintIcon(this, g, comidaMalaX[xbom3], comidaMalaY[ybom3]);
		}
		

		if (comidax[xpos] == snakex[0] && comiday[ypos] == snakey[0]) {
			scores++;
			length++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
			

			if (scores > 10 && scores <= 20) {
				xbom = random.nextInt(34);
				ybom = random.nextInt(23);
			} else if (scores > 20) {
				xbom = random.nextInt(34);
				ybom = random.nextInt(23);
				xbom1 = random.nextInt(34);
				ybom1 = random.nextInt(23);
				xbom2 = random.nextInt(34);
				ybom2 = random.nextInt(23);
				xbom3 = random.nextInt(34);
				ybom3 = random.nextInt(23);
			}
		}
		if (xbom != 0) {
			if ((comidaMalaX[xbom] == snakex[0] && comidaMalaY[ybom] == snakey[0])
					|| (comidaMalaX[xbom1] == snakex[0] && comidaMalaY[ybom1] == snakey[0])
					|| (comidaMalaX[xbom2] == snakex[0] && comidaMalaY[ybom2] == snakey[0])
					|| (comidaMalaX[xbom3] == snakex[0] && comidaMalaY[ybom3] == snakey[0])) {
				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.GREEN);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("PERDISTE !", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 30));
				g.drawString("Preciona ESC para Iniciar", 280, 340);
			}
		}
		for (int i = 1; i < length; i++) {
			if (snakex[i] == snakex[0] && snakey[i] == snakey[0]) {
				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.GREEN);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("PERDISTE !", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 30));
				g.drawString("Preciona ESC para Iniciar", 280, 340);

			}
		}

		if (scores >= 0 && scores <= 10) {
			g.setColor(Color.red);
			g.setFont(new Font("arial", Font.PLAIN, 20));
			g.drawString("NIVEL 1 Puntos (0-10)", 50, 47);

		} else if (scores > 10 && scores <= 20) {
			g.setColor(Color.red);
			g.setFont(new Font("arial", Font.PLAIN, 20));
			g.drawString("NIVEL 2 Puntos (11-20)", 50, 47);
		} else if (scores > 20 && scores <= 30) {
			g.setColor(Color.red);
			g.setFont(new Font("arial", Font.PLAIN, 20));
			g.drawString("NIVEL 3 Puntos (21-30)", 50, 47);
		} else if (scores > 30 && scores <= 40) {
			g.setColor(Color.red);
			g.setFont(new Font("arial", Font.PLAIN, 20));
			g.drawString("NIVEL 4 Puntos (31-40)", 50, 47);

			/*
			 * if(snakex[0]==850 || snakex[0]==25 || snakey[0]==75 || snakey[0]==625) // ACA ESTABA LA FALLA DE QUE SE CORRIA UNA LINEA EN EL NIVEL 4 :D { right=false;
			 * left=false; up=false; down=false;
			 * 
			 * g.setColor(Color.GREEN); g.setFont(new Font("arial", Font.BOLD, 50));
			 * g.drawString("Fin del Juego",300,300);
			 * 
			 * g.setFont(new Font("arial", Font.BOLD, 30));
			 * g.drawString("Preciona ESC para Iniciar",280,340); }
			 */

		} else if (scores > 40 && scores <= 50) {
			g.setColor(Color.red);
			g.setFont(new Font("arial", Font.PLAIN, 20));
			g.drawString("NIVEL 5 Puntos(41-50)", 100, 47);
		}
		if (scores == 50) {
			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.blue);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("GANASTE!!!", 310, 300);

			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Preciona ESC para Iniciar", 260, 340);
		}
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (right) {
			int i = 0;
			for (i = length - 1; i >= 0; i--) {
				snakey[i + 1] = snakey[i];
			}
			for (i = length; i >= 0; i--) {
				if (i == 0) {
					snakex[i] = snakex[i] + 25;
				} else {
					snakex[i] = snakex[i - 1];
				}
				if (snakex[i] > 850) {
					snakex[i] = 25;
				}
			}
			repaint();
		}
		if (left) {
			int i = 0;
			for (i = length - 1; i >= 0; i--) {
				snakey[i + 1] = snakey[i];
			}
			for (i = length; i >= 0; i--) {
				if (i == 0) {
					snakex[i] = snakex[i] - 25;
				} else {
					snakex[i] = snakex[i - 1];
				}
				if (snakex[i] < 25) {
					snakex[i] = 850;
				}
			}
			repaint();
		}
		if (up) {
			int i = 0;
			for (i = length - 1; i >= 0; i--) {
				snakex[i + 1] = snakex[i];
			}
			for (i = length; i >= 0; i--) {
				if (i == 0) {
					snakey[i] = snakey[i] - 25;
				} else {
					snakey[i] = snakey[i - 1];
				}
				if (snakey[i] < 75) {
					snakey[i] = 625;
				}
			}
			repaint();
		}
		if (down) {
			int i = 0;
			for (i = length - 1; i >= 0; i--) {
				snakex[i + 1] = snakex[i];
			}
			for (i = length; i >= 0; i--) {
				if (i == 0) {
					snakey[i] = snakey[i] + 25;
				} else {
					snakey[i] = snakey[i - 1];
				}
				if (snakey[i] > 625) {
					snakey[i] = 75;
				}
			}
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			move = 0;
			length = 3;
			scores = 0;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			move++;
			right = true;
			if (!left) {
				right = true;
			} else {
				left = true;
				right = false;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			move++;
			left = true;
			if (!right) {
				left = true;
			} else {
				right = true;
				left = false;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			move++;
			up = true;
			if (!down) {
				up = true;
			} else {
				down = true;
				up = false;
			}
			left = false;
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			move++;
			down = true;
			if (!up) {
				down = true;
			} else {
				up = true;
				down = false;
			}
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

		
	}

