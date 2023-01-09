import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad implements ActionListener {

    JFrame window;

    // text area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    int fontSize = 12;
    Font defaultFont = new Font("Arial", Font.PLAIN, fontSize);

    // top menu bar
    JMenuBar menuBar;
    // file menu
    JMenu  menuFile, menuEdit, menuFormat, menuColor;
    // format menu
    JMenuItem fNew, fOpen, fSave, fSaveAs, fExit;
    // format menu
    JMenuItem formatWrap, fontArial, fontCSMS, fontTNR, fontSize12,fontSize16, fontSize20;
    JMenu menuFont, menuFontSize;


    FunctionFile functionFile = new FunctionFile(this);
    FunctionFormat functionFormat = new FunctionFormat(this);

    public static void main(String[] args) {
       new Notepad();
    }
    public Notepad(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        window.setVisible(true);

    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        // window.add(textArea);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void createFileMenu(){
        fNew = new JMenuItem("New");
        fNew.addActionListener(this);
        fNew.setActionCommand("New");
        menuFile.add(fNew);

        fOpen = new JMenuItem("Open");
        fOpen.addActionListener(this);
        fOpen.setActionCommand("Open");
        menuFile.add(fOpen);

        fSave = new JMenuItem("Save");
        fSave.addActionListener(this);
        fSave.setActionCommand("Save");
        menuFile.add(fSave);

        fSaveAs = new JMenuItem("Save as");
        fSaveAs.addActionListener(this);
        fSaveAs.setActionCommand("Save as");
        menuFile.add(fSaveAs);

        fExit = new JMenuItem("Exit");
        fExit.addActionListener(this);
        fExit.setActionCommand("Exit");
        menuFile.add(fExit);
    }
    public void createFormatMenu(){
        formatWrap = new JMenuItem("Word Wrap: Off");
        formatWrap.addActionListener(this);
        formatWrap.setActionCommand("Word Wrap");
        menuFormat.add(formatWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        fontArial = new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        menuFont.add(fontArial);

        fontCSMS = new JMenuItem("Comic Sans MS");
        fontCSMS.addActionListener(this);
        fontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(fontCSMS);

        fontTNR = new JMenuItem("Times New Roman");
        fontTNR.addActionListener(this);
        fontTNR.setActionCommand("Times New Roman");
        menuFont.add(fontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        fontSize12 = new JMenuItem("12");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("12");
        menuFontSize.add(fontSize12);

        fontSize16 = new JMenuItem("16");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("16");
        menuFontSize.add(fontSize16);

        fontSize20 = new JMenuItem("20");
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("20");
        menuFontSize.add(fontSize20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New" -> functionFile.newFile();
            case "Open" -> functionFile.openFile();
            case "Save as" -> functionFile.saveFileAs();
            case "Save" -> functionFile.saveFile();
            case "Exit" -> functionFile.exit();
            case "Word Wrap" -> functionFormat.wordWrap();
            case "Arial" -> functionFormat.fontArial();
            case "Comic Sans MS" -> functionFormat.fontCSMS();
            case "Times New Roman" -> functionFormat.fontTNR();
            case "12" -> functionFormat.fontSize12();
            case "16" -> functionFormat.fontSize16();
            case "20" -> functionFormat.fontSize20();
        }
    }
}