import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.WindowConstants;

public class LoginForm  extends JFrame{
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private JButton ingresarButton;
    private JButton cancelButton;
    //private javax.swing.JPanel loginPanel;
    public JPanel loginPanel;

    //USER
    public User user;



    //FUNCIONAMIENTO
    public LoginForm(){

        //BOTON OK FUNCIONALIDAD
        ingresarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                String email=emailTF.getText();
                String password =String.valueOf(passwordTF.getPassword()); //Asi obtenemos el password sin saber cual es (CASTEO)
                System.out.println("Boton Ok");
                user = getAuthenticationUser(email,password);


                if(user!= null){


                    //PANTALLA 2
                    JFrame frame = new JFrame("Sistema de Productos");
                    frame.setSize(700,400);
                    frame.setContentPane(new JavaCrud().Main);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    //dispose();
                    //System.exit(0);

                    // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                }
                else {
                    JOptionPane.showMessageDialog(null,"email o password incorrectos",
                            "Intente nuevamente",JOptionPane.ERROR_MESSAGE);
                    emailTF.setText("");
                    passwordTF.setText("");
                    System.out.println("Error de conexion");

                }


            }


        });
        //BOTON CANCEL
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Cancel");
                System.exit(0);


            }
        });
        // setVisible(true);
    }
    ///////
    //CREAR AUTENTICACION (elementos)
    private User getAuthenticationUser(String email, String password){
        User user = null;
        final String DB_URL= "jdbc:mysql://localhost/mi_tienda?serverTimezone=UTC";
        final String USERNAME = "PaulinaMales";
        final String PASSWORD="Males2001";

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();

            System.out.println("Conexion Exitosa");
            String sql= "SELECT * FROM users WHERE email =? AND password =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.nombre= resultSet.getString("nombre");
                user.email = resultSet.getString("email");
                user.celular = resultSet.getString("celular");
                user.direccion = resultSet.getString("direccion");
                user.password= resultSet.getString("password");

            }

            stmt.close();
            conn.close();


        } catch (Exception e){

            System.out.println("Error de .....");
            e.printStackTrace();
        }

        return user;
    }

    ///////////////////////


    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        User user = loginForm.user;


        //PANTALLA 1
        JFrame frame= new JFrame("Inicio ");
        frame.setContentPane(new LoginForm().loginPanel);
        frame.setTitle("Inicio de Sesion");
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        //frame.dispose();
        //System.exit(0);

    }



    //fin funcionamiento
}

