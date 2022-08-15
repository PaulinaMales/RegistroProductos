import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaCrud {
    public JPanel Main;
    private JTextField textID;
    private JTextField textNombre;
    private JTextField textPrecio;
    private JTextField textCiudad;
    private JTextField textCantidad;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton limpiarButton;
    private JButton buscarButton;
    private JLabel textMensaje;

    //FUNCIONAMIENTO

    public JavaCrud() {
        Connect();
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMensaje.setText("");
                Create();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textMensaje.setText("");
                Delete();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textMensaje.setText("");
                limpiar();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMensaje.setText("");
                Buscar();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMensaje.setText("");
                Update();
            }
        });
    }
    Connection con;
    PreparedStatement pst;
    public void Connect(){
        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="PaulinaMales";
        final String PASSWORD="Males2001";


        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();

            System.out.println("Conexion exitosa");

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void Create(){
        String nombre, precio,ciudad, id, cantidad;
        nombre=textNombre.getText();
        precio=textPrecio.getText();
        ciudad=textCiudad.getText();
        id= textNombre.getText();
        cantidad=textCantidad.getText();
        System.out.println(nombre);
        System.out.println(precio);
        System.out.println(ciudad);
        System.out.println(id);
        System.out.println(cantidad);

        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="PaulinaMales";
        final String PASSWORD="Males2001";


        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="insert into productos(pnombre, pciudad,pprecio,pcantidad)values(?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombre);
            pst.setString(2,ciudad);
            pst.setString(3,precio);
            pst.setString(4,cantidad);
            //ResultSet resultSet=pst.executeQuery();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro Guardado");


            //////////////
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void limpiar(){
        textNombre.setText("");
        textPrecio.setText("");
        textCiudad.setText("");
        textID.setText("");
        textCantidad.setText("");
    }

    public void Buscar(){
        // String nombre, precio,ciudad, id, cantidad;

        String id;
        id = textID.getText();

        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="PaulinaMales";
        final String PASSWORD="Males2001";

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="select * from productos where pid=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,id);


            ResultSet rs=pst.executeQuery();
            //pst.executeQuery();

            if(rs.next()==true){
                String nombre,ciudad,precio,cantidad;
                nombre= rs.getString(2);
                ciudad= rs.getString(3);
                precio=rs.getString(4);
                cantidad = rs.getString(5);

                System.out.println();
                textNombre.setText(nombre);
                textCiudad.setText(ciudad);
                textPrecio.setText(precio);
                textCantidad.setText(cantidad);

            }else {

                textMensaje.setText("No se encuentra el producto");
                limpiar();
                //textMensaje.setText("");
            }

            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }


    }

    public void Update(){

        String id, nombre,ciudad,precio,cantidad;

        id = textID.getText();
        nombre=textNombre.getText();
        ciudad = textCiudad.getText();
        precio = textPrecio.getText();
        cantidad = textCantidad.getText();

        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="PaulinaMales";
        final String PASSWORD="Males2001";


        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="update productos set pnombre=?, pciudad=?,pprecio=?,pcantidad=? where pid=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombre);
            pst.setString(2,ciudad);
            pst.setString(3,precio);
            pst.setString(4,cantidad);
            pst.setString(5,id);
            //ResultSet resultSet=pst.executeQuery();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro Actualizado");

            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }




    }

    public void Delete(){
        String borrarId= textID.getText();

        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="PaulinaMales";
        final String PASSWORD="Males2001";



        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="delete from productos where pid=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,borrarId);

            //ResultSet resultSet=pst.executeQuery();
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Borrado");

            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }


    }


    //Fin funcionamiento



}
