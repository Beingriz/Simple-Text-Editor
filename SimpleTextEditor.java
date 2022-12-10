import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTextEditor implements ActionListener {
    JFrame frame; // Creating Window
    JTextArea jTextArea; // TextArea
    JMenuBar menuBar; // Menu bar
    JMenu File,Edit, Close; // Menu bar Options
    JMenuItem New, Open, Save, Print; // File Menu Items
    JMenuItem Cut, Copy, Paste; // Edit Menu items
    JMenuItem CloseEditor; // Close Menu Item

    public SimpleTextEditor() {

        // Frame
        frame = new JFrame("Simple Text Editor"); // Title of Window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // When Close button is hit, Execution of program is also Terminates
        frame.setVisible(true); // Make the Frame Visible.
        frame.setBounds(20,20,800,800);// Default Window Size.



        // JTextArea
        jTextArea = new JTextArea("Welcome to Simple Text Editor");
        frame.add(jTextArea); // Added into Main Frame


        // MenuBar
        menuBar  = new JMenuBar();// Creating Menu bar
        frame.setJMenuBar(menuBar);// Setting Menu Bar into frame



        //Menu
        File = new JMenu("File");
        Edit  = new JMenu("Edit");
        Close  = new JMenu("Close");
        // After Creating Menu Added into Menu Bar;
        menuBar.add(File);
        menuBar.add(Edit);
        menuBar.add(Close);

        // Menu Items for File Option
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Save = new JMenuItem("Save");
        Print = new JMenuItem("Print");
            // After Creating Menu Item Add into File
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Print);

        // Menu Item for Edit Option
        Cut  = new JMenuItem("Cut");
        Copy  = new JMenuItem("Copy");
        Paste  = new JMenuItem("Paste");
        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);

        CloseEditor = new JMenuItem("Close");
        Close.add(CloseEditor);
    }

    public static void main(String[] args) {
        SimpleTextEditor eidtor = new SimpleTextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String s = e.getActionCommand();
//        if(s.equals())
    }
}
