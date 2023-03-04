package com.company;

import javax.swing.*;

import static com.company.Main.*;

public class ListBooks extends JFrame{

    public ListBooks() {
        super("View Books");
        setSize(600, 300);

        sortObj.sort(bookList);
        String[] column = {"Author", "Title", "Genre","Pages","Published Date"};
        Object[][] data = new Object[bookList.size()][];
        for (int i = 0; i < bookList.size(); i++) {
            data[i] = bookList.get(i).toObjectArray();
        }

        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 600, 300);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);
    }

}