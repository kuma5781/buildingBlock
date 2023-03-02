package service

import dto.user.User
import repository.userRepository.UserRepository

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userRepository: UserRepository)(implicit ec: ExecutionContext) {
  def findUsers(): Future[Seq[User]] = {
    userRepository.findAll()
  }


}
