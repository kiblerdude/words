#Words

Words service developed using [http://spray.io](http://spray.io "spray.io").

##APIs

####`GET /stats` 
Return general statistics about the service.

#####Example
[http://localhost:8080/stats](http://localhost:8080/stats)

	Dictionary has 4 words and 3 anagrams.

####`GET /words/:word` 
Returns `200 OK` if the `word` exists in the dictionary or `404 Not Found` if the word does not exist in the dictionary.

#####Example
[http://localhost:8080/words/tea](http://localhost:8080/words/tea)

	OK
	
####`GET /anagrams/:word` 
Returns `200 OK` and a list of anagrams for the `word` or `404 Not Found` if the word does not have any anagrams.
#####Example
[http://localhost:8080/anagrams/tea](http://localhost:8080/anagrams/tea)

	List(eat)


##Development

    $ sbt
	> compile
	> re-start
	> re-stop

### Dictionary File

The dictionary file was generated on Linux using `/usr/share/dict/words` with `cat /usr/share/dict/words > words.txt`. 