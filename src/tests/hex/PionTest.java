package tests.hex;
import Plateau_Pion.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Plateau_Pion.*;
class PionTest {

	@Test
	void test() {
		assertEquals("X",Pion.Croix.toString());
		assertEquals("O",Pion.Rond.toString());
		assertEquals(".",Pion.Vide.toString());
		
		assertTrue(Pion.Croix == Pion.get('X'));
		assertTrue(Pion.Rond == Pion.get('O'));
		assertTrue(Pion.Vide == Pion.get('.'));
		
		assertThrows(IllegalArgumentException.class,
				() -> {
					Pion.get('*');
				}
				);
	}

}
