package com.turkcell.app.commandprompt;

import org.csystem.util.commandprompt.Command;
import org.csystem.util.commandprompt.CommandPrompt;
import org.csystem.util.commandprompt.ErrorCommand;
import org.csystem.util.console.Console;

public class TurkcellCommands {
    private final CommandPrompt m_commandPrompt;
    @Command
    @Command("add")
    private void insert(String text)
    {
        Console.writeLine("insert/add:%s", text);
    }

    @Command
    @Command("find")
    private void search(String text)
    {
        Console.writeLine("find/search:%s", text);
    }

    @Command("quit")
    @Command("exit")
    private void quit()
    {
        Console.writeLine("Turkcell");
        System.exit(0);
    }

    @Command
    private void prompt(String p)
    {
        m_commandPrompt.setPrompt(p);
    }

    @ErrorCommand
    private void errorProc()
    {
        Console.writeLine("Error");
    }

    public TurkcellCommands(CommandPrompt commandPrompt)
    {
        m_commandPrompt = commandPrompt;
    }
}
