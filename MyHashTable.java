// Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class MyHashTable { 
  public static void main(String[] args)throws Exception { 
    // We need to provide file path as the parameter: 
    // double backquote is to avoid compiler interpret words 
    // like \test as \t (ie. as a escape sequence) 
    File file = new File("C:\\Users\\Brandon Salazar\\Desktop\\dictionary.txt"); 
    
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    
    String st; 
    int count = 0;
    while ((st = br.readLine()) != null){
        count++;    
    } 
    System.out.println(count);
  } 
}

    
