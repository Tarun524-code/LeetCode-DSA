class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
           int c = 0;
        for(int x : arr1){
            if(isValid(x, arr2, d)) c++;
        }
        return c;
    }
    boolean isValid(int x, int[] arr, int d){
        for(int a : arr){
            if(Math.abs(a - x) <= d) return false;
        }
        return true;
    }
}