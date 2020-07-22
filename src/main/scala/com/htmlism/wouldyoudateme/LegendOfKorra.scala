package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LegendOfKorra extends App {
  val avatar = List(20, 20, 21)
  val korra = List(12, 14, 13, 13)

  val pivot = LocalDate.of(2020, 8, 14)

  val avatarEps = avatar
    .zipWithIndex
    .flatMap { case (n, i) =>
      (1 to n)
        .map(s => s"Avatar S${i + 1} E$s")
    }

  val korraEps = korra
    .zipWithIndex
    .flatMap { case (n, i) =>
      (1 to n)
        .map(s => s"Korra S${i + 1} E$s")
    }

  val beforeDays =
    (1 to avatarEps.length)
      .map(_.toLong)
      .map(pivot.minusDays)
      .reverse

  val afterDays =
    korraEps
      .indices
      .map(_.toLong)
      .map(pivot.plusDays)

  val allDays =
    avatarEps.zip(beforeDays) ++ korraEps.zip(afterDays)

  val formatter =
    DateTimeFormatter.ofPattern("E, MMM d")

  allDays
    .foreach { case (ep, d) =>
      println(s"$ep\t${d.format(formatter)}")
    }
}
