import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class WordPuzzle {
  MyHashTable ht; 
  MyHashTable prefixHt;
  char[][] array;
  int size;

  public WordPuzzle(int inputSize, MyHashTable hTable, MyHashTable prefixTable){
    this.size = inputSize;
    array = new char[inputSize][inputSize];
    ht = hTable;
    prefixHt = prefixTable;
    populateArray();
  }

  public void populateArray(){
    Random r = new Random();
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        array[i][j] = (char) (r.nextInt(26) + 'a');
        System.out.print(array[i][j]);
        System.out.print(" ");
        if (j == size - 1){
          System.out.println("");
        }
      }
    }
  }

  public void rightCheck(char[][] arr, int i, int j){
    String st = "";
    int k = j;
    while(k < size && st.length() < 29){
      st += arr[i][k];
      k++;
      if (ht.contains(st)){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  public void leftCheck(char[][] arr, int i, int j){
    String st = "";
    int k = j;
    while(k > -1 && st.length() < 29){
      st += arr[i][k];
      k--;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }

    }
  }
  public void downCheck(char[][] arr, int i, int j){
    String st = "";
    int k = i;
    while(k < size && st.length() < 29){
      st += arr[k][j];
      k++;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  public void upCheck(char[][] arr, int i, int j){
    String st = "";
    int k = i;
    while(k > -1 && st.length() < 29){
      st += arr[k][j];
      k--;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  
  public void downRightCheck(char[][] arr, int i, int j){
    String st = "";
    int l = i;
    int k = j;
    while(k < size && l < size && st.length() < 29){
      st += arr[l][k];
      k++;
      l++;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  public void upRightCheck(char[][] arr, int i, int j){
    String st = "";
    int l = i;
    int k = j;
    while(k < size && l > -1 && st.length() < 29){
      st += arr[l][k];
      k++;
      l--;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  public void downLeftCheck(char[][] arr, int i, int j){
    String st = "";
    int l = i;
    int k = j;
    while(k > -1 && l < size && st.length() < 29){
      st += arr[l][k];
      k--;
      l++;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }
  public void upLeftCheck(char[][] arr, int i, int j){
    String st = "";
    int l = i;
    int k = j;
    while(l > -1 && k > -1 && st.length() < 29){
      st += arr[l][k];
      k--;
      l--;
      if (ht.contains(st) && st.length()!= 1){
        System.out.print(st + ", ");
      }
      if (prefixHt.size() > 0){
        if (!prefixHt.contains(st)){
          break;
        }
      }
    }
  }

  public void check(){
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        rightCheck(array, i, j);
        leftCheck(array, i, j);
        upCheck(array, i, j);
        downCheck(array, i, j);

        downRightCheck(array, i, j);
        upRightCheck(array, i, j);
        upLeftCheck(array, i, j);
        downLeftCheck(array, i, j);
      }
    }
  }

    public static void main(String[] args)throws Exception { 
    File file = new File("C:\\Users\\Brandon Salazar\\Desktop\\dictionary.txt"); 
    BufferedReader br = new BufferedReader(new FileReader(file)); 
    String st; 
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Input a value for the table size(Integer < 20): ");
    String userInput = myObj.nextLine();  // Read user input
    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Use enhancement? (Y/N): ");
    String userInput2 = myObj2.nextLine();  // Read user input

    MyHashTable ht = new MyHashTable(); 
    MyHashTable prefixTable = new MyHashTable();
    if (userInput2.equals("Y") || userInput2.equals("y") ){
      prefixTable.setTableSize(prefixTable.getTableSize() * 2);
    }
    // table size is 109616
    // prefix tableSize is 1023085
    Instant start = Instant.now();

    while ((st = br.readLine()) != null){
        if (userInput2.equals("Y") || userInput2.equals("y") ){
          for(int i = 0; i < st.length() - 1; i++){
            prefixTable.put(st.substring(0, i), 1);
          }
        }
        ht.put(st, 1);
    }
    WordPuzzle puzz = new WordPuzzle(Integer.valueOf(userInput), ht, prefixTable);
    puzz.check();
     
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    System.out.println("");
    System.out.println(timeElapsed);
  } 
}
