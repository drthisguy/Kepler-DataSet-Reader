package datareader

import scala.collection.mutable.{ArrayBuffer, Map}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/** KeplerDataReader
  * 
  * 
  */
object datareader extends App {
    val bufferedSource = io.Source.fromFile("cumulative_kepler2020.csv")
    val lines = ArrayBuffer[String]()

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