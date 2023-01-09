import java.awt.*;
import java.io.*;

public class FunctionFile {
    Notepad notepad;
    String fileName;
    String fileAddress;
    public FunctionFile(Notepad notepad) {
        this.notepad = notepad;
    }
    public void newFile(){
        notepad.textArea.setText("");
        notepad.window.setTitle("New");
    }
    public void openFile() {
        FileDialog fileDialog = new FileDialog(notepad.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            notepad.window.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            notepad.textArea.setText("");
            String line;
            while ((line = br.readLine()) != null) {
                notepad.textArea.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveFile(){
        if(fileName==null){
            saveFileAs();
        }
        else{
            try{
                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                fileWriter.write(notepad.textArea.getText());
                notepad.window.setTitle(fileName);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveFileAs(){
        FileDialog fileDialog = new FileDialog(notepad.window, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            notepad.window.setTitle(fileName);
        }
        try{
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(notepad.textArea.getText());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void exit(){
        System.exit(0);
    }
}
