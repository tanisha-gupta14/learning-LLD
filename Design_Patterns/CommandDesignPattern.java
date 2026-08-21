package Design_Patterns;

interface Command{
    void execute();
    void undo();
}

class Light{
    public void turnOn(){
        System.out.println("Light is ON");
    }
    public void turnOff(){
        System.out.println("Light is OFF");
    }
}

class LightCommand implements Command{
    private Light light;
    public LightCommand(Light light){
        this.light=light;
    }
    public void execute(){
        light.turnOn();
    }
    public void undo(){
        light.turnOff();
    }
}

class RemoteControl{
    private Command command;
    private Command previousCommand;
    public void setCommand(Command command){
        this.command=command;
    }
    public void pressButton(){
        command.execute();
        previousCommand=command;
    }
    public void pressUndo(){
        if(previousCommand!=null){
            previousCommand.undo();
        }
        else{
            System.out.println("No command to undo");
        }
    }

}


public class CommandDesignPattern {
    public static void main(String[] args){
        Light light=new Light();
        Command lightCommand=new LightCommand(light);
        RemoteControl remoteControl=new RemoteControl();
        remoteControl.setCommand(lightCommand);
        remoteControl.pressButton();
        remoteControl.pressUndo();
    }
}
