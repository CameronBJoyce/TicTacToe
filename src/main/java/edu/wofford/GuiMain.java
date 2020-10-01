package edu.wofford;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GuiMain extends JFrame implements ActionListener {
    private JLabel result = new JLabel();
    private JPanel panel;
    private JButton[][] buttons = new JButton[3][3];
    private TicTacToeModel ttModelGui;
    private JPanel buttonsPanel;

   // private GridLayout board;

  //  Label lblGameStatus = new Label(getTurn());;

    public void actionPerformed(ActionEvent event) {
        JButton j = (JButton)event.getSource();
        String name = j.getName();
       // System.out.println("Name = " + name);
        int y = Integer.parseInt(String.valueOf(name.charAt(name.length() - 1)));
        int x = Integer.parseInt(String.valueOf(name.charAt(name.length() - 2)));
        if(ttModelGui.legalMove(x,y) && (!ttModelGui.didWin() || ttModelGui.isDraw())) {
          //  System.out.println("I have been hit!");
            ttModelGui.makeMove(x,y);
            ttModelGui.showBoard();
            buttons[x][y].setText(ttModelGui.getMark(x,y));
        }
        if(ttModelGui.didWin()) {
            result.setText(ttModelGui.printWinner());
        } else if (ttModelGui.isDraw()) {
            result.setText("Tie");
        } else {
          //  result.setText(ttModelGui.printTurn());
        }
    }


    public GuiMain() {
        //GUI Window Setup
        setTitle("Tic Tac Toe");
       // setSize(600,600);


        ttModelGui = new TicTacToeModel();

        //Label
        result.setName("result");
        result.setText("");

       //Builds Board
        //board =  new GridLayout(4,3);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3,3));
//        panel.add(result);
//        panel.add(s1);
//        panel.add(s2);
//        panel.setLayout(board);
        //buttons = new JButton[3][3]; //Buttons
        addButtons(); // Function Call
        panel.add(result, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);
        add(panel);
       // setSize(550, 550);
        //Sets Visible
        //setVisible(true);
        pack();
    }

    public void addButtons() {
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++) {
                  buttons[x][y] = new JButton(ttModelGui.getMark(x,y));
                  String s = "location" + x + y;
                  System.out.println(s);
                  buttons[x][y].setName(s);
                  buttons[x][y].addActionListener(this);
                  buttonsPanel.add(buttons[x][y]);
            }
        }
    }

  //  public void playGame() {
//        while (!ttModelGui.didWin() && !ttModelGui.isDraw()) {
//            System.out.println(" ********************");
//            buttons.setText(ttModelGui.printTurn());
//            y = input.nextInt();
//            ttModel.makeMove(x, y);
//            ttModel.showBoard();

  //  }


	public static void main(String[] args) {
        GuiMain window = new GuiMain();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //GridLayout guiBoard = new GridLayout(3,3);
      //  window.setLayout(guiBoard);

	}
}
