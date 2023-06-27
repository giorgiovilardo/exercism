class School {
  type DB = Map[Int, Seq[String]]

  private var _db: DB = Map[Int, Seq[String]]()

  def add(name: String, grade: Int) = {
    _db = db + (grade -> (db.getOrElse(grade, Seq()) :+ name))
    _db
  }

  def db: DB = _db

  def grade(g: Int): Seq[String] = _db.getOrElse(g, Seq())

  def sorted: DB = _db.toSeq.map(tuple => (tuple._1, tuple._2.sorted)).sortBy(_._1).toMap
}

