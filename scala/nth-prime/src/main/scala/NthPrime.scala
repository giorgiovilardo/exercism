object NthPrime {
  def prime(n: Int): Option[Int] = {
    if (n <= 0) None else {
      val limit = upperBound(n)
      val primeSieve = Array(false).concat(Array(false)).concat(Array.fill(limit - 1)(true)).zipWithIndex
      for (i <- primeSieve) {
        if (i._1) {
          val upperRange = BigInt(i._2)
          for (j <- upperRange * upperRange to limit by i._2) {
            primeSieve(j.toInt) = (false, j.toInt)
          }
        }
      }
      val primes = primeSieve.collect{ case (isPrime, i) if isPrime => i }
      Some(primes(n-1))
    }
  }

  private def upperBound(n: Int): Int = {
    if (n < 6) 100 else math.ceil(n * (math.log(n) + math.log(math.log(n)))).toInt
  }
}
