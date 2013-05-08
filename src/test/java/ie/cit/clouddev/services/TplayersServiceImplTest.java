package ie.cit.clouddev.services;

import static org.junit.Assert.*;
import ie.cit.clouddev.domain.Player;
import ie.cit.clouddev.domain.dao.PlayersRepository;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

public class TplayersServiceImplTest {

	private TplayersServiceImpl tested;
	private PlayersRepository playersRepository;

	@Before
	public void setup() {
		playersRepository = Mockito.mock(PlayersRepository.class);
		tested = new TplayersServiceImpl(playersRepository);
	}

	@Test
	public void testnewplayer() {
		Player newplayer = tested.newplayer("Test name", "99999", "1/1/1999");
		Mockito.verify(playersRepository).add(newplayer);
		Assert.assertThat(newplayer.getName(),
				CoreMatchers.equalTo("Test name"));
	}

}

