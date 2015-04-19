package com.cloudwick.spark

import com.cloudwick.spark.sparkspec.SparkSpec
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

/**
 * Sample test suite for Spark WordCount application
 * @author ashrith
 */
class WordCountSpec extends FlatSpec with SparkSpec with GivenWhenThen with Matchers {
  "Empty set" should "be counted" in {
    Given("empty set")
    val lines = Array("")

    When("count words")
    val wordCounts = WordCount.count(sc.parallelize(lines), Set()).collect()

    Then("empty count")
    wordCounts shouldBe empty
  }

  "Given a sample words" should "be counted" in {
    Given("quote")
    val lines = Array("The Hello world", "yet again hello world")

    Given("stop words")
    val stopWords = Set("the")

    When("count words")
    val wordCounts = WordCount.count(sc.parallelize(lines), stopWords).collect()

    Then("words counted")
    wordCounts.sortBy(_.word) should equal(Array(
      WordCount("again", 1),
      WordCount("hello", 2),
      WordCount("world", 2),
      WordCount("yet", 1)
    ))
  }
}
