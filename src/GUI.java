import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JPanel implements ActionListener {

        private JFrame Stopwatch;
        private JButton startButton = new JButton("START");
        private JButton resetButton = new JButton("RESET");
        private JLabel timeLabel = new JLabel();

        int elapsedTime = 0;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        boolean started = false;
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);



        public GUI() {

            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            timeLabel.setBounds(0, 0, 224, 100);
            timeLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 35));
            timeLabel.setBorder(BorderFactory.createBevelBorder(1));
            timeLabel.setOpaque(true);
            timeLabel.setHorizontalAlignment(JTextField.CENTER);

            startButton.setBounds(0, 100, 114, 55);
            startButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
            startButton.setFocusable(false);
            startButton.addActionListener(this);

            resetButton.setBounds(110, 100, 114, 55);
            resetButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
            resetButton.setFocusable(false);
            resetButton.addActionListener(this);

            Stopwatch.add(startButton);
            Stopwatch.add(resetButton);
            Stopwatch.add(timeLabel);

            Stopwatch.setTitle("Stopwatch");
            Stopwatch.setSize(240, 194);
            Stopwatch.setLayout(null);
            Stopwatch.setVisible(true);

        }
    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }

    }
    );


    @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == startButton) {
                //make START change to STOP when timer started
                if (started == false) {
                    started = true;
                    startButton.setText("STOP");
                    start();
                } else {
                    started = false;
                    startButton.setText("START");
                    stop();
                }

            }
            if (e.getSource() == resetButton) {
                started = false;
                startButton.setText("START");
                reset();
            }

        }

        void start() {
            timer.start();

        }

        void stop() {
            timer.stop();

        }

        void reset() {
            timer.stop();
            elapsedTime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }

    }

