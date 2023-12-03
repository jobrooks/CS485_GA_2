package edu.loyola.cs485.view;

import edu.loyola.cs485.model.entity.Route;

import javax.swing.*;
public class MainFrame extends JFrame{
    public MainFrame(){
        super("CS485 Train Database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setJMenuBar(createMainMenu());
    }

    public JMenuBar createMainMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(
                e->{ System.exit(0); }
        );
        menuFile.add(mniExit);

        JMenu menuRoute = new JMenu("Route");
        JMenuItem mniRouteInsert = new JMenuItem("New / Create");
        mniRouteInsert.addActionListener(e->{
            newRouteClick();
        });
        menuRoute.add(mniRouteInsert);

        JMenuItem mniRouteCrud = new JMenuItem("CRUD");
        mniRouteCrud.addActionListener( e->{
            crudRouteClick();
        });
        menuRoute.add(mniRouteCrud);

        bar.add(menuFile);
        bar.add(menuRoute);
        return bar;
    }

    public void newRouteClick(){
        RouteDialog dlg = new RouteDialog();
        dlg.pack();
        dlg.setVisible(true);
    }

    public void crudRouteClick(){
        RouteCrudDialog dlg = new RouteCrudDialog();
        dlg.pack();
        dlg.setVisible(true);
    }
}
