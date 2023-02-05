package db

object DBProperties {
  val driver: String = sys.env("MYSQL_DRIVER")
  val url: String = sys.env("MYSQL_URL")
  val username: String = sys.env("MYSQL_USERNAME")
  val password: String = sys.env("MYSQL_PASSWORD")
}
