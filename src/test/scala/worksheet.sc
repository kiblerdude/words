object worksheet {

	import spray.json._
	import DefaultJsonProtocol._
  
  val words = List("tea", "eat", "hello", "world")//> words  : List[String] = List(tea, eat, hello, world)
  
  val anagrams = (words.map(word => word.sorted) zip words).groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}
                                                  //> anagrams  : scala.collection.immutable.Map[String,List[String]] = Map(dlorw 
                                                  //| -> List(world), aet -> List(tea, eat), ehllo -> List(hello))
  
  val anagram = anagrams.get("aet")               //> anagram  : Option[List[String]] = Some(List(tea, eat))
  
  val json = anagram.get.toJson                   //> json  : spray.json.JsValue = ["tea","eat"]
  
  json.toString                                   //> res0: String = ["tea","eat"]
}