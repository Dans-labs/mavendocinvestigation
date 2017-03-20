package io.github.rvanheest.triedLogic

import scala.util.{Failure, Success, Try}

object Main extends App {

	val st: Try[Boolean] = Success(true)
	val sf: Try[Boolean] = Success(false)
	val f: Try[Boolean] = Failure(new Exception("foobar"))
	val bt: Boolean = true
	val bf: Boolean = false

	// AND
	st && st
	st && sf
	st && f
	st && bt
	st && bf

	sf && st
	sf && sf
	sf && f
	sf && bt
	sf && bf

	f && st
	f && sf
	f && f
	f && bt
	f && bf

	bt && st
	bt && sf
	bt && f
	bt && bt
	bt && bf

	bf && st
	bf && sf
	bf && f
	bf && bt
	bf && bf

	// OR
	st || st
	st || sf
	st || f
	st || bt
	st || bf

	sf || st
	sf || sf
	sf || f
	sf || bt
	sf || bf

	f || st
	f || sf
	f || f
	f || bt
	f || bf

	bt || st
	bt || sf
	bt || f
	bt || bt
	bt || bf

	bf || st
	bf || sf
	bf || f
	bf || bt
	bf || bf

	bf || (bt && st)
}
