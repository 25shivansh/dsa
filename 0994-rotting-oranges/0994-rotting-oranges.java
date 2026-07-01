class Solution {
    int []dRow={-1,1,0,0};
    int []dCol={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length ;
        int freshCount =0;
        int minute =0;
        Queue<int []>q=new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int []{i,j});
                }else if(grid[i][j]==1){
                    freshCount ++;
                }
            }
        }
        if(freshCount == 0)return 0;
        while(!q.isEmpty()){
            int size =q.size();
            while(size-->0){
                int []node =q.poll();
                int row = node[0];
                int col = node[1];
                for(int i =0;i<4;i++){
                    int nr = row +dRow[i];
                    int nc = col+dCol[i];
                    if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int []{nr,nc});
                        freshCount --;
                    }
                }
            }
            minute ++;

        }
        if(freshCount ==0)return minute -1;
        return -1;

    }
}