import javax.swing.*;
import javax.swing.undo.UndoManager;
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
    // Color menu
    JMenuItem cColor1, cColor2, cColor3;
    // edit menu
    JMenuItem eUndo, eRedo;

    FunctionFile functionFile = new FunctionFile(this);
    FunctionFormat functionFormat = new FunctionFormat(this);
    FunctionColor functionColor = new FunctionColor(this);
    FunctionEdit functionEdit = new FunctionEdit(this);

    UndoManager manager = new UndoManager();
    public static void main(String[] args) {
       new Notepad();
    }
    public Notepad(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();
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

        textArea.getDocument().addUndoableEditListener(
                e -> manager.addEdit(e.getEdit())
        );
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
        addItemToMenu(menuFile, fNew, "New");
        addItemToMenu(menuFile, fOpen, "Open");
        addItemToMenu(menuFile, fSave, "Save");
        addItemToMenu(menuFile, fSaveAs, "Save as");
        addItemToMenu(menuFile, fExit, "Exit");
    }
    public void createFormatMenu(){
        formatWrap = new JMenuItem("Word Wrap: Off");
        formatWrap.addActionListener(this);
        formatWrap.setActionCommand("Word Wrap");
        menuFormat.add(formatWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        addItemToMenu(menuFont, fontArial, "Arial");
        addItemToMenu(menuFont, fontCSMS, "Comic Sans MS");
        addItemToMenu(menuFont, fontTNR, "Times New Roman");

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        addItemToMenu(menuFontSize, fontSize12, "12");
        addItemToMenu(menuFontSize, fontSize16, "16");
        addItemToMenu(menuFontSize, fontSize20, "20");
    }
    public void createColorMenu(){
        addItemToMenu(menuColor, cColor1, "White");
        addItemToMenu(menuColor, cColor2, "Black");
        addItemToMenu(menuColor, cColor3, "Blue");
    }
    public void createEditMenu(){
        addItemToMenu(menuEdit, eRedo, "Redo");
        addItemToMenu(menuEdit, eUndo, "Undo");
    }
    public void addItemToMenu(JMenu menu, JMenuItem menuItem, String text){
        menuItem = new JMenuItem(text);
        menuItem.addActionListener(this);
        menuItem.setActionCommand(text);
        menu.add(menuItem);

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
            case "Undo" -> functionEdit.undo();
            case "Redo" -> functionEdit.redo();
            case "Word Wrap" -> functionFormat.wordWrap();
            case "Arial" -> functionFormat.setFont("Arial");
            case "Comic Sans MS" -> functionFormat.setFont("Comic Sans MS");
            case "Times New Roman" -> functionFormat.setFont("Times New Roman");
            case "12" -> functionFormat.setFontSize(12);
            case "16" -> functionFormat.setFontSize(16);
            case "20" -> functionFormat.setFontSize(20);
            case "White" -> functionColor.changeColor("White");
            case "Black" -> functionColor.changeColor("Black");
            case "Blue" -> functionColor.changeColor("Blue");
        }
    }
}