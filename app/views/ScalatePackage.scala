package views

import org.fusesource.scalate.{Binding, TemplateSource}
import org.fusesource.scalate.support.TemplatePackage


/**
 * Defines some common imports, attributes and methods across templates in package foo and below
 */
class ScalatePackage extends TemplatePackage {

  	/** Returns the Scala code to add to the top of the generated template method */
	override def header(source: TemplateSource, bindings: List[Binding]) = 
		"""
			- import controllers._

	  	""".stripMargin
}