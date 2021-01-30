package vt.hacks.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vt.hacks.domain.Restaurant;
import vt.hacks.repository.RestaurantRepository;
import vt.hacks.service.dto.RestaurantDTO;

@Service
public class RestaurantService {
	
	private final Logger log = LoggerFactory.getLogger(RestaurantService.class);
	 
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	

	public Page<RestaurantDTO> getAllRestaurants(Pageable pageable){
		return restaurantRepository.findAll(pageable).map(RestaurantDTO::new);
	}
	
	
	/** 
	 * TODO  - you can use this method for the add restaurant functionality
	 * Use restaurantRepository.save(restaurant); to save the object
	 * @param restaurantDto
	 * @return
	 */
	public Restaurant createRestaurant(RestaurantDTO restaurantDto) {
		Restaurant restaurant = new Restaurant();
		return restaurant;
		
	}
	

}
