import javax.swing.*;
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
        // フレームの設定
        frame = new JFrame("数字当てゲーム");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        // ラベルの設定
        JLabel instructionLabel = new JLabel("1から100までの数を当ててください:");
        instructionLabel.setBounds(20, 20, 250, 25);
        frame.add(instructionLabel);

        // 入力フィールドの設定
        guessInput = new JTextField();
        guessInput.setBounds(20, 50, 100, 25);
        frame.add(guessInput);

        // ボタンの設定
        guessButton = new JButton("推測する");
        guessButton.setBounds(130, 50, 120, 25);
        frame.add(guessButton);

        // メッセージラベルの設定
        messageLabel = new JLabel("");
        messageLabel.setBounds(20, 80, 250, 25);
        frame.add(messageLabel);

        // ボタンのアクションリスナーを設定
        guessButton.addActionListener(new GuessButtonListener());

        // ゲームの初期化
        initializeGame();

        // フレームを表示
        frame.setVisible(true);
    }

    private void initializeGame() {
        // ゲームの初期設定
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // ユーザーの入力を取得
                int userGuess = Integer.parseInt(guessInput.getText());
                numberOfTries++;

                // ゲームのロジック
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