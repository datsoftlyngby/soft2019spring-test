package monopolydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author TM
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTakeTurn {
    
 @Mock
 Die d1, d2;
 
 @Mock
 Board b;
 
 @Mock
 Piece p;
 
 @Mock
 Square oldSquare, newSquare;
 
 
     @Test
     public void testTaketurn() {
         Die[] dice = {d1, d2};
         when(d1.getFaceValue()).thenReturn(4);
         when(d2.getFaceValue()).thenReturn(2);
         when(p.getLocation()).thenReturn(oldSquare);
         when(b.getSquare(oldSquare, 6)).thenReturn(newSquare);
         
         Player player = new Player(dice, p, b);
         player.takeTurn();
         
         verify(d1).roll();
         verify(d2).roll();
         verify(d1).getFaceValue();
         verify(d2).getFaceValue();
         verify(p).getLocation();
         verify(b).getSquare(oldSquare, 6);
         verify(p).setLocation(newSquare);
     
     }
}
