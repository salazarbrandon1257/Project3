// Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class MyHashTable { 

  public static int hash(String key, int tableSize)
{
    int hashVal = 0;

    for (int i = 0; i < key.length(); i++)
         hashVal = 7 * hashVal + key.charAt(i);

    hashVal %= tableSize;
    if (hashVal < 0)
         hashVal += tableSize;

    return hashVal;
}
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
    System.out.println(hash("abc", 10000));
  } 
}

    
