package tennis

case class Player(name: String, var score: Int = 0) {
  def incrementScore(): Unit = score += 1

  def scoreLabel = score match {
    case 0 => "Love"
    case 1 => "Fifteen"
    case 2 => "Thirty"
    case 3 => "Forty"
  }

  def notSameScore(other: Player) = !sameScore(other)

  def sameScore(other: Player) = score == other.score

}
