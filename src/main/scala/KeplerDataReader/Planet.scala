package KeplerDataReader

import org.bson.types.ObjectId


class Planet {
  var name = Option[String] = None
  var hostStar = Option[String] = None
}

object Planet {
  def apply(name: String, hostStar: String): Planet =
    Planet(name, hostStar)
}
