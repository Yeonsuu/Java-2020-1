package HangMan.src.project;
import java.io.*;
import java.util.Random;
  
  public class File{
	  
	  private String [] fword;
	  private Random rd;
	  private int len;//�ܾ��� ����
	  
	  
	  public File(String fname){
		  fword = new String[100];
		  rd= new Random();
		  try{
		    BufferedReader br = new BufferedReader(new FileReader(fname));
		    int i;
		    for( i =0;i<100;i++){
		      fword[i]=br.readLine();//�������پ� �о� �迭����
		      if( fword[i]==null)break;

		    }
		    len=i;//�ܾ��� ������ i��
		    br.close();//����
		  }
		  catch(IOException e){
		    System.out.println("IOExceptrion!!!!!!!!!!");


		  }
		  
		  

		}
		  public String getFword(){
		    return fword[rd.nextInt(fword.length)];
		    //int�� n�̸� �����߻����Ѽ�
		  }
			
			
	  
	  
  }


