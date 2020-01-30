package edu.eci.cvds.tdd.registry;

import edu.eci.cvds.tdd.registry.Gender;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Juan Diaz", 1016087573, 23, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void personShouldBeDead() {

	Person person = new Person("Elmer Cado", 1017087698, 62, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void personShouldBeUnderaged() {

	Person person = new Person("Zoila Mora", 1045023123, 17, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void invalidAgePerson() {

	Person person = new Person("Juan Diaz", 1016087573, -23, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

    }	
    
    @Test
    public void personShouldBeDuplicated() {
	
	Person person0 = new Person("Juan Diaz", 1016087573, 23, Gender.MALE, true);
	Person person1 = new Person("Juan Diaz", 1016087573, 23, Gender.MALE, true);

        RegisterResult result0 = registry.registerVoter(person0);
	RegisterResult result1 = registry.registerVoter(person1);

        Assert.assertEquals(RegisterResult.DUPLICATED, result1);

    }		
}