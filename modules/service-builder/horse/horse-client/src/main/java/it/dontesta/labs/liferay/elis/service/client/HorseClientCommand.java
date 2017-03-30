package it.dontesta.labs.liferay.elis.service.client;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseService;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseServiceUtil;


@Component(immediate = true, 
	service = Object.class, 
	property = {
	"osgi.command.function=createHorse",
	"osgi.command.function=getCurrentHorseByAge",
	"osgi.command.function=getAllHorse", 
	"osgi.command.function=getHorseByName",
	"osgi.command.function=getHorseByKind", 
	"osgi.command.scope=elis"
})
public class HorseClientCommand {

    /**
     * Create a Horse
     *
     * @param name
     * @param kind
     * @param mantle
     * @param gender
     * @param age
     */
    public void createHorse(String name, String kind, String mantle, String gender, int age) {

        Horse horse = _horseService.addHorse(name, kind, mantle, gender, age);

        System.out.println("Horse created whit id "
                + horse.getPrimaryKey());
    }

    /**
     * Get all current Horses by age
     *
     * @param age
     */
    public void getCurrentHorseByAge(int age) {

    	List<Horse> horses = _horseService.getCurrentHorseByeAge(age);
        horses.forEach(System.out::println);       
   
    }
    

    /**
     * Get all Horse
     */
    public void getAllHorse() {

    	List<Horse> horses = _horseService.getHorses();
        horses.forEach(System.out::println);       
    }
    
    /**
     * Get Horse by Name
     * 
     * @param name
     */
    public void getHorseByName(String name) {

    	List<Horse> horses = _horseService.getHorsesByName(name);
        horses.forEach(System.out::println);       

    }
    
    /**
     * Get Horse by kind
     * 
     * @param kind
     */
    public void getHorseByKind(String kind) {

    	List<Horse> horses = _horseService.getHorsesByKind(kind);
        horses.forEach(System.out::println);       

    }
    
    @Reference
    protected void setHorseService(HorseService horseService) {
    	_horseService = horseService;
    }

    protected void unsetHorseServiceUtil(HorseServiceUtil horseService) {
    	_horseService = null;
    }

    private HorseService _horseService;
}