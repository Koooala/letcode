
import java.util.*;

public class Graph {
    List<Node> nodes;
    List<Edge> edges;
    public static void main(String[] args) {
        System.out.println("Hello Graph!");
    }

    public  static  void  BFS (Node node){
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> set =new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
          Node cur= queue.poll();
          // do something
            System.out.println(cur.val);
            for (Node next:cur.next){
                if (!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }

    }
    public  static  void  DFS (Node node){
        Stack<Node> stack =new Stack<>()
        HashSet<Node> set =new HashSet<>();
        stack.push(node);
        set.add(node);
        while (!stack.empty()){
            Node cur= stack.pop();
            for (Node next:cur.next){
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    // do something
                    System.out.println(cur.val);
                    set.add(cur);
                    break;
                }
            }
        }

    }
    public  static  void  TopologySort (Graph g ){
     // 1:找到入度为0的点，将其点和边的影响（对其他点的入度）擦掉，继续找入度为0的点
        // code todo
    }

    public static  Set<Edge>  prim (Graph graph){
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(); // TODO 定义比较器 生成小根堆
        HashSet<Node> set=new HashSet<>();
        Set<Edge> res =new HashSet<>();

        for (Node node:graph.nodes){ // for 循环处理图不连通 生成森林
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge:node.edges){
                    priorityQueue.add(edge);
                    while (!priorityQueue.isEmpty()){
                        Edge e =priorityQueue.poll();
                        Node toNode =e.to;
                        if (!set.contains(toNode)){
                            set.add(toNode);
                            res.add(edge);
                            for (Edge toEdge:toNode.edges){
                                priorityQueue.add(toEdge);
                            }
                        }
                    }
                }
            }
        }
        return  res;
    }

    // 迪杰斯特拉
    public static  HashMap<Node,Integer> dijkstra (Node head){
        HashMap<Node,Integer> distanceMap=new HashMap<>();
        HashSet<Node> selectNodes =new HashSet<>();
        distanceMap.put(head,0);
        Node minNode =getUnsedNode(distanceMap,selectNodes);
        while (minNode!=null){
            int dis =distanceMap.get(minNode);
            for (Edge edge:minNode.edges){
                Node toNode =edge.to;
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,dis+edge.w);
                }
                distanceMap.put(toNode,Math.min(distanceMap.get(toNode),dis+ edge.w));
            }
            selectNodes.add(minNode);
            minNode=getUnsedNode(distanceMap,selectNodes);
        }
        return  distanceMap;
    }

    private static  Node getUnsedNode(  HashMap<Node,Integer> disMap , HashSet<Node> selectNodes){
        Node minNode =null;
        int minDis =Integer.MAX_VALUE;
        for (Map.Entry<Node,Integer> entry:disMap.entrySet()){
            Node node =entry.getKey();
            int dis =entry.getValue();
            if (!selectNodes.contains(node)&& dis<minDis){
                minDis=dis;
                minNode=node;
            }
        }
        return minNode;
    }
}



