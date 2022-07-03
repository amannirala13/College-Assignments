import org.junit.jupiter.api.Test
import com.github.stefanbirkner.systemlambda.SystemLambda.*
import kotlin.test.assertEquals

internal class Tests{

    /**
     * Get result from the print command
     */
    private fun getResult(fn: ()-> Unit): String {
        val result = tapSystemOut {
            fn() }
        return result.trim()
    }


    /**
     * ----------------------[ TESTS HERE ]--------------------------
     */


    /**
     * Test for apples and oranges!
     * @see [AppleOranges]
     */
    @Test
    fun applesAndOranges(){
        assertEquals("1\n1", getResult {
            AppleOranges.run(7,11,5,15, arrayOf(-2, 2, 1), arrayOf(5,-6))
         })
    }

    /**
     * Test for between two sets!
     * @see [BetweenTwoSets]
     */
    @Test
    fun betweenTwoSets(){
        assertEquals(3,BetweenTwoSets.run(arrayOf(2, 4), arrayOf(16, 32, 96)))
    }

    /**
     * Test for number line jumps!
     * @see [NumberLineJumps]
     */
    @Test
    fun numberLineJumps(){
        assertEquals("YES", NumberLineJumps.run(0,3, 4, 2))
    }

    /**
     * Test for sub array division!
     * @see [SubarrayDivision]
     */
    @Test
    fun subArrayDivision(){
        assertEquals(2, SubarrayDivision.run(arrayOf(1,2,1,3,2), 3,2))
    }

    /**
     * Test for divisible sum pair!
     * @see [DivisibleSumPairs]
     */
    @Test
    fun divisibleSumPairs(){
        assertEquals(5, DivisibleSumPairs.run(3, arrayOf(1,3,2,6,1,2)))
    }

    /**
     * Test for migratory birds!
     * @see [MigratoryBirds]
     */
    @Test
    fun migratoryBirds(){
        assertEquals(4, MigratoryBirds.run(arrayOf(1,4,4,4,5,3)))
    }
}