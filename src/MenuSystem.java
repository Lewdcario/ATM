import java.awt.EventQueue; 

import javax.swing.JFrame; 
import javax.swing.JButton; 
import java.awt.Font; 

public class MenuSystem { 

    private JFrame frame; 

    /** 
     * Launch the application. 
     */ 
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() { 
            public void run() { 
                try { 
                    MenuSystem window = new MenuSystem(); 
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
    public MenuSystem() { 
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
         
        JButton btnDeposit = new JButton("Deposit"); 
        btnDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnDeposit.setBounds(45, 36, 130, 35); 
        frame.getContentPane().add(btnDeposit); 
         
        JButton btnCheckBalance = new JButton("Check Balance"); 
        btnCheckBalance.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnCheckBalance.setBounds(45, 106, 130, 35); 
        frame.getContentPane().add(btnCheckBalance); 
         
        JButton btnWithdraw = new JButton("Withdraw"); 
        btnWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnWithdraw.setBounds(241, 36, 122, 35); 
        frame.getContentPane().add(btnWithdraw); 
         
        JButton btnMakeTransfer = new JButton("Make Transfer"); 
        btnMakeTransfer.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnMakeTransfer.setBounds(241, 106, 122, 35); 
        frame.getContentPane().add(btnMakeTransfer); 
         
        JButton btnLogout = new JButton("Logout"); 
        btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnLogout.setBounds(241, 182, 122, 35); 
        frame.getContentPane().add(btnLogout); 
         
        JButton btnChange = new JButton("Change Password"); 
        btnChange.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        btnChange.setBounds(45, 182, 130, 35); 
        frame.getContentPane().add(btnChange); 
    } 

} 
