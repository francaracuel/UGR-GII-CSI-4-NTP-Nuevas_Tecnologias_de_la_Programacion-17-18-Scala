var ciudades = Set("Granada", "Jaén", "Málaga")

ciudades += "Sevilla"

print(ciudades)

import scala.collection.mutable.Set

val asignaturas = Set("Matemáticas", "Física")

asignaturas += "Informática"

println(asignaturas)


import scala.collection.immutable.HashSet

val conjunto = HashSet("1", "2")

// Por defecto los mapas son inmutables
val dias = Map(1 -> "Lunes", 2 -> "Martes")

println(dias)