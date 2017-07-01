import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField; 

public class ATMmachine { 

    private JFrame frame; 
    private JPasswordField txtAccountNumber; 

    /** 
     * Launch the application. 
     */ 
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() { 
            public void run() { 
                try { 
                    ATMmachine window = new ATMmachine(); 
                    window.frame.setVisible(true); 
                } catch (Exception e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
    } 

    /** 
     * Create the application. 
     */ 
    public ATMmachine() { 
        initialize(); 
    } 

    /** 
     * Initialize the contents of the frame. 
     */ 
    private void initialize() { 
        frame = new JFrame(); 
        frame.setBounds(100, 100, 450, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.getContentPane().setLayout(null); 
         
        JLabel lblAccountNumber = new JLabel("Account Number:"); 
        lblAccountNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16)); 
        lblAccountNumber.setBounds(62, 64, 134, 56); 
        frame.getContentPane().add(lblAccountNumber); 
         
        JLabel lblPassword = new JLabel("Password:"); 
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16)); 
        lblPassword.setBounds(72, 126, 121, 35); 
        frame.getContentPane().add(lblPassword); 
         
        txtAccountNumber = new JPasswordField(); 
        txtAccountNumber.setBounds(192, 81, 128, 26); 
        frame.getContentPane().add(txtAccountNumber); 
         
        JPasswordField txtPassword = new JPasswordField(); 
        txtPassword.setBounds(193, 131, 128, 29); 
        frame.getContentPane().add(txtPassword); 
         
        JButton btnLogin = new JButton("LOGIN"); 
        btnLogin.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                 
                String password = txtPassword.getText(); 
                String accountnumber = txtAccountNumber.getText(); 
             
                if (password.contains("group2")&& accountnumber.contains("1111")){ 
                   txtPassword.setText(null); 
                   txtAccountNumber.setText(null); 
                   
                   MenuSystem info = new MenuSystem(); 
                   MenuSystem.main(null); 
        } 
                else 
                { 
                    JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE); 
                    txtPassword.setText(null); 
                    txtAccountNumber.setText(null); 
                 
                } 
            } 
        }); 
        btnLogin.setBounds(50, 184, 113, 35); 
        frame.getContentPane().add(btnLogin); 
         
        JButton btnReset = new JButton("RESET"); 
        btnReset.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent arg0) { 
             
                txtAccountNumber.setText(null); 
                txtPassword.setText(null); 
                 
             
            } 
             
        }); 
        btnReset.setBounds(242, 184, 113, 35); 
        frame.getContentPane().add(btnReset); 
         
        JLabel lblAtmSystem = new JLabel("ATM System"); 
        lblAtmSystem.setFont(new Font("Times New Roman", Font.PLAIN, 17)); 
        lblAtmSystem.setBounds(154, 11, 151, 45); 
        frame.getContentPane().add(lblAtmSystem); 
    } 
} 