package design

class LeetCode_1396 {

    class UndergroundSystem {

        private class Station {

            private var count: Int = 0
            private var sum: Double = 0.0

            fun getAverage() = sum / count

            fun addTime(time: Int) {
                count++
                sum += time
            }
        }

        private class ConnectedStation {

            private val stations = HashMap<String, Station>()

            fun get(station: String) = this.stations[station]

            fun add(endStation: String, time: Int) {
                this.stations.computeIfAbsent(endStation) { Station() }
                    .addTime(time)
            }
        }

        private val stationMap = HashMap<String, ConnectedStation>()
        private val passengerMap = HashMap<Int, Pair<String, Int>>()

        fun checkIn(id: Int, stationName: String, t: Int) {
            passengerMap[id] = Pair(stationName, t)
        }

        fun checkOut(id: Int, stationName: String, t: Int) {
            if (!passengerMap.containsKey(id)) {
                return
            }

            val checkInInfo = passengerMap[id]!!

            stationMap.computeIfAbsent(checkInInfo.first) { ConnectedStation() }
                .add(stationName, t - checkInInfo.second)
        }

        fun getAverageTime(startStation: String, endStation: String): Double {
            return stationMap[startStation]!!.get(endStation)!!.getAverage()
        }
    }
}

fun main() {
    // Input
    val undergroundSystem = LeetCode_1396.UndergroundSystem()
    // Output
    undergroundSystem.checkIn(45, "Seongsu", 3)
    undergroundSystem.checkIn(32, "Jamsil", 8)
    undergroundSystem.checkIn(27, "Seongsu", 10)
    undergroundSystem.checkOut(45, "Gangnam", 15)
    undergroundSystem.checkOut(27, "Gangnam", 20)
    undergroundSystem.checkOut(32, "Samseong", 22)
    undergroundSystem.getAverageTime("Jamsil", "Samseong").run {
        println(this)
        require(14.0000 == this)
    }
    undergroundSystem.getAverageTime("Seongsu", "Gangnam").run {
        println(this)
        require(11.0000 == this)
    }
    undergroundSystem.checkIn(10, "Seongsu", 24)
    undergroundSystem.getAverageTime("Seongsu", "Gangnam").run {
        println(this)
        require(11.0000 == this)
    }
    undergroundSystem.checkOut(10, "Gangnam", 38)
    undergroundSystem.getAverageTime("Seongsu", "Gangnam").run {
        println(this)
        require(12.0000 == this)
    }
}
