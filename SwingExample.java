import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        // SwingのUIコンポーネントを作成
        JFrame frame = new JFrame("Swing Example");
        JButton button = new JButton("クリックしてみてください");
        JLabel label = new JLabel("こんにちは、Swing!");

        // レイアウトマネージャーを設定
        frame.setLayout(new java.awt.FlowLayout());

        // コンポーネントをフレームに追加
        frame.add(button);
        frame.add(label);

        // フレームの設定
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
