
public class FunctionEdit {
    Notepad notepad;

    public FunctionEdit(Notepad notepad) {
        this.notepad = notepad;
    }
    public void undo(){
        if(notepad.manager.canUndo()) notepad.manager.undo();
    }
    public void redo(){
        if(notepad.manager.canRedo()) notepad.manager.redo();
    }
}
