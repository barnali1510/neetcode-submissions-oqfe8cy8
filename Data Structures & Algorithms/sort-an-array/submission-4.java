class Solution {
    public int[] sortArray(int[] nums) {

        merge(nums, 0, nums.length-1);
        return nums;
        
    }

    public void merge(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = left + (right-left)/2;

        merge(nums, left, mid);
        merge(nums, mid+1, right);

        mergeSort(nums, left, mid, right);
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++) {
            arr1[i] = nums[left+i];
        }

        for(int j=0; j<n2; j++) {
            arr2[j] = nums[mid+1+j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i<n1 && j<n2) {
            if(arr1[i] <= arr2[j]) {
                nums[k++] = arr1[i++];
            } else {
                nums[k++] = arr2[j++];
            }
        }

        while(i<n1) {
            nums[k++] = arr1[i++];
        }

        while(j<n2) {
            nums[k++] = arr2[j++];
        }
    }
}