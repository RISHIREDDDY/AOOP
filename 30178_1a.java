import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// LogLevel Enum
enum LogLevel {
    INFO, DEBUG, ERROR
}

// Command Interface
interface Command {
    void execute();
}

// LogCommand Class
class LogCommand implements Command {
    private LogHandler handler;
    private String message;
    private LogLevel level;

    public LogCommand(LogHandler handler, String message, LogLevel level) {
        this.handler = handler;
        this.message = message;
        this.level = level;
    }

    @Override
    public void execute() {
        handler.handle(message, level);
    }
}

// Abstract LogHandler Class
abstract class LogHandler {
    protected LogHandler next;

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void handle(String message, LogLevel level) {
        if (canHandle(level)) {
            write(message);
        } else if (next != null) {
            next.handle(message, level);
        }
    }

    protected abstract boolean canHandle(LogLevel level);

    protected abstract void write(String message);
}

// Concrete Handlers
class InfoHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

class ErrorHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

// Logger Class
class Logger {
    private List<Command> commands = new ArrayList<>();

    public Logger() {
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void processCommands() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command command = iterator.next();
            command.execute();
        }
    }
}

// Client Class
public class LoggingSystem {
    public static void main(String[] args) {
        // Configure the chain of responsibility
        LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();

        infoHandler.setNext(debugHandler);
        debugHandler.setNext(errorHandler);

        // Create the logger
        Logger logger = new Logger();

        // Create commands
        logger.addCommand(new LogCommand(infoHandler, "System is starting up", LogLevel.INFO));
        logger.addCommand(new LogCommand(infoHandler, "Debugging mode enabled", LogLevel.DEBUG));
        logger.addCommand(new LogCommand(infoHandler, "An error occurred", LogLevel.ERROR));

        // Process the commands
        logger.processCommands();
    }
}
