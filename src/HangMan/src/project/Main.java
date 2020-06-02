package HangMan.src.project;


import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Main extends JFrame implements ActionListener {

  private Word wordP;
  //private Enter enterP;
  private Chance chanceP;
  private Draw drawP;
  private Wrong wrongP;
  private JTextField tf;
  Container contentPane = this.getContentPane();

  //������ - �����ӵ� gui setting
  public Main(){
  	getContentPane().setBackground(Color.RED);
  	setBackground(Color.YELLOW);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100 , 100 , 300 , 200);

 
	  
	  contentPane.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	  
	  
	  Dimension dim = new Dimension(1900,600);
	  setPreferredSize(dim);
	   
  	
    setTitle("HangMan");
    setSize(900,600);//����
    setVisible(true);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
    
    ////////////
    wordP= new Word();
	   //enterP = new Enter();
	   chanceP= new Chance();
	   drawP = new Draw();
	   wrongP = new Wrong(); //�� Ŭ���� ��ü����

	   wordP.setWord(wordP.getWord());//���⿡ �ܾ� ����
	   chanceP.setChance(5);//��ȸ5��
	   
	  JPanel whole = new JPanel();// word,���߱�,Ʋ����,����
	  whole.setLayout(new GridLayout(4,1));
	  whole.add(wordP);
	  JPanel enter= new JPanel();
	  enter.add(new JLabel ("Guess alphabet: "));
	  enter.add(tf= new JTextField(1));
	  
	  whole.add(enter);
	  
	  tf.addActionListener(this);//������
	  whole.add(wrongP);
	  whole.add(chanceP);
	  
	

	  
	  getContentPane().add(drawP= new Draw());
	  getContentPane().add(whole);
	  //Ȯ���ϱ�....�Ѥ�
	  contentPane.add(whole);
	  contentPane.add(drawP);
	  whole.setBorder(new LineBorder(Color.BLUE,3));
	  
  	
	 
	 //setBorder(new LineBorder(Color.BLUE,3));
	  //getContentPane().add(drawP);
	  //getContentPane().add(whole);

	  //getContentPane().repaint();
	  //drawP.repaint();
	  //whole.repaint();
	
  }
    







//�׼Ǹ����ʸ� ó���� ,���ʹ�����
  public void actionPerformed(ActionEvent e){
    char c = tf.getText().charAt(0);
    tf.setText(" ");

    if(!wordP.matchOne(c)){
      //Ʋ�� ���ĺ� �Է��ϸ� -> 1worng�� �߰�, 2chance -- ,3drawP���� �߰�
      wrongP.addw(c);//1.
      drawP.drawnext();//3.
      if(chanceP.missChance()==0){//2.ī��Ʈ�� 0�̸�
      JOptionPane.showMessageDialog(this, "�����ϼ̽��ϴ�!");
      //reset();//������. �Ǵ� �ٽý���?? //���� �ʿ�!
      }
    }
    else if(wordP.success()){
     JOptionPane.showMessageDialog(this, "�����ϼ̽��ϴ�!");
      //reset();//������. �Ǵ� �ٽý���?? //���� �ʿ�!
    }
  }
private void reset() {
	wordP.setWord("apple");
	chanceP.setChance(5);
	drawP.reset();
	//wrongP.reset()
	
	
}

public static void main(String[] args) {
	  
	new Main();
	
	  
	  
}

}