package KeplerDataReader

import org.mongodb.scala._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal

import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}


class PlanetDAO(mongoClient: MongoClient) {
  val codecRegistry = fromRegistries(
    fromProviders(classOf[Planet]),
    MongoClient.DEFAULT_CODEC_REGISTRY
  )
  val db = mongoClient.getDatabase("kepler_db").withCodecRegistry(codecRegistry)
  val collection: MongoCollection[Planet] = db.getCollection("exoplanets")

  private def getResults[T](obs: Observable[T]): Seq[T] = {
    Await.result(obs.toFuture(), Duration(10, SECONDS))
  }

  def getAll(): Seq[Any] = getResults(collection.find())

  def getByName(name: String): Seq[Any] = {
    getResults(collection.find(equal("name", name)))
  }

  def createNewCollection(table: List[String]): Unit = {
    val header = table.head.split(",")
    val m = table.tail.map(row => (header zip row.split(",")).toMap)

    try {
      collection.insertMany(m.map(doc => doc.map(entry => Document(entry))))
    }
  }
}
