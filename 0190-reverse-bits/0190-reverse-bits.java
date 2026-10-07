class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Get the last bit
            int bit = n & 1;

            // Shift result left
            result = (result << 1) | bit;

            // Remove the last bit from n
            n = n >> 1;
        }

        return result;
    }
}