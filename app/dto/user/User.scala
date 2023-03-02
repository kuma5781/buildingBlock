package dto.user

import entity.UserEntity

case class User(id: Int, schoolId: Int, userName: String)

object User {
  def ofEntity(e: UserEntity): User = {
    User(e.id, e.schoolId, e.user_name)
  }
}
