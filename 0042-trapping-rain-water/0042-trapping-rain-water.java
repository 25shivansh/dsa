class Solution {
    public int trap(int[] height) {
        int n=height.length;
        // //CALCULATE LEFT MAX BOUNDARY--ARRAY
            int []leftMax=new int [n];
            leftMax[0]=height[0];
            for(int i =1;i<n;i++){
                leftMax[i]=Math.max(leftMax[i-1],height[i]);
            }

        // //CALCULATE RIGHT MAX BOUNDARY --array
            int []rightMax=new int [n];
            rightMax[n-1]=height[n-1];
            for(int i=n-2;i>=0;i--){
                rightMax[i]=Math.max(rightMax[i+1],height[i]);
            }
        // //LOOP
        int trapWater=0;
        for(int i =0;i<n;i++){
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
            trapWater+=waterLevel-height[i];
        }


        
        // int water =0;
        // for(int i = 0;i<n;i++){
        //     int leftMax=0;
        //     for(int j=0;j<=i;j++){
        //         leftMax=Math.max(leftMax,height[j]);
        //     }
        //     int rightMax=0;
        //     for(int j =i;j<n;j++){
        //         rightMax=Math.max(rightMax,height[j]);
        //     }
        //     water +=Math.min(leftMax,rightMax)-height[i];
        // }
        return trapWater ;
        
    }
}