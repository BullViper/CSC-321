import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	/**
	 * Adds word to Trie
	 * @param word
	 * @return
	 */
	public boolean addWord(String word) {
	    TrieNode n = root, tmp;
	    for (char c : word.toCharArray()) {
	    	tmp = n.next[c];
	    	if (tmp == null) {
	    		tmp = new TrieNode(c);
	    		n.setChild(c, tmp);
	    		}
	    	n = tmp;
	      }
	    if (n.word) {
	    	return !n.word;
	    	}
	    n.word = true;
	    return n.word;
	  }
	
	/**
	 * Checks if trie contains word
	 * @param word
	 * @return
	 */
	public boolean contains(String word) {
		TrieNode n = root;
		for (char c : word.toCharArray()) {
			n = n.next[c];
			if (null == n) {
				return false;
				}
			}
		return n.word;
		}
	
	/**
	 * Checks if String pre is a prefix
	 * @param pre
	 * @return
	 */
	public boolean containsPrefix(String pre) {
		TrieNode n = root;
		for (char c : pre.toCharArray()) {
			n = n.next[c];
			if (null == n) {
				return false;
				}
			}
		return true;
	}
	
	/**
	 * Resets Trie
	 */
	public void clear() {
		root = new TrieNode('\0');
	}
	
	/**
	 * Find all words in trie and return them
	 * @return
	 */
	public List<String> asList() {
		List<String> result = new ArrayList<String>();
		for (TrieNode n : root.next) {
			if (null != n) {
	        asList(result, n.value + "", n);
	        }
		}
		return result;
	}
	/**
	 * Internal class to aid the above function
	 * @param result
	 * @param word
	 * @param n
	 */
	private void asList(List<String> result, String word, TrieNode n) {
		if (n.word) {
			result.add(word);
			}
		for (TrieNode t : n.next) {
			if (null != t) {
				asList(result, word + t.value, t);
			}
		}
	}
	/**
	 * Removes word from trie
	 * @param word
	 * @return 
	 */
	public boolean removeWord(String word) {
		Stack<TrieNode> stack = new Stack<TrieNode>();
	    TrieNode n = root;
	    stack.add(n);
	    for (char c : word.toCharArray()) {
	    	n = n.next[c];
	    	if (null == n){
	        return false;
	        }
	    	stack.add(n);
	    }
	    if (!n.word){
	    	return false;
	    }
	    n.word = false;
	    if (!n.nextIsEmpty()){
	      return true;
	    }
	    stack.pop();
	    n = stack.pop();
	    while (!stack.isEmpty() && n.nextSize() == 1) {
	    	n.clearNext();
	    	if (n.word) {
	    		return true;
	    	}
	    	n = stack.pop();
	    }
	    return true;
	}
}


/**
 * Internal Class for defining nodes
 * @author Austin Fillipi
 * @param char to set what character the node represents
 */

class TrieNode{
	public char value;
    boolean word;
    TrieNode[] next =new TrieNode[26];
    private int nextLength = 0;
    
    public TrieNode(char c) {
    	value=c;
    }
    void setChild(char c, TrieNode node){
    	next[c]=node;
    }
    void clearNext() {
        next = new TrieNode[256];
        nextLength = 0;
    }
    boolean nextIsEmpty(){
    	return nextLength == 0;
    }
    int nextSize(){
        return nextLength;
    }
}