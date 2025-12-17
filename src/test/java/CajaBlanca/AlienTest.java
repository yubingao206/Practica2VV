package CajaBlanca;
import main.Commons;
import space_invaders.sprites.Alien;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class AlienTest {

    @Test
    void testinitAlien_Caso1() {
        int x = 100;
        int y = 100;
        Alien a = new Alien(x, y);

        try {
            Method metodo = a.getClass().getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(a, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(a);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(a);

            assertTrue((valorx == x) && (valory==y));

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

    @Test
    void testinitAlien_Caso2() {
        int x = 100;
        int y = -1;
        Alien a = new Alien(x, y);

        try {
            Method metodo = a.getClass().getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(a, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(a);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(a);

            assertTrue((valorx == x) && (valory==0));

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

    @Test
    void testinitAlien_Caso3() {
        int x = 100;
        int y = Commons.BOARD_HEIGHT + 1;
        Alien a = new Alien(x, y);

        try {
            Method metodo = a.getClass().getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(a, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(a);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(a);

            assertTrue((valorx == 100) && (valory == Commons.BOARD_HEIGHT));

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

    @Test
    void testinitAlien_Caso4() {
        int x = -1;
        int y = 100;
        Alien a = new Alien(x, y);

        try {
            Method metodo = a.getClass().getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(a, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(a);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(a);

            assertTrue((valorx == 0) && (valory == 100));

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

    @Test
    void testinitAlien_Caso5() {
        int x = Commons.BOARD_WIDTH + 1;
        int y = 100;
        Alien a = new Alien(x, y);

        try {
            Method metodo = a.getClass().getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(a, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(a);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(a);

            assertTrue((valorx == Commons.BOARD_WIDTH) && (valory == 100));

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

    @Test
    void testAct_Caso1(){
        int direccion = -1;
        int x = 100;
        Alien a = new Alien(x,10);
        a.act(direccion);
        assertEquals(x + direccion,a.getX());
    }
}
