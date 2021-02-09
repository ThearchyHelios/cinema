import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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


    public static void main(String[] args) {
        JFrame frame = new JFrame("IHMMain");
        frame.setContentPane(new IHMMain().main_interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public IHMMain() {
        lesfilmsList.setModel(listModel);

        String filepath = "/Users/yilunjiang/Documents/GitHub/cinema/JIANG_WANG_KANG_CPOProjet/src/film.txt";
        List<String> list_film_in_txt = new ArrayList<String>();
        List<String> list_mode_in_txt = new ArrayList<String>();
        String line = "";
        try {
            FileInputStream fin = new FileInputStream(filepath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            StringBuffer buffer = new StringBuffer();
            while ((line = buffReader.readLine()) != null) {
                System.out.println(line);
                String[]film_string = line.split(",");
                list_film_in_txt.add(film_string[0].toString());
                list_mode_in_txt.add(film_string[1].toString());
            }
            System.out.println(list_film_in_txt);
            System.out.println(list_mode_in_txt);
            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(int j=0;j<list_film_in_txt.size();j++){
            listModel.addElement(new lesfilms(list_film_in_txt.get(j), list_mode_in_txt.get(j)));
        }
        lesfilmsList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lesfilms film = lesfilmsList.getSelectedValue();
                filmInfoTextArea.setText("Name: " + film.getNomdefilm() + "\n" + "Type: " + film.getModel());
            }
        });


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
