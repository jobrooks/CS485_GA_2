package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.RouteService;
import edu.loyola.cs485.model.entity.Route;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Time;

public class RouteUpdateDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtTime;
    private JTextField txtStrtSttn;
    private JTextField txtEndSttn;
    private JTextField txtDist;

    public RouteUpdateDialog(Route route) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(route);
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
    }

    private void onOK(Route r) {
        try {
            String T_T = txtTime.getText();
            String sStation = txtStrtSttn.getText();
            String eStation = txtEndSttn.getText();
            String dTraveled = txtDist.getText();

            RouteService service = new RouteService();
            service.update(r, Time.valueOf(T_T),sStation,eStation, Integer.parseInt(dTraveled));
            dispose();
        }catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
