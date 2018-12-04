package model;

import java.util.ArrayList;

public class AdapterGraph implements GraphInterface {


    public Graph graph;
    public  int MAX_VERTS=20;

    public int sizeGraph() {
        return this.graph.sizeGraph();
    }

    public void addVertex(String lab) {
        graph.addVertex(lab);
    }


    public ArrayList<String> display() {
        ArrayList<String> arr = new ArrayList<>(MAX_VERTS);
        String[] subStr;
        String delimeter = " ";
        subStr = graph.displayVertex().split(delimeter);

        for (int i = 0; i < subStr.length; i++) {
            arr.add(String.valueOf(subStr[i]));
        }
        return arr;
    }
}
