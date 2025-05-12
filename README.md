# ViaMaintenance

A simple Bukkit plugin to manage server maintenance mode.

## Features

*   Toggle server maintenance mode on/off.
*   Prevents players without specific permission from joining during maintenance.
*   Customizable kick message for players trying to join during maintenance.
*   Permission node to bypass maintenance mode.

## Commands

*   `/maintenance [on|off]` - Toggles maintenance mode. If `on` or `off` is not specified, it toggles the current state.
    *   Aliases: `/maint`, `/vm`
    *   Permission: `viamaintenance.admin`

## Permissions

*   `viamaintenance.admin` - Allows using the `/maintenance` command. (Default: op)
*   `viamaintenance.bypass` - Allows joining the server even when maintenance mode is enabled. (Default: op)

## Configuration (`config.yml`)

```yaml
# Whether maintenance mode is currently active.
# Can be toggled with /maintenance command.
maintenance-mode: false

# The message shown to players who try to join during maintenance
# without the viamaintenance.bypass permission.
# You can use color codes with '&'.
kick-message: "&cServer is under maintenance.\n&ePlease try again later."
```

## Building

You can build the plugin using Maven:
```bash
mvn clean package
``` 