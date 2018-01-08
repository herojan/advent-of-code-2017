import scala.io.Source

object Day2 {

  def main(args: Array[String]): Unit = {
    val lines = Source.fromResource("Day2Spreadsheet1.txt").getLines().toStream
    val linesWithInts = lines.map(_.split('\t').map(_.toInt))

    val checksum1 = linesWithInts.foldLeft(0)((acc, ints) => acc + (ints.max - ints.min))
    println(checksum1)

    val checksum2 = linesWithInts.foldLeft(0)((acc, ints) => acc + findWholeDivision(ints))
    println(checksum2)
  }

  def findWholeDivision(ints: Seq[Int]): Int = {
    val allPairs = for {
      x <- ints
      y <- ints
    } yield (x, y)

    go(allPairs.tail, allPairs.head)
  }

  def go(pairs: Seq[(Int, Int)], pair: (Int, Int)): Int = {
    val a = divmod(pair._1, pair._2)
    val b = divmod(pair._2, pair._1)

    if (a._2 == 0 && a._1 != 1){
      a._1
    }
    else if (b._2 == 0 && b._1 != 1){
      b._1
    }
    else go(pairs.tail, pairs.head)
  }

  def divmod(a: Int, b: Int): (Int, Int) = {
    (a / b, a % b)
  }
}
