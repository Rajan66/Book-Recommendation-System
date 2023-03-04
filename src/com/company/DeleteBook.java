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

import static com.company.Helper.book;

import static com.company.Main.*;

public class DeleteBook extends JFrame {

    private JTextField tfTitle;
    private JButton btnDelete;

    public DeleteBook() {
        super("Delete Word");
        setSize(220, 160);

        tfTitle = new JTextField(30);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sortObj.sort(bookList);
                    if (!tfTitle.getText().isEmpty()){
                        String input = tfTitle.getText().toLowerCase();

                        int index = searchObj.binarySearch(bookList, input.replaceAll("\\s+", ""));
                        if (index == -1) {
                            JOptionPane.showMessageDialog(DeleteBook.this,"Book not found!");
                        } else {
                            try {
                                JSONArray jsArray = new JSONArray();
                                for (Book item : bookList) {
                                    jsArray.put(item);
                                }
                                FileWriter fileWriter = new FileWriter("res\\books.json");

                                book.remove(index);
                                jsArray = new JSONArray(book);

                                fileWriter.write(jsArray.toString());
                                fileWriter.flush();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(DeleteBook.this, "Deleted Book Successfully!",
                                    "Delete Book", JOptionPane.INFORMATION_MESSAGE);
                            tfTitle.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(DeleteBook.this, "Title is empty!!", "Delete Word", JOptionPane.ERROR_MESSAGE);
                    }
                    tfTitle.requestFocus();
                }
            }
        );

        JLabel lTitle = new JLabel("Title: ");
        JLabel blank = new JLabel();

        lTitle.setBounds(10, 30, 60, 30);
        tfTitle.setBounds(70, 30, 100, 30);

        blank.setBounds(10, 50, 100, 30);

        btnDelete.setBounds(30, 70, 100, 30);

        add(tfTitle);
        add(btnDelete);

        add(lTitle);
        add(blank);
    }
}