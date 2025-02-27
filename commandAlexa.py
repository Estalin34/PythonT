from abc import ABC, abstractmethod


class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass


class Light:
    def on(self):
        print("Luz encendida")
    
    def off(self):
        print("Luz apagada")

    def adjust_brightness(self, level):
        print(f"Brillo ajustado a {level}%")


class LightOnCommand(Command):
    def __init__(self, light):
        self.light = light
    
    def execute(self):
        self.light.on()
    
    def undo(self):
        self.light.off()

class LightOffCommand(Command):
    def __init__(self, light):
        self.light = light
    
    def execute(self):
        self.light.off()
    
    def undo(self):
        self.light.on()

class LightBrightnessCommand(Command):
    def __init__(self, light, level):
        self.light = light
        self.level = level
    
    def execute(self):
        self.light.adjust_brightness(self.level)
    
    def undo(self):
        print(f"Restaurando brillo al 100%")
        self.light.adjust_brightness(100)


class RemoteControl:
    def __init__(self):
        self.commands = []
    
    def add_command(self, command):
        print("Comando agregado: " + command.__class__.__name__)
        self.commands.append(command)
    
    def execute_command(self):
        print("Ejecutando comandos")
        for command in self.commands:
            command.execute()
    
    def undo_last_command(self):
        if self.commands:
            print("Deshaciendo último comando")
            self.commands.pop().undo()
    
    def undo_all_commands(self):
        print("Deshaciendo todos los comandos")
        while self.commands:
            self.commands.pop().undo()


class Alexa:
    def __init__(self, remote_control):
        self.remote_control = remote_control

    def process_voice_command(self, command):
        print(f"Alexa procesando el comando: {command}")
        if command == "encender luz":
            self.remote_control.add_command(LightOnCommand(test_light))
        elif command == "apagar luz":
            self.remote_control.add_command(LightOffCommand(test_light))
        elif command.startswith("ajustar brillo"):
            level = int(command.split()[-1])
            self.remote_control.add_command(LightBrightnessCommand(test_light, level))
        else:
            print("Comando no reconocido")


test_light = Light()
remote_control = RemoteControl()


alexa = Alexa(remote_control)


alexa.process_voice_command("encender luz")
alexa.process_voice_command("ajustar brillo 50")
alexa.process_voice_command("apagar luz")
alexa.process_voice_command("ajustar brillo 80")


remote_control.execute_command()


remote_control.undo_last_command()


remote_control.undo_all_commands()
