import java.awt.*;

public class FunctionFormat {
    Notepad notepad;
    FunctionFormat(Notepad notepad){
        this.notepad = notepad;
    }
    public void wordWrap(){
        if(notepad.wordWrapOn) {
            notepad.wordWrapOn = false;
            notepad.textArea.setLineWrap(false);
            notepad.textArea.setWrapStyleWord(false);
            notepad.formatWrap.setText("Word Wrap: On");
        } else {
            notepad.wordWrapOn = true;
            notepad.textArea.setLineWrap(true);
            notepad.textArea.setWrapStyleWord(true);
            notepad.formatWrap.setText("Word Wrap: Off");
        }
    }
    public void fontArial(){
        Font arial = new Font("Arial", Font.PLAIN, notepad.fontSize);
        notepad.textArea.setFont(arial);
    }
    public void fontCSMS() {
        Font CSMS = new Font("Comic Sans MS", Font.PLAIN, notepad.fontSize);
        notepad.textArea.setFont(CSMS);
    }
    public void fontTNR() {
        Font TNR = new Font("Times New Roman", Font.PLAIN, notepad.fontSize);
        notepad.textArea.setFont(TNR);
    }
    public void fontSize12(){
        notepad.fontSize = 12;
        Font font = notepad.textArea.getFont().deriveFont(Font.PLAIN, 12);
        notepad.textArea.setFont(font);

    }
    public void fontSize16(){
        notepad.fontSize = 16;
        Font font = notepad.textArea.getFont().deriveFont(Font.PLAIN, 16);
        notepad.textArea.setFont(font);
    }
    public void fontSize20(){
        notepad.fontSize = 20;
        Font font = notepad.textArea.getFont().deriveFont(Font.PLAIN, 20);
        notepad.textArea.setFont(font);
    }


}
