package dto.user

import entity.UserEntity

case class User(id: Int, name: String)

object User {
  def ofEntity(e: UserEntity): User = {
    User(e.id, e.name)
  }
}
