/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sprintuno;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
/**
 *
 * @author HP VICTUS
 */
public class visualizarDiagrama extends JFrame{
    private JTextArea umlTextArea;
    public visualizarDiagrama(String umlContent) {

        setTitle("Visor de Diagramas UML");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área de texto para mostrar el contenido del archivo UML
        umlTextArea = new JTextArea();
        umlTextArea.setText(umlContent);  // Insertar el contenido UML pasado como parámetro
        umlTextArea.setEditable(false);   // Hacer que el área de texto no sea editable
        JScrollPane scrollPane = new JScrollPane(umlTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para recuperar el contenido del diagrama desde la base de datos
    public static String getUMLContentFromDatabase(int archivoId, Connection connection) throws SQLException {
        String query = "SELECT contenido FROM archivo WHERE id_archivo = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, archivoId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Convertir el contenido bytea a texto
            byte[] contenidoBytes = resultSet.getBytes("contenido");
            return new String(contenidoBytes);  // Convertidor de bytes a string
        } else {
            throw new SQLException("No se encontró el archivo con el ID especificado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Usar la conexión definida en la clase Conexion
                    Connection connection = Conexion.getConnection();

                    // Obtención del ID del archivo UML que deseas visualizar
                    int archivoId = 1;  

                    // Obtener el contenido del archivo desde la base de datos
                    String umlContent = getUMLContentFromDatabase(archivoId, connection);

                    // Crear y mostrar la ventana con el diagrama UML
                    visualizarDiagrama viewer = new visualizarDiagrama(umlContent);
                    viewer.setVisible(true);

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al recuperar el diagrama UML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
