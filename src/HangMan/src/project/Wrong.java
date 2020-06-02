package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Wrong extends JPanel{
	  private JLabel wr;
	  private boolean flag[]; // 정답이 포함하는 알파벳 = true
	  //private char ans[]; // 정답을 갖는 char 배열
	  //private char wrong[]; // 틀린 글자를 일정 형식에 맞게 보관하는 배열
	  //private int index;

	  public Wrong() {
	    add(new JLabel("Wrong: "));
	    add(wr = new JLabel()); // 처음 띄워지는 형태

	    flag = new boolean[26];

	    //ans = new char[answer.length()];
	    //ans = answer.toCharArray();
	  
	  //  for(int i = 0; i < answer.length(); i++) {
	    //  flag[(int)ans[i] - 97] = true; // 정답인 알파벳을 true로 체크
	    //}

	    //wrong = new char[26];
	    //index = 1;
	  }

	  public void addw(char c) { //라벨에 보여지는 틀린것들을 c 로 추가한다
	    flag[c-'a'] = true;
	    wr.setText(scan());
	  }

	  public String scan() { 
	    int i, len = 0;
	    int j=0;
	    String returns;
	    
	    for (i=0;i<26;i++)
	    	if(flag[i]==true)
	    		len++;
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