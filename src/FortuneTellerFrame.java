import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel outputPnl;
    JPanel controlPnl;
    JTextArea textArea;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    int fortuneIndex;
    int lastFortuneIndex = -1;
    ArrayList<String> fortunes = new ArrayList<>();

//    fortunes[0] = "You will have a great day!";
//    fortunes[1] = "A surprise is waiting for you around the corner.";
//    fortunes[2] = "Your hard work will soon pay off.";
//    fortunes[3] = "You will meet someone special soon.";
//    fortunes[4] = "An exciting opportunity is on the horizon.";
//    fortunes[5] = "You will find joy in unexpected places.";
//    fortunes[6] = "Your positive attitude will attract good things.";
//    fortunes[7] = "A new adventure is about to begin.";
//    fortunes[8] = "You will achieve your goals with determination.";
//    fortunes[9] = "Your kindness will be rewarded.";
//    fortunes[10] = "You will discover a hidden talent.";
//    fortunes[11] = "A pleasant surprise is in store for you.";

    public static void main(String[] args)
    {
        // The invokeLater method ensures the GUI is created on the
        // Event Dispatch Thread (EDT) to avoid thread interference.

        SwingUtilities.invokeLater(() -> new FortuneTellerFrame());
    }

    public FortuneTellerFrame(){

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createIconPanel();
        mainPnl.add(iconPnl,BorderLayout.NORTH);
        createTextPanel();
        mainPnl.add(outputPnl, BorderLayout.CENTER);
        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you around the corner.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("You will meet someone special soon.");
        fortunes.add("An exciting opportunity is on the horizon.");
        fortunes.add("You will find joy in unexpected places.");
        fortunes.add("Your positive attitude will attract good things.");
        fortunes.add("A new adventure is about to begin.");
        fortunes.add("You will achieve your goals with determination.");
        fortunes.add("Your kindness will be rewarded.");
        fortunes.add("You will discover a hidden talent.");
        fortunes.add("A pleasant surprise is in store for you.");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);


    }

    private void createIconPanel(){
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortune-teller.jpg");
        titleLbl = new JLabel("Get Your Fortune", icon, JLabel.CENTER);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setFont(new Font("Informal Roman", Font.BOLD, 46));

        iconPnl.add(titleLbl);
    }

    private void createTextPanel(){
        outputPnl = new JPanel();
        outputPnl.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(textArea);

        outputPnl.add(scrollPane,BorderLayout.CENTER);
    }

    private void createControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(new Font("SansSerif", Font.PLAIN, 18));
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("SansSerif", Font.PLAIN, 18));

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
        quitBtn.addActionListener(ae -> System.exit(0));
        fortuneBtn.addActionListener(ae -> {
            do{
                fortuneIndex = (int)(Math.random() * fortunes.size());
            }while (fortuneIndex == lastFortuneIndex);
            textArea.append(fortunes.get(fortuneIndex) + "\n");
            lastFortuneIndex = fortuneIndex;
        });
    }



}