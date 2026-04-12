class Solution {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int counts = 0;

        for(int i=0; i<nums.length; i++) {
            if(counts == 0) {
                candidate = nums[i];
            }

            if(candidate == nums[i]) {
                counts++;
            } else {
                counts--;
            }
        }

        return candidate;
        
    }
}