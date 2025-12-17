package CajaNegra;

import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void SetUp(){
        player = new Player();
    }
    @Test
    void testAct_Caso1() {
        int dx = -2;
        int x = 0;
        int salidaEsperada = 0;
        boolean resultado ;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso2(){
        int dx = 2;
        int x = Commons.BOARD_WIDTH;
        int salidaEsperada = Commons.BOARD_WIDTH;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso3(){
        int dx = 2;
        int x = 36;
        int salidaEsperada = 38;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso4(){
        int dx = 0;
        int x = 38;
        int salidaEsperada = 38;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso5(){
        int dx = -2;
        int x = 100;
        int salidaEsperada = 98;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestInitPlayer_Caso1(){
        int salidaPlayerEnMedio = 179;
        int salidaPlayerInitGround = 280;
        boolean xyCorrecto;
        xyCorrecto = (salidaPlayerEnMedio == player.getX()) && (salidaPlayerInitGround == player.getY());
        assertTrue(xyCorrecto);
    }

    @Test
    void TestKeyPressed_Caso1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDxIzquierdo = -2;
        boolean resultado;
        player.keyPressed(e);
        resultado = (player.getDx() == salidaEsperadaDxIzquierdo);
        assertTrue(resultado);
    }

    @Test
    void TestKeyPressed_Caso2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDxDerecha = 2;
        boolean resultado;
        player.keyPressed(e);
        resultado = (player.getDx() == salidaEsperadaDxDerecha);
        assertTrue(resultado);
    }

    @Test
    void TestKeyPressed_Caso3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDxIzquierda = -2;
        int salidaEsperadaDxDerecha = 2;
        boolean resultado;
        player.keyPressed(e);
        resultado = !((player.getDx() == salidaEsperadaDxIzquierda) && (player.getDx() == salidaEsperadaDxDerecha));
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleased_Caso1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDxIzquierda = 0;
        boolean resultado;
        player.keyReleased(e);
        resultado = (player.getDx() == salidaEsperadaDxIzquierda);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleased_Caso2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDxDerecha = 0;
        boolean resultado;
        player.keyReleased(e);
        resultado = (player.getDx() == salidaEsperadaDxDerecha);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleased_Caso3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDx = 0;
        boolean resultado;
        player.keyReleased(e);
        resultado = (player.getDx() == salidaEsperadaDx);
        assertTrue(resultado);
    }
}