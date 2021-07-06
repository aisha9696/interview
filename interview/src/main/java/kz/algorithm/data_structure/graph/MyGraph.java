package kz.algorithm.data_structure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MyGraph {
    private final HashMap<Integer, MyNode> nodeList = new HashMap<>();

    public static class MyNode{
        private final int vertex;
        private final LinkedList<MyNode> adjacent = new LinkedList<>();

        public MyNode(int vertex, Object o) {
            this.vertex = vertex;
        }
    }

    private MyNode getNode(int vertex){
        return nodeList.get(vertex);
    }

    private void addEdge(int source, int destination){
        MyNode sourceNode = getNode(source);
        MyNode destinationNode = getNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

    private boolean hasPathDFS(int source, int destination){
        MyNode sourceNode = getNode(source);
        MyNode destinationNode = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceNode, destinationNode, visited);
    }
    private boolean hasPathDFS(MyNode s, MyNode d, HashSet<Integer> visited){
        if(visited.contains(s.vertex)){
            return false;
        }
        visited.add(s.vertex);
        if(s == d){
            return true;
        }
        for(MyNode child: s.adjacent){
            if(hasPathDFS(child,d, visited)){
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean hasPathBFS(int source, int destination){
        MyNode sourceNode = getNode(source);
        MyNode destinationNode = getNode(destination);
        LinkedList<MyNode> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(sourceNode);
        while (!nextToVisit.isEmpty()){
            MyNode node = nextToVisit.remove();
            if(node == destinationNode){
                return true;
            }

            if(visited.contains(node.vertex)){
                continue;
            }
            visited.add(node.vertex);

            for(MyNode child : node.adjacent){
                nextToVisit.add(child);
            }

        }
        return false;
    }

    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph();
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,6);
        myGraph.addEdge(0,5);
        myGraph.addEdge(6,4);
        myGraph.addEdge(4,3);
        myGraph.addEdge(4,5);
        myGraph.addEdge(3,5);
        System.out.println(myGraph.hasPathDFS(4,1));

    }

}
