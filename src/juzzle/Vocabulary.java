package juzzle;

/**
 * Created by chace on 6/7/14.
 */
public interface Vocabulary {
    boolean add(String word);
    boolean isPrefix(String word);
    boolean contains(String word);
    String getName();
}
