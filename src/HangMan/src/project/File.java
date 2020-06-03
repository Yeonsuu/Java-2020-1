package HangMan.src.project;
import java.io.*;
import java.util.Random;
  
  public class File{
	  
	  private String [] fword;//���پ� ����
	  private Random rd;
	  private int wordNum;//�ܾ��� ����
	  
	  
	  public File(String fname){
		  fword = new String[100];
		  rd= new Random();
		  
		  try{
		    BufferedReader br = new BufferedReader(new FileReader(fname));
		    int i;
		    for( i =0;i<100;i++){
		      fword[i]=br.readLine();//�������پ� �о� �迭����
		      if(fword[i]==null) 
		    	  break;

		    }
		    wordNum=i;//�ܾ��� ������ i��
		    br.close();//����
		  }
		  catch(IOException e){
		    System.out.println("IOException!!!!!!!!!!"+e.getMessage());
		    //e.printStackTrace();
		    System.exit(0);


		  }
		  
		  

		}
		  public String getFword(){
		    return fword[rd.nextInt(wordNum)];
		    //int�� n�̸� �����߻����Ѽ�
		  }
			
			
	  
	  
  }


