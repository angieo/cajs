package controllers

import org.fusesource.scalate.{DefaultRenderContext, TemplateEngine}
import java.io.{StringWriter, PrintWriter}
import play.api.mvc.{AnyContent, Request}
import play.api.templates.Html
import play.api.Play.current
import play.api.Play


/**
 * Created with IntelliJ IDEA.
 * User: antoine
 * Date: 01/06/12
 * Time: 16:43
 */

object Template {

  val basePath="app/views/"
  val engine:TemplateEngine=new TemplateEngine()
  engine.classLoader=Play.classloader

  def render(templateName:String, args:Map[String,Any]=Map())(implicit request:Request[AnyContent])={
    val buffer=new StringWriter()
    val context=new DefaultRenderContext(request.uri,engine,new PrintWriter(buffer))
    for (varName <- args.keys) context.attributes(varName)=args(varName)
    engine.layout(basePath+templateName,context)
    Html(buffer.toString)
  }
  
}