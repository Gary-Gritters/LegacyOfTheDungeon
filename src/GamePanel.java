import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***************************************************
 * This class creates the GUI and sets up the info for it.
 *
 * @author Garett Gritters
 ***************************************************/


public class GamePanel extends JPanel {
    private JButton[][] board;
    private JButton characterSheet;
    private JButton mapSystem;

    private int sizeRow;
    private int sizeCol;
    private int lastRowClicked;
    private int lastColClicked;

    private GameModel gameModel;
    // declare other instance variables as needed

    private listener listener;
    private buttonListener buttonListener;

    /***********************************************
     * Constructor for the GamePanel. This will act as the GUI for the game. From here, grid based combat
     * will be performed.
     *
     * @param sizeOfRow is the row size of the GamePanel.
     * @param sizeOfCol is the column size of the GamePanel
     */

    public GamePanel(int sizeOfRow, int sizeOfCol) {
        sizeRow = sizeOfRow;
        sizeCol = sizeOfCol;
        //Creating the board for buttons
        board = new JButton[sizeRow][sizeCol];
        listener = new listener();
        buttonListener = new buttonListener();
        //Creating the game model
        gameModel = new GameModel(sizeRow, sizeCol);


        JPanel boardPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        boardPanel.setLayout(new GridLayout(sizeRow, sizeCol, 1, 1));

        for (int r = 0; r < sizeRow; r++) {
            for (int c = 0; c < sizeCol; c++) {
                board[r][c] = new JButton("", null);
                board[r][c].addActionListener(listener);
                board[r][c].setPreferredSize(new Dimension(30, 30));
                boardPanel.add(board[r][c]);
                board[r][c].setBackground(Color.black);
            }
        }
        /*
        For Creating Units
         */
        createUnit("Assets/Priest.PNG", 4, 4, 2, 1, "Priest", 1);
        createUnit("Assets/Mage.PNG", 5, 3, 2, 1, "Mage", 1);
        createUnit("Assets/Goblin.PNG", 0, 0, 3, 1, "Goblin1", -1);
        /*
            For Creating Units
         */
        add(boardPanel, BorderLayout.WEST);
        //Size of the board. Buttons fill it. Therefore, this'll make each button 40 pixels by 40 pixels. Neat!
        boardPanel.setPreferredSize(new Dimension(sizeRow*40, sizeCol*40));
        add(buttonPanel, BorderLayout.SOUTH);

        characterSheet = new JButton("Character");
        mapSystem = new JButton("Map");

        BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(boxLayout1);
        characterSheet.addActionListener(buttonListener);
        mapSystem.addActionListener(buttonListener);
        buttonPanel.add(characterSheet);
        buttonPanel.add(mapSystem);


    }

    /***********************************************
     * Sets color of buttons to black depending on row and column
     *
     * @param r row of that button
     * @param c column of that button
     */

    private void setBackGroundColor(int r, int c) {
            board[r][c].setBackground(Color.BLACK);
    }

    /***********************************************
     * Creates a unit on the board
     *
     * @param picture is a string that should be the file direction to a picture
     * @param rowSpot is the row the new unit should be created onto
     * @param colSpot is the column the new unit should be created onto
     * @param moveSpeed is the amount of squares the new unit should be able to move in their turn
     * @param attackRange is the range of that unit
     * @param name is their name
     * @param isAlly is the allegiance of that unit. 1 for ally, 0 for nothing, -1 for enemy
     */

    public void createUnit(String picture, int rowSpot, int colSpot, int moveSpeed, int attackRange, String name, int isAlly){
        try {
            Image myImage = ImageIO.read(getClass().getResource(picture));
            myImage = myImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
            board[rowSpot][colSpot].setIcon(new ImageIcon(myImage));
            gameModel.createPiece(rowSpot, colSpot, moveSpeed, attackRange, name, isAlly);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /*
     *For if someone wants to redo their turn
     */
    private class buttonListener implements ActionListener {

        /*
         * This method runs if the character or map button is pushed.
         *
         * @param event if a button is pushed.
         */

        public void actionPerformed(ActionEvent event) {
            if(characterSheet == event.getSource()){
                //Look at your character?
                System.out.println("Will show character sheet");
            }
            if (mapSystem == event.getSource()){
                //Can be used to open the map?
                JOptionPane.showInputDialog("Will show map");
            }
        }
    }

    private class listener implements ActionListener {

        /**
         * This method checks for a mouse event and determines
         * what to do for each event.
         *
         * @param event the mouse event.
         */

        public void actionPerformed(ActionEvent event) {
            boolean spotClicked = false;
            int rowClicked = 0;
            int colClicked = 0;

            //For loop checks for where the player clicked
            for (int r = 0; r < sizeRow; r++) {
                for (int c = 0; c < sizeCol; c++) {
                    if (board[r][c] == event.getSource()) {
                        //Highlights the button clicked
                        board[r][c].setBackground(Color.GREEN);
                        spotClicked = true;
                        rowClicked = r;
                        colClicked = c;
                        //Should only be able to move heroes
                        if (gameModel.canMovePiece(lastRowClicked, lastColClicked, r, c)) {
                            board[r][c].setIcon(board[lastRowClicked][lastColClicked].getIcon());
                            board[lastRowClicked][lastColClicked].setIcon(null);
                            gameModel.movePiece(lastRowClicked, lastColClicked, r, c);
                            //This is set up like this so you have to reclick a hero to be able to move them again
                            spotClicked = false;
                        } else {
                            lastRowClicked = r;
                            lastColClicked = c;

                        }
                        if (gameModel.isAlly(r, c) == -1) {
                            board[r][c].setBackground(Color.red);
                        }
                    }else {
                        setBackGroundColor(r, c);
                    }
                    //setBackGroundColor(r, c);
                }
            }
            if(spotClicked){
                lookForMovement(rowClicked, colClicked);
            }
        }

        /**
         * This method looks for the movement from a selected spot. If it's a moveable spot, it'll be blue.
         * If it's an ally, yellow, and enemies are red.
         * @param fromRow the unit moving from the Row
         * @param fromCol the unit moving from the Col
         */

        private void lookForMovement(int fromRow, int fromCol){
            for(int r = 0; r < sizeRow; r++){
                for (int c = 0; c < sizeCol; c++){
                    if(!(r == fromRow) || !(c == fromCol)) {
                        if (gameModel.canMovePiece(fromRow, fromCol, r, c)) {
                            board[r][c].setBackground(Color.BLUE);
                        }
                        if (gameModel.isAlly(r, c) == 1) {
                            board[r][c].setBackground(Color.YELLOW);
                        }
                        if (gameModel.isAlly(r, c) == -1) {
                            board[r][c].setBackground(Color.RED);
                        }
                    }
                }
            }
        }
    }
}
