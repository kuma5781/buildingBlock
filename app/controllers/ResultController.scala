package controllers

import dto.user.ResultResource
import play.api.libs.json.{JsObject, Json, Writes}
import play.api.mvc.{Action, AnyContent, InjectedController}
import service.ResultService

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class ResultController @Inject()(resultService: ResultService)(implicit ex: ExecutionContext) extends InjectedController{

  implicit val resultWrites = new Writes[ResultResource] {
    def writes(resultResource: ResultResource): JsObject = Json.obj(
      "id" -> resultResource.id,
      "userId" -> resultResource.userId,
      "point" -> resultResource.point,
      "userName" -> resultResource.userName,
      "schoolName" -> resultResource.schoolName,
      "responsibleUserName" -> resultResource.responsibleUserName
    )
  }

  /** 結果一覧を全件取得します */
  def getResults(): Action[AnyContent] = Action.async {
    resultService.findResults().map(results => Ok(Json.toJson(results)))
  }

}
