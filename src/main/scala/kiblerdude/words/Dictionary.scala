package kiblerdude.words

import scala.io.Source
import scala.collection.immutable.List
import scala.collection.immutable.HashMap
import scala.util.Sorting

class Dictionary(file: String) {
  
  // load the dictionary file and store the words in lowercase
  val words = Source.fromFile(file, "UTF-8").getLines.map(line => line.trim().toLowerCase()).toList

  // map all the anagrams for the words in the dictionary
  val anagrams = {
    // sort all the strings in the list
    val sorted = words.map(_.sorted)
    // zip the sorted and unsorted strings in the list.  this creates tuples such as:
    // (sorted1, unsorted2), (sorted2, unsorted2), etc...
    val zipped = sorted zip words
    // group the elements in the list by the sorted string.  this combines all the unsorted strings
    // that have the same sorted string, meaning the strings are anagrams of each other.
    zipped.groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}
  }
  
  def size : (Int, Int) = {
    (words.size, anagrams.size)
  }
  
  /**
   * Returns true if the word exists in the dictionary.
   */
  def hasWord(word : String) : Boolean = {
    words.contains(word.toLowerCase())
  }
  
  /**
   * Returns a list of anagrams for the provided word.
   */
  def getAnagrams(word : String) : Option[List[String]] = {
    anagrams.get(word.sorted) match {
		case None => None
		case Some(x) => {
		  val filtered = x.filter(w => !w.equals(word))
		  if (filtered.isEmpty) None
		  else Some(filtered)
		}
    }
  }  
}