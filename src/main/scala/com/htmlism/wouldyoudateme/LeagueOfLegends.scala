package com.htmlism.wouldyoudateme

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object LeagueOfLegends extends App {
  val maxPoints = 500

  val now = LocalDate.now()
  val endDate = LocalDate.of(2020, 8, 9)

  val hours = ChronoUnit.HOURS.between(now.atStartOfDay(), endDate.atStartOfDay())

  for (n <- 0 to maxPoints by 10) {
    val newDate = now.atStartOfDay().plusHours(hours * n / maxPoints)

    println(s"$n : $newDate")
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
