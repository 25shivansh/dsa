class Solution {
    public int brokenCalc(int startValue, int target) {
        return solve(startValue,target);
    }
    private int solve(int st , int target){
        if(st==target){
            return 0;
        }
        if(st>target){
            return st-target;
        }
        if(target%2==0){
            return 1+ solve(st,target/2);
        }
        return 1+ solve(st,target+1);
    }
}