package db

import scalikejdbc._

import scala.concurrent.{ExecutionContext, Future}

object DBAccessor {
  Class.forName(DBProperties.driver)
  ConnectionPool.singleton(DBProperties.url, DBProperties.username, DBProperties.password)

  def selectRecords[T](sql: String, getRecord: WrappedResultSet => T)(implicit ec: ExecutionContext): Future[Seq[T]] = {
    Future {
      DB readOnly { implicit session =>
        SQL(sql).map(getRecord).list().apply()
      }
    }
  }

}
