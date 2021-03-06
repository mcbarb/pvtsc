package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    val s1001 = singletonSet(1001)
    val s = union(union(union(s1, s2), union(s3, s1001)),s4) //  {1,2,3,1001,4}
    val positivesAndZero : Set = _ >= 0
    val positives : Set = _ > 0
    val negatives : Set = _ < 0
    val integers : Set = _ => true
    val integersExcludingZero : Set = _ != 0

  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      assert(contains(s, 1), "s does contain 1")
      assert(contains(s, 2), "s does contain 2")
      assert(!contains(s, 7), "s does not contain 7")
    }
  }

  test("intersect contains only elements contained in both sets") {
    new TestSets {
      assert(!contains(intersect(s1,s2), 3), "Intersetc{1,2} == {} does not contain 3")
      assert(contains(intersect(s1,s1), 1), "Intersect{1,1} == {1} does contain 1")
    }
  }

  test("forall works") {
    new TestSets {
      assert(forall(positives, positivesAndZero), "Positives and Zero contains positives")
      assert(forall(positives, integersExcludingZero), "Positives and Zero contains positives")
      assert(!forall(positivesAndZero, integersExcludingZero), "positives And Zero not contained in Integers Excluding Zero")
    }
  }

  test("exists works") {
    new TestSets {
      assert(exists(s, (_ < 4)),"any value smaller than 4 exists in s")
      assert(!exists(s, (_ > 999)),"any value greater than 999 does not exists in s because s is bounded")
      assert(!exists(s, (_ < 0)),"any value smaller than 0 does not exist in s")
    }
  }

  test("map works") {
    new TestSets {
      val mapped = map(s, (_ * 2))
      assert( contains(mapped, 2), "map 2" )
      assert( contains(mapped, 4), "map 4" )
      assert( contains(mapped, 6), "map 6" )
      assert( !contains(mapped, 3), "map: 3 is not contained" )
    }
  }


}
