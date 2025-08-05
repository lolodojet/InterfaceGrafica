import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyledDocument;
import javafx.scene.layout.BorderRepeat;
import java.util.HashMap;
import java.util.Map;

public class Layout {

    public static void main(String[] args) {
        System.out.println("Olá Mundo GUI");

        JFrame frame = new JFrame("Carros Esportivos");

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(15, 45, 100));

        
        JLabel label = new JLabel("Escolha seu carro esportivo favorito!");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.ITALIC, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        String[] carros = {
            "Ferrari 488 Spider",
            "Lamborghini Huracán",
            "McLaren 720S",
            "Audi R8",
            "Nissan GT-R",
            "Porsche 911 GT3-RS",
            "Bugatti Tourbillon"
        };

        JComboBox<String> comboCarros = new JComboBox<>(carros);
        comboCarros.setFont(new Font("Arial", Font.ITALIC, 20));

        Map<String, String> mapaImagens = new HashMap<>();
        mapaImagens.put("Ferrari 488 Spider", "ferrari.jpg");
        mapaImagens.put("Lamborghini Huracán", "lambo.jpg");
        mapaImagens.put("McLaren 720S", "mclaren2.png");
        mapaImagens.put("Audi R8", "audi.jpg");
        mapaImagens.put("Nissan GT-R", "nissan.jpg");
        mapaImagens.put("Porsche 911 GT3-RS", "porsche.jpeg");
        mapaImagens.put("Bugatti Tourbillon", "bugatti.jpg");




        

        JLabel imagemLabel = new JLabel();
        imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Runnable atualizarImagem = () -> {
            String carro = (String) comboCarros.getSelectedItem();
            String caminhoImg = mapaImagens.get(carro);
            
            if (caminhoImg != null){
                ImageIcon icon =  new ImageIcon(caminhoImg);
                int largura = 700;
                int altura = 500;
                Image img = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
                imagemLabel.setIcon(new ImageIcon(img));
                imagemLabel.setPreferredSize(new Dimension(largura, altura));         
            } else {
                imagemLabel.setIcon(null);
                imagemLabel.setPreferredSize(null);
            }
        };

        comboCarros.addActionListener(e -> atualizarImagem.run());
        atualizarImagem.run();

        JButton button = new JButton("Salvar");
        button.setFont(new Font("Verdana", Font.BOLD, 13));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(150, 190, 255));
        button.setPreferredSize(new Dimension(100, 30));
        button.setContentAreaFilled(true);


        button.addActionListener(e ->{
            String carroEscolhido = comboCarros.getSelectedItem().toString();

            if (carroEscolhido.toLowerCase().contains("porsche")){
            JOptionPane.showMessageDialog(null, "Ótima escolha, você tem mesmo bom gosto!", "Carro Salvo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, carroEscolhido+ " Legal... Mas, todo mundo sabe que Porsche é melhor, rs!", "Carro Salvo", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboCarros.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel painelEscolha = new JPanel();
        painelEscolha.setLayout(new BoxLayout(painelEscolha, BoxLayout.Y_AXIS));
        painelEscolha.setOpaque(false);
        painelEscolha.add(label);
        painelEscolha.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEscolha.add(comboCarros);
        painelEscolha.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEscolha.add(button);

        JPanel painelCentral = new JPanel(new FlowLayout());
        painelCentral.setOpaque(false);
        painelCentral.setLayout((new FlowLayout(FlowLayout.CENTER, 20, 10)));

        JPanel painelImagem = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelImagem.setOpaque(false);
        painelImagem.add(imagemLabel);
        painelImagem.setBorder(BorderFactory.createEmptyBorder(0, 0, 250, 0));

        
        painelCentral.add(painelEscolha);
        panel.add(painelCentral, BorderLayout.CENTER);
        panel.add(painelImagem, BorderLayout.SOUTH);
   
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}