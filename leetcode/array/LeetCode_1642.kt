package array

import java.util.PriorityQueue

class LeetCode_1642 {

    /**
     * Solution - Priority Queue
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Use Priority Queue to solve the problem.
     * The key to this problem is to use a ladder for the biggest leap (i.e., when the next building is the highest).
     * So we can use priority queues that are as large as the number of ladders.
     * Add all jump costs to the ladder priority queue until when the queue is larger than the number of ladders.
     * When queue is larger than the number of ladders, it means we have to use bricks now. so poll the smallest jump cost from the queue and compare it to the current number of blocks.
     * Because the cost is free, buildings with the same height or lower height are excluded.
     * When all iterations are finished, return the value by adding the distance traveled use the block and the size of the priority queue (that is, the number of ladders used).
     * If the ladder is not given, it does not need to be calculated as a priority queue, so it is calculated separately.
     *
     * @param heights integer array representing the heights of buildings
     * @param bricks that can be piled up as you go up a building
     * @param ladders that can be used to climb a building
     * @return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally
    */
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        if (ladders == 0) {
            return furthestBuildingWithOutLadders(heights, bricks)
        }

        val heightsQueue: PriorityQueue<Int> = PriorityQueue()
        var bricks = bricks

        var count = 0
        for (i in 0 until heights.size - 1) {
            if (heights[i] >= heights[i + 1]) {
                count++
                continue
            }

            heightsQueue.add(heights[i + 1] - heights[i])

            if (heightsQueue.size > ladders) {
                val lowerHeight = heightsQueue.poll()

                if (bricks >= lowerHeight) {
                    bricks -= lowerHeight
                    count++
                } else {
                    break
                }
            }
        }

        return count + heightsQueue.size
    }

    private fun furthestBuildingWithOutLadders(heights: IntArray, bricks: Int): Int {
        var count = 0
        var bricks = bricks

        for (i in 0 until heights.size - 1) {
            if (bricks >= heights[i + 1] - heights[i]) {
                bricks -= heights[i + 1] - heights[i]
                count++
                continue
            } else {
                break
            }
        }

        return count
    }
}

fun main() {
    val heights = intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19)
    val bricks = 10
    val ladders = 2
    println(LeetCode_1642().furthestBuilding(heights, bricks, ladders))
}
