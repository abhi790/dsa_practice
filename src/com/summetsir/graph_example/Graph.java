package com.summetsir.graph_example;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> graph;

    //create a graph of 5 size by default
    Graph(){
        graph = new ArrayList<ArrayList<Integer>>(5);
        for(int i = 0; i < 5; i++){
            graph.add(new ArrayList<>());
        }
    }
    //crate a graph of specific size provided
    Graph(int size){
        graph = new ArrayList<ArrayList<Integer>>(size);
        for(int i = 0; i < size; i++){
            graph.add(new ArrayList<>());
        }
    }
    //Printing graph method overloaded for more general purpose
    public void printGraph(){
      for(int i=0; i < graph.size(); i++){
          System.out.print(i + "|->");
          for(int j= 0; j < graph.get(i).size(); j++){
              if( j == graph.get(i).size() - 1){
                  System.out.println(graph.get(i).get(j));
              }
              else
                System.out.print(graph.get(i).get(j) + "->");
          }

      }
  }
    public void printGraph(ArrayList<ArrayList<Integer>> graph){
        for(int i=0; i < graph.size(); i++){
            System.out.print(i + "->");
            for(int j= 0; j < graph.get(i).size(); j++){
                if( j == graph.get(i).size() - 1){
                    System.out.println(graph.get(i).get(j));
                }
                else
                    System.out.print(graph.get(i).get(j) + "->");
            }

        }
    }

    //Add edges to graph
    public void addEdge(int u, int v){
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    public void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    //
}
