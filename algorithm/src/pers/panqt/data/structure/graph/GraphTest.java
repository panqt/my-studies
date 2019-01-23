package pers.panqt.data.structure.graph;

import java.util.Arrays;

/**
 *  @time       2019年01月24日	3:49
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class GraphTest {
    public static void main(String[] args) {
        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Vertice D = new Vertice("D");
        Vertice E = new Vertice("E");

        Graph graph = new Graph(5);
        graph.addVertice(A);
        graph.addVertice(B);
        graph.addVertice(C);
        graph.addVertice(D);
        graph.addVertice(E);

        graph.addEdge(A,B);
        graph.addEdge(A,C);
        graph.addEdge(B,C);
        graph.addEdge(B,D);
        graph.addEdge(B,E);

        for(int[] a:graph.adjMat){
            System.out.println(Arrays.toString(a));
        }

        graph.dfs();
    }
}
