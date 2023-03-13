import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MemoryHelper extends JFrame {
    private JLabel upperLabel;
    private JLabel lowerLabel;
    private ArrayList<String[]> lines;
    private int currentLineIndex;
    private int displayTimeSeconds;

    public void setDisplayTimeSeconds(int displayTimeSeconds) {
        this.displayTimeSeconds = displayTimeSeconds * 1000;
    }

    public static void main(String[] args) throws IOException {
        MemoryHelper memoryHelper = new MemoryHelper();
        
        // Prompt user for display time
        String input = JOptionPane.showInputDialog("Enter display time in seconds:");
        int displayTimeSeconds = Integer.parseInt(input);
        memoryHelper.setDisplayTimeSeconds(displayTimeSeconds);
     
        memoryHelper.setVisible(true);
    
    }


    public MemoryHelper() throws IOException {
        super("Memory Helper");
        setSize(320, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        upperLabel = new JLabel("", SwingConstants.CENTER);
        upperLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(upperLabel);

        lowerLabel = new JLabel("", SwingConstants.CENTER);
        lowerLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(lowerLabel);

        // Load lines from text file
        lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data.txt"), "UTF-8"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            lines.add(parts);
        }
        br.close();

        currentLineIndex = 0;
        displayCurrentLine();    
        

        // Display each line for set seconds
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(displayTimeSeconds);
                    currentLineIndex = (currentLineIndex + 1) % lines.size();
                    displayCurrentLine();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // Set the frame to always be on top of other windows
        setAlwaysOnTop(true);

    }

    private void displayCurrentLine() {
        String[] currentLine = lines.get(currentLineIndex);
        upperLabel.setText(currentLine[0]);
        lowerLabel.setText(currentLine[1]);
        
    }

}
