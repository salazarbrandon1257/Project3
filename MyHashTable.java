import java.util.Arrays;

public class MyHashTable { 
  private String[] keys;
  private int[] values;
  int m = 100;

  public MyHashTable(){
    keys = new String[m];
    values = new int[m];
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
}



  public static void main(String[] args)throws Exception { 
    MyHashTable ht = new MyHashTable(); 
    // table size is 109616
    ht.put("a", 1);
    ht.put("da", 1);
    ht.getKeys();

  } 
}

    
