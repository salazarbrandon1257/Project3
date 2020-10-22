import java.util.Arrays;

public class MyHashTable { 
  private String[] keys;
  private int[] values;
  private int m; // size of table, since the table size is 109,616 then I will set the table size to (4/3) * 109,616
  private int n; // number of key-value pairs in the symbol table

  public MyHashTable(){
    n = 0;
    m = 146155; 
    keys = new String[m];
    values = new int[m];
  }
  public void setTableSize(int k){
    this.m = k;
    this.keys = new String[k];
    this.values = new int[k];
  }
  public int getTableSize(){
    return m;
  }

  public int get(String key){
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m){
        if (keys[i].equals(key)){
            return values[i];
        }
    }
    return -1;
  }

  public boolean contains(String key){
    return get(key) != -1;
  }

  public int size(){
    return n;
  }
  public boolean isEmpty(){
    return n == 0;
  }

  public void getKeys(){
    System.out.println(Arrays.toString(keys));
  }
  private int hash(String key){
    return hash(key, m);
  }

  // used horners rule to hash the strings
  public static int hash(String key, int tableSize){
    int hashVal = 0;
    for (int i = 0; i < key.length(); i++){hashVal = 7 * hashVal + key.charAt(i);}
    hashVal %= tableSize;
    if (hashVal < 0){hashVal += tableSize;}
    return hashVal;
  }

  public void put(String key,int val) {
    // double table size if 50% full
    // if (n >= m/2) resize(2*m);
    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
        if (keys[i].equals(key)) {
            values[i] = val;
            return;
        }
    }
    keys[i] = key;
    values[i] = val;
    n++;
}



  public static void main(String[] args)throws Exception { 
  } 
}

    
