package kiblerdude.words

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.MediaTypes._
import spray.httpx.marshalling.ToResponseMarshallable.isMarshallable
import spray.routing.Directive.pimpApply

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class WordsServiceActor extends Actor with WordsService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(route)
}

// this trait defines our service behavior independently from the service actor
trait WordsService extends HttpService {
  val dictionary = new Dictionary("./src/main/resources/words.txt");
  val route: Route =
    path("words" / ".*".r) { word =>
      get {
        if (dictionary.contains(word)) complete(StatusCodes.OK)
        else complete(StatusCodes.NotFound)
      }
    } ~
    path("stats") {
        get {
          complete {
            "Dictionary has " + dictionary.size + " words."
      }
    }
  }
}