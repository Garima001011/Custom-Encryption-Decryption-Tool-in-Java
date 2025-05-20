import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EncryptionToolGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Encryption Tool");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea inputArea = new JTextArea(5, 40);
        JTextField keyField = new JTextField();
        JTextArea outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        JButton loadButton = new JButton("Load File");
        JButton saveButton = new JButton("Save Output");

        JPanel topPanel = new JPanel(new GridLayout(6, 1));
        topPanel.add(new JLabel("Enter Text:"));
        topPanel.add(new JScrollPane(inputArea));
        topPanel.add(new JLabel("Enter Key (16 chars for AES):"));
        topPanel.add(keyField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        encryptButton.addActionListener(e -> {
            String input = inputArea.getText();
            String key = keyField.getText();
            if (key.length() != 16) {
                JOptionPane.showMessageDialog(frame, "AES key must be 16 characters long.");
                return;
            }
            try {
                String encrypted = AESCipher.encrypt(input, key);
                outputArea.setText(encrypted);
                JOptionPane.showMessageDialog(frame, "Encryption completed!");
            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        decryptButton.addActionListener(e -> {
            String input = inputArea.getText();
            String key = keyField.getText();
            if (key.length() != 16) {
                JOptionPane.showMessageDialog(frame, "AES key must be 16 characters long.");
                return;
            }
            try {
                String decrypted = AESCipher.decrypt(input, key);
                outputArea.setText(decrypted);
                JOptionPane.showMessageDialog(frame, "Decryption completed!");
            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    String content = FileHandler.readFile(fileChooser.getSelectedFile().getAbsolutePath());
                    inputArea.setText(content);
                } catch (Exception ex) {
                    outputArea.setText("File read error: " + ex.getMessage());
                }
            }
        });

        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    FileHandler.writeFile(fileChooser.getSelectedFile().getAbsolutePath(), outputArea.getText());
                    JOptionPane.showMessageDialog(frame, "Output saved successfully!");
                } catch (Exception ex) {
                    outputArea.setText("File write error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}
