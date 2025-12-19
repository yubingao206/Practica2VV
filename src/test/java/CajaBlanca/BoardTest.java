package CajaBlanca;

import main.Board;
import main.Commons;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board;
    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        board=new Board();
    }

    @Test
    public void test_GameInit_Case1(){
        assertEquals((Commons.ALIEN_ROWS * Commons.ALIEN_COLUMNS), board.getAliens().size());
    }

    @Test
    public void test_Update_Case1() {
        try{
            board.setDeaths(23);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(board.isInGame());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Case2() {
        try{
            board.setDeaths(24);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            assertFalse(board.isInGame());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso1() {
        try{
            Shot shot = board.getShot();
            shot.die();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertFalse(shot.isVisible());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso3() {
        try{
            for (Alien alien : board.getAliens()) {
                alien.die();
            }
            Shot shot = board.getShot();
            shot.setY(100);
            shot.setX(100);
            int shotPosY = shot.getY();
            int shotPosX = shot.getX();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((shotPosY - Commons.SHOT_SPEED) == shot.getY() && (shotPosX) == shot.getX());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso4() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setY(alien.getY() + Commons.ALIEN_HEIGHT + 1);
            shot.setX(alien.getX() + Commons.ALIEN_WIDTH);
            int shotPosY = shot.getY();
            int shotPosX = shot.getX();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((shotPosY - Commons.SHOT_SPEED) == shot.getY() && (shotPosX) == shot.getX());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso5() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setY(alien.getY());
            shot.setX(alien.getX());
            int deaths = board.getDeaths();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue( alien.isDying() && ((deaths + 1) == board.getDeaths()));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso6() {
        try{
            for (Alien alien : board.getAliens()) {
                alien.die();
            }
            Shot shot = board.getShot();
            shot.setX(100);
            shot.setY(-1);
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertFalse(shot.isVisible());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Aliens_Caso3() {
        try{
            for (Alien alien : board.getAliens()) {
                alien.die();
            }
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(!board.getAliens().getFirst().isVisible());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Aliens_Caso4 () {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.setX(Commons.BOARD_WIDTH/2);
            alien.setY(Commons.BOARD_HEIGHT/2);
            int aliensPosX = alien.getX(), aliensPosY = alien.getY();
            board.setDirection(1);
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((aliensPosY == alien.getY()) && (aliensPosX != alien.getX()));
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Aliens_Caso5 () {
        try {
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.setX(Commons.BOARD_WIDTH/2);
            alien.setY(Commons.GROUND + Commons.ALIEN_HEIGHT + 1);
            String message = "Invasion!";
            int aliensPosX = alien.getX(), aliensPosY = alien.getY();
            board.setDirection(1);
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((aliensPosY == alien.getY()) && (aliensPosX != alien.getX()) &&
                    board.getMessage().equals(message) && !board.isInGame());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Aliens_Caso7 () {
        try {
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.setX(Commons.BOARD_WIDTH - Commons.BORDER_RIGHT);
            alien.setY(Commons.BOARD_HEIGHT / 2);
            int aliensPosX = alien.getX(), aliensPosY = alien.getY();
            board.setDirection(-1);
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((aliensPosY + Commons.GO_DOWN == alien.getY()) &&
                    (aliensPosX != alien.getX()) && board.getDirection() == -1);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Aliens_Caso9 () {
        try {
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.setX(Commons.BORDER_LEFT);
            alien.setY(Commons.BOARD_HEIGHT / 2);
            int aliensPosX = alien.getX(), aliensPosY = alien.getY();
            board.setDirection(-1);
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((aliensPosY + Commons.GO_DOWN == alien.getY()) &&
                    (aliensPosX != alien.getX()) && board.getDirection() == 1);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Bomb_Caso2(){
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.die();
            alien.getBomb().setDestroyed(true);
            boolean alienVisible = alien.isVisible(), bombDestroyed = alien.getBomb().isDestroyed(),
                    playerVisible = board.getPlayer().isVisible();
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue( (bombDestroyed == alien.getBomb().isDestroyed()) && (playerVisible == board.getPlayer().isVisible()) && (alienVisible == alien.isVisible()));
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Bomb_Caso4(){
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.getBomb().setDestroyed(false);
            alien.getBomb().setY(board.getPlayer().getY() + Commons.PLAYER_HEIGHT + 1);
            alien.getBomb().setX(board.getPlayer().getX());
            Player player = board.getPlayer();
            int bombPosY = alien.getBomb().getY();
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(alien.getBomb().isDestroyed() && !player.isDying() && (bombPosY + Commons.BOMB_SPEED == alien.getBomb().getY()));
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Bomb_Caso5(){
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.getBomb().setDestroyed(false);
            alien.getBomb().setY(board.getPlayer().getY());
            alien.getBomb().setX(board.getPlayer().getX());
            Player player = board.getPlayer();
            int bombPosY = alien.getBomb().getY();
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(alien.getBomb().isDestroyed() && player.isDying() && bombPosY == alien.getBomb().getY());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Bomb_Caso6(){
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.getBomb().setDestroyed(true);
            int alienPosX = alien.getX(), alienPosY = alien.getY();
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            for (int i = 0; i < 100 && alien.getBomb().isDestroyed(); i++) {
                method.invoke(board);
            }
            assertTrue(!alien.getBomb().isDestroyed() && alienPosX == alien.getBomb().getX() &&
                    (alienPosY + Commons.BOMB_SPEED) == alien.getBomb().getY());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Bomb_Caso7(){
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            alien.getBomb().setDestroyed(false);
            board.getPlayer().die();
            alien.getBomb().setX(100);
            alien.getBomb().setY(Commons.GROUND - Commons.BOMB_HEIGHT + 1);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(alien.getBomb().isDestroyed());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
