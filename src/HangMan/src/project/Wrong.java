package HangMan.src.project;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Wrong extends JPanel{
	  private JLabel wr;
	  private boolean flag[]; // 정답이 포함하는 알파벳 = true
	  private JLabel wrongLabel;

	  public Wrong() {
	    add(wrongLabel =new JLabel("Wrong: "));
	    wrongLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
	    add(wr = new JLabel()); // 처음 띄워지는 형태
	    wr.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
	    
	    flag = new boolean[26];

	  }
///#########################3
	  
	  public void addw(char c) { //라벨에 보여지는 틀린것들을 c 로 추가한다
	    flag[c-'a'] = true;
	    wr.setText(scan());
	  }

	  public String scan() { 
	    int i, len = 0;
	    int j=0;
	    String returns;
	    
	    for (i=0;i<26;i++)
	    	if(flag[i])
	    		len++; //
	    char[] ch = new char [len*2];
	    for(i=j;i<26;i++)
	    	if(flag[i]) {
	    		ch[j]=(char)('a'+i);
	    		j++;
	    		ch[j]=' ';
	    		j++;
	    	}
	    returns=new String (ch);
	    return returns;
	    	
	  }
	  
	  public void reset() {
		 wr.setText(" ");
		 for(int i =0; i< 26;i++) {
		 flag[i]=false;
			 
		 }
		  
	  }

	 
	}