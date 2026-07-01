class Solution {
    int []dRow={-1,1,0,0};
    int []dCol={0,0,-1,1};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n =grid.size();
        int m =grid.get(0).size();
        Queue<int []>q=new LinkedList<>();
        int [][]dist =new int [n][m];
        for(int i =0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        // identify theives because distance will be zero there 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int []{i,j});
                }
            }
        }
        // multi source bfs from each theive 
        while(!q.isEmpty()){
            int size = q.size();
            while(size -->0){
                int []node =q.poll();
                int row = node[0];
                int col=node[1];
                for(int i =0;i<4;i++){
                    int nr = row +dRow[i];
                    int nc = col + dCol[i];
                    if(nr>=0&& nc>=0 && nr<n && nc <m && dist[nr][nc]==Integer.MAX_VALUE){
                        dist[nr][nc]=dist[row][col]+1;
                        q.offer(new int []{nr,nc});
                    }
                }
            }
            
        }
        return djikstras(grid , dist,n,m);
        
    }
    private int djikstras(List<List<Integer>>grid ,int [][]dist,int n ,int m ){
            PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
            int [][] res = new int [n][m];
            for(int i =0;i<n;i++){
                Arrays.fill(res[i],-1);
            }
            res[0][0]=dist[0][0];
            pq.offer(new int[]{dist[0][0],0,0});
            while(!pq.isEmpty()){
                int []curr =pq.poll();
                int safe = curr[0];
                int row = curr[1];
                int col =curr[2];
                if(row==n-1&&col==m-1){
                    return safe ;
                }
                if(safe < res[row][col]){
                    continue ;
                }
                for(int d = 0;d<4;d++){
                    int nr = row +dRow[d];
                    int nc= col + dCol[d];
                    if(nr>=0&& nr<n&&nc>=0&&nc<m){
                        int newSafe = Math.min(safe ,dist[nr][nc]);
                        if(newSafe>res[nr][nc]){
                            res[nr][nc]=newSafe;
                            pq.offer(new int []{newSafe,nr,nc});
                        }
                    }

                }

            }
            return 0;
        }
        
    
}