import javax.swing.*;

public class IHMMain extends javax.swing.JFrame {
    private JPanel main_interface;
    private JButton searchButton;
    private JTextField textField1;
    private JButton sortButton;
    private JButton addFilmButton;
    private JLabel lesFilmsLabel;
    private JList<lesfilms> lesfilmsList;
    private JTextArea filmInfoTextArea;
    private JLabel nameOfFilmLabel;

    DefaultListModel<lesfilms> listModel = new DefaultListModel<>();

    public IHMMain() {
        lesfilmsList.setModel(listModel);
        listModel.addElement(new lesfilms("nihaoma", "DVD"));
        listModel.addElement(new lesfilms("Your name", "B-Ray"));
        listModel.addElement(new lesfilms("nihaoma", "DVD"));
        listModel.addElement(new lesfilms("Your name", "B-Ray"));



    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("IHMMain");
        frame.setContentPane(new IHMMain().main_interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        SwingUtilities.invokeLater(IHMMain::new);

    }

    private class lesfilms {
        String nomdefilm;
        String model; //This model here is to define if the movir is stocked in DVD or B-ray
        // TODO: Change model after when other disagree......

        public lesfilms(String nomdefilm, String model) {
            this.nomdefilm = nomdefilm;
            this.model = model;
        }

        public String getNomdefilm() {
            return nomdefilm;
        }

        public void setNomdefilm(String nomdefilm) {
            this.nomdefilm = nomdefilm;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return nomdefilm + "\n" + model;
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
