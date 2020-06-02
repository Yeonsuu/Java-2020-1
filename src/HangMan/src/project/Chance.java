package HangMan.src.project;

import javax.swing.JPanel;

import javax.swing.*; // GUI ���α׷��ֿ� �ʿ��� ���� ��Ŷ �ҷ�����.


 class Chance extends JPanel{
	 
	 private JLabel ch_label;
	 private int ch_cnt;
	 
	 Chance() {  // �гο� "Chances : x)" �̶�� �ؽ�Ʈ�� �����ֱ�;
		 
		 add ( new JLabel ("Chances: ")); // �� �� ���� �гο� ������ "Chances: " �ؽ�Ʈ.
		 
		 add ( ch_label = new JLabel ()); // �ʱⰪ = null;
		 
	 }
	 
	 public void setChance (int ch_cnt) { // cnt ���� ���� �ϴ� �޼ҵ�
		 
		 this.ch_cnt = ch_cnt;
		 
		 ch_label.setText( String.valueOf(ch_cnt)); // �󺧿� ǥ��. setText �޼ҵ�� String ���� �ޱ⿡ String -> int ��ȯ
	 }
	 
	 public int missChance () { // ����ڰ� Ʋ�� ���ĺ��� �����ϸ� Chance �� 1�� �����Ѵ�. 0�� �����ϸ� ���� ����.
		 
		 ch_cnt--; // �ϳ��� ����
		 
		 ch_label.setText( String.valueOf(ch_cnt)); // ���� chance ǥ��;
		 
		 return ch_cnt;
		 
		 
	 }
 }


