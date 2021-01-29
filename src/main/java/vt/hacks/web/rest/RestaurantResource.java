package vt.hacks.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import vt.hacks.domain.Restaurant;
import vt.hacks.repository.RestaurantRepository;
import vt.hacks.security.AuthoritiesConstants;
import vt.hacks.service.RestaurantService;
import vt.hacks.service.dto.RestaurantDTO;
import vt.hacks.service.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class RestaurantResource {
	
	 private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(Arrays.asList("id", "login", "firstName", "lastName", "email", "activated", "langKey"));

	 private final Logger log = LoggerFactory.getLogger(RestaurantResource.class);
	 
	 @Value("${jhipster.clientApp.name}")
	 private String applicationName;
	 
	 private final RestaurantService restaurantService;
	 
	 private final RestaurantRepository restaurantRepository;
	 
	 public RestaurantResource(RestaurantService restaurantService, RestaurantRepository restaurantRepository) {
		 this.restaurantService = restaurantService;
		 this.restaurantRepository = restaurantRepository;
	 
	 }
	 
	 
	 @GetMapping("/restaurants")
	 public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(Pageable pageable){
		    final Page<RestaurantDTO> page = restaurantService.getAllRestaurants(pageable);
	        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	    
	 }
	 
	 
	 @PostMapping("/restaurant/add")
	 @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.USER + "\")")
	 public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody RestaurantDTO restaurantDto) throws URISyntaxException{
		 Restaurant restaurant = restaurantService.createRestaurant(restaurantDto);
		 
		 return ResponseEntity.created(new URI("/api/restaurant/add/" + restaurantDto.getId()))
	                .headers(HeaderUtil.createAlert(applicationName,  "A restaurant is created with identifier " + restaurant.getName(), restaurant.getName()))
	                .body(restaurant);
	 }

	    
	    

}
