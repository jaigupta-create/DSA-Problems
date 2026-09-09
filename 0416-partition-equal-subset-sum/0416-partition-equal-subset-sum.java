class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;

        ArrayList<Boolean> prev =
            new ArrayList<>(Collections.nCopies(target + 1, false));

        prev.set(0, true);

        if (arr[0] <= target)
            prev.set(arr[0], true);

        for (int i = 1; i < n; i++) {

            ArrayList<Boolean> curr =
                new ArrayList<>(Collections.nCopies(target + 1, false));

            curr.set(0, true);

            for (int k = 1; k <= target; k++) {

                boolean nottake = prev.get(k);

                boolean take = false;

                if (arr[i] <= k)
                    take = prev.get(k - arr[i]);

                curr.set(k, take || nottake);
            }

            prev = curr;
        }

        return prev.get(target);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 == 1)
            return false;

        return isSubsetSum(nums, sum / 2);
    }
}