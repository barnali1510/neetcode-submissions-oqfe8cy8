class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] product = new int[n];

        product[0] = 1;
        for(int i=1; i<n; i++) {
            product[i] = product[i-1]*nums[i-1];
        }

        int suffix = 1;
        for(int i=n-1; i>=0; i--) {
            product[i] = suffix*product[i];
            suffix = suffix*nums[i];
        }

        return product;
        
    }
}  
