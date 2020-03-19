package minesweeper.src.main.java.components;

public class Icons {
    private int selectedSkinIndex;
    public static String[] icons = {
        "./src/main/resources/0.png",
        "./minesweeper/src/main/resources/1.png",
        "./minesweeper/src/main/resources/2.png",
        "./minesweeper/src/main/resources/3.png",
        "./minesweeper/src/main/resources/4.png",
        "./minesweeper/src/main/resources/5.png",
        "./minesweeper/src/main/resources/6.png",
        "./minesweeper/src/main/resources/7.png",
        "./minesweeper/src/main/resources/8.png",
        "./minesweeper/src/main/resources/bomb.png",
        "./minesweeper/src/main/resources/facingDown.png",
        "./minesweeper/src/main/resources/flagged.png",
    };

    public String[] cartoonIcons = {
        "./src/main/resources/0.png",
        "./minesweeper/src/main/resources/Cartoony/1.png",
        "./minesweeper/src/main/resources/Cartoony/2.png",
        "./minesweeper/src/main/resources/Cartoony/3.png",
        "./minesweeper/src/main/resources/Cartoony/4.png",
        "./minesweeper/src/main/resources/Cartoony/5.png",
        "./minesweeper/src/main/resources/Cartoony/6.png",
        "./minesweeper/src/main/resources/Cartoony/7.png",
        "./minesweeper/src/main/resources/Cartoony/8.png",
        "./minesweeper/src/main/resources/Cartoony/bomb.png",
        "./minesweeper/src/main/resources/Cartoony/facingDown.png",
        "./minesweeper/src/main/resources/Cartoony/flagged.png",
    };

    public Icons() {
        selectedSkinIndex =0;
    }

    public Icons(int i) {
        selectedSkinIndex = i;
    }

    public String GetIcon(int i) {
        if(selectedSkinIndex == 0) {
            return icons[i];
        }
        else {
            return cartoonIcons[i];
        }       
    }

    public void setSkinIndex(int i) {
        this.selectedSkinIndex = i;
    }
}