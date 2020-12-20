package KeplerDataReader

trait Column {
  val value: Option[Double] = None
}

class DiscoverYear(value: Double) extends Column

class OrbitalPeriod(value: Double) extends Column

class Radius(value: Double) extends Column

class Mass(value: Double) extends Column

class Temperature(value: Double) extends Column

class StellarMass(value: Double) extends Column

class StellarRadius(value: Double) extends Column

class Distance(value: Double) extends Column