package KeplerDataReader

import scala.concurrent.Future

/** KeplerDataReader
  *
  *
  */
object Main extends App {
    val bufferedSource = io.Source.fromFile("cumulative_kepler2020.csv")
    val dp = new DataProcessor()
    val planets = dp.getPlanets(bufferedSource)

    println(" Planet,   Radius")
    val future = Future {
      for (line <- bufferedSource.getLines) {
        val cols = line.split(",").map(_.trim)
        //filter out false positive and unconfirmed candidates.
        if (cols(4) == "CONFIRMED") {
          lines+= line
          println(s"|${cols(3)}|${cols(16)}|}")
        }
      }
    }

  sleep(5000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}
