package HangMan.src.project;

import javax.swing.JPanel;

import javax.swing.*; // GUI 프로그래밍에 필요한 개발 툴킷 불러오기.


 class Chance extends JPanel{
	 
	 private JLabel ch_label;
	 private int ch_cnt;
	 
	 Chance() {  // 패널에 "Chances : x)" 이라는 텍스트를 보여주기;
		 
		 add ( new JLabel ("Chances: ")); // 맨 밑 게임 패널에 보여줄 "Chances: " 텍스트.
		 
		 add ( ch_label = new JLabel ()); // 초기값 = null;
		 
	 }
	 
	 public void setChance (int ch_cnt) { // cnt 값을 설정 하는 메소드
		 
		 this.ch_cnt = ch_cnt;
		 
		 ch_label.setText( String.valueOf(ch_cnt)); // 라벨에 표시. setText 메소드는 String 값을 받기에 String -> int 변환
	 }
	 
	 public int missChance () { // 사용자가 틀린 알파벳을 제시하면 Chance 가 1씩 감소한다. 0에 도달하면 게임 종료.
		 
		 ch_cnt--; // 하나씩 감소
		 
		 ch_label.setText( String.valueOf(ch_cnt)); // 남은 chance 표시;
		 
		 return ch_cnt;
		 
		 
	 }
 }


