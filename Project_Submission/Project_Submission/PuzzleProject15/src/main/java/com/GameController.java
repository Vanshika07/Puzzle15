package com;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
public class GameController {
	
 
 
 @Autowired
 GameService gameService;
 
 @RequestMapping(value="msg")
public ModelAndView getout()
{
	 System.out.println("I Came here");
	return new ModelAndView("index");
}
 
 @RequestMapping(value="PuzzleSollution/{data}",method=RequestMethod.GET)
 public String getOptimisedSolution(@PathVariable("data") String inputSequence)
 {
	System.out.println("In PuzzleSolution"); 
	System.out.println("Data "+inputSequence);
	 return gameService.findOptimizedSolution(inputSequence);
 }
 
 
 
}