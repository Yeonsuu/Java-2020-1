package HangMan.src.project;
import java.io.*;
import java.util.Random;
  
  public class File{
	  
	  private String [] fword;//한줄씩 저장
	  private Random rd;
	  private int wordNum;//단어의 개수
	  
	  
	  public File(String fname){
		  fword = new String[100];
		  rd= new Random();
		  
		  try{
		    BufferedReader br = new BufferedReader(new FileReader(fname));
		    int i;
		    for( i =0;i<100;i++){
		      fword[i]=br.readLine();//파일한줄씩 읽어 배열저장
		      if(fword[i]==null) 
		    	  break;

		    }
		    wordNum=i;//단어의 개수는 i개
		    br.close();//저장
		  }
		  catch(IOException e){
		    System.out.println("IOException!!!!!!!!!!"+e.getMessage());
		    //e.printStackTrace();
		    System.exit(0);


		  }
		  
		  

		}
		  public String getFword(){
		    return fword[rd.nextInt(wordNum)];
		    //int형 n미만 난수발생시켜서
		  }
			
			
	  
	  
  }


