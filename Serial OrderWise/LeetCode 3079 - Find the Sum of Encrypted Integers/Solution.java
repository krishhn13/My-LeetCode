class Solution {
        public int sumOfEncryptedInt(int[] nums) {
                int sum = 0;
                int biggest = 0;
                for (int i : nums) {
                        if (i < 10)
                                sum += i;
                        else {
                                int count = 0;
                                while (i != 0) {
                                        count++;
                                        biggest = biggest > i % 10 ? biggest : i % 10;
                                        i /= 10;
                                }
                                int eleven = 0;
                                while (count != 0) {
                                        eleven = eleven * 10 + 1;
                                        count--;
                                }
                                // System.out.println("eleven: "+ eleven+" biggest : "+ biggest);
                                sum += eleven * biggest;
                                biggest = 0;
                        }
                }
                // System.out.print(sum);
                return sum;
        }
}