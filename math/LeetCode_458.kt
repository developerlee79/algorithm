package math

import kotlin.math.pow

class LeetCode_458 {

    /**
     * Solution - Math
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * @param buckets buckets of liquid, where exactly one of the buckets is poisonous
     * @param minutesToDie minutes takes for a poisoned pig to die
     * @param minutesToTest minutes to determine which bucket is poisonous
     * @return minimum number of pigs needed to figure out which bucket is poisonous within the allotted time
    */
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        // Don't have to kill any pig for testing! Happy moment :D
        if (buckets == 1) {
            return 0
        }

        // Test stage is given chance + 1.
        // Because when last pig got survived to the end, poison is in the next stage.
        // And we don't have to kill that marvelous 🐷 to test last bucket.
        val stage = minutesToTest / minutesToDie + 1.00
        var pigs = 1.00

        // stage ^ pigs means number of buckets that pigs can test.
        // Let's imagine pigs dimension array of stage length.
        // Each pigs consume dimension of itself.
        // So, when any pig died, we only have to examine the dimension of the dead pig.
        // And the length of the dimension is same as length of the stage.
        // Therefore, we can find a bucket of poison unconditionally in stage ^ pigs dimension.
        // Therefore, when stage ^ pigs < bucket, it cannot be examined, so we add a pig (dimension).

        // Example (pigs: 2, stage: 5)
        // @: pig A, #: pig B
        //
        // [1@#, 2@, 3@, 4@, 5@]     In 1D Array
        // [6#, 7, 8, 9, 10]         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
        // [11#, 12, 13, 14, 15]     @#  @  @  @  @  #               #                    #                   #
        // [16#, 17, 18, 19, 20]
        // [21#, 22, 23, 24, 25]
        //
        // When A died and B survive - poison in [2, 3, 4, 5]
        // When A survived and B die - poison in [6, 11, 16, 21]
        // When A and B died - poison in [1]
        // When A and B survived - re-test at [7]
        //
        while (stage.pow(pigs) < buckets) {
            pigs++
        }

        return pigs.toInt()
    }
}

fun main() {
    val buckets = 1000
    val minutesToDie = 15
    val minutesToTest = 60
    println(LeetCode_458().poorPigs(buckets, minutesToDie, minutesToTest))
}
