object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(54); 
  
  val words = List("tea", "eat", "hello", "world");System.out.println("""words  : List[String] = """ + $show(words ));$skip(114); 
  
  val anagrams = (words.map(word => word.sorted) zip words).groupBy(_._1).map { case (k,v) => (k,v.map(_._2))};System.out.println("""anagrams  : scala.collection.immutable.Map[String,List[String]] = """ + $show(anagrams ));$skip(39); 
  
  val anagram = anagrams.get("aet");System.out.println("""anagram  : Option[List[String]] = """ + $show(anagram ))}
}
