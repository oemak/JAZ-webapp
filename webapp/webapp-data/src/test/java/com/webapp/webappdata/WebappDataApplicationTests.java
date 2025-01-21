package com.webapp.webappdata;

import com.webapp.webappdata.client.BeerApiClient;
import com.webapp.webappdata.dto.api.BeerDTO;
import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.mapper.BeerMapper;
import com.webapp.webappdata.service.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class WebappDataApplicationTests {

	@Autowired
	private BeerApiClient beerApiClient;

	@Autowired
	private BeerMapper beerMapper;

	@Autowired
	private BeerService beerService;

	@Test
	void testBeerApiIntegration() {
//		// Test pobierania danych z API
//		BeerDTO beerDTO = beerApiClient.getBeerByName("Magnify The Ties That Bind");
//		assertThat(beerDTO).isNotNull();
//		assertThat(beerDTO.getSku()).isNotEmpty();
//		assertThat(beerDTO.getName()).contains("Magnify");
//
//		// Test mapowania na encję
//		Beer beer = beerMapper.toEntity(beerDTO);
//		assertThat(beer).isNotNull();
//		assertThat(beer.getSku()).isEqualTo(beerDTO.getSku());
//
//		// Test zapisu do bazy
//		Beer savedBeer = beerService.saveBeer(beer);
//		assertThat(savedBeer).isNotNull();
//		assertThat(savedBeer.getSku()).isEqualTo(beer.getSku());
	}
}