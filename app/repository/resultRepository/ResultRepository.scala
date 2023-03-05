package repository.resultRepository

import com.google.inject.ImplementedBy
import dto.user.ResultResource

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[ResultRepositoryImpl])
trait ResultRepository {
  def findResults(): Future[Seq[ResultResource]]
}

@Singleton
class ResultRepositoryImpl @Inject()(resultDao: ResultDao)(implicit ex: ExecutionContext) extends ResultRepository {
  override def findResults(): Future[Seq[ResultResource]] = {
    resultDao.selectResultResources()
  }
}


