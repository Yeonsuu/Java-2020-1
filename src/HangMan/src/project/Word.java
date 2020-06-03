package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Word extends JPanel{
	private String word;
	private int wlength;
	private JTextField tf;
	private char [] arr;//블랭크 또는 알파벳 저장하는 arr
	private int alength;
	
	public Word() {
		//판넬등 기본정보 초기화
		tf=new JTextField(20);
		add(new JLabel("Word: "));
		add(tf);
		tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.CENTER);
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		//맞출 단어 보내기, 블랭크 프린트 초기화
		this.word = word; //file에서 가져옴
		wlength = word.length();
		alength=wlength*2;
		arr=new char[alength];
		
		for(int i=0;i<alength;i++) {
			arr[i]='_';
			i++;
			arr[i]=' ';
		}
		tf.setText(new String(arr)); //여기까진 성공!
		
		
	}
	public int getwordLength() {
		
		return wlength;
	}
	
	public boolean matchOne(char c) {
		//c가 단어에 포함되어 있는지 확인 -t,f
		 boolean match = false;
		for(int i=0;i<wlength;i++) {
			if(word.charAt(i)==c) {//단어의 i번째 문자가 c와 같으면
				arr[i*2]=c; //word의 인덱스 012345
							//arr의 인덱스는 024 6 8 10 임

				match=true;
				}
			}
			tf.setText(new String(arr));
			
			return match;

		
	}
	
	public boolean success() {
		//성공했는지?
		for(int i=0;i<alength;i+=2) {
			if(arr[i]=='_')
			return false;
		//밑줄 하나라도 있으면 성공 못한것
		}
			return true;
		
	}
	
	
	
	
	

}
