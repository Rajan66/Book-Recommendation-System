package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Main.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchBook extends JFrame{

    private JTextField tfTitle;
    private JButton btnSearch;


    public SearchBook() {
        super("Search Word");
        setSize(220, 160);

        tfTitle = new JTextField(30);

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                        sortObj.sort(bookList);
                        if (!tfTitle.getText().isEmpty()){
                            String input = tfTitle.getText().toLowerCase();

                            int index = searchObj.binarySearch(bookList, input.replaceAll("\\s+", ""));
                            if (index == -1) {
                                JOptionPane.showMessageDialog(SearchBook.this,"Book not found!");
                            }else{
                                String output = "Author: " + bookList.get(index).getAuthor()+
                                                "\nTitle: " + bookList.get(index).getTitle() +
                                                "\nGenre: " + bookList.get(index).getGenre() +
                                                "\nPages: " + bookList.get(index).getPages() +
                                                "\nPublished Date: " + bookList.get(index).getYear();
                                JOptionPane.showMessageDialog(SearchBook.this,output,"Details",JOptionPane.INFORMATION_MESSAGE);
                                tfTitle.setText("");
                                tfTitle.requestFocus();
                            }
                        } else {
                         JOptionPane.showMessageDialog(SearchBook.this, "Title is empty!!", "Search Book", JOptionPane.ERROR_MESSAGE);
                         tfTitle.requestFocus();
                     }
                 }
             }
        );
        JLabel lTitle = new JLabel("Title: ");
        JLabel blank = new JLabel();

        lTitle.setBounds(10, 30, 60, 30);
        tfTitle.setBounds(70, 30, 100, 30);

        blank.setBounds(10, 50, 100, 30);

        btnSearch.setBounds(30, 70, 100, 30);

        add(tfTitle);
        add(btnSearch);

        add(lTitle);
        add(blank);
    }
}

