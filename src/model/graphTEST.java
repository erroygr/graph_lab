package model;

public class graphTEST {

    public static void main(String[] args){
        Graph theGraph=new Graph();
        theGraph.addVertex("ji");
        theGraph.addVertex("B");
        theGraph.addVertex("C");
        theGraph.addVertex("D");
        theGraph.addVertex("E");

        /*theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);*/

      //  for(int i=0; i<theGraph.sizeGraph();i++)
        System.out.println("Вершины:  "+theGraph.displayVertex());
    }
}
