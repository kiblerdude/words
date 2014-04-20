object worksheet {

	import spray.json._
	import DefaultJsonProtocol._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  
  val words = List("tea", "eat", "hello", "world");System.out.println("""words  : List[String] = """ + $show(words ));$skip(114); 
  
  val anagrams = (words.map(word => word.sorted) zip words).groupBy(_._1).map { case (k,v) => (k,v.map(_._2))};System.out.println("""anagrams  : scala.collection.immutable.Map[String,List[String]] = """ + $show(anagrams ));$skip(39); 
  
  val anagram = anagrams.get("aet");System.out.println("""anagram  : Option[List[String]] = """ + $show(anagram ));$skip(35); 
  
  val json = anagram.get.toJson;System.out.println("""json  : spray.json.JsValue = """ + $show(json ));$skip(19); val res$0 = 
  
  json.toString;System.out.println("""res0: String = """ + $show(res$0))}
}
