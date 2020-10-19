import java.io.*; 

public class WordPuzzle {
  String[][] array;
  int size;

  public WordPuzzle(int inputSize){
    this.size = inputSize;
    array = new String[inputSize][inputSize];
    populateArray();
  }

  public void populateArray(){
  }

  public void check(){
  }


    public static void main(String[] args)throws Exception { 
    File file = new File("C:\\Users\\Brandon Salazar\\Desktop\\dictionary.txt"); 
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    String st; 
    int tableSize = 0;
    int maxLength = 0;
    String maxWord = "";
    MyHashTable ht = new MyHashTable(); 
    WordPuzzle puzz = new WordPuzzle(4);

    while ((st = br.readLine()) != null){
        tableSize++; 
        ht.put(st, 1);
        if (st.length() > maxLength){
          maxLength = st.length();
          maxWord = st;
        }
    } 
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
