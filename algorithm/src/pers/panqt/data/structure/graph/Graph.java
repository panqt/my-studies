package pers.panqt.data.structure.graph;

import pers.panqt.data.structure.Stack;

/**
 *  @time       2019年01月24日	3:44
 *	@since      V0.1
 *	@author     panqt
 *	@comment    图
 */
public class Graph {
    Vertice[] vertices;
    int currentSize;
    int[][] adjMat;//邻接矩阵

    public Graph(int size){
        vertices = new Vertice[size];
        adjMat = new int[size][size];

        for(int i=0;i<size;i++){
            adjMat[i][i]=1;
        }
    }

    public void addVertice(Vertice v){
        vertices[currentSize]  = v;
        currentSize++;
    }

    public void addEdge(Vertice vertice1,Vertice vertice2){

        int index1=0;
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]==vertice1){
                index1 = i;
            }
        }

        int index2=0;
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]==vertice2){
                index2 = i;
            }
        }

        adjMat[index1][index2]=1;
        adjMat[index2][index1]=1;
    }


    int currentIndex;
    //深度优先算法遍历
    public void dfs(){
        vertices[0].visited=true;
        Stack stack = new Stack();
        stack.push(0);

        System.out.println(vertices[0].value);

        out:while (stack.isNotEmpty()){
            for (int i=currentIndex+1;i<vertices.length;i++){
                if(adjMat[currentIndex][i]==1 && !vertices[i].visited){
                    stack.push(i);
                    vertices[i].visited = true;
                    System.out.println(vertices[i].value);
                    currentIndex = i;
                    continue out;
                }
            }

            stack.pop();
            if (stack.isNotEmpty()){
                currentIndex = stack.peek();
            }
        }
    }
}
