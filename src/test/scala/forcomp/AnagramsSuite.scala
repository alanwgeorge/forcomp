package forcomp

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Anagrams._

@RunWith(classOf[JUnitRunner])
class AnagramsSuite extends FunSuite {

  test("wordOccurrences: abcd") {
    assert(wordOccurrences("abcd") === List(('a', 1), ('b', 1), ('c', 1), ('d', 1)))
  }

  test("wordOccurrences: Robert") {
    assert(wordOccurrences("Robert") === List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1)))
  }

  test("sentenceOccurrences: abcd e") {
    assert(sentenceOccurrences(List("abcd", "e")) === List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1)))
    assert(sentenceOccurrences(List("abcde", "e")) === List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 2)))
  }

  test("dictionaryByOccurrences.get: eat") {
    assert(dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1))).map(_.toSet) === Some(Set("ate", "eat", "tea")))
  }

  test("word anagrams: married") {
    assert(wordAnagrams("married").toSet === Set("married", "admirer"))
  }

  test("word anagrams: player") {
    assert(wordAnagrams("player").toSet === Set("parley", "pearly", "player", "replay"))
  }

  test("word anagrams: zzzzz") {
    assert(wordAnagrams("zzzzz").toSet === Set())
  }

  test("subtract: lard - r") {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val r = List(('r', 1))
    val lad = List(('a', 1), ('d', 1), ('l', 1))
    assert(subtract(lard, r) === lad)
  }

  test("subtract") {
    val oc1 = List(('a', 4), ('b', 3), ('c', 1))
    val oc2 = List(('a', 2), ('b', 2))
    val result = List(('a',2), ('b',1), ('c',1))
    assert(subtract(oc1, oc2) === result)
  }

  test("combinations: []") {
    assert(combinations(Nil) === List(Nil))
  }

  test("combinations: abba") {
    val abba = List(('a', 2), ('b', 2))
    val abbacomb = List(
        List(),
        List(('a', 1)),
        List(('a', 2)),
        List(('b', 1)),
        List(('a', 1), ('b', 1)),
        List(('a', 2), ('b', 1)),
        List(('b', 2)),
        List(('a', 1), ('b', 2)),
        List(('a', 2), ('b', 2))
    )
    assert(combinations(abba).toSet === abbacomb.toSet)
  }

  test("sentence anagrams: Heather") {
    assert(sentenceAnagrams(List("Heather")).toSet === Set(List("re", "the", "ha"), List("he", "hat", "re"), List("three", "ha"), List("hare", "the"), List("her", "Thea"), List("at", "he", "her"), List("her", "et", "ha"), List("re", "ah", "the"), List("hear", "the"), List("he", "he", "art") , List("et", "her", "ha"), List("he", "re", "hat"), List("hat", "re", "he"), List("heather"), List("he", "heart"), List("re", "ha", "the"), List("here", "hat"), List("he", "at", "her"), List("he", "hater"), List("ah", "three"), List("her", "heat"), List("he", "earth"), List("there", "ha"), List("ha", "re", "the"), List("re", "heath"), List("et", "ha", "her"), List("ah", "et", "her"), List("ah", "her", "et"), List("re", "the", "ah"), List("he", "he", "rat"), List("rat", "he", "he"), List("ha", "ether"), List("ha", "her", "et"), List("he", "tar", "he"), List("he", "rat", "he"), List("at", "her", "he"), List("ha", "there"), List("ether", "ha"), List("art", "he", "he"), List("ah", "re", "the"), List("tar", "he", "he"), List("hate", "her"), List("the", "hear"), List("he", "art", "he"), List("earth", "he"), List("Rhea", "the"), List("three", "ah"), List("et", "ah", "her"), List("her", "et", "ah"), List("the", "hare"), List("the", "re", "ah"), List("re", "hat", "he"), List("her", "at", "he"), List("hat", "he", "re"), List("he", "he", "tar"), List("ha", "the", "re"), List("the", "Hera"), List("ah", "the", "re"), List("et", "her", "ah"), List("ha", "three"), List("heat", "her"), List("hater", "he"), List("the", "ha", "re"), List("he", "her", "at"), List("heart", "he"), List("there", "ah"), List("ah", "there"), List("ah", "ether"), List("Hera", "the"), List("her", "he", "at"), List("hat", "here"), List("ha", "et", "her"), List("the", "ah", "re"), List("her", "ah", "et"), List("ether", "ah"), List("the", "Rhea"), List("her", "hate"), List("re", "he", "hat"), List("heath", "re"), List("Thea", "her"), List("her", "ha", "et"), List("the", "re", "ha")))
  }

  test("sentence anagrams: []") {
    val sentence = List()
    assert(sentenceAnagrams(sentence) === List(Nil))
  }

  test("sentence anagrams: Linux rulez") {
    val sentence = List("Linux", "rulez")
    val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
  }  

}
