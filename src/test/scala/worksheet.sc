object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val words = List("tea", "eat", "hello", "world")//> words  : List[String] = List(tea, eat, hello, world)
  
  val anagrams = (words.map(word => word.sorted) zip words).groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}
                                                  //> anagrams  : scala.collection.immutable.Map[String,List[String]] = Map(dlorw 
                                                  //| -> List(world), aet -> List(tea, eat), ehllo -> List(hello))
  
  val anagram = anagrams.get("aet")               //> anagram  : Option[List[String]] = Some(List(tea, eat))
}