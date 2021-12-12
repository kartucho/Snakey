/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movimiento implements KeyListener, ActionListener {
	
	private int[] snakex = new int[750];
	private int[] snakey = new int[750];
	
	private boolean left = false, right = false, up = false, down = false;
	private int length = 3;
	private int move = 0;
	private int scores;

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
	public void keyTyped(KeyEvent e) {
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}*/
