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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
        System.out.println(st);
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
    // int tableSize = 0;
    // int maxLength = 0;
    // String maxWord = "";
    MyHashTable ht = new MyHashTable(); 
    while ((st = br.readLine()) != null){
        // tableSize++; 
        // to find table size
        ht.put(st, 1);
        //if (st.length() > maxLength){
        // maxLength = st.length();
        // maxWord = st;
        //}
        // to find the word with the max length
    }
    WordPuzzle puzz = new WordPuzzle(20, ht);
    puzz.check();
    
    // table size is 109616
    // System.out.print("maxLength: ");
    // System.out.println(maxLength);
    // System.out.print("maxWord: ");
    // System.out.println(maxWord);
  } 
}
