package com.cloudwick

/**
 * Pakcage object for examples
 * @author ashrith
 */
package object spark {
  implicit class StringUtils(val value: String) {
    def strip(stripChars: String): String = value.stripPrefix(stripChars).stripSuffix(stripChars)
  }
}
