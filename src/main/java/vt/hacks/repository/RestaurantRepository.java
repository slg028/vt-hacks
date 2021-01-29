package vt.hacks.repository;

import org.springframework.stereotype.Repository;

import vt.hacks.domain.Restaurant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

		Page<Restaurant> findAll(Pageable pageable);
		
		List<Restaurant> findAllByPrice(String price);
		
		List<Restaurant> findAllByCuisine(String cuisine);
		
		Optional<Restaurant> findOneByName(String name);
		
		//Optional<Restaurant> fineOneByName(String name);
}
