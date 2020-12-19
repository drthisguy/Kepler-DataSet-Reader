package KeplerDataReader

case class Planet() {}

object Planet {
  def apply(name: String, count: Int): Planet =
    Planet(name, count)
}
