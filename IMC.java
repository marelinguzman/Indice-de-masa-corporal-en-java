import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;

    public BMICalculator() {
        setTitle("Calculadora de IMC");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Etiquetas y campos de entrada
        JLabel heightLabel = new JLabel("Altura (m):");
        heightField = new JTextField();

        JLabel weightLabel = new JLabel("Peso (kg):");
        weightField = new JTextField();

        resultLabel = new JLabel("IMC: ");

        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(new CalculateButtonListener());

        // Agregar componentes al panel
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(calculateButton);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(resultLabel);

        // Agregar el panel a la ventana
        add(panel);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtener valores de los campos de entrada
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());

                // Calcular el IMC
                double bmi = weight / (height * height);

                // Mostrar el resultado
                resultLabel.setText(String.format("IMC: %.2f", bmi));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMICalculator().setVisible(true);
            }
        });
    }
}
