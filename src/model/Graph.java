package model;


public class Graph {
    private final int MAX_VERTS=20;//макс кол-во вершин
    private Vertex vertexList[];  //Массив вершин
    private int adjMat[][];     //Матрица смежности
    private int nVerts;         //Текущее кол-о вершин

    public Graph(){
        vertexList =new Vertex[MAX_VERTS];
        adjMat=new int  [MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0;k<MAX_VERTS;k++)
                adjMat[j][k]=0;
    }
    public int sizeGraph(){
        return nVerts;
    }
    public void addVertex(String lab)
    {
        vertexList[nVerts++]= new Vertex(lab);
    }
    public void addEdge(int start, int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }
    public String displayVertex(){
        String str="";
            for(int i=0;i<sizeGraph();i++)
            str+= vertexList[i].name_lab+" ";

        return str;
    }

    public String dispOneVertex(int val){
        String str="";
        str=vertexList[val].name_lab+" ";
        return str;
    }






}
