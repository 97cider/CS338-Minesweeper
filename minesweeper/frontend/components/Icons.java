package minesweeper.frontend.components;

public class Icons {
    private int selectedSkinIndex;
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

    public String[] cartoonIcons = {
        "./minesweeper/images/Cartoony/0.png",
        "./minesweeper/images/Cartoony/1.png",
        "./minesweeper/images/Cartoony/2.png",
        "./minesweeper/images/Cartoony/3.png",
        "./minesweeper/images/Cartoony/4.png",
        "./minesweeper/images/Cartoony/5.png",
        "./minesweeper/images/Cartoony/6.png",
        "./minesweeper/images/Cartoony/7.png",
        "./minesweeper/images/Cartoony/8.png",
        "./minesweeper/images/Cartoony/bomb.png",
        "./minesweeper/images/Cartoony/facingDown.png",
        "./minesweeper/images/Cartoony/flagged.png",
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