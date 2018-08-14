package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipWrekController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipWrekController sk;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void initMock(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shipWreckGetTest(){
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1L);
		Optional<Shipwreck> shipwreckOptional = Optional.ofNullable(shipwreck);
		when(shipwreckRepository.findById(1L))
			.thenReturn(shipwreckOptional);
		
		Shipwreck wreck = sk.get(1L);
		verify(shipwreckRepository).findById(1L);
		//assertEquals(1L, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1L));
	}
}
