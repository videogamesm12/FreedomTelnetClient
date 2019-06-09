package videogamesm12.FreedomTelnetClientPlus;

import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import me.StevenLawson.BukkitTelnetClient.BukkitTelnetClient;
import me.StevenLawson.BukkitTelnetClient.FavoriteButtonEntry;

public class BTC_FavoriteButtonsMenu extends JMenu {
    public BTC_FavoriteButtonsMenu(final Collection<FavoriteButtonEntry> buttonList)
    {
        final ActionListener actionListener = event ->
        {
            if (BukkitTelnetClient.mainPanel != null)
            {
                BukkitTelnetClient.mainPanel.getConnectionManager().sendDelayedCommand(event.getActionCommand(), true, 100);
            }
        };
        
        for (final FavoriteButtonEntry buttonData : buttonList)
        {
            final JMenuItem button = new JMenuItem();
            button.setText(buttonData.getLabel());
            button.setActionCommand(buttonData.getCommand());
            button.addActionListener(actionListener);
            add(button);
        }
    }
}
