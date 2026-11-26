class Solution {
    public boolean canAliceWin(int n) {
        if(n<10)return false ;// alice can not move so bob wins  
        if(n==10)return true ;
        if(n>10 && n<19)return true ;// next chance is not possible by bob
        if(n>=19 && n<27 ) return false ;
        if(n>=27 && n<34)return true ;
        if(n>=34 && n<40)return false ;
        if(n>=40 && n<45)return true ;
        if(n>=45 && n<49) return false;
        if(n>=49 && n<52) return true;
        if(n>=52 && n<54) return false;
        if(n==54) return true;
        return false;
        //return true ;

    }
}