package vt.hacks.config.dbmigrations;

import vt.hacks.domain.Authority;
import vt.hacks.domain.Restaurant;
import vt.hacks.domain.User;
import vt.hacks.security.AuthoritiesConstants;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);

        User systemUser = new User();
        systemUser.setId("user-0");
        systemUser.setLogin("system");
        systemUser.setPassword("$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
        systemUser.setFirstName("");
        systemUser.setLastName("System");
        systemUser.setEmail("system@localhost");
        systemUser.setActivated(true);
        systemUser.setLangKey("en");
        systemUser.setCreatedBy(systemUser.getLogin());
        systemUser.setCreatedDate(Instant.now());
        systemUser.getAuthorities().add(adminAuthority);
        systemUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(systemUser);

        User anonymousUser = new User();
        anonymousUser.setId("user-1");
        anonymousUser.setLogin("anonymoususer");
        anonymousUser.setPassword("$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("User");
        anonymousUser.setEmail("anonymous@localhost");
        anonymousUser.setActivated(true);
        anonymousUser.setLangKey("en");
        anonymousUser.setCreatedBy(systemUser.getLogin());
        anonymousUser.setCreatedDate(Instant.now());
        mongoTemplate.save(anonymousUser);

        User adminUser = new User();
        adminUser.setId("user-2");
        adminUser.setLogin("admin");
        adminUser.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        adminUser.setFirstName("admin");
        adminUser.setLastName("Administrator");
        adminUser.setEmail("admin@localhost");
        adminUser.setActivated(true);
        adminUser.setLangKey("en");
        adminUser.setCreatedBy(systemUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);

        User userUser = new User();
        userUser.setId("user-3");
        userUser.setLogin("user");
        userUser.setPassword("$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
        userUser.setFirstName("");
        userUser.setLastName("User");
        userUser.setEmail("user@localhost");
        userUser.setActivated(true);
        userUser.setLangKey("en");
        userUser.setCreatedBy(systemUser.getLogin());
        userUser.setCreatedDate(Instant.now());
        userUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(userUser);
    }
    
    @ChangeSet(order = "03", author = "initiator", id = "03-addRestaurants")
    public void addRestaurants(MongoTemplate mongoTemplate) {
    	
    	Restaurant pks = new Restaurant();
    	pks.setName("pks");
    	pks.setCuisine("American");
    	pks.setBar(1);
    	pks.setSpecials("Tuesday");
    	pks.setLocation("Downtown Blacksburg");
    	pks.setPrice(2);
    	mongoTemplate.save(pks);
    	
    	Restaurant elRods = new Restaurant();
    	elRods.setName("El Rods");
    	elRods.setCuisine("Mexican");
    	elRods.setBar(1);
    	elRods.setSpecials("");
    	elRods.setLocation("Downtown Blacksburg");
    	elRods.setPrice(2);
    	mongoTemplate.save(elRods);
    	
    	Restaurant wendys = new Restaurant();
    	wendys.setName("Wendys");
    	wendys.setCuisine("Fast Food");
    	wendys.setBar(0);
    	wendys.setSpecials("");
    	wendys.setLocation("Downtown Blacksburg");
    	wendys.setPrice(1);
    	mongoTemplate.save(wendys);
    	
    	Restaurant bar201 = new Restaurant();
    	bar201.setName("622 Restaurant and Bar");
    	bar201.setCuisine("Eclectic ");
    	bar201.setBar(1);
    	bar201.setSpecials("");
    	bar201.setLocation("Downtown Blacksburg");
    	bar201.setPrice(3);
    	mongoTemplate.save(bar201);
    	
    	Restaurant mcDonalds = new Restaurant();
    	mcDonalds.setName("McDonalds");
    	mcDonalds.setCuisine("Fast Food");
    	mcDonalds.setBar(0);
    	mcDonalds.setSpecials("");
    	mcDonalds.setLocation("Downtown Blacksburg");
    	mcDonalds.setPrice(1);
    	mongoTemplate.save(mcDonalds);
    	
    	Restaurant cellar = new Restaurant();
    	cellar.setName("Cellar");
    	cellar.setCuisine("Greek");
    	cellar.setBar(1);
    	cellar.setSpecials("");
    	cellar.setLocation("Downtown Blacksburg");
    	cellar.setPrice(2);
    	mongoTemplate.save(cellar);
    	
    	Restaurant sharkeys = new Restaurant();
    	sharkeys.setName("Sharkeys");
    	sharkeys.setCuisine("American");
    	sharkeys.setBar(1);
    	sharkeys.setSpecials("Wednesday, Sunday");
    	sharkeys.setLocation("Downtown Blacksburg");
    	sharkeys.setPrice(2);
    	mongoTemplate.save(sharkeys);
    	
    	Restaurant moes = new Restaurant();
    	moes.setName("Moes");
    	moes.setCuisine("Mexican");
    	moes.setBar(0);
    	moes.setSpecials("Monday");
    	moes.setLocation("Downtown Blacksburg");
    	moes.setPrice(2);
    	mongoTemplate.save(moes);
    	
    	Restaurant fivermill = new Restaurant();
    	fivermill.setName("Rivermill");
    	fivermill.setCuisine("American");
    	fivermill.setBar(1);
    	fivermill.setSpecials("");
    	fivermill.setLocation("Downtown Blacksburg");
    	fivermill.setPrice(2);
    	mongoTemplate.save(fivermill);
    	
    	Restaurant bennys = new Restaurant();
    	bennys.setName("Bennys");
    	bennys.setCuisine("Italian");
    	bennys.setBar(0);
    	bennys.setSpecials("");
    	bennys.setLocation("Downtown Blacksburg");
    	bennys.setPrice(2);
    	mongoTemplate.save(bennys);
    	
    	Restaurant tots = new Restaurant();
    	tots.setName("TOTS");
    	tots.setCuisine("American");
    	tots.setBar(1);
    	tots.setSpecials("Wednesday");
    	tots.setLocation("Downtown Blacksburg");
    	tots.setPrice(3);
    	mongoTemplate.save(tots);
    	
    	Restaurant cookout = new Restaurant();
    	cookout.setName("Cook Out");
    	cookout.setCuisine("Fast Food");
    	cookout.setBar(0);
    	cookout.setSpecials("");
    	cookout.setLocation("Blacksburg");
    	cookout.setPrice(1);
    	mongoTemplate.save(cookout);
    	
    	Restaurant cabo = new Restaurant();
    	cabo.setName("Cabo Fish Taco");
    	cabo.setCuisine("Mexican");
    	cabo.setBar(1);
    	cabo.setSpecials("");
    	cabo.setLocation("Downtown Blacksburg");
    	cabo.setPrice(2);
    	mongoTemplate.save(cabo);
        
        Restaurant dueSouth = new Restaurant();
    	dueSouth.setName("Due South BBQ");
    	dueSouth.setCuisine("BBQ");
    	dueSouth.setBar(0);
    	dueSouth.setSpecials("");
    	dueSouth.setLocation("Christiansburg");
    	dueSouth.setPrice(2);
    	mongoTemplate.save(dueSouth);
        
        Restaurant redRobin = new Restaurant();
    	redRobin.setName("Red Robin");
    	redRobin.setCuisine("American");
    	redRobin.setBar(1);
    	redRobin.setSpecials("");
    	redRobin.setLocation("Christiansburg");
    	redRobin.setPrice(2);
    	mongoTemplate.save(redRobin);
        
        Restaurant marcoAndLucas = new Restaurant();
    	marcoAndLucas.setName("Marco And Lucas");
    	marcoAndLucas.setCuisine("Asian");
    	marcoAndLucas.setBar(0);
    	marcoAndLucas.setSpecials("");
    	marcoAndLucas.setLocation("Blacksburg");
    	marcoAndLucas.setPrice(1);
    	mongoTemplate.save(marcoAndLucas);
        
        Restaurant firehouse = new Restaurant();
    	firehouse.setName("Firehouse");
    	firehouse.setCuisine("American");
    	firehouse.setBar(0);
    	firehouse.setSpecials("");
    	firehouse.setLocation("Blacksburg");
    	firehouse.setPrice(2);
    	mongoTemplate.save(firehouse);
        
        Restaurant carolLeeDonuts = new Restaurant();
    	carolLeeDonuts.setName("Carol Lee Donuts");
    	carolLeeDonuts.setCuisine("Breakfast");
    	carolLeeDonuts.setBar(0);
    	carolLeeDonuts.setSpecials("");
    	carolLeeDonuts.setLocation("Blacksburg");
    	carolLeeDonuts.setPrice(1);
    	mongoTemplate.save(carolLeeDonuts);
        
        Restaurant blacksburgTavern = new Restaurant();
    	blacksburgTavern.setName("Blacksburg Tavern");
    	blacksburgTavern.setCuisine("American");
    	blacksburgTavern.setBar(1);
    	blacksburgTavern.setSpecials("");
    	blacksburgTavern.setLocation("Downtown Blacksburg");
    	blacksburgTavern.setPrice(2);
    	mongoTemplate.save(blacksburgTavern);
        
        Restaurant dpDoughs = new Restaurant();
    	dpDoughs.setName("D.P. Dough");
    	dpDoughs.setCuisine("Italian");
    	dpDoughs.setBar(0);
    	dpDoughs.setSpecials("Daily Calzone");
    	dpDoughs.setLocation("Downtown Blacksburg");
    	dpDoughs.setPrice(2);
    	mongoTemplate.save(dpDoughs);
        
        Restaurant bww = new Restaurant();
    	bww.setName("Buffalo Wild Wings");
    	bww.setCuisine("American");
    	bww.setBar(1);
    	bww.setSpecials("Tuesday/Thursday BOGO");
    	bww.setLocation("Blacksburg");
    	bww.setPrice(2);
    	mongoTemplate.save(bww);
        
        Restaurant souvlaki = new Restaurant();
    	souvlaki.setName("Souvlaki");
    	souvlaki.setCuisine("Greek");
    	souvlaki.setBar(0);
    	souvlaki.setSpecials("");
    	souvlaki.setLocation("Downtown Blacksburg");
    	souvlaki.setPrice(1);
    	mongoTemplate.save(souvlaki);
        
        Restaurant helloBagel = new Restaurant();
    	helloBagel.setName("Hello Bagel");
    	helloBagel.setCuisine("Breakfast");
    	helloBagel.setBar(0);
    	helloBagel.setSpecials("");
    	helloBagel.setLocation("Blacksburg");
    	helloBagel.setPrice(1);
    	mongoTemplate.save(helloBagel);
        
        Restaurant jimmyJohns = new Restaurant();
    	jimmyJohns.setName("Jimmy Johns");
    	jimmyJohns.setCuisine("Fast Food");
    	jimmyJohns.setBar(0);
    	jimmyJohns.setSpecials("");
    	jimmyJohns.setLocation("Downtown Blacksburg");
    	jimmyJohns.setPrice(1);
    	mongoTemplate.save(jimmyJohns);
        
        Restaurant avellinos  = new Restaurant();
    	avellinos.setName("Avellinos ");
    	avellinos.setCuisine("Italian");
    	avellinos.setBar(1);
    	avellinos.setSpecials("");
    	avellinos.setLocation("Blacksburg");
    	avellinos.setPrice(3);
    	mongoTemplate.save(avellinos);
        
        Restaurant ihop  = new Restaurant();
    	ihop.setName("IHOP ");
    	ihop.setCuisine("Breakfast");
    	ihop.setBar(0);
    	ihop.setSpecials("");
    	ihop.setLocation("Christiansburg");
    	ihop.setPrice(1);
    	mongoTemplate.save(ihop);
    	
    }
 
}
