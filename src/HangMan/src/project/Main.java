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
  private File file;

  //생성자 - 프레임등 gui setting
  public Main(){
	  Container c = this.getContentPane();
	  
	  setSize(1000,550);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setTitle("GGang Man");
	  
	  wordP = new Word();
	  chanceP= new Chance();
	  
	  JPanel enter = new JPanel();
	  JLabel label = new JLabel("Guess ");
	  label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
	  enter.add(label);
	  enter.add(tf = new JTextField(1));
	  tf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
	  tf.addActionListener(this);
	  
	  JPanel whole = new JPanel();
	  whole.setLayout(new GridLayout(4,1));
	  whole.add(wordP);
	  whole.add(enter);
	  wrongP = new Wrong();
	  whole.add(wrongP);
	  whole.add(chanceP);
	  
	  getContentPane().setLayout(new BoxLayout(c,BoxLayout.X_AXIS ));
	  getContentPane().add(whole);
	  drawP = new Draw();
	  getContentPane().add(drawP);
	  drawP.setLayout(null);
	  
	  JLabel hwa = new JLabel("화려한 조명이 나를 감싸네");
	  hwa.setFont(new Font("굴림", Font.BOLD, 15));
	  hwa.setBounds(107, 448, 206, 15);
	  drawP.add(hwa);
	  
	  whole.setBorder(new LineBorder(Color.BLUE,4,true));
	  whole.setPreferredSize(new Dimension(150,400));

	
	  
	  setVisible(true);
	  
	  file= new File("src/HangMan/src/project/word.txt");//IO 객체 생성
	  wordP.setWord(file.getFword());//IO!!!!!!!!
	  chanceP.setChance(6);// 기회6번
	  
	
  }
  


//액션리스너를 처리함 ,엔터누르면
  public void actionPerformed(ActionEvent e){
    char c = tf.getText().charAt(0);
    tf.setText("");
    

    if(wordP.matchOne(c)==false){
      //틀린 알파벳 입력하면 -> 1worng에 추가, 2chance -- ,3drawP에서 추가
      wrongP.addw(c);//1.
      drawP.drawnext();//3.
      repaint();
      
      if(chanceP.missChance()==0){//2.카운트가 0이면->실패
      JOptionPane.showMessageDialog(this, "You failed!"+"\n Answer: "+ wordP.getWord());
      restart();//꺼진다. 또는 다시시작?? //논의 필요!
      }
    }
    else if(wordP.success()==true){
     JOptionPane.showMessageDialog(this, "Success! "+"\n Answer: "+wordP.getWord());
      restart();//꺼진다. 또는 다시시작?? //논의 필요!
    }
   
  }
private void restart() {
	wordP.setWord(file.getFword());
	chanceP.setChance(6);
	drawP.reset();
	wrongP.reset();
	
}

public static void main(String[] args) {
	  
	new Main();
	
	  
	  
}

}
