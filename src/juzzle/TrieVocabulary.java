package juzzle;

import java.util.Collection;

/**
 * Created by chace on 6/7/14.
 */
public class TrieVocabulary implements Vocabulary {

    private boolean isWord = false;
    private TrieVocabulary[] children = new TrieVocabulary[Alphabet.LOWERCASE.size()];
    private int numChildren = 0;

    public TrieVocabulary() {

    }

    public TrieVocabulary(Collection<String> words) {
        for (String w : words) {
            add(w);
        }
    }

    @Override
    public boolean add(String word) {
        char first = word.charAt(0);
        int index = Alphabet.LOWERCASE.getIndex(first);
        if (index < 0) {
            System.out.println("uf");
        }
        TrieVocabulary child = children[index];
        if (child == null) {
            child = new TrieVocabulary();
            children[index] = child;
            numChildren++;
        }
        if (word.length() == 1) {
            if (child.isWord) {
                return false;
            }
            child.isWord = true;
            return true;
        } else {
            return child.add(word.substring(1));
        }
    }

    @Override
    public boolean isPrefix(String word) {
        TrieVocabulary n = getNode(word);
        return n != null && n.numChildren > 0;
    }

    @Override
    public boolean contains(String word) {
        TrieVocabulary n = getNode(word);
        return n != null && n.isWord;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

    public TrieVocabulary getNode(String s) {
        TrieVocabulary node = this;
        for (int i = 0; i < s.length(); i++) {
            int index = Alphabet.LOWERCASE.getIndex(s.charAt(i));
            TrieVocabulary child = node.children[index];
            if (child == null) {
                return null;
            }
            node = child;
        }
        return node;
    }

    public boolean hasChildren() {
        return numChildren > 0;
    }
}
