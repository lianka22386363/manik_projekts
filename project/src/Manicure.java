import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Manicure {
    private JPanel rootPanel;
    private JLabel dataLabel;
    private JButton readyButton;
    private JTextField dataTextField;
    private JComboBox<String> timeComboBox;
    private JLabel timeLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel typeLabel;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> lengthComboBox;
    private JLabel lengthLabel;
    private JLabel brokenLabel;
    private JComboBox<String> brokenComboBox;
    private JLabel vivod;
    private JLabel vivod2;
    private JLabel vivod3;
    FileWriter writer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pieraksts manikīram");
        frame.setContentPane(new Manicure().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public Manicure() {

        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame thankFrame = new JFrame();
                String name = nameTextField.getText();
                String data =  dataTextField.getText();
                String time = (String) timeComboBox.getSelectedItem();
                String type = (String) typeComboBox.getSelectedItem();
                String length = (String) lengthComboBox.getSelectedItem();
                String broken = (String) brokenComboBox.getSelectedItem();

                int optionresult = JOptionPane.showConfirmDialog(null, "Paldies! Jūs esat pierakstīti! \nVai Jūs esat pārliecināti par pierakstīšanos?");
                if (optionresult == JOptionPane.YES_OPTION) {

                    Info info = new Info(name, data, time, type, length, broken);

                    vivod.setText("Paldies par Jūsu pierakstu, " + name + "! "  + "\n" );
                    vivod2.setText("Gaidīsim Jūs: " + data + " plkts. " + time );
                    vivod3.setText("Jūsu procedūra ir: " + type + ", nagi ir " + length + ", ir " + broken + " salauzti nagi.");
                    try {
                        FileWriter writer = new FileWriter("manikirs.txt", true);
                        writer.write("\n" + info.printinfo());
                        writer.close();
                    } catch (IOException E) {
                        System.out.println("Ir radusies kļūda!");
                    }
                } else {
                    vivod.setText("Meģiniet vēlreiz!");
                    vivod2.setText(" ");
                    vivod3.setText(" ");
                }
            }
        });
    }
    private void createUIComponents() {
        timeComboBox = new JComboBox<>();
        timeComboBox.addItem("9:00");
        timeComboBox.addItem("12:00");
        timeComboBox.addItem("15:00");
        timeComboBox.addItem("18:00");

        typeComboBox = new JComboBox<>();
        typeComboBox.addItem("klasiskais manikīrs");
        typeComboBox.addItem("gēla manikīrs");
        typeComboBox.addItem("nagu pieaudzēsana");
        typeComboBox.addItem("lakas noņemšana");

        lengthComboBox = new JComboBox<>();
        lengthComboBox.addItem("īsie");
        lengthComboBox.addItem("vidējie");
        lengthComboBox.addItem("garie");

        brokenComboBox = new JComboBox<>();
        brokenComboBox.addItem("0");
        brokenComboBox.addItem("1-3");
        brokenComboBox.addItem("4-5");
        brokenComboBox.addItem("6 un vairāk");
    }
}