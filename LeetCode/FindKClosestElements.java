class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int mid = 0;
        int low = 0;
        int high = arr.length - k;
        while(low < high) {
            mid = (low + high)/2;
            if(x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return Arrays.stream(arr, mid, mid + k).boxed().collect(Collectors.toList());
    }
}
