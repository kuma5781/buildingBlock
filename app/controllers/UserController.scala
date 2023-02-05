package controllers

import dto.user.User
import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.{JsObject, Json, Writes}
import play.api.mvc.{Action, AnyContent, InjectedController}
import service.UserService

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class UserController @Inject()(userService: UserService)(implicit ex: ExecutionContext) extends InjectedController {

  implicit val userWrites = new Writes[User] {
    def writes(user: User): JsObject = Json.obj(
      "id" -> user.id,
      "name" -> user.name
    )
  }

  def getUsers(): Action[AnyContent] = Action.async {
        userService.findUsers().map(users => Ok(Json.toJson(users)))
  }

}
