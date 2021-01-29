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
    	pks.setCuisine("american");
    	pks.setBar(1);
    	pks.setSpecials("Tuesday");
    	pks.setLocation("Downtown Blacksburg");
    	pks.setPrice(2);
    	mongoTemplate.save(pks);
    	
    	Restaurant elRods = new Restaurant();
    	elRods.setName("El Rods");
    	elRods.setCuisine("mexican");
    	elRods.setBar(1);
    	elRods.setSpecials("");
    	elRods.setLocation("Downtown Blacksburg");
    	elRods.setPrice(2);
    	mongoTemplate.save(elRods);
    	
    	Restaurant wendys = new Restaurant();
    	wendys.setName("Wendys");
    	wendys.setCuisine("fast food");
    	wendys.setBar(0);
    	wendys.setSpecials("");
    	wendys.setLocation("Downtown Blacksburg");
    	wendys.setPrice(1);
    	mongoTemplate.save(wendys);
    	
    	Restaurant bar201 = new Restaurant();
    	bar201.setName("622 Restaurant and Bar");
    	bar201.setCuisine("");
    	bar201.setBar(1);
    	bar201.setSpecials("");
    	bar201.setLocation("Downtown Blacksburg");
    	bar201.setPrice(2);
    	mongoTemplate.save(bar201);
    	
    	Restaurant mcDonalds = new Restaurant();
    	mcDonalds.setName("McDonalds");
    	mcDonalds.setCuisine("fast food");
    	mcDonalds.setBar(0);
    	mcDonalds.setSpecials("");
    	mcDonalds.setLocation("Downtown Blacksburg");
    	mcDonalds.setPrice(1);
    	mongoTemplate.save(mcDonalds);
    	
    	Restaurant cellar = new Restaurant();
    	cellar.setName("Cellar");
    	cellar.setCuisine("greek");
    	cellar.setBar(1);
    	cellar.setSpecials("");
    	cellar.setLocation("Downtown Blacksburg");
    	cellar.setPrice(2);
    	mongoTemplate.save(cellar);
    	
    	Restaurant sharkeys = new Restaurant();
    	sharkeys.setName("Sharkeys");
    	sharkeys.setCuisine("American");
    	sharkeys.setBar(1);
    	sharkeys.setSpecials("");
    	sharkeys.setLocation("Downtown Blacksburg");
    	sharkeys.setPrice(2);
    	mongoTemplate.save(sharkeys);
    	
    	Restaurant moes = new Restaurant();
    	moes.setName("Moes");
    	moes.setCuisine("Mexican");
    	moes.setBar(0);
    	moes.setSpecials("");
    	moes.setLocation("Downtown Blacksburg");
    	moes.setPrice(2);
    	mongoTemplate.save(moes);
    	
    	Restaurant fivermill = new Restaurant();
    	fivermill.setName("Fivermill");
    	fivermill.setCuisine("American");
    	fivermill.setBar(1);
    	fivermill.setSpecials("");
    	fivermill.setLocation("Downtown Blacksburg");
    	fivermill.setPrice(2);
    	mongoTemplate.save(fivermill);
    	
    	Restaurant bennys = new Restaurant();
    	bennys.setName("Bennys");
    	bennys.setCuisine("Italian");
    	bennys.setBar(1);
    	bennys.setSpecials("");
    	bennys.setLocation("Downtown Blacksburg");
    	bennys.setPrice(2);
    	mongoTemplate.save(bennys);
    	
    	Restaurant tots = new Restaurant();
    	tots.setName("Tots");
    	tots.setCuisine("American");
    	tots.setBar(1);
    	tots.setSpecials("");
    	tots.setLocation("Downtown Blacksburg");
    	tots.setPrice(3);
    	mongoTemplate.save(tots);
    	
    	Restaurant sochouse = new Restaurant();
    	sochouse.setName("Social House");
    	sochouse.setCuisine("");
    	sochouse.setBar(0);
    	sochouse.setSpecials("");
    	sochouse.setLocation("Downtown Blacksburg");
    	sochouse.setPrice(2);
    	mongoTemplate.save(sochouse);
    	
    	Restaurant cookout = new Restaurant();
    	cookout.setName("Cook Out");
    	cookout.setCuisine("fast food");
    	cookout.setBar(0);
    	cookout.setSpecials("");
    	cookout.setLocation("Downtown Blacksburg");
    	cookout.setPrice(1);
    	mongoTemplate.save(cookout);
    	
    	Restaurant cabo = new Restaurant();
    	cabo.setName("Cabo");
    	cabo.setCuisine("Mexican");
    	cabo.setBar(1);
    	cabo.setSpecials("");
    	cabo.setLocation("Downtown Blacksburg");
    	cabo.setPrice(2);
    	mongoTemplate.save(cabo);
    	
    }
 
}
