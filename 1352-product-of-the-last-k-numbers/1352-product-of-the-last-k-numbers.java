class ProductOfNumbers {
    List<Integer> nums = null; 
    public ProductOfNumbers() {
        nums=new ArrayList<Integer>();
        nums.add(1);
    }
    
    public void add(int num) {
        if(num==0) {nums.clear();
        nums.add(1);}
        else {
            nums.add(num * nums.get(nums.size()-1));
        }
    }
    
    public int getProduct(int k) {

        if(k>=nums.size()) return 0;
        else
        return nums.getLast()/nums.get(nums.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */