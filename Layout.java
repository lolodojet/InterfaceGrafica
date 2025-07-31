import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyledDocument;

public class Layout {

    public static void main(String[] args) {
        System.out.println("Olá Mundo GUI");

        JFrame frame = new JFrame("Informações");

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new BorderLayout());

        JButton button = new JButton("Clique para salvar o carro que informou!");
        button.setForeground(Color.BLACK);
        button.setBackground(Color.RED);
        button.setPreferredSize(new Dimension(100, 30));

        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Serif", Font.ITALIC, 28));
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, textField.getText(), "Titulo", 1);
        });

        JLabel label = new JLabel("Diga seu carro favorito:");
        label.setFont(new Font("Serif", Font.ITALIC, 28));

        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();

        ImageIcon icon = new ImageIcon("carro.jpg");
        JLabel imageLabel = new JLabel(icon);
        
         
        //JTextArea textArea = new JTextArea("Veja carros novos!");
        //JTextArea textArea1 = new JTextArea("Hoje esta frio!");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formPanel.add(label);
        formPanel.add(textField);
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);
        //panel.add(textArea1, BorderLayout.CENTER);
   
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

     

    }
}