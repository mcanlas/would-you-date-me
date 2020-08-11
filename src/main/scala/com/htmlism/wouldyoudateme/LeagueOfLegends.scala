package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object LeagueOfLegends extends App {
  val maxPoints = 750

  val now = LocalDate.now()
  val endDate = LocalDate.of(2020, 8, 9)
    .plusDays(107L)

  val hours = ChronoUnit.HOURS.between(now.atStartOfDay(), endDate.atStartOfDay())

  val already = args.headOption.map(_.toInt).getOrElse(0)

  for (n <- 0 to (maxPoints - already) by 20) {
    val newDate = now.atStartOfDay().plusHours(hours * n / maxPoints)

    println(s"${n + already} : $newDate")
  }

  val daysRemaining = ChronoUnit.DAYS.between(now, endDate)

  val formatter =
    DateTimeFormatter.ofPattern("E, MMM d")

  for (n <- 0L until daysRemaining) {
    val newDate = now.plusDays(n)

    val points = maxPoints * n / daysRemaining

    println(s"${newDate.format(formatter)} : $points")
  }
}
