package com.cloudwick.spark

import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

/**
 * Simple word count application to illustrate spark standalone applications usage
 * @author ashrith
 */

case class WordCount(word: String, count: Int)

object WordCount {
  def count(lines: RDD[String], stopWords: Set[String]):RDD[WordCount] = {
    val words = prepareWords(lines, stopWords)

    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _).map {
      case (word: String, count: Int) => WordCount(word, count)
    }

    wordCounts
  }

  def prepareWords(lines: RDD[String], stopWords: Set[String]): RDD[String] = {
    lines.flatMap(_.split("\\s+"))
      .map(_.strip(",").strip(".").toLowerCase)
      .filter(!stopWords.contains(_)).filter(!_.isEmpty)
  }
}
