package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.company.AddBook;

public class MenuFrame extends JFrame {
    public MenuFrame() throws Exception {
        super("Book Recommendation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        // create menu
        JMenu mnuBook = new JMenu("Dictionary");
        mb.add(mnuBook);

        // options in Dictionary Menu
        JMenuItem option = new JMenuItem("Add book..");
//        option.setIcon( getImage("add.gif"));
        option.setAccelerator(KeyStroke.getKeyStroke("F5"));
        mnuBook.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

//        // options in Dictionary Menu
//        option = new JMenuItem("Delete Book...");
////        option.setIcon( getImage("delete.gif"));
//        option.setAccelerator(KeyStroke.getKeyStroke("F6"));
//        mnuBook.add(option);
//        option.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteBook();
//            }
//        });
//
//        mnuBook.addSeparator();
//
//        // options in Dictionary Menu
//        option = new JMenuItem("Search Book...");
////        option.setIcon( getImage("search.gif"));
//        option.setAccelerator(KeyStroke.getKeyStroke("F7"));
//        mnuBook.add(option);
//        option.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                searchBook();
//            }
//        });
//
//
//        option = new JMenuItem("List Books");
////        option.setIcon( getImage("list.gif"));
//        option.setAccelerator(KeyStroke.getKeyStroke("F8"));
//        mnuBook.add(option);
//        option.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                listBooks();
//            }
//        });
//
//        mnuBook.addSeparator();
//
//        option = new JMenuItem("Recommend Book");
////        option.setIcon( getImage("list.gif"));
//        option.setAccelerator(KeyStroke.getKeyStroke("F9"));
//        mnuBook.add(option);
//        option.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                recommendBook();
//            }
//        });

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

//    public void deleteBook() {
//        DeleteWord w = new DeleteWord();
//        centerToParent(MenuFrame.this, w);
//        w.setVisible(true);
//    }
//
//    public void searchBook() {
//        SearchWord w = new SearchWord();
//        centerToParent(MenuFrame.this, w);
//        w.setVisible(true);
//    }
//
//    public void listBooks() {
//        ListWords w = new ListWords();
//        w.setVisible(true);
//        centerToParent(MenuFrame.this, w);
//    }
//
//    public void recommendBook() {
//        Recommender w = new Recommender();
//        w.setVisible(true);
//        centerToParent(MenuFrame.this, w);
//    }


    public void addToolbar() {
        JToolBar tb = new JToolBar();
//        JButton b = new JButton( getImage("add.gif"));
        JButton b = new JButton("Add Book");
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Add Book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }

        });
    }

    //
////        b = new JButton( getImage("delete.gif"));
//        b = new JButton("Delete Book");
//        b.setPreferredSize(new Dimension(32, 32));
//        tb.add(b);
//        b.setToolTipText("Delete Word");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteBook();
//            }
//
//        });
//
////        b = new JButton( getImage("search.gif"));
//        b = new JButton("Search Book");
//        b.setPreferredSize(new Dimension(32, 32));
//        tb.add(b);
//        b.setToolTipText("Search Word");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                searchBook();
//            }
//
//        });
//
//
////        b = new JButton( getImage("list.gif"));\
//        b = new JButton("List Book");
//        tb.add(b);
//        b.setToolTipText("List Words");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                listBooks();
//            }
//
//        });
//
//        tb.addSeparator();
//
////        b = new JButton( getImage("save.gif"));
//        b = new JButton("Recommend Book");
//        tb.add(b);
//        b.setToolTipText("Recommend Book");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                recommendBook();
//            }
//
//        });
//
//
//        getContentPane().add(tb, BorderLayout.NORTH);
//    }


    public void run() throws Exception{
        MenuFrame f = new MenuFrame();
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
