object Day1 {

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("1 Integer argument must be provided")
      System.exit(1)
    }

    val ints: Seq[Int] = args(0).stripPrefix("-").map(_.asDigit)

    println(sumIntsMatchingIntAhead(ints))
    println(sumIntsMatchingIntAhead(ints, ints.length / 2))
  }

  /**
    * Returns the sum of any ints which match the int `aheadBy` items ahead of them in the list.
    *
    * {{{
    *  scala> sumIntsMatchingIntAhead(List(1, 2, 1, 2), 2)
    *  res0: Int = 6
    *  scala> sumIntsMatchingIntAhead(List(1, 1, 2, 2))
    *  res0: Int = 3
    * }}}
    *
    * @param ints the list of ints
    * @param aheadBy how far ahead the int to match against is
    */
  def sumIntsMatchingIntAhead(ints: Seq[Int], aheadBy: Int = 1): Int = {
    val listView = ints.view

    listView.zipWithIndex.foldLeft(0)((b, a) => {
      val nextInt = listView((a._2 + aheadBy) % listView.length)
      if(nextInt == a._1) b + a._1 else b
    })
  }
}
