package controllers

import play.api._
import play.api.templates.{Html, HtmlFormat}
import http.{Writeable, ContentTypeOf, ContentTypes}
import mvc.Codec
import play.api.Play.current
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import java.io.File

object Scalate {

    import org.fusesource.scalate._
    import org.fusesource.scalate.util._

    var format = Play.configuration.getString("scalate.format") match {
        case Some(configuredFormat) => configuredFormat
        case _ => "scaml"
    }

    lazy val path = Play.application.path

    lazy val scalateEngine = {
        val engine = new TemplateEngine
        engine.resourceLoader = new FileResourceLoader(Some(Play.getFile("app/views")))
        engine.sourceDirectories = new File(path, "app") :: Nil
        engine.layoutStrategy = new DefaultLayoutStrategy(engine, "app/views/layouts/default." + format)
        engine.classpath = "tmp/classes"
        engine.workingDirectory = Play.getFile("tmp")
        engine.combinedClassPath = true
        engine.classLoader = Play.classloader
        engine
    }

    def apply(template: String, myformat: String = format) = Template(template + "." + myformat)

    case class Template(name: String) {

        //def render(args: Map[String, Any] = Map.empty): ScalateContent = {
            //ScalateContent{
                //scalateEngine.layout(name, args)
            //}
        //}

        def render(args: (Symbol, Any)*) = {
            ScalateContent{
                scalateEngine.layout(name, args.map {
                    case (k, v) => k.name -> v
                } toMap)
            }
        }
    }

    case class ScalateContent(val cont: String)

    implicit def writeableOf_ScalateContent[SC <: ScalateContent](implicit codec: Codec): Writeable[SC] = {
        Writeable(scalate => codec.encode(scalate.cont))
    }

    implicit def contentTypeOf_ScalateContent[SC <: ScalateContent](implicit codec: Codec): ContentTypeOf[SC] = {
        ContentTypeOf(Some(ContentTypes.HTML))
    }
}