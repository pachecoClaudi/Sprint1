/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sprintuno.EditarUML;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PACHECO
 */
public class editarUML {
    // Método para obtener el archivo desde la base de datos
    public static byte[] obtenerArchivoDeBD(int idArchivo) {
        byte[] contenidoArchivo = null;
        Connection cn = Conexion.getConnection(); // Asumiendo que tienes una clase Conexion con el método getConnection()

        String sql = "SELECT contenido FROM archivo WHERE id_archivo = ?";

        try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
            pstmt.setInt(1, idArchivo); // Asigna el ID del archivo que deseas obtener
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                contenidoArchivo = rs.getBytes("contenido"); // Obtén el contenido del archivo
                JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún archivo con ese ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el archivo: " + e.getMessage());
        } finally {
            try {
                if (cn != null) cn.close(); // Cierra la conexión después de usarla
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return contenidoArchivo;
    }

    public static void main(String[] args) {
        // Aquí puedes invocar el método para descargar un archivo, por ejemplo con ID 1
        int idArchivo = 1; // Asigna el ID del archivo que quieres descargar
        byte[] archivo = obtenerArchivoDeBD(idArchivo);

        if (archivo != null) {
            // Aquí puedes implementar la lógica para guardar el archivo en el sistema de archivos o procesarlo.
            System.out.println("Archivo descargado con éxito.");
        }
    }
}
