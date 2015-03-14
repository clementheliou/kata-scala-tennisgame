package tennis

class TennisGame1(player1Name: String, player2Name: String) extends TennisGame {

  val player1 = Player(player1Name)
  val player2 = Player(player2Name)
  val players = Seq(player1, player2)

  def wonPoint(playerName: String) {
    players.filter(_.name equals playerName).foreach(_.incrementScore())
  }

  def calculateScore(): String = (player1, player2) match {
    case ADVANTAGE(player) => s"Advantage ${player.name}"
    case CLASSICAL(p1, p2) => s"${p1.scoreLabel}-${p2.scoreLabel}"
    case DEUCE() => "Deuce"
    case TIGHT(score) => s"$score-All"
    case WIN(player) => s"Win for ${player.name}"
  }

}