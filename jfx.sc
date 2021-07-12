
import $ivy.{
  `org.scalafx::scalafx:16.0.0-R24`
}

lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
javaFXModules.map(m =>
  interp.load.ivy(coursierapi.Dependency.of("org.openjfx", s"javafx-$m", "15.0.1").withClassifier(osName))
)
