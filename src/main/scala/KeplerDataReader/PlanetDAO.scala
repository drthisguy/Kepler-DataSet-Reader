package KeplerDataReader

import org.mongodb.scala._
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal

class PlanetDAO(mongoClient: MongoClient) {
  val db = mongoClient.getDatabase("kepler_db")
  val collection: MongoCollection[Planet] = db.getCollection("exoplanets")

  private def getResults[T](obs: Observable[T]): Seq[T] = {
    Await.result(obs.toFuture(), Duration(10, SECONDS))
  }

  def getAll(): Seq[Planet] = getResults(collection.find())

  def getByName(name: String): Seq[Planet] = {
    getResults(collection.find(equal("name", name)))
  }

}
