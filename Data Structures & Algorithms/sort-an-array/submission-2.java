class Solution {
    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length-1);
        return nums;
        
    }

    private void mergeSort(int[] nums, int left, int right) {
        //we need to run the loop till left < right

        if(left>=right) {
            return;
        }

        int mid = left + (right-left)/2;

        //devide the left half recursively
        mergeSort(nums, left, mid);

        //divide the right half recursively
        mergeSort(nums, mid+1, right);

        //merge the sorted parts 
        merge(nums, left, mid, right);
    }

    private void merge(int nums[], int left, int mid, int right) {

        //take two temp arrays to story the left sorted part and right sorted part

        int n1 = mid-left+1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0; i<n1; i++) {
            leftArray[i] = nums[left+i];
        }

        for(int j=0; j<n2; j++) {
            rightArray[j] = nums[mid+1+j];
        }

//take two pointers i and J to track the elemnets in the sorted arrays
        int i=0;
        int j=0;
        int k=left;

//if value at i is less than value at j then, then store i in the temp array and move ahead the i pointer, else j
        while(i<n1 && j<n2) {
            if(leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

//store the remaining element of left array in sorted fashion
        while(i<n1) {
            nums[k++] = leftArray[i++];
        }

//store the remaining element of right array in sorted fashion
        while(j<n2) {
            nums[k++] = rightArray[j++];
        }
    }
}