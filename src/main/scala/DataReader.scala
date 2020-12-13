package datareader

import scala.collection.mutable.Map
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/** keplerDataReader
  * 
  * 
  */
object datareader extends App {
    println(" Planet,   Radius")
    val bufferedSource = io.Source.fromFile("cumulative_kepler2020.csv")

    val future = Future {
      for (line <- bufferedSource.getLines) {
        val cols = line.split(",").map(_.trim)
        println(s"|${cols(3)}|${cols(16)}|}")
      }
    }

  sleep(5000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}