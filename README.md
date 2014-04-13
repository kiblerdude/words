#Words

Words service developed using [http://spray.io](http://spray.io "spray.io").

##APIs

`GET /stats` Return general statistics about the service.

`GET /words/:word` Returns `200 OK` if the word exists in the dictionary or `404 Not Found` if the word does not exist in the dictionary.

##Development

    $ sbt
	> compile
	> re-start
	> re-stop

The following INFO log will appear once the service is started from `sbt` using the `re-start` command: 

> [INFO] [04/13/2014 17:57:39.455] [on-spray-can-akka.actor.default-dispatcher-3] [akka://on-spray-can/user/IO-HTTP/listener-0] Bound t
o localhost/127.0.0.1:8080

Open a web browser to [http://localhost:8080/stats](http://localhost:8080/stats) and you should see:

> Dictionary has 4953699 words.

### Dictionary File

The dictionary file was generated on Linux using `/usr/share/dict/words` with `cat /usr/share/dict/words > words.txt`. 