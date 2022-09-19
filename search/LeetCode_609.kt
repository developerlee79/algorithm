package search


class LeetCode_609 {

    /**
     * Solution - Hash Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use hash map to save file data & find duplicate.
     *
     * @param paths list of directory info
     * @return return all the duplicate files in the file system in terms of their paths
    */
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val fileMap = hashMapOf<String, MutableList<String>>()

        for (pathString in paths) {
            val pathSplitArray = pathString.split(" ")
            val path = pathSplitArray[0]

            for (i in 1 until pathSplitArray.size) {
                val currentFileArray = pathSplitArray[i].split("(")
                val currentFileContent = currentFileArray[1].substringBefore(")")

                fileMap.computeIfAbsent(currentFileContent) { mutableListOf() }.add("$path/${currentFileArray[0]}")
            }
        }

        return fileMap.values.filter { it.size > 1 }.toList()
    }
}

fun main() {
    val paths = arrayOf(
        "root/a 1.txt(abcd) 2.txt(efgh)",
        "root/c 3.txt(abcd)",
        "root/c/d 4.txt(efgh)",
        "root 4.txt(efgh)"
    )
    println(LeetCode_609().findDuplicate(paths))
}
