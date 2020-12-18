package KeplerDataReader

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/** KeplerDataReader
 *
 *
 */
object KeplerDR extends App {
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

  val colNumbers = new mutable.ArrayBuffer[Int](args.length)
  val columns = args.filter(_.startsWith("--"))
  columns.foreach {
      case "--yr" => colNumbers.addOne(6)
      case "--op" => colNumbers.addOne(11)
      case "--r" => colNumbers.addOne(13)
      case "--m" => colNumbers.addOne(15)
      case "--t" => colNumbers.addOne(20)
      case "--d" => colNumbers.addOne(33)
      case "--sm" => colNumbers.addOne(26)
      case "--sr" => colNumbers.addOne(25)
      case _ => println("not an argument.")
  }
  println(colNumbers)
  val table = dp.buildNewCSVTable(planets, colNumbers)

//  val future = Future {
    table.foreach(row => {
      val cols = row.split(",").map(_.trim)
      println(s"${cols.foreach(col => print(s"| $col |"))}")
    })
//  }

  sleep(5000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}
