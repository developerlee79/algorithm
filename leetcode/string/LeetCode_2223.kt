package string

class LeetCode_2223 {

    /**
     * Solution - Z Algorithm
     * Time Complexity : O(M + N)
     * Space Complexity : O(N)
     *
     * Use Z algorithm to find sum of the score in array.
     * Z algorithm is pattern searching algorithm that searching in linear time. (M + N)
     * It's an algorithm that make 'Z Array'.
     * Z array is of same length as original string.
     * Z[i] is fixed by length of original string cause first elements of Z array is always be prefix and suffix itself.
     * And the other element Z[i] of Z array stores length of the longest substring starting from str[i] which is also a prefix of str[0..n-1].
     * Therefore, to solve this problem, you only need to sum all the z[i] values of the Z algorithm.
     * Now let's take a look at the implementation.
     * The idea is to keep the prefix substring spacing between two pointers Left and Right.
     * If i is greater than the Right pointer, it means that i is not in the gap between the two pointers (i.e., the prefix substring).
     * In this repeat, There is no information available from the gap between the current two pointers.
     * Because you need to check the prefix substring of the interval between 0 and Right++. (Because there is no prefix substring that starts before i and ends after i)
     * Thus, the Left and Right pointers are initialized to i and kept at intervals of i until the values indicated by Left and Right are different (i.e., until they are no longer prefix substring) and increase the Right pointer.
     * Then set Z[i] to the distance between the two pointers (length of the prefix substring).
     * If i is less than or equal to the Right pointer, there are two cases from here.
     * If the prefix substring starting from i - Left is less than the current interval, it means that the maximum interval that can be expanded is shorter than the current interval.
     * Therefore, since there is no prefix substring starting with i, set it to Z[i] = Z[k], and leave the interval the same and continue to the next iteration.
     * If it is greater than the current interval, it means that the current interval can be expanded further. Therefore, expand the spacing and set Z[i].
     *
     * @param s tring
     * @return sum of the score* of s
     *   score : length of the longest common prefix between s[i] and s[n]
    */
    fun sumScores(s: String): Long {
        val n = s.length
        val zArray = IntArray(n)
        var left = 0
        var right = 0
        var count = n.toLong()

        for (i in 1 until n) {
            if (i > right) {
                left = i
                right = i

                while (right < n && s[right - left] == s[right]) {
                    right++
                }

                zArray[i] = right-- - left
            } else {
                val k = i - left

                if (zArray[k] < right - i + 1) {
                    zArray[i] = zArray[k]
                } else {
                    left = i

                    while (right < n && s[right - left] == s[right]) {
                        right++
                    }

                    zArray[i] = right-- - left
                }
            }

            count += zArray[i]
        }

        return count
    }
}

fun main() {
    val s = "azbazbzaz"
    println(LeetCode_2223().sumScores(s))
}
