package CajaNegra;

import main.Board;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Shot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MockTest {
    @Test
    public void testUpdate() {
        try {
            //para el metodo Player.act()
            Board board = new Board();
            board.setInGame(true);
            board.getPlayer().setDx(-2);
            //para el metodo update_shots()
            Shot shot = new Shot();
            shot.setX(140);
            shot.setY(5);
            board.setShot(shot);
            //para el metodo update_aliens()
            board.setDirection(1);
            List<Alien> aliens = new ArrayList<>();
            aliens.add(new Alien(328,5));
            board.setAliens(aliens);
            //para el metodo update_bomb()
            Alien.Bomb bomb = aliens.getFirst().getBomb();
            bomb.setDestroyed(false);
            bomb.setX(200);
            bomb.setY(100);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testGameInit(){
        try{
            Board board = new Board();
            Method method = Board.class.getDeclaredMethod("gameInit");
            method.setAccessible(true);
            method.invoke(board);
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
