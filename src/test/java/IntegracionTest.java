import main.Board;
import main.Commons;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Shot;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class IntegracionTest {

    Board board;
    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        board=new Board();
    }

    @Test
    public void testGameInit(){
        boolean alienGenerado = board.getAliens().size() == Commons.ALIEN_ROWS*Commons.ALIEN_COLUMNS;
        boolean alienBombGenerado = board.getAliens().getFirst().getBomb() != null;
        boolean playerGenerado = board.getPlayer() != null;
        boolean shotGenerado = board.getShot() != null;
        assertTrue(alienGenerado && alienBombGenerado && playerGenerado && shotGenerado);
    }

    @Test
    public void testUpdate() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }

            int alenPosX = 10;
            alien.setX(alenPosX);

            int playerPos = board.getPlayer().getX();
            board.getPlayer().setDx(2);

            int shotPos = 100;
            board.getShot().setY(shotPos);

            alien.getBomb().setDestroyed(false);
            int bombPosY = 50;
            alien.getBomb().setY(bombPosY);

            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);

            boolean playerAct = board.getPlayer().getX() == playerPos + board.getPlayer().getDx();
            boolean update_shot = board.getShot().getY() == shotPos - Commons.SHOT_SPEED;
            boolean update_alien = alien.getX() == alenPosX + board.getDirection();
            boolean update_bomb = alien.getBomb().getY() == bombPosY + Commons.BOMB_SPEED;

            assertTrue(playerAct && update_shot && update_alien && update_bomb);
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
