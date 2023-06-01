package com.ktcart.webportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcart.webportal.config.SportConfig;
import com.ktcart.webportal.interfaces.ICoach;
@RestController
@RequestMapping("coach") // http://localhost:8080/coach/
public class CoachController {
	
	/* these values are defined in application.properties file 
	 * path - "/src/main/resources/application.properties" */
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.game}")
	private String coachGame;
	
	@Value("${coach.award}")
	private String coachAward;
	
	@Value("${coach.win}")
	private String coachWin;
	
	private ICoach cricket;
	private ICoach football;
	private ICoach hockey;
	private ICoach golf;
	
	@Autowired
	public CoachController(
			
			@Qualifier("Cricket") ICoach cricketCoach, 			
			@Qualifier("Football") ICoach footballCoach,		
			@Qualifier("Hockey") ICoach hockeyCoach,	
			@Qualifier("Golf") ICoach golfCoach	

			/* Both the method are correct
			 * * you can use A @Qualifiers in case you have same Type "ICoach"  OR
			 * * you can change the type from Interface ICoach to there specific class i.e. Cricket, Hockey, Football
			 * If you are using @Qualifiers and @Primary both in the same class remember @Qualifier has the highest priority
			 * @Qualifier is recommended over @Primary because @Qualifier is more specific and you can have more than one @Qualifier */ 
			
		 /* Cricket cricketCoach,
			Football footballCoach,
			Hockey hockeyCoach */
	) {
		football = footballCoach;
		hockey = hockeyCoach;
		cricket = cricketCoach;
		golf = golfCoach;
	}
	
	@GetMapping("")
	public String getCoach() {
		return "get coach stats - \n - name = "+ coachName +"- \n - game = "+ coachGame +"- \n - award = "+ coachAward +"- \n - wins ="+ coachWin;
	}
	
	@GetMapping("/{game}/{task}")
	public String getCoaching(@PathVariable String game, @PathVariable String task) {
		
		switch (game.toLowerCase()) {
			case "cricket":
					return getCoaching(cricket, task);
			case "football":
					return getCoaching(football, task);
			case "hockey":
					return getCoaching(hockey, task);
			case "golf":
				return getCoaching(golf, task);
			default:
					return "no coaching";	
		}
		
	}
	
	private String getCoaching (ICoach game, String task) {
		if(task.toLowerCase().equals("coachdetails")) {
			return game.getCoachDetails();
		} else if( task.toLowerCase().equals("coachinstructions") ) {
			return game.getCoachInstructions();
		} else if(task.toLowerCase().equals("coachtips")) {
			return game.getCoachTip();
		} else {
			return "";
		}
	}


}
