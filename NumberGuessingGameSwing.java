import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameSwing {
    private JFrame frame;
    private JTextField guessInput;
    private JLabel messageLabel;
    private JButton guessButton;
    private int numberToGuess;
    private int numberOfTries;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessingGameSwing().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("数字当てゲーム");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel instructionLabel = new JLabel("1から100までの数を当ててください:");
        guessInput = new JTextField();
        guessButton = new JButton("推測する");
        messageLabel = new JLabel("");

        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        guessInput.setFont(new Font("Arial", Font.PLAIN, 14));
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        guessButton.setBackground(Color.GREEN);
        guessButton.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.RED);

        panel.add(instructionLabel);
        panel.add(guessInput);
        panel.add(guessButton);
        panel.add(messageLabel);

        frame.add(panel, BorderLayout.CENTER);

        guessButton.addActionListener(new GuessButtonListener());

        initializeGame();

        frame.setVisible(true);
    }

    private void initializeGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int userGuess = Integer.parseInt(guessInput.getText());
                numberOfTries++;

                if (userGuess < numberToGuess) {
                    messageLabel.setText("もっと大きな数です!");
                } else if (userGuess > numberToGuess) {
                    messageLabel.setText("もっと小さな数です!");
                } else {
                    messageLabel.setText("正解です! " + numberOfTries + " 回の試行で当てました!");
                    guessInput.setEnabled(false);
                    guessButton.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("無効な入力です。数字を入力してください。");
            }
        }
    }
}