import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Alien.Bomb;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTest {

    @Test
    void testinitBomb_Caso1() {
        int x = 100;
        int y = 100;
        Alien a = new Alien(x, y);
        Alien.Bomb b = a.getBomb();

        try {
            Method metodo = b.getClass().getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(b, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(b);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(b);

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
    void testinitBomb_Caso2() {
        int x = -10;
        int y = 100;
        Alien a = new Alien(x, y);
        Alien.Bomb b = a.getBomb();

        try {
            Method metodo = b.getClass().getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(b, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(b);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(b);

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
    void testinitBomb_Caso3() {
        int x = 359;
        int y = 100;
        Alien a = new Alien(x, y);
        Alien.Bomb b = a.getBomb();

        try {
            Method metodo = b.getClass().getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(b, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(b);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(b);

            assertTrue((valorx == 358) && (valory == 100));

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
    void testinitBomb_Caso4() {
        int x = 100;
        int y = -10;
        Alien a = new Alien(x, y);
        Alien.Bomb b = a.getBomb();

        try {
            Method metodo = b.getClass().getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(b, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(b);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(b);

            assertTrue((valorx == 100) && (valory == 0));

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
    void testinitBomb_Caso5() {
        int x = 100;
        int y = 351;
        Alien a = new Alien(x, y);
        Alien.Bomb b = a.getBomb();

        try {
            Method metodo = b.getClass().getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(b, x,y);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = (int) valx.get(b);

            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(b);

            assertTrue((valorx == 100) && (valory == 350));

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