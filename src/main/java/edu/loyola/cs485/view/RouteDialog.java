package edu.loyola.cs485.view;

import com.mysql.cj.xdevapi.Client;
import edu.loyola.cs485.controller.RouteService;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Time;

public class RouteDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtID;
    private JTextField txtTime;
    private JTextField txtStrtSttn;
    private JTextField txtEndSttn;
    private JTextField txtDist;

    public RouteDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
        // add your code here
        try {
            String T_T = txtTime.getText();
            String sStation = txtStrtSttn.getText();
            String eStation = txtEndSttn.getText();
            String dTraveled = txtDist.getText();

            RouteService service = new RouteService();
            service.createNewRoute(Time.valueOf(T_T),sStation,eStation, Integer.parseInt(dTraveled));
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

    public static void main(String[] args) {
        RouteDialog dialog = new RouteDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
