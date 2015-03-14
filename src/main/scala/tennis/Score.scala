package tennis

import scala.math.abs

object ADVANTAGE {
  def unapply(p: (Player, Player)): Option[Player] = {
    if ((p._1.score > 3 || p._2.score > 3) && p._1.notSameScore(p._2) && abs(p._1.score - p._2.score) == 1) {
      Some(Seq(p._1, p._2).maxBy(_.score))
    } else None
  }
}

object CLASSICAL {
  def unapply(p: (Player, Player)): Option[(Player, Player)] = {
    if (p._1.score < 4 && p._2.score < 4 && p._1.notSameScore(p._2)) {
      Some(p)
    } else None
  }
}

object DEUCE {
  def unapply(p: (Player, Player)): Boolean = p._1.score == p._2.score && p._1.score > 2
}

object TIGHT {
  def unapply(p: (Player, Player)): Option[String] = {
    if (p._1.sameScore(p._2) && p._1.score < 3) {
      Some(p._1.scoreLabel)
    } else None
  }
}

object WIN {
  def unapply(p: (Player, Player)): Option[Player] = {
    if ((p._1.score > 3 || p._2.score > 3) && abs(p._1.score - p._2.score) > 1) {
      Some(Seq(p._1, p._2).maxBy(_.score))
    } else None
  }
}