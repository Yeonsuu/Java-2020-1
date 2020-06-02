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

  //생성자 - 프레임등 gui setting
  public Main(){
  	getContentPane().setBackground(Color.RED);
  	setBackground(Color.YELLOW);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100 , 100 , 300 , 200);

 
	  
	  contentPane.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	  
	  
	  Dimension dim = new Dimension(1900,600);
	  setPreferredSize(dim);
	   
  	
    setTitle("HangMan");
    setSize(900,600);//미정
    setVisible(true);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
    
    ////////////
    wordP= new Word();
	   //enterP = new Enter();
	   chanceP= new Chance();
	   drawP = new Draw();
	   wrongP = new Wrong(); //각 클래스 객체생성

	   wordP.setWord(wordP.getWord());//여기에 단어 설정
	   chanceP.setChance(5);//기회5개
	   
	  JPanel whole = new JPanel();// word,맞추기,틀린것,찬스
	  whole.setLayout(new GridLayout(4,1));
	  whole.add(wordP);
	  JPanel enter= new JPanel();
	  enter.add(new JLabel ("Guess alphabet: "));
	  enter.add(tf= new JTextField(1));
	  
	  whole.add(enter);
	  
	  tf.addActionListener(this);//수신자
	  whole.add(wrongP);
	  whole.add(chanceP);
	  
	

	  
	  getContentPane().add(drawP= new Draw());
	  getContentPane().add(whole);
	  //확인하기....ㅡㅡ
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
    







//액션리스너를 처리함 ,엔터누르면
  public void actionPerformed(ActionEvent e){
    char c = tf.getText().charAt(0);
    tf.setText(" ");

    if(!wordP.matchOne(c)){
      //틀린 알파벳 입력하면 -> 1worng에 추가, 2chance -- ,3drawP에서 추가
      wrongP.addw(c);//1.
      drawP.drawnext();//3.
      if(chanceP.missChance()==0){//2.카운트가 0이면
      JOptionPane.showMessageDialog(this, "실패하셨습니다!");
      //reset();//꺼진다. 또는 다시시작?? //논의 필요!
      }
    }
    else if(wordP.success()){
     JOptionPane.showMessageDialog(this, "성공하셨습니다!");
      //reset();//꺼진다. 또는 다시시작?? //논의 필요!
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