package repository.userRepository

import com.google.inject.ImplementedBy
import db.DBAccessor
import entity.UserEntity
import scalikejdbc.WrappedResultSet
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[UserDaoImpl])
trait UserDao {
  /** 全ユーザを取得します */
  def selectAll(): Future[Seq[UserEntity]]
}

class UserDaoImpl @Inject()()(implicit ec: ExecutionContext) extends UserDao {
  
  private val tableName = "users"

  private val userDto = (rs: WrappedResultSet) => {
    val id = rs.int("id")
    val schoolId = rs.int("school_id")
    val userName = rs.string("user_name")
    UserEntity(id, schoolId, userName)
  }

  /** 全ユーザを取得します */
  override def selectAll(): Future[Seq[UserEntity]] = {
    val sql = s"SELECT * FROM $tableName"
      DBAccessor.selectRecords(sql, userDto)
  }
}
