import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebPageRefreshPlugin extends JFrame {
    private JTextField urlTextField;
    private JTextField refreshCountTextField;
    private JTextField intervalTextField;

    public WebPageRefreshPlugin() {
        setTitle("Web Page Refresh Plugin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // 创建界面元素
        JLabel urlLabel = new JLabel("URL:");
        urlTextField = new JTextField();
        JLabel refreshCountLabel = new JLabel("Refresh Count:");
        refreshCountTextField = new JTextField();
        JLabel intervalLabel = new JLabel("Interval (in seconds):");
        intervalTextField = new JTextField();
        JButton startButton = new JButton("Start Refresh");

        // 布局
        setLayout(new GridLayout(4, 2));
        add(urlLabel);
        add(urlTextField);
        add(refreshCountLabel);
        add(refreshCountTextField);
        add(intervalLabel);
        add(intervalTextField);
        add(new JLabel());
        add(startButton);

        // 注册按钮点击事件
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlTextField.getText();
                int refreshCount = Integer.parseInt(refreshCountTextField.getText());
                int interval = Integer.parseInt(intervalTextField.getText());

                // 调用刷新方法
                try {
                    refreshWebPage(url, refreshCount, interval);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // 刷新网页方法
    private void refreshWebPage(String url, int refreshCount, int interval) throws IOException, URISyntaxException {
        for (int i = 0; i < refreshCount; i++) {
            // 打开默认浏览器，并加载指定的网页
            Desktop.getDesktop().browse(new URI(url));

            // 间隔指定时间后刷新下一次
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebPageRefreshPlugin plugin = new WebPageRefreshPlugin();
                plugin.setVisible(true);
            }
        });
    }
}
