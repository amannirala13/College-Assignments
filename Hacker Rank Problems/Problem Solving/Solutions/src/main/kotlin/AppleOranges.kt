/**
 * Check the problem statement here
 *@see <a href = "https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true"> Problem Statement </a>
 */
object AppleOranges{
    fun run(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
        // Write your code here

        var appleCount = 0
        var orangeCount = 0
        val houseRange = s..t

        // for apples (left tree)
        for (d in apples){
            if((a+d) in houseRange){
                appleCount++
            }
        }

        // for oranges (right tree)
        for (d in oranges){
            if((b+d) in houseRange){
                orangeCount++
            }
        }

        print("$appleCount\n$orangeCount")
    }
}