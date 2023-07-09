sealed trait BankAccount {
  def closeAccount(): Unit
  def getBalance: Option[Int]
  def incrementBalance(increment: Int): Option[Int]
}

case class Account() extends BankAccount {
  private var balance: Option[Int] = Some(0)
  override def closeAccount(): Unit = balance = None
  override def getBalance: Option[Int] = balance
  override def incrementBalance(increment: Int): Option[Int] = {
    synchronized {
      balance = balance.map(bal => bal + increment)
      balance
    }
  }
}

object Bank {
  def openAccount(): BankAccount = Account()
}
