package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
	def index = Action {
    	Ok(views.html.index("Your new application is ready."))
  	}

  	def renderWithTemplate = Action { implicit request =>
  		Ok(Template.render("scamlTemplate.scaml", Map("title" -> "Template with Scaml")))
  	}

  	def renderWithScalate = Action {
  		Ok(Scalate("scamlTemplate").render('title -> "Scalate with Scaml"))
  	}

  	def renderWithScalateAndFormat = Action {
  		Ok(Scalate("jadeTemplate", "jade").render('title -> "Scalate With Jade"))
  	}

  	def renderSimpleLayout = Action {
  		Ok(Scalate("simpleLayout").render('title -> "Scalate Simple Layout"))
  	}
  
}