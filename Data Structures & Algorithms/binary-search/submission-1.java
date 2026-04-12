class Solution {
    public int search(int[] nums, int target) {

        int size = nums.length;

        for(int i=0; i<size; i++) {
            if(nums[i] == target)
            return i;
        }
        return -1;
        
    }
}
