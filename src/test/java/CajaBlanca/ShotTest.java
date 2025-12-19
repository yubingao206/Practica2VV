package CajaBlanca;

import space_invaders.sprites.Shot;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    @Test
    void testinitShot_Caso1(){
        int x = 10;
        int y = 10;
        Shot shot = new Shot();
        try {
            Method metodo = shot.getClass().getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(shot);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(shot);

            assertTrue((valorx == 16) && (valory == 9));

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
