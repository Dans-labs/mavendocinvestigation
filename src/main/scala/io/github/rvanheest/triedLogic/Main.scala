package io.github.rvanheest.triedLogic

import scala.util.{ Success, Try }

object Main extends App {

	implicit class TriedBooleanLogic(val b: Boolean) extends AnyVal {
		def &&(t2: => Try[Boolean]): Try[Boolean] = {
			if (b) t2
			else Success(false)
		}
	}

	def foo = Success(false)
	def bar(implicit x: Int) = Success(true)

	def fooCall: Try[Boolean] = true && foo
	def barCall(implicit implParam: Int): Try[Boolean] = true && bar
}
