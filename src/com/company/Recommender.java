package com.company;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Random;

import static com.company.Main.*;

public class Recommender extends JFrame {

    public Recommender() {
        super("Suggestion");
        setSize(500, 300);

        JLabel lAuthor = new JLabel("Author: ");
        JLabel lTitle = new JLabel("Title: ");
        JLabel lGenre = new JLabel("Genre: ");
        JLabel lPages = new JLabel("Pages: ");
        JLabel lDate = new JLabel("Published Date: ");

        JLabel authorValue = new JLabel();
        JLabel titleValue = new JLabel();
        JLabel genreValue = new JLabel();
        JLabel pagesValue = new JLabel();
        JLabel dateValue = new JLabel();

        JLabel blank = new JLabel();

        Random random = new Random();
        int index = random.nextInt(bookList.size());


        lAuthor.setBounds(50, 20, 60, 30);
        authorValue.setBounds(150, 20, 200, 30);
        authorValue.setText(bookList.get(index).getAuthor());

        lTitle.setBounds(50, 60, 60, 30);
        titleValue.setBounds(150, 60, 200, 30);
        titleValue.setText(bookList.get(index).getTitle());

        lGenre.setBounds(50, 100, 60, 30);
        genreValue.setBounds(150, 100, 200, 30);
        genreValue.setText(bookList.get(index).getGenre());

        lPages.setBounds(50, 140, 60, 30);
        pagesValue.setBounds(150, 140, 200, 30);
        pagesValue.setText(Integer.toString(bookList.get(index).getPages()));

        blank.setBounds(50,160,60,30);
        lDate.setBounds(50, 180, 200, 30);
        dateValue.setBounds(150, 180, 200, 30);
        dateValue.setText(Integer.toString(bookList.get(index).getYear()));

        add(authorValue);
        add(titleValue);
        add(genreValue);
        add(pagesValue);
        add(dateValue);

        add(lAuthor);
        add(lTitle);
        add(lGenre);
        add(lPages);
        add(lDate);
        add(blank);
    }
}
