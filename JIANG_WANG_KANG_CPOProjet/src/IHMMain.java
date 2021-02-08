import javax.swing.*;

public class IHMMain extends javax.swing.JFrame {
    private JPanel main_interface;
    private JButton searchButton;
    private JTextField textField1;
    private JButton sortButton;
    private JButton addFilmButton;
    private JLabel lesFilmsLabel;
    public JList lesfilmsList;
    private JTextArea filmInfoTextArea;
    private JLabel nameOfFilmLabel;


    public IHMMain(){
        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("Item1");
        l1.addElement("Item2");
        l1.addElement("Item3");
        l1.addElement("Item4");
        lesfilmsList = new JList(l1);
        lesfilmsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lesfilmsList.setSelectedIndex(0);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IHMMain");
        frame.setContentPane(new IHMMain().main_interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
