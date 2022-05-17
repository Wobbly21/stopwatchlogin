import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
/*the login form doesn't do anything more than let you
type stuff in, also hides your password
*/

    private JFrame frame;
    private JPanel panel;
    private JButton login;
    public Login(int width, int height) {

        frame.setTitle("Login");
        frame.setSize(305, 160);
        frame.add(panel);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 19, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 49, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(132, 83, 100, 25);
        panel.add(loginButton);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            System.out.println("Login successful");
            Login test = new Login(300, 300);
            frame.dispose();
        }
    }
}