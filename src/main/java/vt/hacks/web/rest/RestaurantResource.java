package vt.hacks.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import vt.hacks.domain.Restaurant;
import vt.hacks.repository.RestaurantRepository;
import vt.hacks.service.RestaurantService;
import vt.hacks.service.dto.RestaurantDTO;

@RestController
@RequestMapping("/api")
public class RestaurantResource {
	
	 @Value("${jhipster.clientApp.name}")
	 private String applicationName;
	 
	 private final RestaurantService restaurantService;
	
	 
	 public RestaurantResource(RestaurantService restaurantService, RestaurantRepository restaurantRepository) {
		 this.restaurantService = restaurantService;
	 }
	 
	 /**
	  * Pull a list of all existing restaurants
	  * @param pageable
	  * @return
	  */
	 @GetMapping("/restaurants")
	 public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(Pageable pageable){
		    final Page<RestaurantDTO> page = restaurantService.getAllRestaurants(pageable);
	        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	    
	 }
	 
	 /**
	  * Create a new restaurant
	  * 
	  * @param restaurantDto
	  * @return
	  * @throws URISyntaxException
	  */
	 @PostMapping("/restaurant/add")
	 public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody RestaurantDTO restaurantDto) throws URISyntaxException{
		 Restaurant restaurant = restaurantService.createRestaurant(restaurantDto);
		 
		 return ResponseEntity.created(new URI("/api/restaurant/add/" + restaurantDto.getId()))
	                .headers(HeaderUtil.createAlert(applicationName,  "A restaurant is created with identifier " + restaurant.getName(), restaurant.getName()))
	                .body(restaurant);
	 }
	 
	 /**
	  * Update data for an existing restaurant
	  * @param restaurantDto
	  * @return
	  */
	 @PostMapping("/restaurant/update")
	 public ResponseEntity<RestaurantDTO> updateRestaurant(@Valid @RequestBody RestaurantDTO restaurantDto){
		 Optional<RestaurantDTO> updatedRest = restaurantService.updateRestaurantId(restaurantDto);
		 
		 if(!updatedRest.isPresent()) {
			 updatedRest = restaurantService.updateRestaurantName(restaurantDto);
		 }

	     return ResponseUtil.wrapOrNotFound(updatedRest,
	            HeaderUtil.createAlert(applicationName, "A restaurant is updated with identifier " + restaurantDto.getId(), restaurantDto.getId()));
	    
	 }

	    
	    

}
