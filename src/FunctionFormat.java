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
    public void setFont(String fontName){
        Font font = new Font(fontName, Font.PLAIN, notepad.fontSize);
        notepad.textArea.setFont(font);
    }
    public void setFontSize(int size){
        notepad.fontSize = size;
        Font font = notepad.textArea.getFont().deriveFont(Font.PLAIN, size);
        notepad.textArea.setFont(font);
    }
}
