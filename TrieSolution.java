import java.util.Map;
import java.util.HashMap;

class Trie {

    Map<Character, Trie> nodes;
    /** Initialize your data structure here. */
    public Trie() {
        nodes = new HashMap<Character, Trie>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {


        Trie temporary = this; // A Temporary trie to traverse through the existing trie
        for (int i = 0; i < word.length(); i++) {
            if (temporary.nodes.containsKey(word.charAt(i))) {
                temporary = temporary.nodes.get(word.charAt(i));
            } else {
                temporary.nodes.put(word.charAt(i), new Trie());
                temporary = temporary.nodes.get(word.charAt(i));
            }
        }
        temporary.nodes.put('.', new Trie());
    }

     /** Returns if the word is in the trie. */
     public boolean search(String word) {
        
        Trie temporary = this;

        for (int i = 0; i < word.length(); i++) {

            if(!temporary.nodes.containsKey(word.charAt(i))){
                return false;
            }
            temporary = temporary.nodes.get(word.charAt(i));
        }
        if(temporary.nodes.containsKey('.')){
            return true;
        }
        else{
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given
    prefix. */
    public boolean startsWith(String prefix) {

        Trie temporary = this;

        for (int i = 0; i < prefix.length(); i++) {

            if(!temporary.nodes.containsKey(prefix.charAt(i))){
                return false;
            }
            temporary = temporary.nodes.get(prefix.charAt(i));
        }
    
        return true;
    }

}

public class TrieSolution {

    public static void main(final String[] args) {
        Trie test = new Trie();
        test.insert("karan");
        System.out.println(test.search("karan"));
        System.out.println(test.startsWith("karan"));
    }

}