import java.awt.*;

public class FunctionColor {
    Notepad notepad;

    public FunctionColor(Notepad notepad) {
        this.notepad = notepad;
    }
    public void changeColor(String color){
        switch (color){
            case "White" -> {
                notepad.window.getContentPane().setBackground(Color.white);
                notepad.textArea.setBackground(Color.white);
                notepad.textArea.setForeground(Color.black);
            }
            case "Black" -> {
                notepad.window.getContentPane().setBackground(Color.black);
                notepad.textArea.setBackground(Color.black);
                notepad.textArea.setForeground(Color.white);
            }
            case "Blue" -> {
                notepad.window.getContentPane().setBackground(Color.blue);
                notepad.textArea.setBackground(Color.blue);
                notepad.textArea.setForeground(Color.white);
            }
        }
    }
}

