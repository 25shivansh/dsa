class Solution {
    class Pair{
        int node ;
        int dist;
        int stops ;
        Pair(int node,int dist ,int stops){
            this.node = node ;
            this.dist =dist ;
            this.stops =stops ;

            
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:flights){
            int u =edge[0];
            int v =edge[1];
            int w =edge[2];
            adj.get(u).add(new Pair(v,w,0));
        }
        return djikstras(adj,n,flights,src,dst,k);
    }
    private int djikstras(List<List<Pair>>adj,int n,int [][]flights,int src, int dst ,int k){
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int [][]dist = new int [n][k+2];
        for(int i = 0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[src][0]=0;
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair currNode =pq.poll();
            int node =currNode.node;
            int cost =currNode.dist ;
            int stops = currNode.stops ;
            if(node==dst)return cost ;
            if(stops==k+1)continue ;
            
            for(Pair nei :adj.get(node)){
                int adjNode = nei.node ;
                int adjDist =cost +nei.dist ;
                if(adjDist<dist[adjNode][stops+1]){
                    dist[adjNode][stops+1]=adjDist;
                    pq.add(new Pair(adjNode ,adjDist, stops+1));
                }
            }
        }
        return -1 ;
    }
}