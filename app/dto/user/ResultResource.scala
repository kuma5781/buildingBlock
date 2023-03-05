package dto.user

case class ResultResource(
    id: Int,
    userId: Int,
    point: Double,
    userName: String,
    schoolName: String,
    responsibleUserName: String
)
