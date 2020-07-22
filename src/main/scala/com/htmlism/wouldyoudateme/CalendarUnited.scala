package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object CalendarUnited extends App {
  val now = LocalDate.now()

  val formatter =
    DateTimeFormatter.ofPattern("E, MMM d")

  for (n <- 0 to 30) {
    val day = now.plusDays(n.toLong)

    val key = day.format(formatter)

    val eps = UmbrellaAcademy.allDaysMap.get(key).toList ++ LegendOfKorra.allDaysMap.get(key).toList

    val episodeString = eps.mkString(" and ")

    println(s"$key   Rewatch with me: $episodeString")
  }
}
