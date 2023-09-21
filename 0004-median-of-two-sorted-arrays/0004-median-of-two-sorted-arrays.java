class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int half = (n1 + n2 + 1)/2;

        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = n1;
        while(lo <= hi){
            int mid1 = lo + (hi - lo)/2;
            int mid2 = half - mid1;

            int a = mid1 > 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int b = mid2 > 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int c = mid1 >= n1 ? Integer.MAX_VALUE : nums1[mid1];
            int d = mid2 >= n2 ? Integer.MAX_VALUE : nums2[mid2];

            if(a<=d && b<=c){
                if((n1 + n2) % 2 == 0)
                    return (Math.max(a,b) + Math.min(c,d))/2.0;
                else
                    return Math.max(a,b);                    
            }
            else if(a >= d)
                hi = mid1-1;
            else
                lo = mid1+1;
        }

        return -1;
    }
}