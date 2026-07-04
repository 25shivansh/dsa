class Solution {
    class Pair {
        int node ;
        int dist ;
        Pair(int node,int dist){
            this.node =node ;
            this.dist =dist ;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:roads){
            int u = edge[0];
            int v =edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        return djikstras(adj,n,1);
    }
    private int djikstras(List<List<Pair>>adj,int n , int src){
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int []res = new int [n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src]=Integer.MAX_VALUE;
        pq.add(new Pair(src,Integer.MAX_VALUE));
        while(!pq.isEmpty()){
            Pair currNode = pq.poll();
            int node =currNode.node;
            int dist = currNode.dist ;
            if(dist > res[node])continue ;
            for(Pair nei : adj.get(node)){
                int adjNode=nei.node;
                int adjDist=nei.dist ;
                int minDist=Math.min(dist, adjDist);
                if(minDist<res[adjNode]){
                    res[adjNode]=minDist;
                    pq.offer(new Pair(adjNode,minDist));
                }
            }

        }
        return res[n];
    }
}