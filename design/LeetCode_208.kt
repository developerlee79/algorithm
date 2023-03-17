package design

class LeetCode_208 {

    class Trie {

        private data class CharNode(
            val character: Char
        ) {

            private val childNodeMap = HashMap<Char, CharNode>()
            private var isEnd: Boolean = false

            fun search(targetString: CharIterator): Boolean {
                if (!targetString.hasNext()) {
                    return this.isEnd
                }

                val currentChar = targetString.nextChar()

                return if (childNodeMap.containsKey(currentChar)) {
                    childNodeMap[currentChar]!!.search(targetString)
                } else {
                    false
                }
            }

            fun startWith(targetString: CharIterator): Boolean {
                if (!targetString.hasNext()) {
                    return true
                }

                val currentChar = targetString.nextChar()

                return if (childNodeMap.containsKey(currentChar)) {
                    childNodeMap[currentChar]!!.startWith(targetString)
                } else {
                    false
                }
            }

            fun add(targetString: CharIterator) {
                if (!targetString.hasNext()) {
                    this.isEnd = true
                    return
                }

                val currentChar = targetString.nextChar()

                if (!childNodeMap.containsKey(currentChar)) {
                    childNodeMap[currentChar] = CharNode(currentChar)
                }

                childNodeMap[currentChar]!!.add(targetString)
            }
        }

        private val headNode = CharNode(' ')

        fun insert(word: String) {
            headNode.add(word.iterator())
        }

        fun search(word: String): Boolean {
            return headNode.search(word.iterator())
        }

        fun startsWith(prefix: String): Boolean {
            return headNode.startWith(prefix.iterator())
        }

    }
}

fun main() {
    // Input
    val trie = LeetCode_208.Trie()
    // Output
    trie.insert("apple")
    assert(trie.search("apple"))
    assert(!trie.search("app"))
    assert(trie.startsWith("app"))
    trie.insert("app")
    assert(trie.search("app"))
}
