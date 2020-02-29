import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************************************
 * This class is the actual code for creating the GUI panel
 * 
 * @author GG
 * @version 1.0
 **********************************************************/

public class GamePanel extends JPanel {
    private JButton[][] board;
    private JButton undo;
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
    // declare other instance variables as needed

    private listener listener;
    private undoListener undoListener;
    private characterSheetListener characterSheetListener;
    private mapSystemListener mapSystemListener;

    public GamePanel() {
        model = new GameModel();
        sizeRow = 6;
        sizeCol = 6 ;
        /*
         * SHOULD BECOME ALLOCATED DEPENDING ON SIZE OF MAP
         * model.sizeRow(), model.sizeCol()
         */
        board = new JButton[sizeRow][sizeCol];
        /*
         * SHOULD BECOME ALLOCATED DEPENDING ON SIZE OF MAP
         */
        listener = new listener();
        undoListener = new undoListener();
        //createIcons();

        JPanel boardpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        /*
         * Again, model.sizeRow(), model.sizeCol()
         */
        boardpanel.setLayout(new GridLayout(sizeRow, sizeCol, 1, 1));

        for (int r = 0; r < sizeRow; r++) {
            for (int c = 0; c < sizeCol; c++) {
                //if (model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("(" + r + ", " + c + ")", null);
                    board[r][c].addActionListener(listener);
                //}else if (model.pieceAt(r, c).player() == Player.WHITE) {
                //    placePieces(r, c);
                //} else if (model.pieceAt(r, c).player() == Player.BLACK) {
                //    placePieces(r, c);
                //}

                boardpanel.add(board[r][c]);
                board[r][c].setBackground(Color.WHITE);
            }
        }
        add(boardpanel, BorderLayout.WEST);
        //Size of the board. Buttons fill it
        boardpanel.setPreferredSize(new Dimension(500, 500));
        add(buttonpanel, BorderLayout.SOUTH);

        undo = new JButton("Undo");
        characterSheet = new JButton("Character");
        mapSystem = new JButton("Map");
        BoxLayout boxLayout1 = new BoxLayout(buttonpanel, BoxLayout.Y_AXIS);
        buttonpanel.setLayout(boxLayout1);
        undo.addActionListener(undoListener);
        characterSheet.addActionListener(characterSheetListener);
        mapSystem.addActionListener(mapSystemListener);
        buttonpanel.add(undo);
        buttonpanel.add(characterSheet);
        buttonpanel.add(mapSystem);
        firstTurnFlag = true;

    }
    
    /*****************************************************
     * This method sets the color of a given tile to white.
     * r is the row and c is the column.
     * @param r 
     * @param c
     *****************************************************/
    
    private void setBackGroundColor(int r, int c) {
            board[r][c].setBackground(Color.WHITE);
    }

    /**********************************************************************
     * This class allows the user to undo an action. 
     * It may not be needed for the final product but is useful for testing.
     * @author GG
     * @version 1.0
     **********************************************************************/
    
    private class undoListener implements ActionListener {

        /***********************************************
         * This method runs if the undo button is pushed.
         *
         * @param event if the undo button is pushed.
         ***********************************************/

        public void actionPerformed(ActionEvent event) {
            if (undo == event.getSource()) {
                //for stack please
      //          if (model.prevMoveExists()) {
                    // Undoes the previous move
    //                model.undo();
//
                    // Toggles Players
   //                 model.setNextPlayer();

      //              displayBoard()
                //}
            }
        }
    }
    
    /*****************************************
     * This class opens up the character GUI.
     * @author GG
     * @version 1.0
     *****************************************/
    
    private class characterSheetListener implements ActionListener {
    	
    	/****************************************************
    	 * This method runs if the Character button is pushed.
    	 * 
    	 * @param event if the Character button is pushed.
    	 ****************************************************/
    	
        public void actionPerformed(ActionEvent event){
            if (characterSheet == event.getSource()){
                System.out.println("It worked!");
            }
        }
    }


    /**********************************
     * This class opens up the map GUI.
     * @author GG
     * @version 1.0
     *********************************/
    
    private class mapSystemListener implements ActionListener {
    	
    	/**********************************************
    	 * This method runs if the Map button is pushed.
    	 * 
    	 * @param event if the Map button is pushed
    	 **********************************************/
    	
        public void actionPerformed(ActionEvent event){
            if (mapSystem == event.getSource()){
                JOptionPane.showInputDialog("Give me the cake.");
            }else{
                System.out.println("hoho");
            }
        }
    }

    /******************************************************
     * This class checks for clicks on the main GUI buttons.
     * @author GG
     * @version 1.0
     ******************************************************/
    
    private class listener implements ActionListener {

        /***************************************************************
         * This method checks for a mouse click on the main GUI buttons.
         * It then determines which button was clicked and what to do.
         *
         * @param event the mouse event.
         ***************************************************************/

        public void actionPerformed(ActionEvent event) {

            //For loop checks for where the player clicked
            for (int r = 0; r < sizeRow; r++) {
                for (int c = 0; c < sizeCol; c++) {
                    if (board[r][c] == event.getSource()) {
                        board[r][c].setBackground(Color.GREEN);
                    }else {
                        setBackGroundColor(r, c);
                    }
                    //setBackGroundColor(r, c);
                }
            }
        }
    }
}
