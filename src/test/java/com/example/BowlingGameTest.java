package com.example;


import com.example.Bowling.BowlingGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testGutterGame() throws Exception{
        rollMany(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    public void testMedia() throws Exception{
        rollMedia();
        bowlingGame.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowlingGame.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(17, 0);
        assertEquals(24, bowlingGame.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.score());
    }

    public void rollStrike() {
        bowlingGame.roll(10);
    }

    private void rollMany(int n, int bolos){
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(bolos);
        }
    }

    private void rollMedia(){
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }
}
