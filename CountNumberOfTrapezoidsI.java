class Solution {
    public int mod = 1_000_000_000 + 7;
    public int countTrapezoids(int[][] points) {
        int traps = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //stores axis and the count of how many points are on that axis
        for (int[] point : points) {
            int axis = point[1]; 
            int count = 1;
            if (map.containsKey(axis)) count += map.get(axis);
            if (count > maxCount) maxCount = count;
            map.put(axis, count);
        }
        int[] arr = buildCombArr(maxCount);
        int[] axisComb = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            axisComb[index] = arr[map.get(key)];
            index++;
        }

        long s = 0;
        long s2 = 0;
        for (int i = 0; i < axisComb.length; i++) {
            long ai = axisComb[i]; // promote to long
            s = (s + ai) % mod;
            s2 = (s2 + ai * ai % mod) % mod;
        }

        long inv2 = (mod + 1L) / 2L;

        long t = (s * s) % mod;    
        t = (t - s2 + mod) % mod;  
        t = (t * inv2) % mod;  
        traps = (int)t;
        return traps;
    }

    public int[] buildCombArr(int maxCount){
        int[] arr = new int[maxCount+1];
        for(int i = 0; i < 2; i++) arr[i] = 0;
        for(int i = 2; i <= maxCount; i++) arr[i] = (arr[i-1] + i-1) % mod;
        return arr;
    }
}
