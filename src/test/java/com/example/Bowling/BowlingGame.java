package com.example.Bowling;

public class BowlingGame {


    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int bolos) {
        rolls[currentRoll++] = bolos;
    }

    public int score() {
        int score = 0;
        int FrameIndex=0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(FrameIndex)){
                score += getStrikeBonus(FrameIndex);
                FrameIndex ++;
            }
           else if(isMedia(FrameIndex)) {

                score += 10 + getMediaBonus(FrameIndex);
                FrameIndex += 2;
            }else{
                score += getAditionFrame(FrameIndex);
                FrameIndex += 2;
            }

        }
        return score;
    }

    public int getAditionFrame(int frameIndex) {
        return  rolls[frameIndex] + rolls[frameIndex + 1];
    }

    public int getMediaBonus(int frameIndex ) {
        return rolls[frameIndex + 2];
    }

    public int getStrikeBonus(int frameIndex) {
        return 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    public boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isMedia(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex +1] == 10;
    }
}
