package design

class LeetCode_706 {

    class MyHashMap {

        private val hashArray = IntArray(1000001) { -1 }

        fun put(key: Int, value: Int) {
            hashArray[key] = value
        }

        fun get(key: Int) = hashArray[key]

        fun remove(key: Int) {
            hashArray[key] = -1
        }

    }
}

fun main() {
    // Input
    val myHashMap = LeetCode_706.MyHashMap()
    // Output
    myHashMap.put(1, 1)
    myHashMap.put(2, 2)
    require(1 == myHashMap.get(1))
    require(-1 == myHashMap.get(3))
    myHashMap.put(2, 1)
    require(1 == myHashMap.get(2))
    myHashMap.remove(2)
    require(-1 == myHashMap.get(2))
}
