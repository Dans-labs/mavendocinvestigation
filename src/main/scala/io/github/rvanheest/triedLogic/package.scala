package io.github.rvanheest

import scala.util.{Success, Try}

package object triedLogic {

	/*
   Logic opperators that work with Try[Boolean]
   TODO future candidate for dans-scala-lib.
   TODO investigate why it doesn't (maven) build with the standard && and || for the case 'Boolean && Try[Boolean]'
     error: type mismatch;
      found   : scala.util.Try[Boolean]
      required: Boolean
            s.stageFileDataAsRedirectDatastreams || (s.stubAVfiles && isAVType(bagRelativePath))
   */
	implicit class TryLogic(val t: Try[Boolean]) extends AnyVal {
		def &&(t2: => Try[Boolean]): Try[Boolean] = {
			t.flatMap {
				case true => t2
				case _ => Success(false)
			}
		}

		// Using DummyImplicit to prevent 'have same type after type erasure' !
		def &&(b: => Boolean)(implicit d: DummyImplicit): Try[Boolean] = {
			t.map {
				case true => b
				case _ => false
			}
		}

		def ||(t2: => Try[Boolean]): Try[Boolean] = {
			t.flatMap {
				case false => t2
				case _ => Success(true)
			}
		}

		// Using DummyImplicit to prevent 'have same type after type erasure' !
		def ||(b: => Boolean)(implicit d: DummyImplicit): Try[Boolean] = {
			t.map {
				case false => b
				case _ => true
			}
		}

		def unary_! : Try[Boolean] = {
			t.map(!_)
		}
	}

	implicit class BooleanLogicWithTry(val b: Boolean) extends AnyVal {
		def &&(t2: => Try[Boolean]): Try[Boolean] = {
			if (b) t2
			else Success(false)
		}

		def ||(t2: => Try[Boolean]): Try[Boolean] = {
			if (b) Success(true)
			else t2
		}
	}
}
