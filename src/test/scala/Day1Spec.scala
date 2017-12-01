import Day1.sumIntsMatchingIntAhead
import org.scalatest._

class Day1Spec extends FlatSpec with Matchers {
  "sumIntsMatchingIntAhead" should "sum all digits which are equal to the following digit" in {
    sumIntsMatchingIntAhead(List()) shouldEqual 0
    sumIntsMatchingIntAhead(List(1)) shouldEqual 1
    sumIntsMatchingIntAhead(List(1, 1, 2, 2)) shouldEqual 3
    sumIntsMatchingIntAhead(List(1 ,1 ,1, 1)) shouldEqual 4
    sumIntsMatchingIntAhead(List(1, 2, 3, 4)) shouldEqual 0
    sumIntsMatchingIntAhead(List(9, 1, 2, 1, 2, 1, 2, 1, 9)) shouldEqual 9
  }

  "sumIntsMatchingIntAhead" should "sum all digits which are equal to the digit ahead of them by n places" in {
    sumIntsMatchingIntAhead(List(), 5) shouldEqual 0
    sumIntsMatchingIntAhead(List(5), 0) shouldEqual 5
    sumIntsMatchingIntAhead(List(5), 5) shouldEqual 5
    sumIntsMatchingIntAhead(List(1, 2, 1, 2), 2) shouldEqual 6
    sumIntsMatchingIntAhead(List(1 ,2 ,2, 1), 2) shouldEqual 0
    sumIntsMatchingIntAhead(List(1, 2, 3, 1, 2, 3), 3) shouldEqual 12

    sumIntsMatchingIntAhead(List(1, 2, 1, 3, 1, 4, 1, 5), 4) shouldEqual 4
  }
}
