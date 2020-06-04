package HangMan.src.project;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class Word extends JPanel{
	private String word;
	private int wlength;// �ܾ��� ����
	private int alength;//arr�� ����
	private JTextField tf;
	private char [] arr;//��ũ �Ǵ� ���ĺ� �����ϴ� arr
	private JLabel wordLabel;

	
	public Word() {
		//�ǳڵ� �⺻���� �ʱ�ȭ
		tf=new JTextField(12);
		tf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		add(wordLabel=new JLabel("Word: "));
		wordLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
		add(tf);
		tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.CENTER);
		
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		//���� �ܾ� ������, ��ũ ����Ʈ �ʱ�ȭ
		this.word = word; //file���� ������
		wlength = word.length();
		alength=wlength*2;
		arr=new char[alength];
		
		for(int i=0;i<alength;i++) {
			arr[i]='_';
			i++;
			arr[i]=' ';
		}
		tf.setText(new String(arr)); //������� ����!
		
		
	}
	public int getwordLength() {
		
		return wlength;
	}
	
	public boolean matchOne(char c) {
		//c�� �ܾ ���ԵǾ� �ִ��� Ȯ�� -t,f
		 boolean match = false;
		for(int i=0;i<wlength;i++) {
			if(word.charAt(i)==c) {//�ܾ��� i��° ���ڰ� c�� ������
				arr[i*2]=c; //word�� �ε��� 012345
							//arr�� �ε����� 024 6 8 10 ��

				match=true;
				}
			}
			tf.setText(new String(arr));
			
			return match;

		
	}
	
	public boolean success() {
		//�����ߴ���?
		for(int i=0;i<alength;i+=2) {
			if(arr[i]=='_')
			return false;
		//���� �ϳ��� ������ ���� ���Ѱ�
		}
			return true;
		
	}
	
	
	
	
	

}
