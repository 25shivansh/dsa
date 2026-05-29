class Solution {
    public int minElement(int[] nums) {
        int n = nums.length ;
        
        int minSum = Integer.MAX_VALUE ;
        for(int a : nums){
            int sum = 0;
            while(a!=0){
                
                int digit = a % 10;
                sum +=digit ;
                a=a/10;
                

            }
            minSum = Math.min(minSum,sum);
        }
        return minSum ;
    }
}