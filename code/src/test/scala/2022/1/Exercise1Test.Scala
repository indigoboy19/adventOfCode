import Exercise1

import org.scalatest.funsuite.AnyFunSuite

class Exercise1Test extends AnyFunSuite {
    test("An empty Set should have size 0") {
        assert(Set.empty.size == 0)
    }

}