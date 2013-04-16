import sbt._
import Keys._
import play.Project._
import com.gu.SbtJasminePlugin._

object ApplicationBuild extends Build {

	val appName         = "cajs"
	val appVersion      = "1.0-SNAPSHOT"

	val appDependencies = Seq(
		// Add your project dependencies here,
		jdbc,
		anorm,
		"org.fusesource.scalate" % "scalate-core_2.10" % "1.6.1"
	)


	val main = play.Project(appName, appVersion, appDependencies)
	.settings(
		// Add your own project settings here  
		coffeescriptOptions := Seq("bare")
	)
	.settings(
		jasmineSettings : _*
	)
	.settings(
      // Add your own project settings here

      // jasmine configuration, overridden as we don't follow the default project structure sbt-jasmine expects
      appJsDir <+= baseDirectory( _ / "target" / "scala-2.10" / "resource_managed" / "main" / "public" / "javascripts"),
      appJsLibDir <+= baseDirectory( _ / "public" / "javascripts" / "lib"),
      jasmineTestDir <+= baseDirectory( _ / "test" / "assets"),
      jasmineConfFile <+= baseDirectory( _ / "test" / "assets" / "test.dependencies.js"),
      // link jasmine to the standard 'sbt test' action. Now when running 'test' jasmine tests will be run
      // and after that other Play tests will be executed.
      (test in Test) <<= (test in Test) dependsOn (jasmine)
    )

}
