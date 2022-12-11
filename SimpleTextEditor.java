import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;

public class SimpleTextEditor implements ActionListener {
    JFrame frame; // Creating Window
    JTextArea jTextArea; // TextArea
    JMenuBar menuBar; // Menu bar
    JMenu File, Edit, Close; // Menu bar Options
    JMenuItem New, Open, Save, Print; // File Menu Items
    JMenuItem Cut, Copy, Paste; // Edit Menu items
    JMenuItem CloseEditor; // Close Menu Item

    public SimpleTextEditor() {

        // Frame
        frame = new JFrame("Simple Text Editor"); // Title of Window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // When Close button is hit, Execution of program is also Terminates
        frame.setVisible(true); // Make the Frame Visible.
        frame.setBounds(20, 20, 800, 800);// Default Window Size.


        // JTextArea
        jTextArea = new JTextArea("Welcome to Simple Text Editor");
        frame.add(jTextArea); // Added into Main Frame


        // MenuBar
        menuBar = new JMenuBar();// Creating Menu bar
        frame.setJMenuBar(menuBar);// Setting Menu Bar into frame


        //Menu
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Close = new JMenu("Close");
        // After Creating Menu Added into Menu Bar;
        menuBar.add(File);
        menuBar.add(Edit);
        menuBar.add(Close);

        // Menu Items for File Option
        New = new JMenuItem("New");
        New.addActionListener(this);//  Action Listener to Each Menu Item to Add Functionality

        Open = new JMenuItem("Open");
        Open.addActionListener(this);

        Save = new JMenuItem("Save");
        Save.addActionListener(this);

        Print = new JMenuItem("Print");
        Print.addActionListener(this);
        // After Creating Menu Item Add into File
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Print);

        // Menu Item for Edit Option
        Cut = new JMenuItem("Cut");
        Cut.addActionListener(this);

        Copy = new JMenuItem("Copy");
        Copy.addActionListener(this);

        Paste = new JMenuItem("Paste");
        Paste.addActionListener(this);


        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);

        CloseEditor = new JMenuItem("Close");
        Close.add(CloseEditor);
        Close.addActionListener(this);
    }

    public static void main(String[] args) {
        SimpleTextEditor eidtor = new SimpleTextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Copy")) {
            jTextArea.copy(); // Predefine Function of JTextArea
        } else if (s.equals("Cut")) {
            jTextArea.cut();
        } else if (s.equals("Paste")) {
            jTextArea.paste();
        } else if (s.equals("Print")) {
            try {
                jTextArea.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        } else if (s.equals("New")) {
            jTextArea.setText("");
        } else if (s.equals("Close")) {
            frame.setVisible(false);
        } else if (s.equals("Open")) {
            JFileChooser jFileChooser = new JFileChooser("c:");// Open the Directory
            int path = jFileChooser.showOpenDialog(null); // Default Selection is Null.
            if (path==jFileChooser.APPROVE_OPTION){ // When File Is Selected
                File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());// Store the Path of the Selected File
                String s1 = "", s2 = ""; // to Store the Data of Selected file
                // Try block to catch the Exception when file is not selected
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    s2 = bf.readLine(); // Read the each Line of Selected File
                    while ((s1=bf.readLine())!=null){ // until the last line of the File
                        s2+=s1+"\n"; // Store the Data in S2 with same format
                    }
                    jTextArea.setText(s2); // Set the Text Area with String S2
                } catch (FileNotFoundException ex) { // Exception if file is Not Found
                    throw new RuntimeException(ex);
                } catch (IOException ex) { // Exception if file is Empty
                    throw new RuntimeException(ex);
                }
            }
        } else if (s.equals("Save")) {
            JFileChooser jFileChooser = new JFileChooser("C:");
            int path = jFileChooser.showSaveDialog(null);
            if(path == jFileChooser.APPROVE_OPTION){
                File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file,false));
                    writer.write((jTextArea.getText()));
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}