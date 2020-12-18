package KeplerDataReader

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/** KeplerDataReader
 *
 *
 */
object Main extends App {
  val terminal = new Terminal
  terminal.welcomeMessage()

  val bufferedSource = io.Source.fromFile("cumulative_kepler2020.csv")
  val dp = DataProcessor()
  val planets = dp.getAllPlanets(bufferedSource)
  bufferedSource.close
  terminal.logger("Done.")

  if (args.length == 0) {
    terminal.logger("No arguments found. Run with \"-help\" to see the usage.")
    System.exit(0)
  }

  val columns = args.filter(_.startsWith("--"))
  columns.foreach {
      case "--yr" => println("year discovered")
      case "--op" => "one"
      case "--r" => "two"
      case "--m" => "two"
      case "--t" => println("EQ Temp")
      case "--d" => "two"
      case "--sm" => "two"
      case "--sr" => "two"
      case _ => println("not an argument.")
  }
//  val future = Future {
//    planets.foreach(row => {
//      val cols = row.split(",").map(_.trim)
//      println(s"${cols(2)} | ${cols(14)}")
//    })
//  }

  sleep(5000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}
