class Solution {
    int ans; //global variable to update
    public int maxLength(List<String> arr) {
        ans=0;
        backTrack(arr,0,"");
        return ans;
    }
    public void backTrack(List<String> arr,int i,String upto){
        
        //when ever reach the final string check for validity
        if(checkValid(upto) && i==arr.size()){
            if(ans<upto.length()) ans=upto.length(); 
            return;
        }
        
        //if reaches end of array return even if not valid string
        if(i==arr.size()) return;
        
        
        //backtrack without the index value so start from next value
        backTrack(arr,i+1,upto);
        //backtrack with the index value;
        backTrack(arr,i+1,upto+arr.get(i));
    }
    
    //check it contains only one charector of not
    public boolean checkValid(String upto){
        int []abc=new int[26];
        for(char c:upto.toCharArray()){
            if(abc[c-'a']++>0) return false;
        }
        return true;
    }
}