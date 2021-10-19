package helloword.leetcode;



public class unionFindSet {
    int[] root;
    int[] rank;
    int count;

    public unionFindSet(int size){
        root =new int[size];
        rank =new int[size];
        count =size;
        for (int i = 0; i < size; i++) {
            root[i]=i;
            rank[i] =1;
        }
    }
    public int find (int x){
        if (x==root[x]){
            return  x;
        }
        return  root[x]=find(root[x]);
    }
    public  void  union (int x ,int y){
        int rootx=find(x);
        int rooty=find(y);
        if (rootx!=rooty){
            if (rank[rootx]>rank[rooty])
            root[rooty]=rootx;
        } else if (rank[rootx]<rank[rooty]){
            root[rootx]=rooty;
        } else if (rank[rootx]==rank[rooty]){
            root[rootx]=rooty;
            rank[rootx]+=1;
        }
        count--;
    }
    public boolean connected(int x, int y){
        return find(x)==find(y);
    }
    public int getCount(){

        return count;
    }


    public static  int proviceNum(int[][] pro){
        if (pro==null||pro.length==0){
            return 0;
        }
         int n=pro.length;
        unionFindSet uf=new unionFindSet(n);
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (pro[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        unionFindSet uset =new unionFindSet(10);
        uset.union(1,2);
        uset.union(2,5);
        uset.union(5,6);
        uset.union(6,7);
        uset.union(3,8);
        uset.union(8,9);
        System.out.println(uset.connected(1,5));
        System.out.println(uset.connected(1,6));
        System.out.println(uset.connected(5,7));
        System.out.println(uset.connected(3,7));
        System.out.println(uset.connected(3,9));
    }
}
