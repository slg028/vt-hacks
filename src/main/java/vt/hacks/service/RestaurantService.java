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
	 * Create a new restaurant and add it to the DB
	 * @param restaurantDto
	 * @return
	 */
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
	
	/** 
	 * Given an existing DTO, update the data/information for it
	 * @param restaurantDto
	 * @return
	 */
	public Optional<RestaurantDTO> updateRestaurantId(RestaurantDTO restaurantDto){
		return Optional.of(restaurantRepository.findById(restaurantDto.getId()))
				.filter(Optional::isPresent)
	            .map(Optional::get)
				.map(rest -> {
					rest.setName(restaurantDto.getName());
					rest.setCuisine(restaurantDto.getCuisine());
					rest.setBar(restaurantDto.getBar());
					rest.setLocation(restaurantDto.getLocation());
					rest.setPrice(restaurantDto.getPrice());
					rest.setSpecials(restaurantDto.getSpecials());
					restaurantRepository.save(rest);
					log.debug("Changed Information for Restaurant: {}", rest);
					return rest;
				})
				.map(RestaurantDTO::new);
	}
	
	/** 
	 * Given an existing DTO, update the data/information for it
	 * @param restaurantDto
	 * @return
	 */
	public Optional<RestaurantDTO> updateRestaurantName(RestaurantDTO restaurantDto){
		return Optional.of(restaurantRepository.findOneByName(restaurantDto.getName()))
				.filter(Optional::isPresent)
	            .map(Optional::get)
				.map(rest -> {
					rest.setName(restaurantDto.getName());
					rest.setCuisine(restaurantDto.getCuisine());
					rest.setBar(restaurantDto.getBar());
					rest.setLocation(restaurantDto.getLocation());
					rest.setPrice(restaurantDto.getPrice());
					rest.setSpecials(restaurantDto.getSpecials());
					restaurantRepository.save(rest);
					log.debug("Changed Information for Restaurant: {}", rest);
					return rest;
				})
				.map(RestaurantDTO::new);
	}

}
