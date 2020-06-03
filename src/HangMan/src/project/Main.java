package HangMan.src.project;


import javax.swing.*;
//import javax.swing.border.LineBorder;
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
  private File fword;

  //생성자 - 프레임등 gui setting
  public Main(){
	  Container c = this.getContentPane();
	  
	  setSize(1000,600);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setTitle("GGangMan");
	  
	  wordP = new Word();
	  chanceP= new Chance();
	  
	  JPanel enter = new JPanel();
	  enter.add(new JLabel("Guess alphabet: "));
	  enter.add(tf = new JTextField(1));
	  tf.addActionListener(this);
	  
	  JPanel whole = new JPanel();
	  whole.setLayout(new GridLayout(4,1));
	  whole.add(wordP);
	  whole.add(enter);
	  wrongP = new Wrong();
	  whole.add(wrongP);
	  whole.add(chanceP);
	  
	  setLayout(new BoxLayout(c,BoxLayout.X_AXIS ));
	  add(whole);
	  drawP = new Draw();
	  add(drawP);
	  
	  whole.setBorder(new LineBorder(Color.BLUE,5,true));
	  
	  setVisible(true);
	  
	  wordP.setWord("elementry");
	  chanceP.setChance(5);// 기회5번
	  
	
  }
  


//액션리스너를 처리함 ,엔터누르면
  public void actionPerformed(ActionEvent e){
    char c = tf.getText().charAt(0);
    tf.setText("");
    

    if(wordP.matchOne(c)==false){
      //틀린 알파벳 입력하면 -> 1worng에 추가, 2chance -- ,3drawP에서 추가
      wrongP.addw(c);//1.
      drawP.drawnext();//3.
      
      if(chanceP.missChance()==0){//2.카운트가 0이면->실패
      JOptionPane.showMessageDialog(this, "실패하셨습니다!");
      restart();//꺼진다. 또는 다시시작?? //논의 필요!
      }
    }
    else if(wordP.success()==true){
     JOptionPane.showMessageDialog(this, "성공하셨습니다!");
      restart();//꺼진다. 또는 다시시작?? //논의 필요!
    }
    else {
    	//맞는 알파벳 입력하면 
    	
    	
    }
  }
private void restart() {
	wordP.setWord("apple");
	chanceP.setChance(5);
	drawP.reset();
	wrongP.reset();
	
}

public static void main(String[] args) {
	  
	new Main();
	
	  
	  
}

}