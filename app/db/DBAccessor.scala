package db

import scalikejdbc._

import scala.concurrent.{ExecutionContext, Future}

object DBAccessor {
  private val driver = DBProperties.driver
  private val url = DBProperties.url
  private val username = DBProperties.username
  private val password = DBProperties.password

  Class.forName(driver)
  ConnectionPool.singleton(url, username, password)

  def selectRecords[T](sql: String, getRecord: WrappedResultSet => T)(implicit ec: ExecutionContext): Future[Seq[T]] = {
    Future {
      DB readOnly { implicit session =>
        SQL(sql).map(getRecord).list().apply()
      }
    }
  }

}
