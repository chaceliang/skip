package edocteel.recursion;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by chace on 5/16/14.
 */
public class WordLadderII {

    public ArrayList<ArrayList<String>> findLaders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        if (start == null || end == null) {
            return paths;
        }

        Map<String, ArrayList<Node>> visited = new HashMap<String, ArrayList<Node>>();

        getMinLenth(start, end, dict, visited);
        buildPaths(end, start, visited, new LinkedList<String>(), paths);
        return paths;
    }

    private void getMinLenth(String start, String end, HashSet<String> dict, Map<String, ArrayList<Node>> visited) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, 1));
        dict.add(end);
        int lastLevel = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (lastLevel > 0 && node.depth >= lastLevel) {
                break;
            }
            for (int i = 0; i < node.word.length(); i++) {
                StringBuilder builder = new StringBuilder(node.word);
                char original = builder.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) {
                        continue;
                    }
                    builder.setCharAt(i, c);
                    String next = builder.toString();
                    if (next.equals(end)) {
                        if (lastLevel == 0) {
                            lastLevel = node.depth + 1;
                        }
                    }
                    if (dict.contains(next) && !next.equals(start)) {
                        ArrayList<Node> pres = visited.get(next);
                        if (pres == null) {
                            queue.add(new Node(next, node.depth+1));
                            pres = new ArrayList<Node>();
                            pres.add(node);
                            visited.put(next, pres);
                        } else if (pres.get(0).depth == node.depth) {
                            pres.add(node);
                        }
                    }
                }
            }
        }
    }

    private void buildPaths(String s, String start, Map<String, ArrayList<Node>> visited, LinkedList<String> path, ArrayList<ArrayList<String>> paths) {
        if (s == null || visited == null || path == null || paths == null) {
            return;
        }
        path.add(0, s);
        if (s.equals(start)) {
            ArrayList<String> p = new ArrayList<String>(path);
            paths.add(p);
        } else {
            ArrayList<Node> pres = visited.get(s);
            if (pres != null) {
                for (Node pre : pres) {
                    buildPaths(pre.word, start, visited, path, paths);
                }
            }
        }
        path.remove(0);
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] d = {"hot","dot","dog","lot","log"};
        HashSet<String> dict = new HashSet<String>();
        for (String s : d) {
            dict.add(s);
        }

        WordLadderII test = new WordLadderII();
        test.findLaders(start, end, dict);

    }

    public ArrayList<ArrayList<String>> findLadders2(String start, String end, HashSet<String> dict) {
        HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> level = new HashMap<String, Integer>();
        LinkedList<String> queue = new LinkedList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if(start == null || end == null || start.length() != end.length()) return result;

        HashSet<String> path = new HashSet<String>();
        int minLen = Integer.MAX_VALUE;
        visited.put(start, path);//only difference from word ladder I
        level.put(start, 1);
        queue.add(start);

        while (!queue.isEmpty()) {
            String head = queue.poll();
            char[] chars = head.toCharArray();
            for (int i = 0; i < head.length(); i++) {
                char old = chars[i];
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    chars[i] = letter;
                    String nextWord = new String(chars);
                    //two possible situations
                    //level does not contain nextWord
                    //level contains nextWord and near the start
                    if (dict.contains(nextWord) && (!level.containsKey(nextWord) || (level.containsKey(nextWord) && level.get(nextWord) > level.get(head)))){
                        //we update the path, visited, level
                        if (visited.containsKey(nextWord)) {
                            visited.get(nextWord).add(head);
                        } else {
                            path = new HashSet<String>();
                            path.add(head);
                            visited.put(nextWord, path);
                            level.put(nextWord, level.get(head) + 1);
                            queue.add(nextWord);
                        }
                    }

                    if (nextWord.equals(end)) {
                        if (level.get(head) < minLen) {
                            ArrayList<String> entry = new ArrayList<String>();
                            entry.add(end);
                            result.addAll(backtrace(head,visited,entry));
                            minLen = level.get(head)+1;
                        } else {
                            break;
                        }
                    }
                    chars[i] = old;

                }
            }
        }
        return result;
    }

    private ArrayList<ArrayList<String>> backtrace(String end, HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> entry = new ArrayList<String>(path);
        entry.add(0,end);
        if(visited.get(end).size()<1){
            result.add(entry);
            return result;
        }

        for(String str : visited.get(end)){
            result.addAll(backtrace(str,visited,entry));
        }
        return result;
    }
}

class Node {
    String word;
    int depth;
    public Node(String w, int d) {
        word = w;
        depth = d;
    }
}