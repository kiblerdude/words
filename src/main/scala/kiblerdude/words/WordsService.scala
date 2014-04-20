package kiblerdude.words

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.MediaTypes._
import spray.httpx.marshalling.ToResponseMarshallable.isMarshallable
import spray.routing.Directive.pimpApply

class WordsServiceActor extends Actor with WordsService {
  def actorRefFactory = context
  def receive = runRoute(route)
}

// TODO return JSON response
// TODO subwords API

trait WordsService extends HttpService {
  val dictionary = new Dictionary("./src/main/resources/test.txt");
  val route: Route =
    path("words" / ".*".r) { word =>
      get {
        if (dictionary.hasWord(word)) complete(StatusCodes.OK)
        else complete(StatusCodes.NotFound)
      }
    } ~
    path("anagrams" / ".*".r) { word =>
      get {      
        dictionary.getAnagrams(word) match {
          case None => complete(StatusCodes.NotFound)
          case Some(x) => complete(x.toString)
        }
      }
    } ~
    path("stats") {
      get {
          complete {
           "Dictionary has " + dictionary.size._1 + " words and " + dictionary.size._2 + " anagrams."
          }	
      }
    }
}