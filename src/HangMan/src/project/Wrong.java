package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Wrong extends JPanel{
	  private JLabel wr;
	  private boolean flag[]; // ������ �����ϴ� ���ĺ� = true
	  //private char ans[]; // ������ ���� char �迭
	  //private char wrong[]; // Ʋ�� ���ڸ� ���� ���Ŀ� �°� �����ϴ� �迭
	  //private int index;

	  public Wrong() {
	    add(new JLabel("Wrong: "));
	    add(wr = new JLabel()); // ó�� ������� ����

	    flag = new boolean[26];

	    //ans = new char[answer.length()];
	    //ans = answer.toCharArray();
	  
	  //  for(int i = 0; i < answer.length(); i++) {
	    //  flag[(int)ans[i] - 97] = true; // ������ ���ĺ��� true�� üũ
	    //}

	    //wrong = new char[26];
	    //index = 1;
	  }

	  public void addw(char c) { //�󺧿� �������� Ʋ���͵��� c �� �߰��Ѵ�
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