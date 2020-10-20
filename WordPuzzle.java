import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class WordPuzzle {
  MyHashTable ht; 
  char[][] array;
  int size;

  public WordPuzzle(int inputSize, MyHashTable hTable){
    this.size = inputSize;
    array = new char[inputSize][inputSize];
    ht = hTable;
    populateArray();
  }

  public void populateArray(){
    Random r = new Random();
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        array[i][j] = (char) (r.nextInt(26) + 'a');
        System.out.print(i);
        System.out.print(",");
        System.out.print(j);
        System.out.print(":");
        System.out.print(array[i][j]);
        System.out.print(" ");
        if (j == size - 1){
          System.out.println("");
        }
      }
    }
  }

  public void check(){
    String st;
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        st = "";
        while( )
      }
    }
  }

    public static void main(String[] args)throws Exception { 
    File file = new File("C:\\Users\\Brandon Salazar\\Desktop\\dictionary.txt"); 
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    String st; 
    int tableSize = 0;
    int maxLength = 0;
    String maxWord = "";
    MyHashTable ht = new MyHashTable(); 
    while ((st = br.readLine()) != null){
        tableSize++; 
        ht.put(st, 1);
        if (st.length() > maxLength){
          maxLength = st.length();
          maxWord = st;
        }
    }
    WordPuzzle puzz = new WordPuzzle(4, ht);
    
    
    // table size is 109616
    System.out.print("Tablesize: ");
    System.out.println(tableSize);
    System.out.print("maxLength: ");
    System.out.println(maxLength);
    System.out.print("maxWord: ");
    System.out.println(maxWord);
    System.out.println(ht.contains("zebra"));
  } 
}
