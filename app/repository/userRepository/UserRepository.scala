package repository.userRepository

import com.google.inject.ImplementedBy
import dto.user.User

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[UserRepositoryImpl])
trait UserRepository {

  /** 全ユーザを取得します */
  def findAll: Future[Seq[User]]

}

@Singleton
class UserRepositoryImpl @Inject()(userDao: UserDao)(implicit ex: ExecutionContext) extends UserRepository {

  /** @inheritdoc */
  override def findAll: Future[Seq[User]] = {
    userDao.selectAll().map(_.map(User.ofEntity))
  }

}
