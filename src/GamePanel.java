import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private JButton[][] board;
    private JButton characterSheet;
    private JButton mapSystem;
    private GameModel model;


    //private ImageIcon (icons) if we want to add them


    private boolean firstTurnFlag;
    private int fromRow;
    private int toRow;
    private int fromCol;
    private int toCol;
    private int sizeRow;
    private int sizeCol;
    private int lastRowClicked;
    private int lastColClicked;

    private GameModel gameModel;
    // declare other instance variables as needed

    private listener listener;
    private buttonListener buttonListener;

    public GamePanel() {
        sizeRow = 17;
        sizeCol = 17;
        model = new GameModel(sizeRow, sizeCol);
        /*
         * SHOULD BECOME ALLOCATED DEPENDING ON SIZE OF MAP
         * model.sizeRow(), model.sizeCol()
         */
        board = new JButton[sizeRow][sizeCol];
        /*
         * SHOULD BECOME ALLOCATED DEPENDING ON SIZE OF MAP
         */
        listener = new listener();
        buttonListener = new buttonListener();
        gameModel = new GameModel(sizeRow, sizeCol);
        //createIcons();

        JPanel boardpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        /*
         * Again, model.sizeRow(), model.sizeCol()
         */
        boardpanel.setLayout(new GridLayout(sizeRow, sizeCol, 1, 1));

        /*
         * Creating images for the buttons.
         */

        for (int r = 0; r < sizeRow; r++) {
            for (int c = 0; c < sizeCol; c++) {
                if(r != 3 || c != 3) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                }else{
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                }
                board[r][c].setPreferredSize(new Dimension(30, 30));
                boardpanel.add(board[r][c]);
                board[r][c].setBackground(Color.black);
            }
        }
        /*
            Needs to be automated w/ a method
         */
        try {
            Image myImage = ImageIO.read(getClass().getResource("Assets/AdventurerOne.PNG"));
            myImage = myImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
            board[4][4].setIcon(new ImageIcon(myImage));
            gameModel.createPiece(4, 4, 2, 1, "Hero");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        /*
            This method!
         */
        add(boardpanel, BorderLayout.WEST);
        //Size of the board. Buttons fill it
        boardpanel.setPreferredSize(new Dimension(sizeRow*40, sizeCol*40));
        add(buttonpanel, BorderLayout.SOUTH);

        characterSheet = new JButton("Character");
        mapSystem = new JButton("Map");
        BoxLayout boxLayout1 = new BoxLayout(buttonpanel, BoxLayout.Y_AXIS);
        buttonpanel.setLayout(boxLayout1);
        characterSheet.addActionListener(buttonListener);
        mapSystem.addActionListener(buttonListener);
        buttonpanel.add(characterSheet);
        buttonpanel.add(mapSystem);
        firstTurnFlag = true;

    }

    private void setBackGroundColor(int r, int c) {
            board[r][c].setBackground(Color.BLACK);
    }

    /*
     *For if someone wants to redo their turn
     */
    private class buttonListener implements ActionListener {

        /*
         * This method runs if the undo button is pushed.
         *
         * @param event if the undo button is pushed.
         */

        public void actionPerformed(ActionEvent event) {
            if(characterSheet == event.getSource()){
                //Look at your character?
                System.out.println("for real?");
            }
            if (mapSystem == event.getSource()){
                //Can be used to open the map?
                JOptionPane.showInputDialog("Give me the cake.");
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
                        board[r][c].setBackground(Color.GREEN);
                        spotClicked = true;
                        rowClicked = r;
                        colClicked = c;
                        //Should only be able to move heroes
                        if(gameModel.canMovePiece(lastRowClicked, lastColClicked, r, c)){
                            board[r][c].setIcon(board[lastRowClicked][lastColClicked].getIcon());
                            board[lastRowClicked][lastColClicked].setIcon(null);
                            gameModel.movePiece(lastRowClicked, lastColClicked, r, c);
                            //This is set up like this so you ahve to reclick a hero to be able to move them again
                            spotClicked = false;
                        }else {
                            lastRowClicked = r;
                            lastColClicked = c;
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
        private void lookForMovement(int fromRow, int fromCol){
            for(int r = 0; r < sizeRow; r++){
                for (int c = 0; c < sizeCol; c++){
                    if(gameModel.canMovePiece(fromRow, fromCol, r, c)){
                        board[r][c].setBackground(Color.BLUE);
                    }
                }
            }
        }
    }
}
