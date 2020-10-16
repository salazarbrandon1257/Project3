import java.io.*; 
public class WordPuzzle {
    public static void main(String[] args)throws Exception { 
    File file = new File("C:\\Users\\Brandon Salazar\\Desktop\\dictionary.txt"); 
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    String st; 
    int tableSize = 0;
    while ((st = br.readLine()) != null && tableSize < 10){
        tableSize++; 
        System.out.println(st);  
    } 
    // table size is 109616
    System.out.print("Tablesize: ");
    System.out.println(tableSize);
  } 
}
