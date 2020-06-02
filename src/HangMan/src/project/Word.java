package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Word extends JPanel{
	private String word;
	private int length;
	private JTextField tf;
	private char [] arr;//��ũ �Ǵ� ���ĺ� �����ϴ� arr
	
	public Word() {
		//�ǳڵ� �⺻���� �ʱ�ȭ
		tf=new JTextField(10);
		add(new JLabel("Word: "));
		add(tf);
		tf.setEditable(false);
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		//���� �ܾ� ������, ��ũ ����Ʈ �ʱ�ȭ
		this.word = word; //file���� ������
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
		//c�� �ܾ ���ԵǾ� �ִ��� Ȯ�� -t,f
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
		//�����ߴ���?
		for(int i=0;i<length;i++) {
			if(arr[i]=='_')
			return false;
		//
		}
			return true;
		
	}
	
	
	
	
	

}
