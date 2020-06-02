package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Word extends JPanel{
	private String word;
	private int length;
	private JTextField tf;
	private char [] arr;//블랭크 또는 알파벳 저장하는 arr
	
	public Word() {
		//판넬등 기본정보 초기화
		tf=new JTextField(10);
		add(new JLabel("Word: "));
		add(tf);
		tf.setEditable(false);
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		//맞출 단어 보내기, 블랭크 프린트 초기화
		this.word = word; //file에서 가져옴
		length = word.length();
		arr=new char[length];
		
		for(int i=0;i<length;i++) {
			arr[i]='_';
			arr[i+1]=' ';
		}
		
		
	}
	public int getLength() {
		
		return length;
	}
	
	public boolean matchOne(char c) {
		//c가 단어에 포함되어 있는지 확인 -t,f
		 boolean match = false;
		for(int i=0;i<length;i++) {
			if(word.charAt(i)==c) {
				arr[i]=c;
				match=true;
				}
			}
			tf.setText(new String(arr));
			
			return match;

		
	}
	
	public boolean success() {
		//성공했는지?
		for(int i=0;i<length;i++) {
			if(arr[i]=='_')
			return false;
		//
		}
			return true;
		
	}
	
	
	
	
	

}
