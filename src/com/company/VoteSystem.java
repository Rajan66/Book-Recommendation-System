package com.company;
//import garna nabirsinu
import javax.swing.*;
import java.awt.event.*;

//JFrame extend garna nabirsinu
public class VoteSystem extends JFrame{

    public VoteSystem(String title){
        // sabae ma same hunxa yo haru
        setTitle(title);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //k k chaixa initialize garyo
        JLabel label = new JLabel("Enter your age:");
        JTextField text = new JTextField();
        JButton button = new JButton("Check");
        JLabel status = new JLabel();

        //size ra position rakhyo
        label.setBounds(50,80,200,30);
        text.setBounds(150,80,100,30);
        button.setBounds(90,120,100,30);
        status.setBounds(90,160,180,30);

        //button click garesi k garne vanera code
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(text.getText()) < 18 ){
                    status.setText("You are not eligible to vote.");
                } else{
                    status.setText("You are eligible to vote.");
                }
            }
        });

        //Frame ma add gareko... yo lekhena ki output ma dekhaudaina
        // eg: button comment gara ta
        add(label);
        add(text);
        add(button);
        add(status);
    }

    public static void main(String[] args) {
        //Object banayo visible garyo ani window
        VoteSystem voteSystem = new VoteSystem("Checking for vote");
        voteSystem.setVisible(true);
    }
}
