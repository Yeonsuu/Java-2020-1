package HangMan.src.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


class Draw extends JPanel{
	public Draw() {}
	private int failcount=0;
	
	//@@@overriding
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//failcount = 5; // �ٸ� Ŭ�������� count 
		base(g);
		DrawHangMan(g);
		

	}

	public void DrawHangMan(Graphics g) {
		Image head= Toolkit.getDefaultToolkit().getImage("�Ӹ�.png");  
		Image body= Toolkit.getDefaultToolkit().getImage("����1.png");
		Image left_A= Toolkit.getDefaultToolkit().getImage("����.png");
		Image right_A= Toolkit.getDefaultToolkit().getImage("������.png");
		Image left_L= Toolkit.getDefaultToolkit().getImage("�޹�.png");
		Image right_L= Toolkit.getDefaultToolkit().getImage("������.png");
		
    if(failcount >= 1) {
			g.drawImage(head, 175, 95, this); // �Ӹ�; �׸�
			
      if(failcount >= 2) {
				g.drawImage(body, 135, 135, this); // ����
			}
			if(failcount >= 3) {
				g.drawImage(left_A, 52, 130, this); // ����
			}
			if(failcount >=4) {
				g.drawImage(right_A, 252, 130, this); // ������; �׸�
			}
			if(failcount >=5) {
				g.drawImage(left_L, 137, 240, this); // �޹�; �׸�
			}
			if(failcount >= 6) {
				g.drawImage(right_L, 190, 243, this); // ������; �׸�
			}		
		}
	}
	
  public void base(Graphics g) { //�⺻ �ܵδ� Ʋ
		g.setColor(Color.red);
		g.drawRect(50, 50, 300, 450); // ������ Ʋ
		g.setColor(Color.red);
		g.drawLine(200, 50, 200, 100); // ����
		g.setColor(Color.YELLOW);   //stage
		g.fillOval(60, 350, 280, 120); // stage
		
		
	}

  public boolean drawnext() {   
	   failcount++;
	   //System.out.println(failcount); // count ����
	   boolean drawnext = false;
	   
	    if(failcount <=6){
	       drawnext = false;
	    }
	    if(failcount>6){ // �׸��� �� �׷����� true return
	      drawnext = true;
	      reset();
	    }
	    return drawnext;
	      
	      
	   }
	     public void reset() { 
	         failcount =0;
	         repaint();
	        }
}