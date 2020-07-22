package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LegendOfKorra {
  val avatar = List(20, 20, 21)
  val korra = List(12, 14, 13, 13)

  val pivot = LocalDate.of(2020, 8, 14)

  val avatarEps = avatar
    .zipWithIndex
    .flatMap { case (n, i) =>
      (1 to n)
        .map(s => s"Avatar: The Last Airbender S${i + 1} E$s 🌬")
    }

  val korraEps = korra
    .zipWithIndex
    .flatMap { case (n, i) =>
      (1 to n)
        .map(s => s"Legend of Korra S${i + 1} E$s 🔥")
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

  val allDaysMap =
    allDays
      .map { case (ep, d) =>
        d.format(formatter) -> ep
      }
      .toMap
}
