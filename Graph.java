package helloword.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    void  dfs2(int[][] Graph,  int node ,List<Integer> path,List<List<Integer>> paths){
        path.add(node);
        if (node==Graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
      int[] nexNodes =Graph[node];
      for (int nodeNex :nexNodes){
          dfs2(Graph,nodeNex,path,paths);
          path.remove(path.size()-1);
      }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs2(graph, 0, new ArrayList<>(), paths);
        return paths;
    }
}
