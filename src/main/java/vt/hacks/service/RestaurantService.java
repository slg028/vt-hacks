package vt.hacks.service;

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
	
	
	public Restaurant createRestaurant(RestaurantDTO restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(restaurantDto.getName());
		restaurant.setCuisine(restaurantDto.getCuisine());
		restaurant.setBar(restaurantDto.getBar());
		restaurant.setLocation(restaurantDto.getLocation());
		restaurant.setPrice(restaurantDto.getPrice());
		restaurant.setLocation(restaurantDto.getLocation());
		
		restaurantRepository.save(restaurant);
		log.debug("Created restaurant: {}", restaurant);
		return restaurant;
		
	}
	public Page<RestaurantDTO> getAllRestaurants(Pageable pageable){
		return restaurantRepository.findAll(pageable).map(RestaurantDTO::new);
	}

}
