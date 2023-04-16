package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ActorService {
	@Autowired
	H2JpaI h2JpaI; 
	
	public String registerActor(Actor actor) {
		Actor sactor=h2JpaI.save(actor);
		return"Actor is Registered with iD :: "+sactor.getId();
	}
	

}
