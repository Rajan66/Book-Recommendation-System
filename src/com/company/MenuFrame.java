package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    public MenuFrame() throws Exception {
        super("Book Recommendation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu mnuBook = new JMenu("Book Recommendation System");
        mb.add(mnuBook);

        JMenuItem option = new JMenuItem("Add book..");
        option.setAccelerator(KeyStroke.getKeyStroke("F5"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });


        option = new JMenuItem("Delete Book...");
        option.setAccelerator(KeyStroke.getKeyStroke("F6"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });

        mnuBook.addSeparator();

        option = new JMenuItem("Search Book...");

        option.setAccelerator(KeyStroke.getKeyStroke("F7"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });

        option = new JMenuItem("Recommend Book");
        option.setAccelerator(KeyStroke.getKeyStroke("F8"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                recommendBook();
            }
        });

        mnuBook.addSeparator();

        option = new JMenuItem("View Books");
        option.setAccelerator(KeyStroke.getKeyStroke("F9"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listBooks();
            }
        });

        addToolbar();
        setJMenuBar(mb);

    }

    public void centerToParent(JFrame parent, JFrame child) {
        Dimension pd = parent.getSize();
        Dimension cd = child.getSize();
        int x = (int) (pd.getWidth() - cd.getWidth()) / 2;
        int y = (int) (pd.getHeight() - cd.getHeight()) / 2;
        child.setLocation(x, y);

    }

    public void addBook() {
        AddBook w = new AddBook();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void deleteBook() {
        DeleteBook w = new DeleteBook();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void searchBook() {
        SearchBook w = new SearchBook();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void listBooks() {
        ListBooks w = new ListBooks();
        w.setVisible(true);
        centerToParent(MenuFrame.this, w);
    }

    public void recommendBook() {
        Recommender w = new Recommender();
        w.setVisible(true);
        centerToParent(MenuFrame.this, w);
    }


    public void addToolbar() {
        JToolBar tb = new JToolBar();
        tb.setBounds(20, 20, 500, 50);

        JButton b = new JButton("Add Book");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Add a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }

        });

        b = new JButton("Delete Book");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Delete a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }

        });

        b = new JButton("Search Book");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Search a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }

        });

        b = new JButton("Recommend Book");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Suggest a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recommendBook();
            }

        });

        b = new JButton("View Books");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("View all Books");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listBooks();
            }

        });
        getContentPane().add(tb, BorderLayout.NORTH);
    }

    public void run() throws Exception {
        MenuFrame f = new MenuFrame();
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
