package kiblerdude.words

import scala.io.Source;
import scala.collection.immutable.List

class Dictionary(file: String) {
  
  val words = Source.fromFile(file, "UTF-8").toList
  
  def size : Int = {
    words.size
  }
  
  def contains(word : String) : Boolean = {
    words.contains(word)
  }
}