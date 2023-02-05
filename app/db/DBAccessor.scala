package db

import java.sql.{DriverManager, ResultSet, Statement}
import scala.concurrent.{ExecutionContext, Future}

object DBAccessor {
  private val driver = DBProperties.driver
  private val url = DBProperties.url
  private val username = DBProperties.username
  private val password = DBProperties.password

  Class.forName(driver)

  def selectRecords[T](sql: String, getRecord: ResultSet => T)(implicit ec: ExecutionContext): Future[Seq[T]] = {
    val readRecords = (stmt: Statement) => {
      val rs = stmt.executeQuery(sql)
      var records = Seq.empty[T]
      while (rs.next) records = records :+ getRecord(rs)
      records
    }
    connect(readRecords)
  }

  private def connect[T](fun: Statement => T)(implicit ec: ExecutionContext): Future[T] = {
    val con = DriverManager.getConnection(url, username, password)
    val resultFuture = Future {
      val stmt = con.createStatement
      fun(stmt)
    }
    for {
      result <- resultFuture
      _ = con.close()
    } yield result
  }

}
