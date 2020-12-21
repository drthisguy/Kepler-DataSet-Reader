package KeplerDataReader

import org.bson.types.ObjectId


case class Planet() {
  var name: String = ""
  var hostStar: String = ""
  var yearDiscovered: Int = 0
  var orbitalPeriod: Double = 0
  var radius: Double = 0
  var mass: Double = 0
  var eqTemp: Double = 0
  var stellarMass: Double = 0
  var stellarRadius: Double = 0
  var distance: Double = 0

  override def toString = {
    s"Planet: $name | Host Star: $hostStar | Discovery Year $yearDiscovered | Orbital Period: $orbitalPeriod | Radius: $radius |" +
    s" Mass: $mass | Temperature: $eqTemp | Stellar Mass: $stellarMass | Stellar Radius: $stellarRadius | Distance: $distance"
  }
}

object Planet {
  def apply(name: String, hostStar: String): Planet = {
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    p
  }
  def apply(name: String, hostStar: String, col: Column): Planet = {
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    this.setFieldValues(p, col)
    p
  }
  def apply(name: String, hostStar: String, col3: Column, col4: Column): Planet = {
    val cols = List(col3, col4)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(name: String, hostStar: String, col3: Column, col4: Column, col5: Column): Planet = {
    val cols = List(col3, col4, col5)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(
             name: String, hostStar: String, col3: Column, col4: Column, col5: Column, col6: Column
           ): Planet = {
    val cols = List(col3, col4, col5, col6)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(
             name: String, hostStar: String, col3: Column, col4: Column, col5: Column, col6: Column, col7: Column
           ): Planet = {
    val cols = List(col3, col4, col5, col6, col7)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(
             name: String,
             hostStar: String,
             col3: Column,
             col4: Column,
             col5: Column,
             col6: Column,
             col7: Column,
             col8: Column
           ): Planet = {
    val cols = List(col3, col4, col5, col6, col7, col8)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(
             name: String,
             hostStar: String,
             col3: Column,
             col4: Column,
             col5: Column,
             col6: Column,
             col7: Column,
             col8: Column,
             col9: Column
           ): Planet = {
    val cols = List(col3, col4, col5, col6, col7, col8, col9)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }
  def apply(
             name: String,
             hostStar: String,
             col3: Column,
             col4: Column,
             col5: Column,
             col6: Column,
             col7: Column,
             col8: Column,
             col9: Column,
             col10: Column
           ): Planet = {
    val cols = List(col3, col4, col5, col6, col7, col8, col9, col10)
    var p = new Planet
    p.name = name
    p.hostStar = hostStar
    for (col <- cols) this.setFieldValues(p, col)
    p
  }

  private def setFieldValues(p: Planet, col: Column): Unit = col match {
      case c: DiscoverYear => p.yearDiscovered = c.value
      case c: OrbitalPeriod => p.orbitalPeriod = c.value
      case c: StellarRadius => p.stellarRadius = c.value
      case c: StellarMass => p.stellarMass = c.value
      case c: Temperature => p.eqTemp = c.value
      case c: Distance => p.distance = c.value
      case c: Radius => p.radius = c.value
      case c: Mass => p.mass = c.value
  }
}

