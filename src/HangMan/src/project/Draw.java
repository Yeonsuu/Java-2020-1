package HangMan.src.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


class Draw extends JPanel{
	public Draw() {
		
	}
	public static int failcount=0;
	//override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//failcount = 5; // 다른 클래스에서 count 
		base(g);
		DrawHangMan(g);
		

	}

	public void DrawHangMan(Graphics g) {
		Image head= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\머리.png");  
		Image body= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\몸통1.png");
		Image left_A= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\왼팔.png");
		Image right_A= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\오른팔.png");
		Image left_L= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\왼발.png");
		Image right_L= Toolkit.getDefaultToolkit().getImage("C:\\Users\\yoonhyunmin\\Desktop\\오른발.png");
		
    if(failcount >= 1) {
			g.drawImage(head, 175, 95, this); // 머리; 그림
			
      if(failcount >= 2) {
				g.drawImage(body, 135, 135, this); // 몸통
			}
			if(failcount >= 3) {
				g.drawImage(left_A, 52, 130, this); // 왼팔
			}
			if(failcount >4) {
				g.drawImage(right_A, 252, 130, this); // 오른팔; 그림
			}
			if(failcount >=5) {
				g.drawImage(left_L, 137, 240, this); // 왼발; 그림
			}
			if(failcount >= 6) {
				g.drawImage(right_L, 190, 243, this); // 오른팔; 그림
			}		
		}
	}
	
  public void base(Graphics g) { //기본 단두대 틀
		g.setColor(Color.red);
		g.drawRect(50, 50, 300, 450); // 사형대 틀
		g.setColor(Color.red);
		g.drawLine(200, 50, 200, 100); // 목줄
		g.setColor(Color.YELLOW);   //stage
		g.fillOval(60, 350, 280, 120); // stage
	}

	public boolean drawnext() { 
		failcount++;
		
		boolean drawnext = false;
    if(failcount <6){
    	drawnext = false;
    }
    else{ // 그림이 다 그려지면 true return
      drawnext = true;
    }
    return drawnext;
		
		
	}
	  public void reset() {
					  
		  }
}
	