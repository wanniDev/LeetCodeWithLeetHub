class Solution {
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int s1 = left;
        int s2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        for (int i = 0; i < n1; i++) {
            tempArr[s1 + i] = arr[s1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[s2 + i] = arr[s2 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[s1 + i] <= tempArr[s2 + j]) {
                arr[k] = tempArr[s1 + i];
                i++;
            } else {
                arr[k] = tempArr[s2 + j];
                j++;
            }
            k += 1;
        }

        while (i < n1) {
            arr[k] = tempArr[s1 + i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = tempArr[s2 + j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        merge(arr, left, mid, right, tempArr);
    }

    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }
}