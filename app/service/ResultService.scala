package service

import dto.user.ResultResource
import repository.resultRepository.ResultRepository

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ResultService @Inject()(resultRepository: ResultRepository)(implicit ex: ExecutionContext) {
  def findResults(): Future[Seq[ResultResource]] = {
    resultRepository.findResults()
  }
}
