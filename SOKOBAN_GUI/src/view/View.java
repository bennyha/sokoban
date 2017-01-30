package view;

import model.data.level.*;
import controller.commands.Command;

public interface View{
 
    void display(Level l) throws Exception;
    void setMoveMade(String s);
    void Finished();
    void start();
}
