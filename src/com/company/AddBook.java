package com.company;

import org.json.JSONArray;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import static com.company.Main.bookList;
import static com.company.Helper.book;

public class AddBook extends JFrame {

    private JTextField tfAuthor;
    private JTextField tfTitle;
    private JTextField tfGenre;
    private JTextField tfPages;
    private JTextField tfDate;
    private JButton btnAdd;


    public AddBook() {
        super("Add Word");
        setSize(600, 400);

        tfAuthor = new JTextField(30);
        tfTitle = new JTextField(30);
        tfGenre = new JTextField(30);
        tfPages = new JTextField(30);
        tfDate = new JTextField(30);

        btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if (tfAuthor.getText().length() > 0 && tfTitle.getText().length() > 0 && tfGenre.getText().length() > 0
                     && tfPages.getText().length() > 0 && tfDate.getText().length() > 0) {

                 Book newBook = new Book();
                 newBook.setAuthor(tfAuthor.getText());

                 newBook.setTitle(tfTitle.getText());

                 newBook.setGenre(tfGenre.getText());

                 newBook.setPages(Integer.parseInt(tfPages.getText()));

                 newBook.setYear(Integer.parseInt(tfDate.getText()));

                 bookList.add(newBook);
                 try {
                     // writing back to the file
                     FileWriter fileWriter = new FileWriter("res\\books.json");

                     JSONArray jsonArray = new JSONArray(book);

                     fileWriter.write(jsonArray.toString());

                     fileWriter.flush();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 JOptionPane.showMessageDialog(AddBook.this, "Added Book Successfully!",
                         "Add Book", JOptionPane.INFORMATION_MESSAGE);
                 tfAuthor.setText("");
                 tfTitle.setText("");
                 tfGenre.setText("");
                 tfPages.setText("");
                 tfDate.setText("");

                 tfAuthor.requestFocus();
             } else {
                 JOptionPane.showMessageDialog(AddBook.this, "Please fill all the fields!", "Add Word", JOptionPane.ERROR_MESSAGE);
                 tfAuthor.requestFocus();
             }
         }
     }
        );

        JLabel lAuthor = new JLabel("Author: ");
        JLabel lTitle = new JLabel("Title: ");
        JLabel lGenre = new JLabel("Genre: ");
        JLabel lPages = new JLabel("Pages: ");
        JLabel lDate = new JLabel("Published Date: ");
        JLabel blank = new JLabel();

        lAuthor.setBounds(120, 20, 60, 30);
        tfAuthor.setBounds(250, 20, 100, 30);

        lTitle.setBounds(120, 60, 60, 30);
        tfTitle.setBounds(250, 60, 100, 30);

        lGenre.setBounds(120, 100, 60, 30);
        tfGenre.setBounds(250, 100, 100, 30);

        lPages.setBounds(120, 140, 60, 30);
        tfPages.setBounds(250, 140, 100, 30);

        lDate.setBounds(120, 180, 200, 30);
        tfDate.setBounds(250, 180, 100, 30);

        blank.setBounds(120,200,100,30);

        btnAdd.setBounds(180, 240, 100, 30);


        add(tfAuthor);
        add(tfTitle);
        add(tfGenre);
        add(tfPages);
        add(tfDate);
        add(btnAdd);

        add(lAuthor);
        add(lTitle);
        add(lGenre);
        add(lPages);
        add(lDate);
        add(blank);
    }

    public void insert() {


    }
}

