
object Day2 {

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("1 Integer argument must be provided")
      System.exit(1)
    }



  }

  def checksum(lines: List[List[Int]]): Int = {

  }

  def diffLargestAndSmallest(ints: List[Int]): Int = {
    val largestSmallest = ints.foldLeft((0, 0))((b, a) => {
      val largest = if(a > b._1) a else b._1
      val smallest = if(a < b._2) a else b._2

      (largest, smallest)
    })

    largestSmallest._1 - largestSmallest._2
  }

}
