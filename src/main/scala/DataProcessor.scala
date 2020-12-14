import scala.io.BufferedSource
import scala.collection.mutable.{Set}

case class DataProcessor()

def getPlanets(data: BufferedSource): Set[String] = {
  val confirmedPlanets = Set[String]()

  for (line <- data.getLines) {
    if (line.split(",")(4) == "CONFIRMED")
      confirmedPlanets.add(line)
  }
  confirmedPlanets
}