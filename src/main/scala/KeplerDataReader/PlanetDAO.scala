package KeplerDataReader

import org.mongodb.scala._

import scala.collection.mutable.{ArrayBuffer, Map}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}

import scala.reflect.internal.util.TableDef.Column




class PlanetDAO(mongoClient: MongoClient) {
//  val codecRegistry = fromRegistries(
//    fromProviders(classOf[Planet]),
//    MongoClient.DEFAULT_CODEC_REGISTRY
//  )
  val db = mongoClient.getDatabase("kepler_db")
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
    val docs = table.tail.map(row => (header zip row.split(",")).toMap)
    var planets = ArrayBuffer[Planet]()

    docs.foreach(m => {
      val p = new Planet()
      for ((k,v) <- m) addNeededColumns(k, v, p)
      println(p)
    })
//    try {
//      m.foreach(doc => {
//        val planet = Planet(doc.map((k,v) => )
//      })
//      collection.insertMany(m.map(doc => doc.map(entry => Document(entry))))
    }

  private def addNeededColumns(key: String, value: String, p: Planet): Unit = key match {
    case "planet" => p.name = value
    case "host_star" => p.hostStar = value
    case "discovery_year" => p.yearDiscovered = if(value == "") 0 else value.toInt
    case "orbital_Period_(days)" => p.orbitalPeriod = if(value == "") 0 else value.toDouble
    case "radius_(earth r)" => p.radius = if(value == "") 0 else value.toDouble
    case "mass_(earth m)" => p.mass = if(value == "") 0 else value.toDouble
    case "eq_temp_(K)" => p.eqTemp = if(value == "") 0 else value.toDouble
    case "stellar_radius_(solar r)" => if(value == "") 0 else p.stellarRadius = value.toDouble
    case "stellar_mass_(solar m)" => if(value == "") 0 else p.stellarMass = value.toDouble
    case "distance_(pc)" => if(value == "") 0 else p.distance = value.toDouble
  }
}
