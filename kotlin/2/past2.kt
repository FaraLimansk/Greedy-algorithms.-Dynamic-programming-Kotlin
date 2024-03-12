import java.io.File

fun main() {
    val lines = File("input.txt").readLines()

    val d = lines[0].toInt()
    val m = lines[1].toInt()
    val n = lines[2].toInt()
    val stops = lines[3].split(" ").map { it.toInt() }

    val result = minRefills(d, m, n, stops)

    File("output.txt").writeText(result.toString())
}

fun minRefills(d: Int, m: Int, n: Int, stops: List<Int>): Int {
    var currentRefill = 0
    var numRefills = 0
    val allStops = mutableListOf(0)
    allStops.addAll(stops)
    allStops.add(d)

    while (currentRefill <= n) {
        val lastRefill = currentRefill

        while (currentRefill <= n && (allStops[currentRefill + 1] - allStops[lastRefill] <= m)) {
            currentRefill++
        }

        if (currentRefill == lastRefill) {
            return -1 // Невозможно достичь места назначения
        }

        if (currentRefill <= n) {
            numRefills++
        }
    }

    return numRefills
}
