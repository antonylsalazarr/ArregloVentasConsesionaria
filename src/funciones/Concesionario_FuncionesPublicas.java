package funciones;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Concesionario_FuncionesPublicas {

    public static void exportarTablaEnFormatoCSV(DefaultTableModel model, JFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showSaveDialog(parentFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            File file = new File(selectedDirectory, "datos.csv");

            try (FileWriter writer = new FileWriter(file)) {
                // EscriBir_Filas
                for (int i = 0; i < model.getColumnCount(); i++) {
                    writer.write(model.getColumnName(i));
                    if (i < model.getColumnCount() - 1) {
                        writer.write(",");
                    } else {
                        writer.write("\n");
                    }
                }

                // Escribir_Filas
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        writer.write(model.getValueAt(i, j).toString());
                        if (j < model.getColumnCount() - 1) {
                            writer.write(",");
                        } else {
                            writer.write("\n");
                        }
                    }
                }

                writer.flush();
                JOptionPane.showMessageDialog(parentFrame, "Archivo guardado exitosamente en: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(parentFrame, "Error al guardar el archivo: " + e.getMessage());
            }
        }
    }
}