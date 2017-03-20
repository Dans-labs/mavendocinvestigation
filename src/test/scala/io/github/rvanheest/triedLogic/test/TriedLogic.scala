package io.github.rvanheest.triedLogic.test

import org.scalatest.{ FlatSpec, Matchers }

class TriedLogic extends FlatSpec with Matchers {

  "test" should "succeed" in {
    1 + 1 shouldBe 2
  }
}
