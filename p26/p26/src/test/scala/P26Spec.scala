package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P26Spec extends AnyFunSuite with Matchers {

    test("original test case") {
        val p26 = new P26[Symbol]()
        val result = p26.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
        result should be(List(
            List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), List('a, 'b, 'f), 
            List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c, 'f),
            List('a, 'd, 'e), List('a, 'd, 'f),
            List('a, 'e, 'f),
            List('b, 'c, 'd), List('b 'c, 'e), List('b, 'c, 'f),
            List('b, 'd, 'e), List('b 'd, 'f),
            List('b, 'e, 'f),
            List('c, 'd, 'e), List('c, 'd, 'f), 
            List('c, 'e, 'f),
            List('d, 'e, 'f)
            ))
    }

    test("original test case, combination of 1") {
        val p26 = new P26[Symbol]()
        val result = p26.combinations(1, List('a, 'b, 'c, 'd, 'e, 'f))
        result should be(List(List('a), List('b), List('c), List('d), List('e), List('f))
    }

    test("original test case, combination of 2") {
        val p26 = new P26[Symbol]()
        val result = p26.combinations(2, List('a, 'b, 'c, 'd, 'e, 'f))
        result should be(List(
            List('a, 'b), List('a, 'c), List('a, 'd), List('a, 'e), List('a, 'f),
            List('b, 'c), List('b, 'd), List('b, 'e), List('b, 'f),
            List('c, 'd), List('c, 'e), List('c, 'f),
            List('d, 'e), List('d, 'f),
            List('e, 'f)
            )
        )
    }

}