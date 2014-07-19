package edocteel.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chace on 5/16/14.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, result);

        while (!queue.isEmpty()) {
            UndirectedGraphNode nodeInQueue = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = nodeInQueue.neighbors;
            for (UndirectedGraphNode neighbor : neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(nodeInQueue).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode clone = new UndirectedGraphNode(neighbor.label);
                    map.get(nodeInQueue).neighbors.add(clone);
                    map.put(neighbor, clone);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}