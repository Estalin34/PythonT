import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
    void undo();
}
class Light {
    public void on() {
        System.out.println("Luz encendida");
    }

    public void off() {
        System.out.println("Luz apagada");
    }

    public void adjustBrightness(int level) {
        System.out.println("Brillo ajustado a " + level + "%");
    }
}
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
class LightBrightnessCommand implements Command {
    private Light light;
    private int level;

    public LightBrightnessCommand(Light light, int level) {
        this.light = light;
        this.level = level;
    }

    public void execute() {
        light.adjustBrightness(level);
    }

    public void undo() {
        System.out.println("Restaurando brillo al 100%");
        light.adjustBrightness(100);
    }
}
class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        System.out.println("Comando agregado: " + command.getClass().getSimpleName());
        commands.add(command);
    }

    public void executeCommands() {
        System.out.println("Ejecutando comandos");
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undoLastCommand() {
        if (!commands.isEmpty()) {
            System.out.println("Deshaciendo último comando");
            commands.remove(commands.size() - 1).undo();
        }
    }
    public void undoAllCommands() {
        System.out.println("Deshaciendo todos los comandos");
        while (!commands.isEmpty()) {
            commands.remove(commands.size() - 1).undo();
        }
    }
}

class Alexa {
    private RemoteControl remoteControl;

    public Alexa(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public void processVoiceCommand(String command) {
        System.out.println("Alexa procesando el comando: " + command);
        if (command.equals("encender luz")) {
            remoteControl.addCommand(new LightOnCommand(new Light()));
        } else if (command.equals("apagar luz")) {
            remoteControl.addCommand(new LightOffCommand(new Light()));
        } else if (command.startsWith("ajustar brillo")) {
            int level = Integer.parseInt(command.split(" ")[2]);
            remoteControl.addCommand(new LightBrightnessCommand(new Light(), level));
        } else {
            System.out.println("Comando no reconocido");
        }
    }
}
public class commandoALexa{
        public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Alexa alexa = new Alexa(remoteControl);

        // Procesamos comandos de voz
        alexa.processVoiceCommand("encender luz");
        alexa.processVoiceCommand("ajustar brillo 50");
        alexa.processVoiceCommand("apagar luz");
        alexa.processVoiceCommand("ajustar brillo 80");

        
        remoteControl.executeCommands();

       
        remoteControl.undoLastCommand();

        
        remoteControl.undoAllCommands();
    }
}
