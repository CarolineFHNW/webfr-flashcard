package ch.fhnw.edu.flashcard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller 										 // Die Klasse als PageController deklarieren
@RequestMapping("/jspjstl")							 // Reagiert auf eine URL mit /tiles

public class HelloWorldSpringControllerJspJstl {

	@RequestMapping(value="say/{to}/{from}") 		// Wenn nach /tiles/say kommt, dann diese Methode mit den Parametern "to"/"from"

	/* Der übergebene Parameter to wird in die Variable to gespeichert werden
	 * Der lang Parameter (?lang=de) ist nicht zwingend nötig (required = false) und wird ebenfalls in eine Variable gespeichert*/
	public String sayHello(@PathVariable("to") String to, @PathVariable("from") String from, 
			@RequestParam(value="lang", required=false) String lang, Model uiModel) { 
		

		uiModel.addAttribute("answer", new HelloResponse(to, from, lang));	// Dem Modell den String message mit dem Key message übergeben
		return "jspjstl";									// Das Modell mit dem Namen der richtigen view (?)
	}

}
