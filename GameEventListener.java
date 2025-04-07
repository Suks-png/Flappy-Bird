package com.flappybirdjava.utils;




public interface GameEventListener {
    void onGameStart();
    void onGameOver(int finalScore);
    void onScoreChanged(int newScore);
}
