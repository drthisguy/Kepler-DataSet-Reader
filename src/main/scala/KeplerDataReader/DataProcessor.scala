package KeplerDataReader

import scala.collection.JavaConverters._
import scala.collection.mutable.{ArrayBuffer, StringBuilder}
import scala.io.BufferedSource

case class DataProcessor() {

  def getAllPlanets(data: BufferedSource): ArrayBuffer[String] = {
    val planets = ArrayBuffer[String]()
    var count = 0

    //drop header, add rows
    for (line <- data.getLines.drop(46)) {
        planets+= line
        count = count+1
    }
    planets
  }

  def buildNewCSVTable(rows: ArrayBuffer[String], columnNums: ArrayBuffer[Int]): List[String] = {
    val table = ArrayBuffer[String]()
    for (row <- rows) {
      val cols = row.split(",").map(_.trim())
      val sb = new StringBuilder()

      sb.addAll(cols(0))
      sb.addOne(',')
      sb.addAll(cols(1))
      sb.addOne(',')

      columnNums.foreach(elem => {
        sb.addAll(cols(elem))
        sb.addOne(',')
      })
      table.append(sb.toString.substring(0, sb.length() - 1))
    }.asJava
    table.toList
  }
}