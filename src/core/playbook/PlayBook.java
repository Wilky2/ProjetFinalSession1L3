package core.playbook;

import core.controller.Controller;
import core.data.NoExistException;

public class PlayBook {
	
    public static void main(String[] args) throws NoExistException {
        Controller contr = new Controller();
        contr.running();
    }
    
}
