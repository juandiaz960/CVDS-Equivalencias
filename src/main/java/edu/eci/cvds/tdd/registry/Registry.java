package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
    private ArrayList<Integer> ids = new ArrayList<>();
    public RegisterResult registerVoter(Person p) {

        if (p.isAlive()==false){
		return RegisterResult.DEAD;
	}else if (p.getAge()<18 && p.getAge()>0){
		return RegisterResult.UNDERAGE;
	}else if (p.getAge()<0){
		return RegisterResult.INVALID_AGE;
	}
	else{	
		for(int i=0; i<ids.size(); i++){
			if(p.getId()==ids.get(i)){
				return RegisterResult.DUPLICATED;
			}
		}
		ids.add(p.getId());		
        	return RegisterResult.VALID;
	}
    }
}