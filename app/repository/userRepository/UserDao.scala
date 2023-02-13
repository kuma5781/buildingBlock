package repository.userRepository

import com.google.inject.ImplementedBy
import db.DBAccessor
import entity.UserEntity
import scalikejdbc.WrappedResultSet

import java.sql.ResultSet
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
    val name = rs.string("name")
    UserEntity(id, name)
  }

  /** @inheritdoc */
  override def selectAll(): Future[Seq[UserEntity]] = {
    val sql = s"SELECT * FROM $tableName"
      DBAccessor.selectRecords(sql, userDto)
  }
}
