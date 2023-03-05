package repository.resultRepository

import com.google.inject.ImplementedBy
import db.DBAccessor
import dto.user.ResultResource
import scalikejdbc.WrappedResultSet

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[ResultDaoImpl])
trait ResultDao {
  /** 結果一覧を取得します */
  def selectResultResources(): Future[Seq[ResultResource]]
}

@Singleton
class ResultDaoImpl @Inject()()(implicit ex: ExecutionContext) extends ResultDao {
  private val tableName = "results"
  private val userTableName = "users"
  private val schoolTableName = "school"
  private val responsibleUserTableName = "responsible_users"

  private val resultDto = (rs: WrappedResultSet) => {
    val id = rs.int("id")
    val userId = rs.int("user_id")
    val point = rs.double("point")
    val userName = rs.string("user_name")
    val schoolName = rs.string("school_name")
    val responsibleUserName = rs.string("responsible_user_name")
    ResultResource(
      id, userId, point, userName, schoolName, responsibleUserName
    )
  }

  /** 結果一覧を取得します */
  override def selectResultResources(): Future[Seq[ResultResource]] = {
    // ここでDBアクセスしてもいいかも。SQLのSyntaxSupport入れたい
    val sql = {
      s"""
        | SELECT r.id, u.id as user_id, r.point, u.user_name, s.school_name, res.responsible_user_name FROM $tableName as r
        | INNER JOIN $userTableName as u
        | ON r.user_id = u.id
        | INNER JOIN $schoolTableName as s
        | ON u.school_id = s.id
        | INNER JOIN $responsibleUserTableName as res
        | ON r.responsible_user_id = res.id
      """.stripMargin
    }
    DBAccessor.selectRecords(sql, resultDto)
  }
}