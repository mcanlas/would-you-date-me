package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object UmbrellaAcademy extends App {
  val s1 = (1 to 10).map(n => s"S1 E$n")
  val s2 = (1 to 10).map(n => s"S2 E$n")

  val pivot = LocalDate.of(2020, 7, 31)

  val beforeDays =
    (1 to s1.length)
      .map(_.toLong)
      .map(pivot.minusDays)
      .reverse

  val afterDays =
    s2
      .indices
      .map(_.toLong)
      .map(pivot.plusDays)

  val allDays =
    s1.zip(beforeDays) ++ s2.zip(afterDays)

  val formatter =
    DateTimeFormatter.ofPattern("E, MMM d")

  allDays
    .foreach { case (ep, d) =>
      println(s"$ep: ${d.format(formatter)}")
    }
}
