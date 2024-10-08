package sort

import java.util.PriorityQueue

class LeetCode_2838 {

    fun maximumCoins(heroes: IntArray, monsters: IntArray, coins: IntArray): LongArray {
        val monsterQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        monsters.forEachIndexed { index, monster ->
            monsterQueue.add(Pair(monster, coins[index]))
        }

        val sortedHeroes = heroes.sortedArray()
        val coinMap = hashMapOf<Int, Long>()

        var earnCoins = 0L

        for (i in sortedHeroes.indices) {
            while (monsterQueue.isNotEmpty() && monsterQueue.peek().first <= sortedHeroes[i]) {
                earnCoins += monsterQueue.poll().second
            }

            coinMap[sortedHeroes[i]] = earnCoins
        }

        val maximumCoins = LongArray(heroes.size)

        for (i in heroes.indices) {
            maximumCoins[i] = coinMap[heroes[i]]!!
        }

        return maximumCoins
    }
}

fun main() {
    // Input
    val heroes = intArrayOf(1, 4, 2)
    val monsters = intArrayOf(1, 1, 5, 2, 3)
    val coins = intArrayOf(2, 3, 4, 5, 6)
    // Output
    LeetCode_2838().maximumCoins(heroes, monsters, coins).run {
        println(this.joinToString())
        require(
            longArrayOf(5, 16, 10).contentEquals(this)
        )
    }
}
