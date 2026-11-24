class Solution {
    private long hcf(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return (long)a;
    }
    private long lcm(long a,long b){
        if(a==0||b==0){
            return 0;
        }
        return (long)Math.abs(a*b)/(hcf(a,b));
    }

    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int left=0;left<n;left++){
            long prod=1;
            long g=0;
            long l=1;
            for(int right=left;right<n;right++){
                prod*=nums[right];
                g=hcf(g,nums[right]);
                l=lcm(l,nums[right]);
                if(prod==g*l){
                    ans=Math.max(ans,right-left+1);
                }
            }
        }
        return ans;


    }
}