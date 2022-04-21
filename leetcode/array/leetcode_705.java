public class leetcode_705 {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(1)
    // Space Complexity : O(length of array what required in question / 32)
    // In this problem, maximum possible value to be stored is 1000000
    // We can divide data by 32, which the length of binary.
    // So we mapped the code like num[0] 0-31, num[1] 32-63 ...
    //
    // add()
    // Divide the key by 32 to address the array in which the value will be stored.
    // Then left shift 1 by 32 to specify the hashing key, and invert the value via OR(|).
    //
    // contains()
    // Verify presence by comparing the value at that address with the AND(&) operator.
    //
    // delete()
    // Use the NOT operator to perform the exact opposite of the add method.
    static class MyHashSet {

        int[] hashArray;

        public MyHashSet() {
            hashArray = new int[31251];
        }

        public void add(int key) {
            hashArray[getBit(key)] |= hashing(key);
        }

        public void remove(int key) {
            hashArray[getBit(key)] &= ~hashing(key);
        }

        public boolean contains(int key) {
            return (hashArray[getBit(key)] & hashing(key)) != 0;
        }

        private static int getBit(int key) {
            return key / 32;
        }

        private static int hashing(int key) {
            return 1 << (key % 32);
        }
    }
}
