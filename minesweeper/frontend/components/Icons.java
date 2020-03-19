package minesweeper.frontend.components;

class Icons {
    public static String[] icons = {
        "./minesweeper/images/0.png",
        "./minesweeper/images/1.png",
        "./minesweeper/images/2.png",
        "./minesweeper/images/3.png",
        "./minesweeper/images/4.png",
        "./minesweeper/images/5.png",
        "./minesweeper/images/6.png",
        "./minesweeper/images/7.png",
        "./minesweeper/images/8.png",
        "./minesweeper/images/bomb.png",
        "./minesweeper/images/facingDown.png",
        "./minesweeper/images/flagged.png",
    }; 
    public static String GetIcon(int i) {
        return icons[i];
    }
}