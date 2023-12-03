package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.RouteService;
import edu.loyola.cs485.model.entity.Route;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class RouteCrudDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonEdit;
    private JButton buttonCancel;
    private JList lstRouteUI;
    private JButton deleteButton;
    private JButton newButton;

    public RouteCrudDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        populateList();

        buttonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEditClick();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClick();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClick();
            }
        });
    }

    private void onEditClick() {
        // add your code here
        Route selRoute = (Route) lstRouteUI.getSelectedValue();
        RouteUpdateDialog dlg = new RouteUpdateDialog(selRoute);
        dlg.pack();
        dlg.setVisible(true);

        populateList();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void onNewClick(){
        RouteDialog dlg = new RouteDialog();
        dlg.pack();
        dlg.setVisible(true);

        populateList();
    }

    public void onDeleteClick(){
        try {
            Route selRoute = (Route) lstRouteUI.getSelectedValue();
            RouteService service = new RouteService();
            service.delete(selRoute);

            populateList();
        }catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    public void populateList(){
        try {
            RouteService service = new RouteService();
            List lstdata = service.getRoutes();

            lstRouteUI.setListData(lstdata.toArray());
        }catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        RouteCrudDialog dialog = new RouteCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
