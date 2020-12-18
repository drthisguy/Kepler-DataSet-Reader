package KeplerDataReader

import scala.io.BufferedSource
import scala.collection.mutable.{Set}

case class DataProcessor() {

  def getAllPlanets(data: BufferedSource): Set[String] = {
    val planets = Set[String]()

    //filter out the header, false positive and unconfirmed planets.
    for (line <- data.getLines.drop(47)) {
        planets.add(line)
    }
    planets
  }
}